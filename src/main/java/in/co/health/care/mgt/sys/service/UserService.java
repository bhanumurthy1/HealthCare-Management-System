package in.co.health.care.mgt.sys.service;

import java.util.List;

import in.co.health.care.mgt.sys.entity.UserEntity;
import in.co.health.care.mgt.sys.exception.ApplicationException;
import in.co.health.care.mgt.sys.exception.DuplicateRecordException;

public interface UserService {
	
	public long add(UserEntity entity) throws DuplicateRecordException, ApplicationException;

	public void delete(UserEntity entity) throws ApplicationException;

	public UserEntity findById(long pk) throws ApplicationException;

	public UserEntity findByUserName(String userName) throws ApplicationException;

	public void update(UserEntity entity) throws DuplicateRecordException, ApplicationException;

	public List<UserEntity> list() throws ApplicationException;

	public List<UserEntity> list(int pageNo, int pageSize) throws ApplicationException;

	public List<UserEntity> search(UserEntity entity) throws ApplicationException;

	public List<UserEntity> search(UserEntity entity, int pageNo, int pageSize) throws ApplicationException;

	public UserEntity authentication(UserEntity entity) throws ApplicationException;

	public boolean changePassword(Long id, String oldPassword, String newPassword) throws ApplicationException;

	public boolean forgetPassword(String login) throws ApplicationException;

	public long register(UserEntity entity) throws DuplicateRecordException, ApplicationException;
	public List<UserEntity> findByRoleAndSpecialization(long roleId,String specialization) throws ApplicationException;


}
