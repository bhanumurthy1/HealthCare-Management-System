package in.co.health.care.mgt.sys.form;

import java.util.Date;

import javax.persistence.Column;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import in.co.health.care.mgt.sys.entity.BaseEntity;
import in.co.health.care.mgt.sys.entity.MedicineEntity;
import in.co.health.care.mgt.sys.entity.UserEntity;
import in.co.health.care.mgt.sys.util.DataUtility;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MedicineForm  extends BaseForm{

	@NotEmpty(message = "Name is required")
	private String name;
	@NotEmpty(message = "Description is required")
	private String description;
	@NotEmpty(message = "Company Name is required")
	private String companyName;
	@Min(value = 1, message = "Quantity is required")
	private String quantity;
	@NotEmpty(message = "Manufacture Date is required")
	private String manufactureDate;
	@NotEmpty(message = "Expiry Date is required")
	private String expiryDate;
	
	@NotEmpty(message = "Price is required")
	private String price;
	
	@NotEmpty(message = "Rating is required")
	private String rating;
	
	private boolean active;
	private long shoopkeeperId;
	
	@Override
	public BaseEntity getDTO() {
		MedicineEntity entity=new MedicineEntity();
		entity.setId(id);
		entity.setName(name);
		entity.setDescription(description);
		entity.setCompanyName(companyName);
		entity.setPrice(DataUtility.getDouble(price));
		entity.setQuantity(DataUtility.getInt(quantity));
		entity.setRating(DataUtility.getInt(rating));
		entity.setManufactureDate(DataUtility.getDate(manufactureDate));
		entity.setExpiryDate(DataUtility.getDate(expiryDate));
		entity.setActive(true);
		entity.setCreatedBy(createdBy);
		entity.setModifiedBy(modifiedBy);
		entity.setCreatedDatetime(createdDateTime);
		entity.setModifiedDatetime(modifiedDateTime);
		return entity;
	}

	@Override
	public void populate(BaseEntity bDto) {
		MedicineEntity entity = (MedicineEntity) bDto;
		id = entity.getId();
		name=entity.getName();
		description=entity.getDescription();
		companyName=entity.getCompanyName();
		quantity=String.valueOf(entity.getQuantity());
		rating=String.valueOf(entity.getRating());
		price=String.valueOf(entity.getPrice());
		manufactureDate=DataUtility.getDateString(entity.getManufactureDate());
		expiryDate=DataUtility.getDateString(entity.getExpiryDate());
		createdBy = entity.getCreatedBy();
		modifiedBy = entity.getModifiedBy();
		createdDateTime = entity.getCreatedDatetime();
		modifiedDateTime = entity.getModifiedDatetime();
	}

}
