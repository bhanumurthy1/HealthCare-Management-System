package in.co.health.care.mgt.sys.form;

import javax.validation.constraints.NotEmpty;

import org.springframework.web.multipart.MultipartFile;

import in.co.health.care.mgt.sys.entity.BaseEntity;
import in.co.health.care.mgt.sys.entity.DoctorEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DoctorRegistrationForm extends BaseForm {

	@NotEmpty(message = "LicenseNo is required")
	private String licenseNo;
	@NotEmpty(message = "PastExprience is required")
	private String pastExprience;
	@NotEmpty(message = "TotalExprience is required")
	private String totalExprience;
	@NotEmpty(message = "Specialization is required")
	private String specialization;

	private MultipartFile certificates;

	@Override
	public BaseEntity getDTO() {
		DoctorEntity doctor = new DoctorEntity();
		doctor.setId(id);
		doctor.setLicenseNo(licenseNo);
		doctor.setPastExprience(pastExprience);
		doctor.setTotalExprience(totalExprience);
		doctor.setSpecialization(specialization);
		doctor.setCreatedBy(createdBy);
		doctor.setModifiedBy(modifiedBy);
		doctor.setCreatedDatetime(createdDateTime);
		doctor.setModifiedDatetime(modifiedDateTime);
		return doctor;
	}

	@Override
	public void populate(BaseEntity baseentity) {
		DoctorEntity entity = (DoctorEntity) baseentity;
		id = entity.getId();

		licenseNo = entity.getLicenseNo();
		totalExprience = entity.getTotalExprience();
		pastExprience = entity.getPastExprience();
		specialization = entity.getSpecialization();

		createdBy = entity.getCreatedBy();
		modifiedBy = entity.getModifiedBy();
		createdDateTime = entity.getCreatedDatetime();
		modifiedDateTime = entity.getModifiedDatetime();
	}
}
