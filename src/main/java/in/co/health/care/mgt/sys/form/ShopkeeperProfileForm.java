package in.co.health.care.mgt.sys.form;

import javax.validation.constraints.NotEmpty;

import org.springframework.web.multipart.MultipartFile;

import in.co.health.care.mgt.sys.entity.BaseEntity;
import in.co.health.care.mgt.sys.entity.ShopkeeperEntity;
import in.co.health.care.mgt.sys.entity.UserEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShopkeeperProfileForm extends BaseForm {

	@NotEmpty(message = "First Name is required")
	private String firstName;

	@NotEmpty(message = "LastName is required")
	private String lastName;

	@NotEmpty(message = "Middle Name is required")
	private String middleName;

	@NotEmpty(message = "Email is required")
	private String email;

	@NotEmpty(message = "Phone No is required")
	private String phoneNo;

	@NotEmpty(message = "User Name is required")
	private String userName;

	@NotEmpty(message = "Password is required")
	private String password;

	@NotEmpty(message = "shopName is required")
	private String shopName;
	@NotEmpty(message = "LicenceNo is required")
	private String licenceNo;
	@NotEmpty(message = "Education is required")
	private String education;
	@NotEmpty(message = "ContactNo is required")
	private String contactNo;
	@NotEmpty(message = "ShopAddress is required")
	private String shopAddress;
	@NotEmpty(message = "Shopcity is required")
	private String shopcity;
	@NotEmpty(message = "ShopStreet is required")
	private String shopStreet;
	@NotEmpty(message = "ShopNo is required")
	private String shopNo;
	@NotEmpty(message = "ShopCountry is required")
	private String shopCountry;
	private MultipartFile profilePic;

	private long sId;

	@Override
	public BaseEntity getDTO() {
		UserEntity entity = new UserEntity();
		entity.setId(id);
		entity.setFirstName(firstName);
		entity.setLastName(lastName);
		entity.setMiddleName(middleName);
		entity.setEmailId(email);

		ShopkeeperEntity shop = new ShopkeeperEntity();
		shop.setContactNo(contactNo);
		shop.setEducation(education);
		shop.setShopName(shopName);
		shop.setShopNo(shopNo);
		shop.setId(sId);
		shop.setStreet(shopStreet);
		shop.setShopcity(shopcity);
		shop.setCountry(shopCountry);
		shop.setShopAddress(shopAddress);
		shop.setLicenceNo(licenceNo);

		entity.setShopkeeper(shop);

		entity.setUserName(userName);
		entity.setPassword(password);
		entity.setShopkeeper(shop);
		entity.setPhoneNo(phoneNo);
		entity.setCreatedBy(createdBy);
		entity.setModifiedBy(modifiedBy);
		entity.setCreatedDatetime(createdDateTime);
		entity.setModifiedDatetime(modifiedDateTime);
		return entity;
	}

	@Override
	public void populate(BaseEntity baseentity) {
		UserEntity entity = (UserEntity) baseentity;
		id = entity.getId();
		firstName = entity.getFirstName();
		lastName = entity.getLastName();
		middleName = entity.getMiddleName();

		email = entity.getEmailId();
		phoneNo = entity.getPhoneNo();

		sId = entity.getShopkeeper().getId();
		contactNo = entity.getShopkeeper().getContactNo();
		shopCountry = entity.getShopkeeper().getCountry();
		education = entity.getShopkeeper().getEducation();
		shopAddress = entity.getShopkeeper().getShopAddress();
		shopcity = entity.getShopkeeper().getShopcity();
		shopName = entity.getShopkeeper().getShopName();
		shopNo = entity.getShopkeeper().getShopNo();
		shopStreet = entity.getShopkeeper().getStreet();
		licenceNo = entity.getShopkeeper().getLicenceNo();

		userName = entity.getUserName();
		password = entity.getPassword();
		createdBy = entity.getCreatedBy();
		modifiedBy = entity.getModifiedBy();
		createdDateTime = entity.getCreatedDatetime();
		modifiedDateTime = entity.getModifiedDatetime();
	}
}
