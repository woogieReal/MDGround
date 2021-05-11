package com.sist.feb.storage.dao;

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
public class StorageDaoImpl {

//	▼ 변수 ===============================================================
	
	final Logger LOG = LoggerFactory.getLogger(StorageDaoImpl.class);
	
	final String NAMESPACE = "com.sist.feb.storage";
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

//	▼ 생성자 ==============================================================	

	public StorageDaoImpl () {}
	

//	▼ 메소드 ===============================================================	
	
	public int doStore(DTO dto) throws SQLException {
		return this.sqlSessionTemplate.insert(this.NAMESPACE + ".doStore", dto);
	}
	
	public int doCancelStore(DTO dto) throws SQLException {
		return this.sqlSessionTemplate.delete(this.NAMESPACE + ".doCancelStore", dto);
	}
	
	public int doCheckStore(DTO dto) throws SQLException {
		return this.sqlSessionTemplate.selectOne(this.NAMESPACE + ".doCheckStore", dto);
	}
	
	public List<PostVO> doRetrieveBookmark(DTO dto) throws SQLException {
		return this.sqlSessionTemplate.selectList(this.NAMESPACE + ".doRetrieveBookmark", dto);
	}
	
	
}
