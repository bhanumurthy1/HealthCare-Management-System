package in.co.health.care.mgt.sys.form;

import javax.validation.constraints.NotEmpty;

import in.co.health.care.mgt.sys.entity.BaseEntity;
import in.co.health.care.mgt.sys.entity.PatientEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PatientRegistrationForm extends BaseForm {

	@NotEmpty(message = "InsuranceDetail is required")
	private String insuranceDetail;

	@NotEmpty(message = "Insurance Carrier Name is required")
	private String insuranceCarrierName;

	@NotEmpty(message = "Insurance is required")
	private String insurance;

	@Override
	public BaseEntity getDTO() {
		PatientEntity entity = new PatientEntity();
		entity.setInsurance(insurance);
		entity.setInsuranceCarrierName(insuranceCarrierName);
		entity.setInsuranceDetail(insuranceDetail);
		return entity;
	}

	@Override
	public void populate(BaseEntity baseentity) {
		PatientEntity entity = (PatientEntity) baseentity;
		id = entity.getId();

		insuranceDetail = entity.getInsuranceDetail();
		insuranceCarrierName = entity.getInsuranceCarrierName();
		insurance = entity.getInsurance();

		createdBy = entity.getCreatedBy();
		modifiedBy = entity.getModifiedBy();
		createdDateTime = entity.getCreatedDatetime();
		modifiedDateTime = entity.getModifiedDatetime();
	}
}
