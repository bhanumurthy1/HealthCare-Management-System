package in.co.health.care.mgt.sys.form;

import javax.validation.constraints.NotEmpty;import org.springframework.util.unit.DataUnit;

import in.co.health.care.mgt.sys.entity.BaseEntity;
import in.co.health.care.mgt.sys.entity.QuickAccessEntity;
import in.co.health.care.mgt.sys.util.DataUtility;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuickAccessForm extends BaseForm{

	@NotEmpty(message = "Required")
	private String key;
	
	private String days;
	private String scale;
	
	private String description;

	@Override
	public BaseEntity getDTO() {
		QuickAccessEntity entity=new QuickAccessEntity();
		entity.setId(id);
		entity.setKey(key);
		entity.setDescription(description);
		entity.setFromScale(DataUtility.getLong(scale));
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
