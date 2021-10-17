package com.sist.feb.image.controller;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sist.feb.cmn.MessageVO;
import com.sist.feb.cmn.StringUtil;
import com.sist.feb.image.domain.ImageVO;
import com.sist.feb.image.service.ImageServiceImpl;
import com.sist.feb.member.domain.MemberVO;
import com.sist.feb.member.service.MemberServiceImpl;
import com.sist.feb.post.domain.PostVO;

@Controller
public class ImageController {

//	▼ 변수 ===============================================================
	
	final Logger LOG = LoggerFactory.getLogger(ImageController.class);

	@Autowired
	ImageServiceImpl imageService;
	
	@Autowired
	MemberServiceImpl memberService;
	
//	final String BASIC_PATH = "C:\\Users\\123wo\\OneDrive\\문서\\GitHub\\MDGround\\FEB\\src\\main\\webapp\\resources\\upload";
//	final String BASIC_PATH = "/var/lib/tomcat8/webapps/feb/resources/upload";
//	final String BASIC_PATH = "/var/lib/tomcat8/webapps/upload";
	final String BASIC_PATH = "/Users/gimjaeug/Documents/MDGround/FEB/src/main/webapp/resources/upload";
	
	
//	▼ 생성자 ==============================================================	
	
	public ImageController() {}
	
	
//	▼ 메소드 ===============================================================
	
	@RequestMapping(value = "image/image_view.do", method = RequestMethod.GET
			,produces = "application/json;charset=UTF-8")
	public String view(
			@RequestParam(value = "fromTb", required = false)String fromTb,
			@RequestParam(value = "profileImagePath", required = false)String profileImagePath,
			@RequestParam(value = "profileImageName", required = false)String profileImageName,
			Model model) throws Exception {
		
		LOG.debug("fromTb: "+fromTb);
		model.addAttribute("fromTb", fromTb);
		model.addAttribute("profileImagePath", profileImagePath);
		model.addAttribute("profileImageName", profileImageName);
		return "image/file_upload_popup";
		
	}
	
	@RequestMapping(value = "image/do_upload.do", method = RequestMethod.POST
			,produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String doUpload(MultipartHttpServletRequest request) throws Exception {
		
		List<MultipartFile> fileList = request.getFiles("file_list");
		
		Gson gson = new Gson();
		
		String year = StringUtil.formatDate("yyyy");
		String month = StringUtil.formatDate("MM");
		
		//파일이 업로드 될 경로
		String path = BASIC_PATH+ File.separator + year + File.separator + month;
		String simplePath = "/resources/upload/" + year + "/" + month + "/";
		
		LOG.debug("path: "+path);
		LOG.debug("simplePath: "+simplePath);
		
		//위에서 설정한 경로의 폴더가 없을 경우 생성
		File dir = new File(path);
		
		if(dir.isDirectory()==false) {
			dir.mkdirs();
		}
		
		
		List<ImageVO> imageList = new ArrayList<ImageVO>();
		
		for(MultipartFile file : fileList){
			if(!file.isEmpty()) {
				String orgName = file.getOriginalFilename();
				String saveName = StringUtil.getUUID() + orgName;
				int fileSize = (int) file.getSize();
				String fileExt = orgName.substring(orgName.lastIndexOf("."));
				
				ImageVO image = new ImageVO();
				image.setOrgName(orgName);
				image.setSaveName(saveName);
				image.setFullPath(path);
				image.setPath(simplePath);
				image.setFileSize(fileSize);
				image.setFileExt(fileExt);
				
				imageList.add(image);
				
				file.transferTo(new File(path, saveName));
			}
		}
		
		
		String jsonStr = gson.toJson(imageList.toArray());
		
		LOG.debug(jsonStr);
		
		return jsonStr;
		
	}
	
	@RequestMapping(value = "image/do_delete_profile_image.do", method = RequestMethod.POST
			,produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String doDeleteProfileImage(@RequestParam(value = "profileImagePath", required = false)String profileImagePath,
									   @RequestParam(value = "profileImageName", required = false)String profileImageName,
									   HttpSession session
	) throws Exception {
		
		
		String imageFullPath = profileImagePath + File.separator + profileImageName;
		LOG.debug("imageFullPath: "+imageFullPath);
		
		Path file = Paths.get(imageFullPath);
		boolean deleteFlag = Files.deleteIfExists(file);
		if(deleteFlag) LOG.debug("Old profile image file is deleted");
		
		MemberVO loginMember = new MemberVO();
		if(null != session.getAttribute("member")) {
			loginMember = (MemberVO) session.getAttribute("member");
		}
		
		MessageVO message = new MessageVO();
		message.setMsgId(Integer.toString(imageService.doDeleteProfileImage(loginMember)));
		
		if(message.getMsgId().equals("1")) message.setMsgContents("The Profile image is deleted");
		else message.setMsgContents("There were no profile image");
		
		Gson gson = new Gson();
		
		LOG.debug("메세지: "+gson.toJson(message));
		
		return gson.toJson(message);
		
		
	}
	
	@RequestMapping(value = "image/do_upload_profile_image.do", method = RequestMethod.POST
			,produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String doUploadProfileImage(MultipartHttpServletRequest request, HttpSession session) throws Exception {
		
		List<MultipartFile> fileList = request.getFiles("file_list");
		
		Gson gson = new Gson();
		
		String year = StringUtil.formatDate("yyyy");
		String month = StringUtil.formatDate("MM");
		
		//파일이 업로드 될 경로
		String path = BASIC_PATH+ File.separator + year + File.separator + month;
		String simplePath = "/resources/upload/" + year + "/" + month + "/";
		
		LOG.debug("path: "+path);
		LOG.debug("simplePath: "+simplePath);
		
		//위에서 설정한 경로의 폴더가 없을 경우 생성
		File dir = new File(path);
		
		if(dir.isDirectory()==false) {
			dir.mkdirs();
		}
		
		List<ImageVO> imageList = new ArrayList<ImageVO>();
		
		for(MultipartFile file : fileList){
			if(!file.isEmpty()) {
				String orgName = file.getOriginalFilename();
				String saveName = StringUtil.getUUID() + orgName;
				int fileSize = (int) file.getSize();
				String fileExt = orgName.substring(orgName.lastIndexOf("."));
				
				ImageVO image = new ImageVO();
				image.setOrgName(orgName);
				image.setSaveName(saveName);
				image.setFullPath(path);
				image.setPath(simplePath);
				image.setFileSize(fileSize);
				image.setFileExt(fileExt);
				
				imageList.add(image);
				
				file.transferTo(new File(path, saveName));
			}
		}
		
		int memberNo = 0;
		
		if(null != session.getAttribute("member")) {
			MemberVO loginMember = (MemberVO) session.getAttribute("member");
			memberNo = loginMember.getMemberNo();
		}
		
		MessageVO message = new MessageVO();
		message.setMsgId(Integer.toString(imageService.upRegisterImages(imageList, "2", memberNo)));
		
		if(message.getMsgId().equals("1")) message.setMsgContents("Successfully the profile image is uploaded");
		else message.setMsgContents("Failure to upload the profile image");
		
		LOG.debug("메세지: "+gson.toJson(message));
		
		return gson.toJson(message);
		
	}
	
	@RequestMapping(value = "image/do_select_profile_image.do", method = RequestMethod.POST
			,produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String doSelectProfileImage(MemberVO inVO) throws Exception {
		MemberVO outVO = memberService.doSelectOne(inVO);
		ImageVO imageVO = imageService.doSelectProfileImage(outVO);
		Gson gson = new Gson();
		return gson.toJson(imageVO);
	}
	
	
	@RequestMapping(value = "image/do_insert.do", method = RequestMethod.POST
			,produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String doInsert(@RequestParam(value = "imageList", required = false)String jsonStr, 
				           @RequestParam(value = "fromTb", required = false)String fromTb,
				           @RequestParam(value = "mainImage", required = false)String mainImage
			) throws Exception {
		
		int mainImageNum = 0;
		
		if(mainImage.equals("")) mainImageNum = 0;
		else mainImageNum = Integer.parseInt(mainImage);
		
		LOG.debug("mainImage"+ mainImageNum);
		
		Gson gson = new Gson();
		List<ImageVO> imageList = gson.fromJson(jsonStr, new TypeToken<List<ImageVO>>() {}.getType());
		
		MessageVO message = new MessageVO();
		message.setMsgId(Integer.toString(imageService.upRegisterImages(imageList, fromTb, mainImageNum)));
		
		if(message.getMsgId().equals("1")) message.setMsgContents("Successfully images are uploaded");
		else message.setMsgContents("Failure to upload images");
		
		LOG.debug("메세지: "+gson.toJson(message));
		
		return gson.toJson(message);
		
	}
	
	@RequestMapping(value = "image/do_delete.do", method = RequestMethod.POST
			,produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String doDelete(@RequestParam(value = "imageList", required = false)String jsonStr) throws Exception {
		
		Gson gson = new Gson();
		List<ImageVO> imageList = gson.fromJson(jsonStr, new TypeToken<List<ImageVO>>() {}.getType());
		
		for(ImageVO vo : imageList) {

			String imageFullPath = vo.getFullPath() + File.separator + vo.getSaveName();
			LOG.debug("imageFullPath: "+imageFullPath);
			
			Path file = Paths.get(imageFullPath);
			Files.deleteIfExists(file);
			
		}
		
		MessageVO message = new MessageVO();
		message.setMsgId(Integer.toString(imageService.upDeleteImages(imageList)));
		
		if(message.getMsgId().equals("1")) message.setMsgContents("Images are Successfully deleted");
		else message.setMsgContents("Failure to delete images");
		
		LOG.debug("메세지: "+gson.toJson(message));
		
		return gson.toJson(message);
		
	}
	
	@RequestMapping(value = "image/do_update.do", method = RequestMethod.POST
			,produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String doUpdate(
			@RequestParam(value = "fromTb", required = false)String fromTb,
			@RequestParam(value = "fromNo", required = false)String fromNo,
			@RequestParam(value = "imageListDel", required = false)String jsonStrDel,
			@RequestParam(value = "imageListNew", required = false)String jsonStrNew,
			@RequestParam(value = "mainImage", required = false)String mainImage
			) throws Exception {
		
		int mainImageNum = 0;
		
		if(mainImage.equals("")) mainImageNum = 0;
		else mainImageNum = Integer.parseInt(mainImage);
		
		LOG.debug("mainImage"+ mainImageNum);
		
		Gson gson = new Gson();
		List<ImageVO> imageListDel = gson.fromJson(jsonStrDel, new TypeToken<List<ImageVO>>() {}.getType());
		List<ImageVO> imageListNew = gson.fromJson(jsonStrNew, new TypeToken<List<ImageVO>>() {}.getType());
		
		MessageVO message = new MessageVO();
		message.setMsgId(Integer.toString(imageService.upUpdateImages(Integer.parseInt(fromTb), Integer.parseInt(fromNo), imageListDel, imageListNew, mainImageNum)));
		
		for(ImageVO vo : imageListDel) {
			
			String imageFullPath = vo.getFullPath() + File.separator + vo.getSaveName();
			LOG.debug("imageFullPath: "+imageFullPath);
			
			Path file = Paths.get(imageFullPath);
			Files.deleteIfExists(file);
			
		}
		
		if(message.getMsgId().equals("1")) message.setMsgContents("Images are Successfully edited");
		else message.setMsgContents("Failure to edit images");
		
		LOG.debug("메세지: "+gson.toJson(message));
		
		return gson.toJson(message);
		
	}
	
	
	@RequestMapping(value = "image/do_retrieve.do", method = RequestMethod.GET
			,produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String doRetrieve(ImageVO image) throws Exception {
		List<ImageVO> imageList = imageService.doRetrieveImages(image);
		Gson gson = new Gson();
		return gson.toJson(imageList.toArray());
	}
	
	@RequestMapping(value = "image/do_select_main_image.do", method = RequestMethod.POST
			,produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String doSelectMainImage(PostVO postVO) throws Exception {
		LOG.debug("doSelectMainImage");
		ImageVO imageVO = imageService.doSelectMainImage(postVO);
		Gson gson = new Gson();
		return gson.toJson(imageVO);
	}
	
}
