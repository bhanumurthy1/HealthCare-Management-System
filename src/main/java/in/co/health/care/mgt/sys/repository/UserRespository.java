package in.co.health.care.mgt.sys.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import in.co.health.care.mgt.sys.entity.UserEntity;

public interface UserRespository extends JpaRepository<UserEntity, Long>{
	
	public UserEntity findByUserName(String userName);
	
	public UserEntity findByUserNameAndPassword(String userName,String password);
	
	@Query(nativeQuery = true,value = "SELECT u.* FROM user u \r\n"
			+ "inner join doctor d on u.doctor_id=d.id\r\n"
			+ "where u.role_id in (:roleId) and d.specialization in (:specialization)")
	public List<UserEntity> findByRoleAndSpecialization(@Param("roleId") long roleId,@Param("specialization") String specialization);
	
	@Query(nativeQuery = true,value = "SELECT * FROM user u where role_id=:roleId")
	public List<UserEntity> findByRoleId(@Param("roleId") long roleId);

}
