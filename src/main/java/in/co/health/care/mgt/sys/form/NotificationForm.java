package in.co.health.care.mgt.sys.form;

import java.util.Date;

import javax.persistence.Column;

import in.co.health.care.mgt.sys.entity.BaseEntity;
import in.co.health.care.mgt.sys.entity.NotificationEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotificationForm extends BaseForm{
	
	private String notification;
	private long userId;
	private Date date;

	@Override
	public BaseEntity getDTO() {
		NotificationEntity entity=new NotificationEntity();
		entity.setNotification(notification);
		entity.setUserId(userId);
		entity.setDate(date);
		return entity;
	}

	@Override
	public void populate(BaseEntity bDto) {
		NotificationEntity entity=(NotificationEntity) bDto;
		notification=entity.getNotification();
		userId=entity.getUserId();
		date=entity.getDate();
		
	}

}
