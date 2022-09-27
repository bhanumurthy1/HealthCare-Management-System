package in.co.health.care.mgt.sys.form;

import java.util.Date;

import javax.persistence.Column;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import in.co.health.care.mgt.sys.entity.BaseEntity;
import in.co.health.care.mgt.sys.entity.MedicineEntity;
import in.co.health.care.mgt.sys.entity.ScheduleSlotEntity;
import in.co.health.care.mgt.sys.entity.UserEntity;
import in.co.health.care.mgt.sys.util.DataUtility;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ScheduleSlotForm  extends BaseForm{

	@NotEmpty(message = "Slot is required")
	private String slot;
	@NotEmpty(message = "Schedule Date is required")
	private String scheduledate;
	private long doctorId;
	private boolean available;
	
	@Override
	public BaseEntity getDTO() {
		ScheduleSlotEntity entity=new ScheduleSlotEntity();
		entity.setId(id);
		entity.setSlot(slot);
		entity.setDoctorId(doctorId);
		entity.setScheduledate(DataUtility.getDate(scheduledate));
		entity.setAvailable(true);
		entity.setCreatedBy(createdBy);
		entity.setModifiedBy(modifiedBy);
		entity.setCreatedDatetime(createdDateTime);
		entity.setModifiedDatetime(modifiedDateTime);
		return entity;
	}

	@Override
	public void populate(BaseEntity bDto) {
		ScheduleSlotEntity entity = (ScheduleSlotEntity) bDto;
		id = entity.getId();
		slot=entity.getSlot();
		doctorId=entity.getDoctorId();
		scheduledate=String.valueOf(entity.getScheduledate());
		createdBy = entity.getCreatedBy();
		modifiedBy = entity.getModifiedBy();
		createdDateTime = entity.getCreatedDatetime();
		modifiedDateTime = entity.getModifiedDatetime();
	}

}
