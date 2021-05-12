package com.sist.feb.reply.controller;

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
import com.sist.feb.post.domain.PostVO;
import com.sist.feb.reply.domain.ReplyVO;
import com.sist.feb.reply.service.ReplyServiceImpl;

@Controller
public class ReplyController {

//	▼ 변수 ===============================================================
	
	final Logger LOG = LoggerFactory.getLogger(ReplyController.class);
	
	@Autowired
	ReplyServiceImpl replyService;
	
	Gson gson = new Gson();
	MessageVO message = new MessageVO();
	
//	▼ 생성자 ==============================================================	

	public ReplyController () {}
	

//	▼ 메소드 ===============================================================	
	
	
	@RequestMapping(value = "reply/do_insert.do", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String doInsert(ReplyVO replyVO) throws Exception {
		
		LOG.debug("doInsert");
		message.setMsgId(Integer.toString(replyService.doInsert(replyVO)));
		
		if(message.getMsgId().equals("1")) message.setMsgContents("Successfully inserted");
		else message.setMsgContents("Failure to insert");
		
		LOG.debug("메세지: "+gson.toJson(message));
		
		return gson.toJson(message);
		
	}
	
	@RequestMapping(value = "reply/do_change_delete.do", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String doChangeDelete(ReplyVO replyVO) throws Exception {
		
		LOG.debug("doChangeDelete");
		
		message.setMsgId(Integer.toString(replyService.doChangeDelete(replyVO)));
		
		if(message.getMsgId().equals("1")) message.setMsgContents("Successfully deleted");
		else message.setMsgContents("Failure to delete");
		
		LOG.debug("메세지: "+gson.toJson(message));
		
		return gson.toJson(message);
		
	}
	
	@RequestMapping(value = "reply/do_retrieve.do", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String doRetrieve(PostVO postVO) throws Exception {
		
		LOG.debug("doRetrieve");
		
		List<ReplyVO> replyList = replyService.doRetrieve(postVO);
		
		for(ReplyVO vo : replyList) {
			LOG.debug("vo: "+vo.toString());
		}
		
		String jsonStr = gson.toJson(replyList.toArray());
		
		return jsonStr;
		
	}
	
	
	
}
