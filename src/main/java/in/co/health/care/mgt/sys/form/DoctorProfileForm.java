package in.co.health.care.mgt.sys.form;

import javax.validation.constraints.NotEmpty;

import org.springframework.web.multipart.MultipartFile;

import in.co.health.care.mgt.sys.entity.BaseEntity;
import in.co.health.care.mgt.sys.entity.DoctorEntity;
import in.co.health.care.mgt.sys.entity.UserEntity;
import in.co.health.care.mgt.sys.util.DataUtility;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DoctorProfileForm extends BaseForm {

	@NotEmpty(message = "First Name is required")
	private String firstName;

	@NotEmpty(message = "LastName is required")
	private String lastName;

	@NotEmpty(message = "Middle Name is required")
	private String middleName;

	@NotEmpty(message = "Email is required")
	private String email;

	@NotEmpty(message = "Phone No is required")
	private String phoneNo;

	@NotEmpty(message = "Gender is required")
	private String gender;

	@NotEmpty(message = "Age is required")
	private String age;
	
	@NotEmpty(message = "User Name is required")
	private String userName;
	
	@NotEmpty(message = "Password is required")
	private String password;
	

	@NotEmpty(message = "DOB is required")
	private String dob;

	@NotEmpty(message = "LicenseNo is required")
	private String licenseNo;
	private MultipartFile certificates;
	@NotEmpty(message = "PastExprience is required")
	private String pastExprience;
	@NotEmpty(message = "TotalExprience is required")
	private String totalExprience;
	@NotEmpty(message = "Specialization is required")
	private String specialization;
	
	private MultipartFile profilePic;

	private long dId;
	
	@Override
	public BaseEntity getDTO() {
		UserEntity entity = new UserEntity();
		entity.setId(id);
		entity.setFirstName(firstName);
		entity.setLastName(lastName);
		entity.setMiddleName(middleName);
		entity.setEmailId(email);
		entity.setGender(gender);
		entity.setAge(age);
		entity.setPhoneNo(phoneNo);
		
		entity.setUserName(userName);
		entity.setPassword(password);
		entity.setDob(DataUtility.getDate(dob));
		
		DoctorEntity doctor = new DoctorEntity();
		doctor.setId(dId);
		doctor.setLicenseNo(licenseNo);
		doctor.setPastExprience(pastExprience);
		doctor.setTotalExprience(totalExprience);
		doctor.setSpecialization(specialization);
		entity.setDoctor(doctor);
		
		entity.setCreatedBy(createdBy);
		entity.setModifiedBy(modifiedBy);
		entity.setCreatedDatetime(createdDateTime);
		entity.setModifiedDatetime(modifiedDateTime);
		return entity;
	}

	@Override
	public void populate(BaseEntity baseentity) {
		UserEntity entity = (UserEntity) baseentity;
		id = entity.getId();
		firstName = entity.getFirstName();
		lastName = entity.getLastName();
		middleName=entity.getMiddleName();
		email = entity.getEmailId(); 
		gender = entity.getGender();
		dob = DataUtility.getDateString(entity.getDob());
		age=entity.getAge();
		userName=entity.getUserName();
		password=entity.getPassword();
		
		dId=entity.getDoctor().getId();
		licenseNo=entity.getDoctor().getLicenseNo();
		totalExprience=entity.getDoctor().getTotalExprience();
		pastExprience=entity.getDoctor().getPastExprience();
		specialization=entity.getDoctor().getSpecialization();
		
		phoneNo=entity.getPhoneNo();		
		createdBy = entity.getCreatedBy();
		modifiedBy = entity.getModifiedBy();
		createdDateTime = entity.getCreatedDatetime();
		modifiedDateTime = entity.getModifiedDatetime();
	}
}
