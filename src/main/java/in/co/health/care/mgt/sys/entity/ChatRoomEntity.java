package in.co.health.care.mgt.sys.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="Chat_Room")
public class ChatRoomEntity {
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="patientId")
	private long patientId;
	@Column(name="doctorId")
	private long doctorId;
	@Column(name="chat_Room")
	private String chatRoom;
}
