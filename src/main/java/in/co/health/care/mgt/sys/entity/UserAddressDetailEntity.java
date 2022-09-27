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
@Setter
@Getter
@Table(name = "USER_ADDRESS_DETAIL")
public class UserAddressDetailEntity extends BaseEntity {

	@Column(name = "HOUSE_NO", length = 755)
	private String houseNo;
	@Column(name = "STREET", length = 755)
	private String street;
	@Column(name = "CITY", length = 755)
	private String city;
	@Column(name = "ZIP_CODE", length = 755)
	private String zipCode;
	@Column(name = "COUNTRY", length = 755)
	private String country;
	@Column(name = "STATE", length = 755)
	private String state;
	@Column(name = "ADDRESS", length = 755)
	private String address;
	
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "address")
    @JoinColumn(name = "user_id")
    private UserEntity user;


	@Override
	public String toString() {
		return "UserAddressDetailEntity [houseNo=" + houseNo + ", street=" + street + ", city=" + city + ", zipCode="
				+ zipCode + ", country=" + country + ", state=" + state + ", address=" + address + ", user=" + user
				+ "]";
	}

	
}
