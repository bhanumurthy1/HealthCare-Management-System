package in.co.health.care.mgt.sys.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "DOCTOR")
public class DoctorEntity extends BaseEntity {

	@Column(name = "License_No", length = 755)
	private String licenseNo;
	@Column(name = "PastExprience", length = 755)
	private String pastExprience;
	@Column(name = "Total_Exprience", length = 755)
	private String totalExprience;
	@Column(name = "specialization", length = 755)
	private String specialization;
	
	@Column(name = "certificates", columnDefinition = "LONGBLOB")
	private byte[] certificates;
	


}
