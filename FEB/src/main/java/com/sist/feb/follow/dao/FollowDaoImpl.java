package com.sist.feb.follow.dao;

import java.sql.SQLException;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.feb.cmn.DTO;

@Repository
public class FollowDaoImpl {

//	▼ 변수 ===============================================================
	
	final Logger LOG = LoggerFactory.getLogger(FollowDaoImpl.class);
	
	final String NAMESPACE = "com.sist.feb.follow";
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	

//	▼ 생성자 ==============================================================	

	public FollowDaoImpl () {}
	

//	▼ 메소드 ===============================================================	
	
	public int doCheckFollowing(DTO dto) throws SQLException {
		return this.sqlSessionTemplate.selectOne(this.NAMESPACE + ".doCheckFollowing", dto);
	}
	
	public int doCountFollowing(DTO dto) throws SQLException {
		return this.sqlSessionTemplate.selectOne(this.NAMESPACE + ".doCountFollowing", dto);
	}
	
	public int doCountFollowed(DTO dto) throws SQLException {
		return this.sqlSessionTemplate.selectOne(this.NAMESPACE + ".doCountFollowed", dto);
	}
	
	public int doFollow(DTO dto) throws SQLException {
		return this.sqlSessionTemplate.insert(this.NAMESPACE + ".doFollow", dto);
	}
	
	public int doCancelFollow(DTO dto) throws SQLException {
		return this.sqlSessionTemplate.delete(this.NAMESPACE + ".doCancelFollow", dto);
	}
	
	
	
}
