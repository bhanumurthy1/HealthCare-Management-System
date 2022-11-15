package in.co.health.care.mgt.sys.entity;


public class ChatMessage {
		
	private String content;
	private String sender;
	private long senderId;
	private long reciverId;
	
	
	

	public long getSenderId() {
		return senderId;
	}

	public void setSenderId(long senderId) {
		this.senderId = senderId;
	}

	public long getReciverId() {
		return reciverId;
	}

	public void setReciverId(long reciverId) {
		this.reciverId = reciverId;
	}

	private MessageType type;
	
	public enum MessageType{
		CHAT,LEAVE,JOIN
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public MessageType getType() {
		return type;
	}

	public void setType(MessageType type) {
		this.type = type;
	}
	
	
	
}
