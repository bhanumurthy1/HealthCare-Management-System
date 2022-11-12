package in.co.health.care.mgt.sys.form;

import javax.persistence.Column;

import in.co.health.care.mgt.sys.entity.BaseEntity;
import in.co.health.care.mgt.sys.entity.CartEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartForm extends BaseForm{
	
	
	private long userId;
	private String medicineName;
	private long medicineId;
	private int quantity;
	private double amount;
	private double totalAmount;
	

	@Override
	public BaseEntity getDTO() {
		CartEntity entity=new CartEntity();
		entity.setId(id);
		entity.setUserId(userId);
		entity.setMedicineName(medicineName);
		entity.setMedicineId(medicineId);
		entity.setQuantity(quantity);
		entity.setAmount(amount);
		entity.setTotalAmount(totalAmount);
		return entity;
	}

	@Override
	public void populate(BaseEntity bDto) {
		CartEntity entity=(CartEntity) bDto;
		id=entity.getId();
		userId=entity.getUserId();
		medicineName=entity.getMedicineName();
		medicineId=entity.getMedicineId();
		quantity=entity.getQuantity();
		amount=entity.getAmount();
		totalAmount=entity.getTotalAmount();
	}

}
