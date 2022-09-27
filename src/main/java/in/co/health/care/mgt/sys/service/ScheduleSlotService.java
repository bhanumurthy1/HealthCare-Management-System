package in.co.health.care.mgt.sys.service;

import java.util.Date;
import java.util.List;

import in.co.health.care.mgt.sys.entity.ScheduleSlotEntity;
import in.co.health.care.mgt.sys.exception.ApplicationException;
import in.co.health.care.mgt.sys.exception.DuplicateRecordException;

public interface ScheduleSlotService {
	
	public long add(ScheduleSlotEntity entity) throws DuplicateRecordException, ApplicationException;

	public void delete(ScheduleSlotEntity entity) throws ApplicationException;

	public ScheduleSlotEntity findById(long pk) throws ApplicationException;

	public ScheduleSlotEntity findBySlot(String userName,long id,Date date) throws ApplicationException;

	public void update(ScheduleSlotEntity entity) throws DuplicateRecordException, ApplicationException;

	public List<ScheduleSlotEntity> list() throws ApplicationException;

	public List<ScheduleSlotEntity> list(int pageNo, int pageSize) throws ApplicationException;

	public List<ScheduleSlotEntity> search(ScheduleSlotEntity entity) throws ApplicationException;

	public List<ScheduleSlotEntity> search(ScheduleSlotEntity entity, int pageNo, int pageSize) throws ApplicationException;






}
