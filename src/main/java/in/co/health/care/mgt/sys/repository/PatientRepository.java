package in.co.health.care.mgt.sys.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.co.health.care.mgt.sys.entity.PatientEntity;

public interface PatientRepository extends JpaRepository<PatientEntity, Long>{

}
