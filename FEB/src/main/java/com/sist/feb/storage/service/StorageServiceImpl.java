package com.sist.feb.storage.service;

import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.feb.cmn.DTO;
import com.sist.feb.post.domain.PostVO;
import com.sist.feb.storage.dao.StorageDaoImpl;

@Service
public class StorageServiceImpl {
	
//	▼ 변수 ===============================================================
	
	final Logger LOG = LoggerFactory.getLogger(StorageServiceImpl.class);
	
	@Autowired
	private StorageDaoImpl storageDao;
	

//	▼ 생성자 ==============================================================	

	public StorageServiceImpl () {}
	

//	▼ 메소드 ===============================================================

	public int doStore(DTO dto) throws SQLException {
		return storageDao.doStore(dto);
	}

	public int doCancelStore(DTO dto) throws SQLException {
		return storageDao.doCancelStore(dto);
	}

	public int doCheckStore(DTO dto) throws SQLException {
		return storageDao.doCheckStore(dto);
	}

	public List<PostVO> doRetrieveBookmark(DTO dto) throws SQLException {
		return storageDao.doRetrieveBookmark(dto);
	}


}
