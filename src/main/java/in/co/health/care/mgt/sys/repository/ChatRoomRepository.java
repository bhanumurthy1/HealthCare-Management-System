package in.co.health.care.mgt.sys.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import in.co.health.care.mgt.sys.entity.ChatRoomEntity;

public interface ChatRoomRepository extends JpaRepository<ChatRoomEntity, Long> {

	public Optional<ChatRoomEntity> findByPatientIdAndDoctorId(long patientId, long doctorId);

}
