package in.co.health.care.mgt.sys.form;

import javax.validation.constraints.NotEmpty;

import in.co.health.care.mgt.sys.entity.BaseEntity;
import in.co.health.care.mgt.sys.entity.UserEntity;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ForgetPasswordForm extends BaseForm {

	@NotEmpty(message = "User Name is required")
	private String email;
	
	@Override
	public BaseEntity getDTO() {
		UserEntity dto = new UserEntity();
		dto.setEmailId(email);
		return dto;
	}

	@Override
	public void populate(BaseEntity bDto) {
		
	}

}
