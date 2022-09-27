package in.co.health.care.mgt.sys.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Columns;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "Appointment")
public class AppointmentEntity extends BaseEntity {

	@Column(name = "ALLERGY", length = 1500)
	private String allergy;
	@Column(name = "DESCRIPTION", length = 1500)
	private String description;
	@Column(name = "PRESCRIPTION", length = 1500)
	private String prescription;
	@Column(name = "DOCTOR_ID")
	private long doctorId;
	
	@Column(name="DOCTOR_NAME",length = 225)
	private String doctorName;
	
	@Column(name = "PATINET_ID")
	private long patientId;
	@Column(name = "CONTACT_NO", length = 1500)
	private String contactNo;
	@Column(name = "PATIENT_NAME", length = 1500)
	private String patientName;
	@Column(name = "ADDRESS", length = 1500)
	private String address;
	@Column(name = "APPOINTMENT_DATE")
	private Date appointmentDate;
	@Column(name = "SLOT", length = 1500)
	private String slot;
	@Column(name = "SLOT_ID")
	private long slotId;

}

