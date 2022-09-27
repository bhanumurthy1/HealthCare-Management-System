package in.co.health.care.mgt.sys.form;


import javax.validation.constraints.NotEmpty;

import in.co.health.care.mgt.sys.entity.AppointmentEntity;
import in.co.health.care.mgt.sys.entity.BaseEntity;
import in.co.health.care.mgt.sys.util.DataUtility;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AppointmentForm extends BaseForm {

	@NotEmpty(message = "Allergy is required")
	private String allergy;
	@NotEmpty(message = "Description is required")
	private String description;
	private String prescription;
	private long doctorId;
	private String doctorName;
	private long patientId;
	@NotEmpty(message = "Contact No is required")
	private String contactNo;
	@NotEmpty(message = "Patient is required")
	private String patientName;
	@NotEmpty(message = "Address is required")
	private String address;
	private String appointmentDate;
	private String slot;
	private long slotId;

	@Override
	public BaseEntity getDTO() {
		AppointmentEntity entity = new AppointmentEntity();
		entity.setId(id);
		entity.setAllergy(allergy);
		entity.setDescription(description);
		entity.setPrescription(prescription);
		entity.setDoctorId(doctorId);
		entity.setDoctorName(doctorName);
		entity.setPatientId(patientId);
		entity.setPatientName(patientName);
		entity.setContactNo(contactNo);
		entity.setAddress(address);
		entity.setAppointmentDate(DataUtility.getDate(appointmentDate));
		entity.setSlot(slot);
		entity.setSlotId(slotId);
		entity.setCreatedBy(createdBy);
		entity.setModifiedBy(modifiedBy);
		entity.setCreatedDatetime(createdDateTime);
		entity.setModifiedDatetime(modifiedDateTime);
		return entity;
	}

	@Override
	public void populate(BaseEntity bDto) {
		AppointmentEntity entity = (AppointmentEntity) bDto;
		id = entity.getId();
		allergy = entity.getAllergy();
		description = entity.getDescription();
		prescription = entity.getPrescription();
		doctorId = entity.getDoctorId();
		doctorName = entity.getDoctorName();
		patientId = entity.getPatientId();
		patientName = entity.getPatientName();
		contactNo = entity.getContactNo();
		address = entity.getAddress();
		appointmentDate = DataUtility.getDateString(entity.getAppointmentDate());
		slot = entity.getSlot();
		slotId = entity.getSlotId();
		createdBy = entity.getCreatedBy();
		modifiedBy = entity.getModifiedBy();
		createdDateTime = entity.getCreatedDatetime();
		modifiedDateTime = entity.getModifiedDatetime();
	}

}
