package in.co.health.care.mgt.sys.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import in.co.health.care.mgt.sys.entity.CartEntity;
import in.co.health.care.mgt.sys.entity.MedicineEntity;

public interface CartRepository extends JpaRepository<CartEntity, Long>{

	public CartEntity findByMedicineName(String medicineName);
	
	public List<CartEntity> findByMedicineIdAndUserId(long medicineId,long userId);
}
