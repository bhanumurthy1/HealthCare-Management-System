package in.co.health.care.mgt.sys.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;

import in.co.health.care.mgt.sys.entity.ScheduleSlotEntity;

public interface ScheduleSlotRepository extends JpaRepository<ScheduleSlotEntity, Long>{

	public ScheduleSlotEntity findBySlotAndDoctorIdAndScheduledate(String slot,long doctorId,Date scheduledate);
	
}
