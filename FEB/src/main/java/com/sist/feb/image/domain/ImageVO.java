package com.sist.feb.image.domain;

import com.sist.feb.cmn.DTO;

public class ImageVO extends DTO {
	
	private int    imageNo;      //이미지번호
	private int    mainImage;    //메인이미지
	private String orgName;      //원본파일명
	private String saveName;     //저장파일명
	private String fullPath;
	private String path;          //경로
	private int    fileSize;     //파일용량
	private String fileExt;      //확장자
	private int    fromTb;       //출처
	private int    fromNo;       //출처번호
	private String regDt;        //저장일
	
	public ImageVO() {}

	public ImageVO(int imageNo, int mainImage, String orgName, String saveName, String fullPath, String path,
			int fileSize, String fileExt, int fromTb, int fromNo, String regDt) {
		super();
		this.imageNo = imageNo;
		this.mainImage = mainImage;
		this.orgName = orgName;
		this.saveName = saveName;
		this.fullPath = fullPath;
		this.path = path;
		this.fileSize = fileSize;
		this.fileExt = fileExt;
		this.fromTb = fromTb;
		this.fromNo = fromNo;
		this.regDt = regDt;
	}

	public int getImageNo() {
		return imageNo;
	}

	public void setImageNo(int imageNo) {
		this.imageNo = imageNo;
	}

	public int getMainImage() {
		return mainImage;
	}

	public void setMainImage(int mainImage) {
		this.mainImage = mainImage;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getSaveName() {
		return saveName;
	}

	public void setSaveName(String saveName) {
		this.saveName = saveName;
	}

	public String getFullPath() {
		return fullPath;
	}

	public void setFullPath(String fullPath) {
		this.fullPath = fullPath;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public int getFileSize() {
		return fileSize;
	}

	public void setFileSize(int fileSize) {
		this.fileSize = fileSize;
	}

	public String getFileExt() {
		return fileExt;
	}

	public void setFileExt(String fileExt) {
		this.fileExt = fileExt;
	}

	public int getFromTb() {
		return fromTb;
	}

	public void setFromTb(int fromTb) {
		this.fromTb = fromTb;
	}

	public int getFromNo() {
		return fromNo;
	}

	public void setFromNo(int fromNo) {
		this.fromNo = fromNo;
	}

	public String getRegDt() {
		return regDt;
	}

	public void setRegDt(String regDt) {
		this.regDt = regDt;
	}

	@Override
	public String toString() {
		return "ImageVO [imageNo=" + imageNo + ", mainImage=" + mainImage + ", orgName=" + orgName + ", saveName="
				+ saveName + ", fullPath=" + fullPath + ", path=" + path + ", fileSize=" + fileSize + ", fileExt="
				+ fileExt + ", fromTb=" + fromTb + ", fromNo=" + fromNo + ", regDt=" + regDt + ", toString()="
				+ super.toString() + "]";
	}

	
}
