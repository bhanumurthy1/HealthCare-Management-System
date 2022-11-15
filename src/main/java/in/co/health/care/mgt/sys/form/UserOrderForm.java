package in.co.health.care.mgt.sys.form;


import javax.validation.constraints.NotEmpty;

import in.co.health.care.mgt.sys.entity.BaseEntity;
import in.co.health.care.mgt.sys.entity.UserOrderBillingEntity;
import in.co.health.care.mgt.sys.entity.UserOrderEntity;
import in.co.health.care.mgt.sys.util.DataUtility;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserOrderForm extends BaseForm {
	
	
	private long userId;
	private double amount;
	
	@NotEmpty(message = "FirstName is required")
	private String firstName;
	
	@NotEmpty(message = "LastName is required")
	private String lastName;
	
	@NotEmpty(message = "Email is required")
	private String email;
	
	@NotEmpty(message = "ZipCode is required")
	private String zipCode;
	
	@NotEmpty(message = "ContactNo is required")
	private String contactNo;
	
	@NotEmpty(message = "Address is required")
	private String address;
	
	@NotEmpty(message = "City is required")
	private String city;
	
	@NotEmpty(message = "State is required")
	private String state;
	
	@NotEmpty(message = "Country is required")
	private String country;
	
	private String deliveryType;
	
	private String orderId;
	

	@Override
	public BaseEntity getDTO() {
		UserOrderEntity entity=new UserOrderEntity();
		entity.setId(id);
		entity.setUserId(userId);
		entity.setAmount(amount);
		entity.setOrderId(DataUtility.getLong(orderId));
		entity.setDeliveryType(deliveryType);
		UserOrderBillingEntity billInfo=new UserOrderBillingEntity();
		billInfo.setFirstName(firstName);
		billInfo.setLastName(lastName);
		billInfo.setEmail(email);
		billInfo.setCity(city);
		billInfo.setContactNo(contactNo);
		billInfo.setCountry(country);
		billInfo.setAddress(address);
		billInfo.setZipCode(zipCode);
		
		entity.setUserOrderBilling(billInfo);
		return entity;
	}

	@Override
	public void populate(BaseEntity bDto) {
		UserOrderEntity entity=(UserOrderEntity)bDto;
		id=entity.getId();
		userId=entity.getUserId();
		amount=entity.getAmount();
		orderId=String.valueOf(entity.getOrderId());
		firstName=entity.getUserOrderBilling().getFirstName();
		lastName=entity.getUserOrderBilling().getLastName();
		email=entity.getUserOrderBilling().getEmail();
		city=entity.getUserOrderBilling().getCity();
		contactNo=entity.getUserOrderBilling().getContactNo();
		country=entity.getUserOrderBilling().getContactNo();
		address=entity.getUserOrderBilling().getAddress();
		zipCode=entity.getUserOrderBilling().getZipCode();
		deliveryType=entity.getDeliveryType();
		
	}

}
