package in.co.health.care.mgt.sys.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "NOTIFICATIONS")
public class NotificationEntity extends BaseEntity {

	@Column(name = "notification", length = 1500)
	private String notification;
	@Column(name = "userId")
	private long userId;
	@Column(name = "date")
	private Date date;

}
