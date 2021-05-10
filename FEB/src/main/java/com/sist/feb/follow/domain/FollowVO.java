package com.sist.feb.follow.domain;

import com.sist.feb.cmn.DTO;

public class FollowVO extends DTO {

	private int    followNo;
	private String followingEmail;
	private String followedEmail;
	private String regDt;
	
	public FollowVO() {}

	public FollowVO(int followNo, String followingEmail, String followedEmail, String regDt) {
		super();
		this.followNo = followNo;
		this.followingEmail = followingEmail;
		this.followedEmail = followedEmail;
		this.regDt = regDt;
	}

	public int getFollowNo() {
		return followNo;
	}

	public void setFollowNo(int followNo) {
		this.followNo = followNo;
	}

	public String getFollowingEmail() {
		return followingEmail;
	}

	public void setFollowingEmail(String followingEmail) {
		this.followingEmail = followingEmail;
	}

	public String getFollowedEmail() {
		return followedEmail;
	}

	public void setFollowedEmail(String followedEmail) {
		this.followedEmail = followedEmail;
	}

	public String getRegDt() {
		return regDt;
	}

	public void setRegDt(String regDt) {
		this.regDt = regDt;
	}

	@Override
	public String toString() {
		return "FollowVO [followNo=" + followNo + ", followingEmail=" + followingEmail + ", followedEmail="
				+ followedEmail + ", regDt=" + regDt + ", toString()=" + super.toString() + "]";
	}
	
}
