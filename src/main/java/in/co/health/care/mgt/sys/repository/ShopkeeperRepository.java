package in.co.health.care.mgt.sys.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.co.health.care.mgt.sys.entity.PatientEntity;
import in.co.health.care.mgt.sys.entity.ShopkeeperEntity;

public interface ShopkeeperRepository extends JpaRepository<ShopkeeperEntity, Long>{

}
