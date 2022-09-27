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
@Table(name = "Shopkeeper")
public class ShopkeeperEntity extends BaseEntity {

	@Column(name = "Shop_Name", length = 1500)
	private String shopName;
	@Column(name = "Licence_No", length = 1500)
	private String licenceNo;
	@Column(name = "Education", length = 1500)
	private String education;
	@Column(name = "Contact_No", length = 1500)
	private String contactNo;
	@Column(name = "Shop_Address", length = 1500)
	private String shopAddress;
	@Column(name = "city", length = 1500)
	private String shopcity;
	@Column(name = "street", length = 1500)
	private String street;
	@Column(name = "shopNo", length = 1500)
	private String shopNo;
	@Column(name = "country", length = 1500)
	private String country;
	


}
