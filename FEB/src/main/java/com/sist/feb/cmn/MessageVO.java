package com.sist.feb.cmn;

public class MessageVO extends DTO {
	
	private String msgId;
	private String msgContents;
	
	public MessageVO() {
		
	}

	public MessageVO(String msgId, String msgContents) {
		super();
		this.msgId = msgId;
		this.msgContents = msgContents;
	}

	public String getMsgId() {
		return msgId;
	}

	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}

	public String getMsgContents() {
		return msgContents;
	}

	public void setMsgContents(String msgContents) {
		this.msgContents = msgContents;
	}

	@Override
	public String toString() {
		return "Message [msgId=" + msgId + ", msgContents=" + msgContents + ", toString()=" + super.toString() + "]";
	}
	
}
