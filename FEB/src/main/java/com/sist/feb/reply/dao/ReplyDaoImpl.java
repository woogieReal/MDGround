package com.sist.feb.reply.dao;

import java.sql.SQLException;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.feb.cmn.DTO;
import com.sist.feb.reply.domain.ReplyVO;

@Repository
public class ReplyDaoImpl {
	
//	▼ 변수 ===============================================================
	
	final Logger LOG = LoggerFactory.getLogger(ReplyDaoImpl.class);
	
	final String NAMESPACE = "com.sist.feb.reply";
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	

//	▼ 생성자 ==============================================================	

	public ReplyDaoImpl () {}
	

//	▼ 메소드 ===============================================================	
	
	public int doInsert(DTO dto) throws SQLException {
		return this.sqlSessionTemplate.insert(this.NAMESPACE + ".doInsert", dto);
	}
	
	public int doChangeDelete(DTO dto) throws SQLException {
		return this.sqlSessionTemplate.update(this.NAMESPACE + ".doChangeDelete", dto);
	}
	
	public List<ReplyVO> doRetrieve(DTO dto) throws SQLException {
		return this.sqlSessionTemplate.selectList(this.NAMESPACE + ".doRetrieve", dto);
	}
	
	public int doDelete(DTO dto) throws SQLException {
		return this.sqlSessionTemplate.delete(this.NAMESPACE + ".doDelete", dto);
	}
	
	
	
	
	
	
	
}
