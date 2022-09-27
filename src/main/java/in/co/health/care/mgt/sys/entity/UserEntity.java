package in.co.health.care.mgt.sys.entity;


import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "USER")
@Getter
@Setter
public class UserEntity extends BaseEntity {

	@Column(name = "FIRST_NAME", length = 755)
	private String firstName;

	@Column(name = "MIDDLE_NAME", length = 755)
	private String middleName;
	
	@Column(name = "LAST_NAME", length = 755)
	private String lastName;

	@Column(name = "USER_NAME")
	private String userName;

	@Column(name = "PASSWORD", length = 225)
	private String password;

	@Column(name = "EMAIL_ID", length = 225)
	private String emailId;
	
	@Column(name = "PHONE_NO", length = 225)
	private String phoneNo;	
	
	@Column(name = "GENDER", length = 225)
	private String gender;
	
	@Column(name = "DOB")
	@Temporal(TemporalType.DATE)
	private Date dob;
	
	@Column(name="AGE",length = 225)
	private  String age;
	
	@Column(name = "profile_pic", columnDefinition = "LONGBLOB")
	private byte[] profilePic;
	
	@Transient
	private long roleId;
	
	
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name="address_id" ,referencedColumnName = "id")
	private UserAddressDetailEntity address;
	
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name="patient_id" ,referencedColumnName = "id")
	private PatientEntity patient;
	
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name="doctor_id" ,referencedColumnName = "id")
	private DoctorEntity doctor;
	
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name="shopkeeper_id" ,referencedColumnName = "id")
	private ShopkeeperEntity shopkeeper;

	@ManyToOne
	@JoinColumn(referencedColumnName = "id" ,columnDefinition = "role_Id")
	private RoleEntity role;
}
