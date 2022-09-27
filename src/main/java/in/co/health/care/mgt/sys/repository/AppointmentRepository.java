package in.co.health.care.mgt.sys.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.co.health.care.mgt.sys.entity.AppointmentEntity;

public interface AppointmentRepository extends JpaRepository<AppointmentEntity, Long>{

	public AppointmentEntity findByPatientName(String name);
	
}
