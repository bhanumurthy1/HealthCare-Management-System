package in.co.health.care.mgt.sys.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.co.health.care.mgt.sys.entity.MedicineEntity;

public interface MedicineRepository extends JpaRepository<MedicineEntity, Long>{

	public MedicineEntity findByName(String name);
}
