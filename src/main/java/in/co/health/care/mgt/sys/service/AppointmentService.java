package in.co.health.care.mgt.sys.service;

import java.util.List;

import in.co.health.care.mgt.sys.entity.AppointmentEntity;
import in.co.health.care.mgt.sys.exception.ApplicationException;
import in.co.health.care.mgt.sys.exception.DuplicateRecordException;

public interface AppointmentService {
	
	public long add(AppointmentEntity entity) throws DuplicateRecordException, ApplicationException;

	public void delete(AppointmentEntity entity) throws ApplicationException;

	public AppointmentEntity findById(long pk) throws ApplicationException;

	public AppointmentEntity findByUserName(String userName) throws ApplicationException;

	public void update(AppointmentEntity entity) throws DuplicateRecordException, ApplicationException;

	public List<AppointmentEntity> list() throws ApplicationException;

	public List<AppointmentEntity> list(int pageNo, int pageSize) throws ApplicationException;

	public List<AppointmentEntity> search(AppointmentEntity entity) throws ApplicationException;

	public List<AppointmentEntity> search(AppointmentEntity entity, int pageNo, int pageSize) throws ApplicationException;






}
