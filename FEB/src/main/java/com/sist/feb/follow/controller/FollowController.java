package com.sist.feb.follow.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.sist.feb.cmn.MessageVO;
import com.sist.feb.follow.domain.FollowVO;
import com.sist.feb.follow.service.FollowServiceImpl;
import com.sist.feb.member.domain.MemberVO;
import com.sist.feb.member.service.MemberServiceImpl;

@Controller
public class FollowController {

//	▼ 변수 ===============================================================
	
	final Logger LOG = LoggerFactory.getLogger(FollowController.class);
	
	@Autowired
	FollowServiceImpl followService;
	
	@Autowired
	MemberServiceImpl memberService;
	

//	▼ 생성자 ==============================================================	

	public FollowController () {}
	

//	▼ 메소드 ===============================================================	
	
	@RequestMapping(value = "follow/do_check_following.do", method = RequestMethod.POST
			,produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String doCheckFollowing(FollowVO followVO) throws Exception {
		
		LOG.debug("doCheckFollowing");
		MessageVO message = new MessageVO();
		message.setMsgId(Integer.toString(followService.doCheckFollowing(followVO)));
		
		if(message.getMsgId().equals("1")) message.setMsgContents("Already followed");
		else message.setMsgContents("Not yet");
		
		Gson gson = new Gson();
		LOG.debug("메세지: "+gson.toJson(message));
		
		return gson.toJson(message);
		
	}
	
	@RequestMapping(value = "follow/do_follow.do", method = RequestMethod.POST
			,produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String doFollow(FollowVO followVO) throws Exception {
		
		LOG.debug("doFollow");
		MessageVO message = new MessageVO();
		message.setMsgId(Integer.toString(followService.doFollow(followVO)));
		
		if(message.getMsgId().equals("1")) message.setMsgContents("Successfully followed");
		else message.setMsgContents("Failure to follow");
		
		Gson gson = new Gson();
		LOG.debug("메세지: "+gson.toJson(message));
		
		return gson.toJson(message);
		
	}
	
	@RequestMapping(value = "follow/do_cancel_follow.do", method = RequestMethod.POST
			,produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String doCancelFollow(FollowVO followVO) throws Exception {
		
		LOG.debug("doCancelFollow");
		MessageVO message = new MessageVO();
		message.setMsgId(Integer.toString(followService.doCancelFollow(followVO)));
		
		if(message.getMsgId().equals("1")) message.setMsgContents("Successfully unfollowed");
		else message.setMsgContents("Failure to unfollow");
		
		Gson gson = new Gson();
		LOG.debug("메세지: "+gson.toJson(message));
		
		return gson.toJson(message);
		
	}
	
	
	@RequestMapping(value = "follow/do_retrieve_following.do", method = RequestMethod.POST
			,produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String doRetrieveFollowing(MemberVO inVO) throws Exception {
		
		LOG.debug("doRetrieveFollowing");
		MemberVO outVO = memberService.doSelectOne(inVO);

		List<FollowVO> followList = followService.doRetrieveFollowing(outVO);
		Gson gson = new Gson();
		
		return gson.toJson(followList.toArray());
		
	}	
	
	@RequestMapping(value = "follow/do_retrieve_followed.do", method = RequestMethod.POST
			,produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String doRetrieveFollowed(MemberVO inVO) throws Exception {
		
		LOG.debug("doRetrieveFollowed");
		MemberVO outVO = memberService.doSelectOne(inVO);
		
		List<FollowVO> followList = followService.doRetrieveFollowed(outVO);
		Gson gson = new Gson();
		
		return gson.toJson(followList.toArray());
		
	}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
