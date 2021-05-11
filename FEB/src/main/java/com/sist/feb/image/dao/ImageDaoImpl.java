package com.sist.feb.image.dao;

import java.sql.SQLException;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.feb.cmn.DTO;
import com.sist.feb.image.domain.ImageVO;


@Repository
public class ImageDaoImpl {
	
//	▼ 변수 ===============================================================
	
	final static Logger LOG = LoggerFactory.getLogger(ImageDaoImpl.class);
	final String NAMESPACE = "com.sist.feb.image";
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	
//	▼ 생성자 ==============================================================	

	public ImageDaoImpl() {}
	
	
//	▼ 메소드 ===============================================================	
	
	public int doInquirePostSeqCurr() throws SQLException {
		return this.sqlSessionTemplate.selectOne(this.NAMESPACE + ".doInquirePostSeqCurr");
	}
	
	public int doInsert(DTO dto) throws SQLException {
		return this.sqlSessionTemplate.insert(this.NAMESPACE + ".doInsert", dto);
	}
	
	public int doDeleteOne(DTO dto) throws SQLException {
		return this.sqlSessionTemplate.delete(this.NAMESPACE + ".doDeleteOne", dto);
	}
	
	public List<ImageVO> doRetrieve(DTO dto) throws SQLException {
		return this.sqlSessionTemplate.selectList(this.NAMESPACE + ".doRetrieve", dto);
	}
	
	public ImageVO doSelectMainImage(DTO dto) throws SQLException {
		return this.sqlSessionTemplate.selectOne(this.NAMESPACE + ".doSelectMainImage", dto);
	}
	
	public ImageVO doSelectProfileImage(DTO dto) throws SQLException {
		return this.sqlSessionTemplate.selectOne(this.NAMESPACE + ".doSelectProfileImage", dto);
	}
	
	public int doDeleteProfileImage(DTO dto) throws SQLException {
		return this.sqlSessionTemplate.delete(this.NAMESPACE + ".doDeleteProfileImage", dto);
	}

}
