package com.sist.feb.post.service;

import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.feb.cmn.DTO;
import com.sist.feb.post.dao.PostDaoImpl;
import com.sist.feb.post.domain.PostVO;

@Service
public class PostServiceImpl {

//	▼ 변수 ===============================================================
	
	final Logger LOG = LoggerFactory.getLogger(PostServiceImpl.class);
	
	@Autowired
	private PostDaoImpl postDao;
	
//	▼ 생성자 ==============================================================	

	public PostServiceImpl() {}
	
	
//	▼ 메소드 ===============================================================	
	
	public int doInsert(DTO dto) throws SQLException {
		return postDao.doInsert(dto);
	}
	
	public List<PostVO> doRetrieve(DTO dto) throws SQLException {
		return postDao.doRetrieve(dto);
	}
	
	public PostVO doSelect(DTO dto) throws SQLException {
		return postDao.doSelect(dto);
	}
	
	public int doUpdate(DTO dto) throws SQLException {
		return postDao.doUpdate(dto);
	}
	
	public int doDelete(DTO dto) throws SQLException {
		return postDao.doDelete(dto);
	}
	
	public int doLike(DTO dto) throws SQLException {
		return postDao.doLike(dto);
	}
	
	public int doCancelLike(DTO dto) throws SQLException {
		return postDao.doCancelLike(dto);
	}

	
	
}
