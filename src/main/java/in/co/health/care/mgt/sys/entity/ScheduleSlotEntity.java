package in.co.health.care.mgt.sys.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="SCHEDULE_SLOT")
public class ScheduleSlotEntity extends BaseEntity {

	@Column(name="slot",length = 755)
	private String slot;
	@Column(name="schedule_date")
	private Date scheduledate;
	@Column(name="doctor_id",columnDefinition = "BIGINT default 0")
	private long doctorId;
	@Column(name="available",columnDefinition = "BIT default 0")
	private boolean available;
	
}
