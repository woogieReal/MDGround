/**
* <pre>
* com.sist.feb.member.domain
* Class Name : MemberVO.java
* Description: 멤버정보 VO
* Author: 김재욱
* Since: 2021/03/05
* Version 0.1
* Copyright (c) by H.R.KIM All right reserved.
* Modification Information
* 수정일   수정자    수정내용
*-----------------------------------------------------
*2021/03/05 최초생성
*-----------------------------------------------------
* </pre>
*/
package com.sist.feb.member.domain;

import com.sist.feb.cmn.DTO;

public class MemberVO extends DTO{

	private int    memberNo;
	private String email;     //이메일
	private String name;      //이름
	private String pw;        //비밀번호
	private String location;  //위치
	private String regDt;     //등록일
	private String introMd;   //소개글_md
	private String introHtml; //소개글_html
	
	public MemberVO() {
		
	}

	public MemberVO(int memberNo, String email, String name, String pw, String location, String regDt, String introMd,
			String introHtml) {
		super();
		this.memberNo = memberNo;
		this.email = email;
		this.name = name;
		this.pw = pw;
		this.location = location;
		this.regDt = regDt;
		this.introMd = introMd;
		this.introHtml = introHtml;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getRegDt() {
		return regDt;
	}

	public void setRegDt(String regDt) {
		this.regDt = regDt;
	}

	public String getIntroMd() {
		return introMd;
	}

	public void setIntroMd(String introMd) {
		this.introMd = introMd;
	}

	public String getIntroHtml() {
		return introHtml;
	}

	public void setIntroHtml(String introHtml) {
		this.introHtml = introHtml;
	}

	@Override
	public String toString() {
		return "MemberVO [memberNo=" + memberNo + ", email=" + email + ", name=" + name + ", pw=" + pw + ", location="
				+ location + ", regDt=" + regDt + ", introMd=" + introMd + ", introHtml=" + introHtml + ", toString()="
				+ super.toString() + "]";
	}
	
}
