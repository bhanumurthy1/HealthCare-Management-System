package in.co.health.care.mgt.sys.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "CART")
public class CartEntity extends BaseEntity {

	@Column(name = "user_Id")
	private long userId;

	@Column(name = "MEDICINE_NAME", length = 755)
	private String medicineName;
	@Column(name = "medicine_ID")
	private long medicineId;
	@Column(name = "quantity")
	private int quantity;
	@Column(name = "amount")
	private double amount;
	@Column(name = "totalAmount")
	private double totalAmount;
	
	@ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
	@JoinColumn(name="medicine" ,referencedColumnName = "id")
	private MedicineEntity medicine;
	
	@ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
	@JoinColumn(name="user" ,referencedColumnName = "id")
	private UserEntity user;

}
