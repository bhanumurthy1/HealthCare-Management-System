package in.co.health.care.mgt.sys.form;

import javax.validation.constraints.NotEmpty;

import in.co.health.care.mgt.sys.entity.BaseEntity;
import in.co.health.care.mgt.sys.entity.UserEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginForm extends BaseForm {

	@NotEmpty(message = "UserName is required")
	private String userName;
	@NotEmpty(message = "Password is required")
	private String password;
	

	@Override
	public BaseEntity getDTO() {
		UserEntity bean=new UserEntity();
		bean.setUserName(userName);
		bean.setPassword(password);
		return bean;
	}

	@Override
	public void populate(BaseEntity bdto) {
		UserEntity entity=(UserEntity) bdto;
		userName=entity.getUserName();
		password=entity.getPassword();
	}

}
