package in.co.health.care.mgt.sys.form;

import javax.validation.constraints.NotEmpty;

import in.co.health.care.mgt.sys.entity.BaseEntity;
import in.co.health.care.mgt.sys.entity.ShopkeeperEntity;
import in.co.health.care.mgt.sys.entity.UserEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShopKeeperRegistrationForm extends BaseForm {

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

	@Override
	public BaseEntity getDTO() {
		ShopkeeperEntity shop = new ShopkeeperEntity();
		shop.setId(id);

		shop.setContactNo(contactNo);
		shop.setEducation(education);
		shop.setShopName(shopName);
		shop.setShopNo(shopNo);
		
		shop.setLicenceNo(licenceNo);

		shop.setStreet(shopStreet);
		shop.setShopcity(shopcity);
		shop.setCountry(shopCountry);
		shop.setShopAddress(shopAddress);

		shop.setCreatedBy(createdBy);
		shop.setModifiedBy(modifiedBy);
		shop.setCreatedDatetime(createdDateTime);
		shop.setModifiedDatetime(modifiedDateTime);
		return shop;
	}

	@Override
	public void populate(BaseEntity baseentity) {
		ShopkeeperEntity entity = (ShopkeeperEntity) baseentity;
		id = entity.getId();

		contactNo = entity.getContactNo();
		shopCountry = entity.getCountry();
		education = entity.getEducation();
		shopAddress = entity.getShopAddress();
		shopcity = entity.getShopcity();
		shopName = entity.getShopName();
		shopNo = entity.getShopNo();
		shopStreet = entity.getStreet();
		licenceNo=entity.getLicenceNo();
		createdBy = entity.getCreatedBy();
		modifiedBy = entity.getModifiedBy();
		createdDateTime = entity.getCreatedDatetime();
		modifiedDateTime = entity.getModifiedDatetime();
	}
}
