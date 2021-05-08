package com.sist.feb.post.domain;

import com.sist.feb.cmn.DTO;

public class PostVO extends DTO {

	private int    postNo;         //post_seq.nextval
	private String title;          //null(NN)
	private String textMd;         //null
	private String textHtml;       //null
	private int    readCnt;        //0
	private int    likeCnt;        //0
	private int    hateCnt;        //0
	private String category;       //1
	private String regDt;          //sysdate
	private String modDt;          //null
	private String memberEmail;    //creator
	private String thumbNail;      //post thumb nail
	
	
	public PostVO() {}


	public PostVO(int postNo, String title, String textMd, String textHtml, int readCnt, int likeCnt, int hateCnt,
			String category, String regDt, String modDt, String memberEmail, String thumbNail) {
		super();
		this.postNo = postNo;
		this.title = title;
		this.textMd = textMd;
		this.textHtml = textHtml;
		this.readCnt = readCnt;
		this.likeCnt = likeCnt;
		this.hateCnt = hateCnt;
		this.category = category;
		this.regDt = regDt;
		this.modDt = modDt;
		this.memberEmail = memberEmail;
		this.thumbNail = thumbNail;
	}


	public int getPostNo() {
		return postNo;
	}


	public void setPostNo(int postNo) {
		this.postNo = postNo;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getTextMd() {
		return textMd;
	}


	public void setTextMd(String textMd) {
		this.textMd = textMd;
	}


	public String getTextHtml() {
		return textHtml;
	}


	public void setTextHtml(String textHtml) {
		this.textHtml = textHtml;
	}


	public int getReadCnt() {
		return readCnt;
	}


	public void setReadCnt(int readCnt) {
		this.readCnt = readCnt;
	}


	public int getLikeCnt() {
		return likeCnt;
	}


	public void setLikeCnt(int likeCnt) {
		this.likeCnt = likeCnt;
	}


	public int getHateCnt() {
		return hateCnt;
	}


	public void setHateCnt(int hateCnt) {
		this.hateCnt = hateCnt;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public String getRegDt() {
		return regDt;
	}


	public void setRegDt(String regDt) {
		this.regDt = regDt;
	}


	public String getModDt() {
		return modDt;
	}


	public void setModDt(String modDt) {
		this.modDt = modDt;
	}


	public String getMemberEmail() {
		return memberEmail;
	}


	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}


	public String getThumbNail() {
		return thumbNail;
	}


	public void setThumbNail(String thumbNail) {
		this.thumbNail = thumbNail;
	}


	@Override
	public String toString() {
		return "PostVO [postNo=" + postNo + ", title=" + title + ", textMd=" + textMd + ", textHtml=" + textHtml
				+ ", readCnt=" + readCnt + ", likeCnt=" + likeCnt + ", hateCnt=" + hateCnt + ", category=" + category
				+ ", regDt=" + regDt + ", modDt=" + modDt + ", memberEmail=" + memberEmail + ", thumbNail=" + thumbNail
				+ ", toString()=" + super.toString() + "]";
	}

}
