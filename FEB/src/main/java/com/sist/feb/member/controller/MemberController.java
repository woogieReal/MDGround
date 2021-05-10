package com.sist.feb.member.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.sist.feb.cmn.MessageVO;
import com.sist.feb.cmn.SearchVO;
import com.sist.feb.follow.domain.FollowVO;
import com.sist.feb.follow.service.FollowServiceImpl;
import com.sist.feb.image.domain.ImageVO;
import com.sist.feb.image.service.ImageServiceImpl;
import com.sist.feb.member.domain.MemberVO;
import com.sist.feb.member.service.MemberServiceImpl;
import com.sist.feb.post.domain.PostVO;
import com.sist.feb.post.service.PostServiceImpl;

@Controller
public class MemberController {

//	▼ 변수 ===============================================================

	final Logger LOG = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	MemberServiceImpl memberService;
	
	@Autowired
	FollowServiceImpl followService;
	
	@Autowired
	private PostServiceImpl postService;
	
	@Autowired
	ImageServiceImpl imageService;
	
//	▼ 생성자 ==============================================================	

	public MemberController() {}
	
//	▼ 메소드 ===============================================================

	@RequestMapping(value = "member/sign_in_view.do", method = RequestMethod.GET
			,produces = "application/json;charset=UTF-8")
	public String viewLogin(Model model) throws Exception {
		LOG.debug("viewLogin");
		return "sign/sign_in";
	}
	
	@RequestMapping(value = "member/sign_up_view.do", method = RequestMethod.GET
			,produces = "application/json;charset=UTF-8")
	public String viewSignUp(Model model) throws Exception {
		return "sign/sign_up";
	}
	
	
	@RequestMapping(value = "member/do_register.do", method = RequestMethod.POST
			,produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String doRegister(MemberVO memberVO) throws Exception {
		
		LOG.debug("doRegister");
		MessageVO message = new MessageVO();
		message.setMsgId(Integer.toString(memberService.doRegister(memberVO)));
		
		if(message.getMsgId().equals("1")) message.setMsgContents("회원 등록이 완료되었습니다.");
		else message.setMsgContents("회원 등록에 실패하였습니다.");
		
		Gson gson = new Gson();
		LOG.debug("메세지: "+gson.toJson(message));
		
		return gson.toJson(message);
		
	}
	
	@RequestMapping(value = "member/do_login_check.do", method = RequestMethod.POST
			,produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String doLoginCheck(MemberVO memberVO, HttpSession session) throws Exception {
		
		LOG.debug("doLoginCheck");
		MessageVO message = new MessageVO();
		message.setMsgId(Integer.toString(memberService.doLoginCheck(memberVO)));
		
		if(message.getMsgId().equals("1")) {
			message.setMsgContents("로그인이 완료되었습니다.");
			MemberVO member = memberService.doSelectOne(memberVO);
			session.setAttribute("member", member);
		}
		else {
			message.setMsgContents("아이디와 비밀번호를 확인해 주세요.");
		}
		
		Gson gson = new Gson();
		LOG.debug("메세지: "+gson.toJson(message));
		
		return gson.toJson(message);
		
	}
	
	@RequestMapping(value = "member/do_logoff.do", method = RequestMethod.GET)
	public String doLogOff(HttpSession session) {
		String returnUrl = "main/main";
		
		if(null != session.getAttribute("member")) {
			session.removeAttribute("member");
			session.invalidate();
		}
		
		return returnUrl;
	}
	
	@RequestMapping(value = "member/do_check_duplicated_id.do", method = RequestMethod.POST
			,produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String doCheckDuplicatedId(MemberVO memberVO) throws Exception {
		
		LOG.debug("doCheckDuplicatedId");
		MessageVO message = new MessageVO();
		message.setMsgId(Integer.toString(memberService.doCheckDuplicatedId(memberVO)));
		
		if(message.getMsgId().equals("1")) message.setMsgContents("이미 존재하는 이메일입니다.");
		else message.setMsgContents("사용가능한 이메일입니다.");
		
		Gson gson = new Gson();
		LOG.debug("메세지: "+gson.toJson(message));
		
		return gson.toJson(message);
		
	}
	
	
	@RequestMapping(value="member/do_select_one.do",method = RequestMethod.GET)
	public String doSelectOne(Model model, MemberVO inVO, HttpSession session) throws Exception {
		
		LOG.debug("doSelectOne");
		
		MemberVO outVO = memberService.doSelectOne(inVO);
		
		int followingCount = followService.doCountFollowing(inVO);
		int followedCount = followService.doCountFollowed(inVO);
		int followFlag = 0;
		
		if(null != session.getAttribute("member")) {
			MemberVO loginMember = (MemberVO) session.getAttribute("member");
			FollowVO followVO = new FollowVO(0, outVO.getEmail(), loginMember.getEmail(), null);
			followFlag = followService.doCheckFollowing(followVO);
		}
		
		SearchVO searchVo = new SearchVO("postCategoryNo", "0", "eachMember", outVO.getEmail());
		List<PostVO> postList = postService.doRetrieve(searchVo);
		
		ImageVO profileImage = imageService.doSelectProfileImage(outVO);
		
		//LOG.debug("outVO: "+outVO);
		model.addAttribute("memberVO", outVO);
		model.addAttribute("followingCount", followingCount);
		model.addAttribute("followedCount", followedCount);
		model.addAttribute("followFlag", followFlag);
		model.addAttribute("postList", postList);
		model.addAttribute("profileImage", profileImage);
		
		return "member/my_page";
	}
	
	
	
}
