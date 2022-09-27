package in.co.health.care.mgt.sys.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="Patient")
public class PatientEntity extends BaseEntity {
	
	@Column(name="Insurance_Detail",length = 1500)
	private String insuranceDetail;
	@Column(name="Insurance_Carrier_Name",length = 1500)
	private String insuranceCarrierName;
	@Column(name="Insurance",length = 1500)
	private String insurance;
	
	
	
	

}
