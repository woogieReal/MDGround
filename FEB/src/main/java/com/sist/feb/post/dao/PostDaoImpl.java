package com.sist.feb.post.dao;

import java.sql.SQLException;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.feb.cmn.DTO;
import com.sist.feb.post.domain.PostVO;


@Repository
public class PostDaoImpl {

//	▼ 변수 ===============================================================
	
	final static Logger LOG = LoggerFactory.getLogger(PostDaoImpl.class);
	final String NAMESPACE = "com.sist.feb.post";
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
//	▼ 생성자 ==============================================================

	public PostDaoImpl() {}
	
	
//	▼ 메소드 ===============================================================
	
	public int doInsert(DTO dto) throws SQLException {
		return this.sqlSessionTemplate.insert(this.NAMESPACE + ".doInsert", dto);
	}
	
	public List<PostVO> doRetrieve(DTO dto) throws SQLException {
		return this.sqlSessionTemplate.selectList(this.NAMESPACE + ".doRetrieve", dto);
	}
	
	public PostVO doSelect(DTO dto) throws SQLException {
		return this.sqlSessionTemplate.selectOne(this.NAMESPACE + ".doSelect", dto);
	}

	public int doUpdate(DTO dto) throws SQLException {
		return this.sqlSessionTemplate.update(this.NAMESPACE + ".doUpdate", dto);
	}
	
	public int doDelete(DTO dto) throws SQLException {
		return this.sqlSessionTemplate.delete(this.NAMESPACE + ".doDelete", dto);
	}
	
	public int doLike(DTO dto) throws SQLException {
		return this.sqlSessionTemplate.update(this.NAMESPACE + ".doLike", dto);
	}
	
	public int doCancelLike(DTO dto) throws SQLException {
		return this.sqlSessionTemplate.update(this.NAMESPACE + ".doCancelLike", dto);
	}

	
	
	
	
}
