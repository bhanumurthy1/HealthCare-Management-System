package in.co.health.care.mgt.sys.form;

import javax.validation.constraints.NotEmpty;

import org.springframework.web.multipart.MultipartFile;

import in.co.health.care.mgt.sys.entity.BaseEntity;
import in.co.health.care.mgt.sys.entity.UserAddressDetailEntity;
import in.co.health.care.mgt.sys.entity.UserEntity;
import in.co.health.care.mgt.sys.util.DataUtility;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdminProfileForm extends BaseForm {

	@NotEmpty(message = "First Name is required")
	private String firstName;

	@NotEmpty(message = "LastName is required")
	private String lastName;

	@NotEmpty(message = "Middle Name is required")
	private String middleName;

	@NotEmpty(message = "Email is required")
	private String email;

	private MultipartFile profilePic;

	@NotEmpty(message = "PhoneNo No is required")
	private String phoneNo;

	@NotEmpty(message = "Gender is required")
	private String gender;

	@NotEmpty(message = "DOB is required")
	private String dob;

	@NotEmpty(message = "Age is required")
	private String age;

	@NotEmpty(message = "HouseNo is required")
	private String houseNo;
	@NotEmpty(message = "Street is required")
	private String street;
	@NotEmpty(message = "City is required")
	private String city;
	@NotEmpty(message = "ZipCode is required")
	private String zipCode;
	@NotEmpty(message = "Country is required")
	private String country;
	@NotEmpty(message = "State is required")
	private String state;
	@NotEmpty(message = "Address is required")
	private String address;

	private long aId;

	@Override
	public BaseEntity getDTO() {
		UserEntity entity = new UserEntity();
		entity.setId(id);
		entity.setFirstName(firstName);
		entity.setLastName(lastName);
		entity.setMiddleName(middleName);
		entity.setEmailId(email);
		entity.setGender(gender);
		entity.setDob(DataUtility.getDate(dob));
		entity.setPhoneNo(phoneNo);
		entity.setAge(age);

		UserAddressDetailEntity address = new UserAddressDetailEntity();
		address.setHouseNo(houseNo);
		address.setState(state);
		address.setCity(city);
		address.setZipCode(zipCode);
		address.setStreet(street);
		address.setCountry(country);
		address.setAddress(this.address);

		entity.setAddress(address);
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
		middleName=entity.getMiddleName();
		email = entity.getEmailId();
		gender = entity.getGender();
		dob = DataUtility.getDateString(entity.getDob());
		age=entity.getAge();
		phoneNo=entity.getPhoneNo();

		houseNo = entity.getAddress().getHouseNo();
		state = entity.getAddress().getState();
		city = entity.getAddress().getCity();
		zipCode = entity.getAddress().getZipCode();
		country = entity.getAddress().getCountry();
		street = entity.getAddress().getStreet();
		this.address = entity.getAddress().getAddress();

		createdBy = entity.getCreatedBy();
		modifiedBy = entity.getModifiedBy();
		createdDateTime = entity.getCreatedDatetime();
		modifiedDateTime = entity.getModifiedDatetime();
	}
}
