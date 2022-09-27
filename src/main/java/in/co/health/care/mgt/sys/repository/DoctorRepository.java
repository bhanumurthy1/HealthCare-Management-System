package in.co.health.care.mgt.sys.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.co.health.care.mgt.sys.entity.DoctorEntity;

public interface DoctorRepository extends JpaRepository<DoctorEntity, Long>{

}
