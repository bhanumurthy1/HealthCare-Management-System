package in.co.health.care.mgt.sys.form;

import in.co.health.care.mgt.sys.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ScheduleAppointmentForm extends BaseForm{
	
	private String specialization;

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
