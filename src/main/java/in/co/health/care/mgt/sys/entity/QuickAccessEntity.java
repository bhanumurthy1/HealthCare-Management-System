package in.co.health.care.mgt.sys.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Columns;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "QUICK_ACCESS")
public class QuickAccessEntity extends BaseEntity {

	@Column(name = "key_Access", length = 755)
	private String key;
	@Column(name = "description", length = 2000)
	private String description;

}
