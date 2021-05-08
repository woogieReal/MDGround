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

	private String email;     //이메일
	private String name;      //이름
	private String pw;        //비밀번호
	private String location;  //위치
	private String intro;     //소개글
	private String regDt;    //등록일
	
	public MemberVO() {
		
	}

	public MemberVO(String email, String name, String pw, String location, String intro, String regDt) {
		super();
		this.email = email;
		this.name = name;
		this.pw = pw;
		this.location = location;
		this.intro = intro;
		this.regDt = regDt;
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

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public String getRegDt() {
		return regDt;
	}

	public void setRegDt(String regDt) {
		this.regDt = regDt;
	}

	@Override
	public String toString() {
		return "MemberVO [email=" + email + ", name=" + name + ", pw=" + pw + ", location=" + location + ", intro="
				+ intro + ", regDt=" + regDt + ", toString()=" + super.toString() + "]";
	}

	
}
