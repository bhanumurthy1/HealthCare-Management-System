package in.co.health.care.mgt.sys.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="ROLE")
public class RoleEntity  extends BaseEntity{
	
	@Column(name="NAME",length = 755)
	private String name;
	
	@Column(name="DESCRIPTION",length = 1500)
	private String description;
	
}
