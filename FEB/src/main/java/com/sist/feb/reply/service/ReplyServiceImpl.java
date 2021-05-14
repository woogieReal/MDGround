package com.sist.feb.reply.service;

import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.feb.cmn.DTO;
import com.sist.feb.reply.dao.ReplyDaoImpl;
import com.sist.feb.reply.domain.ReplyVO;

@Service
public class ReplyServiceImpl {

//	▼ 변수 ===============================================================
	
	final Logger LOG = LoggerFactory.getLogger(ReplyServiceImpl.class);
	
	@Autowired
	private ReplyDaoImpl replyDao;

//	▼ 생성자 ==============================================================	

	public ReplyServiceImpl () {}
	

//	▼ 메소드 ===============================================================	
	
	public int doInsert(DTO dto) throws SQLException {
		return replyDao.doInsert(dto);
	}
	
	public int doChangeDelete(DTO dto) throws SQLException {
		return replyDao.doChangeDelete(dto);
	}
	
	public List<ReplyVO> doRetrieve(DTO dto) throws SQLException {
		return replyDao.doRetrieve(dto);
	}

	public int doDelete(DTO dto) throws SQLException {
		return replyDao.doDelete(dto);
	}
	
}
