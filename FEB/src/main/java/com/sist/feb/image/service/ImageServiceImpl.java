package com.sist.feb.image.service;

import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.feb.cmn.DTO;
import com.sist.feb.image.dao.ImageDaoImpl;
import com.sist.feb.image.domain.ImageVO;


@Service
public class ImageServiceImpl {

//	▼ 변수 ===============================================================

	final Logger LOG = LoggerFactory.getLogger(ImageServiceImpl.class);
	
	@Autowired
	private ImageDaoImpl imageDao;
	
	
//	▼ 생성자 ==============================================================	

	public ImageServiceImpl() {}
	
	
//	▼ 메소드 ===============================================================	

	public int upRegisterImages(List<ImageVO> imageList, String fromTb, int mainImageNum) throws Exception {
		int flag = 0;
		int cnt = 0;
		
		if (imageList.size() > 0) {

			if (fromTb.equals("1")) {
				int postSeqCurr = imageDao.doInquirePostSeqCurr();
				
				for (ImageVO vo : imageList) {
					
					if(cnt == mainImageNum) vo.setMainImage(1);  
					
					vo.setFromTb(Integer.parseInt(fromTb));
					vo.setFromNo(postSeqCurr);
					flag = imageDao.doInsert(vo);
					
					cnt += 1;
				}

			} 
			else if (fromTb.equals("2")) {
				int memberNo = mainImageNum;

				for (ImageVO vo : imageList) {
					
					vo.setFromTb(Integer.parseInt(fromTb));
					vo.setFromNo(memberNo);
					flag = imageDao.doInsert(vo);
					
					cnt += 1;
				}
			}

		}

		return flag;
	}
	
	public int upDeleteImages(List<ImageVO> imageList) throws Exception {
		int flag = 0; 
	
		if(imageList.size() > 0) {
			for(ImageVO vo : imageList) {
				flag = imageDao.doDeleteOne(vo);
			}
		}
		return flag;
	}
	
	public int upUpdateImages(int fromTb, int fromNo, List<ImageVO> imageListDel, List<ImageVO> imageListNew, int mainImageNum) throws Exception {
		int flag = 0;
		int cnt = 0;
		
		if(imageListDel.size() > 0) {
			for(ImageVO vo : imageListDel) {
				flag = imageDao.doDeleteOne(vo);
			}
		}
		
		if(imageListNew.size() > 0) {
			for(ImageVO vo : imageListNew) {
				if(cnt == mainImageNum) vo.setMainImage(1);
				
				vo.setFromTb(fromTb);
				vo.setFromNo(fromNo);
				flag = imageDao.doInsert(vo);
				
				cnt += 1;
			}
		}
		return flag;
	}
	
	public List<ImageVO> doRetrieveImages(ImageVO image) throws Exception {
		return imageDao.doRetrieve(image);
	}
	
	public ImageVO doSelectProfileImage(DTO dto) throws SQLException {
		return imageDao.doSelectProfileImage(dto);
	}
	
	public int doDeleteProfileImage(DTO dto) throws SQLException {
		return imageDao.doDeleteProfileImage(dto);
	}
	
}
