package in.co.health.care.mgt.sys.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="MEDICINE")
public class MedicineEntity extends BaseEntity {

	@Column(name="name",length = 1500)
	private String name;
	@Column(name="description",length = 1500)
	private String description;
	@Column(name="company_name",length = 1500)
	private String companyName;
	@Column(name="quantity",columnDefinition = "INT default 0")
	private int quantity;
	
	@Column(name="Manufature_Date")
	private Date manufactureDate;
	@Column(name="Expiry_Date")
	private Date expiryDate;
	@Column(name="ACTIVE",columnDefinition = "BIT default 0")
	private boolean active;
	
	@Column(name="shoopkeeper_Id",columnDefinition = "BIGINT default 0")
	private long shoopkeeperId;
	
	
	
}
