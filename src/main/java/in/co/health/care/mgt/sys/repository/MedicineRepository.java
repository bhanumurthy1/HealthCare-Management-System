package in.co.health.care.mgt.sys.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import in.co.health.care.mgt.sys.entity.MedicineEntity;

public interface MedicineRepository extends JpaRepository<MedicineEntity, Long>{

	public MedicineEntity findByName(String name);
	
	
	@Query(nativeQuery = true,value = "select * from medicine where expiry_date<current_timestamp() and active=1")
	public List<MedicineEntity> getExpiryDateRecord();
	
	
}
