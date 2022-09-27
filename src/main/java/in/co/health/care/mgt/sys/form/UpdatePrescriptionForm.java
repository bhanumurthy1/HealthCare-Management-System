package in.co.health.care.mgt.sys.form;

import javax.validation.constraints.NotEmpty;

import in.co.health.care.mgt.sys.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdatePrescriptionForm extends BaseForm{

	@NotEmpty(message = "Prescription is requred")
	private String prescription;

	@Override
	public BaseEntity getDTO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void populate(BaseEntity bDto) {
		// TODO Auto-generated method stub
		
	}
	
}
