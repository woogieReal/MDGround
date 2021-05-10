package com.sist.feb.follow.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.feb.cmn.DTO;
import com.sist.feb.follow.dao.FollowDaoImpl;

@Service
public class FollowServiceImpl {

//	▼ 변수 ===============================================================
	
	@Autowired
	private FollowDaoImpl followDao;

//	▼ 생성자 ==============================================================	

	public FollowServiceImpl () {}
	

//	▼ 메소드 ===============================================================	
	
	public int doCheckFollowing(DTO dto) throws SQLException {
		return followDao.doCheckFollowing(dto);
	}
	
	public int doCountFollowing(DTO dto) throws SQLException {
		return followDao.doCountFollowing(dto);
	}
	
	public int doCountFollowed(DTO dto) throws SQLException {
		return followDao.doCountFollowed(dto);
	}
	
	public int doFollow(DTO dto) throws SQLException {
		return followDao.doFollow(dto);
	}
	
	public int doCancelFollow(DTO dto) throws SQLException {
		return followDao.doCancelFollow(dto);
	}
	
	
	
	
	
}
