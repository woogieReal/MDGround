package com.sist.feb.reply.domain;

import com.sist.feb.cmn.DTO;

public class ReplyVO extends DTO {

	private int    replyNo;
	private String contents;
	private int    depth;
	private int    parentReply;
	private int    deleteCheck;
	private String regDt;
	private int    postNo;
	private String memberEmail;
	
	public ReplyVO() {}

	public ReplyVO(int replyNo, String contents, int depth, int parentReply, int deleteCheck, String regDt, int postNo,
			String memberEmail) {
		super();
		this.replyNo = replyNo;
		this.contents = contents;
		this.depth = depth;
		this.parentReply = parentReply;
		this.deleteCheck = deleteCheck;
		this.regDt = regDt;
		this.postNo = postNo;
		this.memberEmail = memberEmail;
	}

	public int getReplyNo() {
		return replyNo;
	}

	public void setReplyNo(int replyNo) {
		this.replyNo = replyNo;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public int getParentReply() {
		return parentReply;
	}

	public void setParentReply(int parentReply) {
		this.parentReply = parentReply;
	}

	public int getDeleteCheck() {
		return deleteCheck;
	}

	public void setDeleteCheck(int deleteCheck) {
		this.deleteCheck = deleteCheck;
	}

	public String getRegDt() {
		return regDt;
	}

	public void setRegDt(String regDt) {
		this.regDt = regDt;
	}

	public int getPostNo() {
		return postNo;
	}

	public void setPostNo(int postNo) {
		this.postNo = postNo;
	}

	public String getMemberEmail() {
		return memberEmail;
	}

	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}

	@Override
	public String toString() {
		return "ReplyVO [replyNo=" + replyNo + ", contents=" + contents + ", depth=" + depth + ", parentReply="
				+ parentReply + ", deleteCheck=" + deleteCheck + ", regDt=" + regDt + ", postNo=" + postNo
				+ ", memberEmail=" + memberEmail + ", toString()=" + super.toString() + "]";
	}
	
}
