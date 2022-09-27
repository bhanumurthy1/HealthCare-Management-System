package in.co.health.care.mgt.sys.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import in.co.health.care.mgt.sys.entity.RoleEntity;

public interface RoleRepository extends JpaRepository<RoleEntity, Long>{
	
	@Query(nativeQuery = true,value = "Select * from Role u where u.id not in (1)")
	public List<RoleEntity> findAllWithoutAdmin();

}
