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
public class ShopkeeperForm extends BaseForm {


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
		ShopkeeperEntity entity = new ShopkeeperEntity();
		
		entity.setContactNo(contactNo);
		entity.setEducation(education);
		entity.setShopName(shopName);
		entity.setShopNo(shopNo);
		entity.setId(sId);
		entity.setStreet(shopStreet);
		entity.setShopcity(shopcity);
		entity.setCountry(shopCountry);
		entity.setShopAddress(shopAddress);
		entity.setLicenceNo(licenceNo);

		
		entity.setCreatedBy(createdBy);
		entity.setModifiedBy(modifiedBy);
		entity.setCreatedDatetime(createdDateTime);
		entity.setModifiedDatetime(modifiedDateTime);
		return entity;
	}

	@Override
	public void populate(BaseEntity baseentity) {
		ShopkeeperEntity entity = (ShopkeeperEntity) baseentity;
	
		sId = entity.getId();
		contactNo = entity.getContactNo();
		shopCountry = entity.getCountry();
		education = entity.getEducation();
		shopAddress = entity.getShopAddress();
		shopcity = entity.getShopcity();
		shopName = entity.getShopName();
		shopNo = entity.getShopNo();
		shopStreet = entity.getStreet();
		licenceNo = entity.getLicenceNo();

		createdBy = entity.getCreatedBy();
		modifiedBy = entity.getModifiedBy();
		createdDateTime = entity.getCreatedDatetime();
		modifiedDateTime = entity.getModifiedDatetime();
	}
}
