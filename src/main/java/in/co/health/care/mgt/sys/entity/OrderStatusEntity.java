package in.co.health.care.mgt.sys.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="Order_Status")
public class OrderStatusEntity extends BaseEntity{
	
	@Column(name="code",length = 755)
	private String code;
	
	@Column(name="description",length = 755)
	private String description;
	
}
