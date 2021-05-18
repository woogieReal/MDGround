package com.sist.feb.post.controller;

import java.util.List;
import java.util.Objects;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.sist.feb.cmn.MDParser;
import com.sist.feb.cmn.MessageVO;
import com.sist.feb.cmn.SearchVO;
import com.sist.feb.cmn.StringUtil;
import com.sist.feb.follow.domain.FollowVO;
import com.sist.feb.follow.service.FollowServiceImpl;
import com.sist.feb.image.domain.ImageVO;
import com.sist.feb.image.service.ImageServiceImpl;
import com.sist.feb.member.domain.MemberVO;
import com.sist.feb.member.service.MemberServiceImpl;
import com.sist.feb.post.domain.PostVO;
import com.sist.feb.post.service.PostServiceImpl;
import com.sist.feb.storage.domain.StorageVO;
import com.sist.feb.storage.service.StorageServiceImpl;

@Controller
public class PostController {

//	▼ 변수 ===============================================================

	final Logger LOG = LoggerFactory.getLogger(PostController.class);
	
	@Autowired
	private PostServiceImpl postService;
	
	@Autowired
	private ImageServiceImpl imageService;
	
	@Autowired
	private StorageServiceImpl storageService;
	
	@Autowired
	FollowServiceImpl followService;

	@Autowired
	MemberServiceImpl memberService;
	
//	▼ 생성자 ==============================================================	
	
	public PostController() {}
	
	
//	▼ 메소드 ===============================================================

	@RequestMapping(value = "post/post_reg_view.do", method = RequestMethod.GET
			,produces = "application/json;charset=UTF-8")
	public String viewPostReg(Model model) throws Exception {
		LOG.debug("viewPostReg");
		return "post/post_reg";
	}
	
	@RequestMapping(value = "post/post_detail_view.do", method = RequestMethod.GET
			,produces = "application/json;charset=UTF-8")
	public String viewPostDetail(Model model) throws Exception {
		LOG.debug("viewPostDetail");
		return "post/post_detail";
	}
	
	@RequestMapping(value = "post/do_insert.do", method = RequestMethod.POST
			,produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String doInsert(PostVO postVO) throws Exception {
		
		LOG.debug("doInsert");
		
		String htmlStr = MDParser.parserFromMD(postVO.getTextMd());
		//LOG.debug("htmlStr: "+htmlStr);
		
		postVO.setTextHtml(htmlStr);
		
		MessageVO message = new MessageVO();
		message.setMsgId(Integer.toString(postService.doInsert(postVO)));
		
		if(message.getMsgId().equals("1")) message.setMsgContents("Successfully posted");
		else message.setMsgContents("Failure to post");
		
		Gson gson = new Gson();
		LOG.debug("메세지: "+gson.toJson(message));
		
		return gson.toJson(message);
		
	}
	
	@RequestMapping(value = "post/do_retrieve.do", method = RequestMethod.POST
			,produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String doRetrieve(Model model, SearchVO search) throws Exception {
		
		LOG.debug("doRetrieve");
		
		search.setSearchDiv(StringUtil.nvl(search.getSearchDiv(), "nothing"));
		search.setSearchWord(StringUtil.nvl(search.getSearchWord(), "0"));
		search.setSearchDiv2(StringUtil.nvl(search.getSearchDiv2(), "nothing"));
		search.setSearchWord2(StringUtil.nvl(search.getSearchWord2(), "0"));
		
		List<PostVO> postList = postService.doRetrieve(search);
		Gson gson = new Gson();
		
		return gson.toJson(postList.toArray());
		
	}
	
	@RequestMapping(value="post/do_select_post.do",method = RequestMethod.GET)
	public String doSelectPost(Model model, PostVO PostInVO, HttpSession session) throws Exception {
		
		LOG.debug("doSelectPost");
		
		PostVO postOutVO = postService.doSelect(PostInVO);
		
		ImageVO imageInVO = new ImageVO();
		imageInVO.setFromTb(1);
		imageInVO.setFromNo(PostInVO.getPostNo());
		
		List<ImageVO> imageList = imageService.doRetrieveImages(imageInVO);
		
		int bookmarkFlag = 0;
		int likeFlag = 0;
		int followFlag = 0;
		
		if(null != session.getAttribute("member")) {
			MemberVO loginMember = (MemberVO) session.getAttribute("member");
			StorageVO bookmarkVO = new StorageVO(0, 1, null, loginMember.getEmail(), postOutVO.getPostNo());
			StorageVO likeVO = new StorageVO(0, 2, null, loginMember.getEmail(), postOutVO.getPostNo());
			FollowVO followVO = new FollowVO(0, postOutVO.getMemberEmail(), loginMember.getEmail(), null);
			
			bookmarkFlag = storageService.doCheckStore(bookmarkVO);
			likeFlag = storageService.doCheckStore(likeVO);
			followFlag = followService.doCheckFollowing(followVO);
		}
		
		MemberVO outVO = memberService.doSelectOne(new MemberVO(0, postOutVO.getMemberEmail(), null, null, null, null, null, null));
		ImageVO profileImage = imageService.doSelectProfileImage(outVO);
		
		Gson gson = new Gson();
		
		model.addAttribute("vo", postOutVO);
		model.addAttribute("imageList", imageList);
		model.addAttribute("imageListStr", gson.toJson(imageList.toArray()));
		
		model.addAttribute("bookmarkFlag", bookmarkFlag);
		model.addAttribute("likeFlag", likeFlag);
		model.addAttribute("followFlag", followFlag);
		
		if(Objects.isNull(profileImage)) {
			ImageVO nothingProfileImage = new ImageVO();
			nothingProfileImage.setPath("/resources/image_source/");
			nothingProfileImage.setSaveName("nothing.jpg");
			model.addAttribute("profileImage", nothingProfileImage);
		} else {
			model.addAttribute("profileImage", profileImage);
		}
		
		return "post/post_detail";
	}
	
	@RequestMapping(value = "post/do_convert.do", method = RequestMethod.POST
			,produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String doConvert(@RequestParam(value = "textMD", required = false)String textMD) throws Exception {
		
		LOG.debug("doConvert");

		return MDParser.parserFromMD(textMD);
		
	}

	@RequestMapping(value="post/do_edit_post.do",method = RequestMethod.POST)
	public String doEditPost(Model model, PostVO PostInVO) throws Exception {
		
		LOG.debug("doEditPost");
		
		PostVO postOutVO = postService.doSelect(PostInVO);
		
		ImageVO imageInVO = new ImageVO();
		imageInVO.setFromTb(1);
		imageInVO.setFromNo(PostInVO.getPostNo());
		
		List<ImageVO> imageList = imageService.doRetrieveImages(imageInVO);
		
		for(ImageVO imageVO : imageList) {
			LOG.debug("imageVO: "+imageVO.toString());
		}
		
		Gson gson = new Gson();
		String imageListStr = gson.toJson(imageList.toArray());
		LOG.debug("imageListStr: "+imageListStr);
		
		model.addAttribute("vo", postOutVO);
		model.addAttribute("imageList", imageListStr);
		
		return "post/post_mod";
	}	
	
	@RequestMapping(value = "post/do_update.do", method = RequestMethod.POST
			,produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String doUpdate(PostVO postVO) throws Exception {
		
		LOG.debug("doUpdate");
		
		String htmlStr = MDParser.parserFromMD(postVO.getTextMd());
		//LOG.debug("htmlStr: "+htmlStr);
		
		postVO.setTextHtml(htmlStr);
		
		MessageVO message = new MessageVO();
		message.setMsgId(Integer.toString(postService.doUpdate(postVO)));
		
		if(message.getMsgId().equals("1")) message.setMsgContents("Successfully edited");
		else message.setMsgContents("Failure to edit");
		
		Gson gson = new Gson();
		LOG.debug("메세지: "+gson.toJson(message));
		
		return gson.toJson(message);
		
	}
	
	@RequestMapping(value = "post/do_delete.do", method = RequestMethod.POST
			,produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String doDelete(PostVO postVO) throws Exception {
		
		LOG.debug("doDelete");
		
		MessageVO message = new MessageVO();
		message.setMsgId(Integer.toString(postService.doDelete(postVO)));
		
		if(message.getMsgId().equals("1")) message.setMsgContents("Successfully deleted");
		else message.setMsgContents("Failure to delete");
		
		Gson gson = new Gson();
		LOG.debug("메세지: "+gson.toJson(message));
		
		return gson.toJson(message);
		
	}
	
	
	
	
}
