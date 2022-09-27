package in.co.health.care.mgt.sys.form;

import javax.validation.constraints.NotEmpty;

import in.co.health.care.mgt.sys.entity.BaseEntity;
import in.co.health.care.mgt.sys.entity.QuickAccessEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuickAccessForm extends BaseForm{

	@NotEmpty(message = "Required")
	private String key;
	
	private String description;

	@Override
	public BaseEntity getDTO() {
		QuickAccessEntity entity=new QuickAccessEntity();
		entity.setId(id);
		entity.setKey(key);
		entity.setDescription(description);
		return entity;
	}

	@Override
	public void populate(BaseEntity bDto) {
		QuickAccessEntity entity=(QuickAccessEntity)bDto;
		id=entity.getId();
		description=entity.getDescription();
		key=entity.getKey();
		
	}
	
}
