package in.co.health.care.mgt.sys.service;

import java.util.List;

import in.co.health.care.mgt.sys.entity.MedicineEntity;
import in.co.health.care.mgt.sys.exception.ApplicationException;
import in.co.health.care.mgt.sys.exception.DuplicateRecordException;

public interface MedicineService {
	
	public long add(MedicineEntity entity) throws DuplicateRecordException, ApplicationException;

	public void delete(MedicineEntity entity) throws ApplicationException;

	public MedicineEntity findById(long pk) throws ApplicationException;

	public MedicineEntity findByUserName(String userName) throws ApplicationException;

	public void update(MedicineEntity entity) throws DuplicateRecordException, ApplicationException;

	public List<MedicineEntity> list() throws ApplicationException;

	public List<MedicineEntity> list(int pageNo, int pageSize) throws ApplicationException;

	public List<MedicineEntity> search(MedicineEntity entity) throws ApplicationException;

	public List<MedicineEntity> search(MedicineEntity entity, int pageNo, int pageSize) throws ApplicationException;






}
