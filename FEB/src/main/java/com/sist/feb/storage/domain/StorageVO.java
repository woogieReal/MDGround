package com.sist.feb.storage.domain;

import com.sist.feb.cmn.DTO;

public class StorageVO extends DTO {
	
	private int    storageNo;
	private int    storeType; // 1:북마크 2:좋아요 3:싫어요(보류)
	private String regDt;
	private String memberEmail;
	private int    postNo;
	
	public StorageVO() {}

	public StorageVO(int storageNo, int storeType, String regDt, String memberEmail, int postNo) {
		super();
		this.storageNo = storageNo;
		this.storeType = storeType;
		this.regDt = regDt;
		this.memberEmail = memberEmail;
		this.postNo = postNo;
	}

	public int getStorageNo() {
		return storageNo;
	}

	public void setStorageNo(int storageNo) {
		this.storageNo = storageNo;
	}

	public int getStoreType() {
		return storeType;
	}

	public void setStoreType(int storeType) {
		this.storeType = storeType;
	}

	public String getRegDt() {
		return regDt;
	}

	public void setRegDt(String regDt) {
		this.regDt = regDt;
	}

	public String getMemberEmail() {
		return memberEmail;
	}

	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}

	public int getPostNo() {
		return postNo;
	}

	public void setPostNo(int postNo) {
		this.postNo = postNo;
	}

	@Override
	public String toString() {
		return "StorageVO [storageNo=" + storageNo + ", storeType=" + storeType + ", regDt=" + regDt + ", memberEmail="
				+ memberEmail + ", postNo=" + postNo + ", toString()=" + super.toString() + "]";
	}
	
	
}
