package com.sist.feb.storage.controller;

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
import com.sist.feb.post.service.PostServiceImpl;
import com.sist.feb.storage.domain.StorageVO;
import com.sist.feb.storage.service.StorageServiceImpl;

@Controller
public class StorageController {

//	▼ 변수 ===============================================================
	
	final Logger LOG = LoggerFactory.getLogger(StorageController.class);
	
	@Autowired
	private StorageServiceImpl storageService;
	
	@Autowired
	private PostServiceImpl postService;

//	▼ 생성자 ==============================================================	

	public StorageController () {}
	

//	▼ 메소드 ===============================================================	
	
	
	@RequestMapping(value = "storage/do_store.do", method = RequestMethod.POST
			,produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String doStore(StorageVO storageVO) throws Exception {
		
		LOG.debug("doStore");
		
		int flag = 0;
		int doubleChek = 0;
		
		PostVO postVO = new PostVO();
		postVO.setPostNo(storageVO.getPostNo());
		
		switch (storageVO.getStoreType()) {
		case 1:
			flag = storageService.doStore(storageVO);
			break;
		case 2:
			doubleChek += storageService.doStore(storageVO);
			doubleChek += postService.doLike(postVO);
			if(doubleChek == 2) flag = 1;
			else flag = 0;
			break;
		default:
			break;
		}
		
		MessageVO message = new MessageVO();
		message.setMsgId(Integer.toString(flag));
		
		if(message.getMsgId().equals("1")) message.setMsgContents("Successfully performed");
		else message.setMsgContents("Failure to perform");
		
		Gson gson = new Gson();
		LOG.debug("메세지: "+gson.toJson(message));
		
		return gson.toJson(message);
		
	}
	
	@RequestMapping(value = "storage/do_cancel_store.do", method = RequestMethod.POST
			,produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String doCancelStore(StorageVO storageVO) throws Exception {
		
		LOG.debug("doCancelStore");
		
		int flag = 0;
		int doubleChek = 0;
		
		PostVO postVO = new PostVO();
		postVO.setPostNo(storageVO.getPostNo());
		
		switch (storageVO.getStoreType()) {
		case 1:
			flag = storageService.doCancelStore(storageVO);
			break;
		case 2:
			doubleChek += storageService.doCancelStore(storageVO);
			doubleChek += postService.doCancelLike(postVO);
			if(doubleChek == 2) flag = 1;
			else flag = 0;
			break;
		default:
			break;
		}
		
		MessageVO message = new MessageVO();
		message.setMsgId(Integer.toString(flag));
		
		if(message.getMsgId().equals("1")) message.setMsgContents("Successfully performed");
		else message.setMsgContents("Failure to perform");
		
		Gson gson = new Gson();
		LOG.debug("메세지: "+gson.toJson(message));
		
		return gson.toJson(message);
		
	}
	
	@RequestMapping(value = "storage/do_check_store.do", method = RequestMethod.POST
			,produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String doCheckStore(StorageVO storageVO) throws Exception {
		
		LOG.debug("doCheckStore");
		
		MessageVO message = new MessageVO();
		message.setMsgId(Integer.toString(storageService.doCheckStore(storageVO)));
		
		if(message.getMsgId().equals("1")) message.setMsgContents("already performed");
		else message.setMsgContents("Not yet");
		
		Gson gson = new Gson();
		LOG.debug("메세지: "+gson.toJson(message));
		
		return gson.toJson(message);
		
	}
	
	
	
	
}
