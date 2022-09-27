package in.co.health.care.mgt.sys.service;

import java.util.List;

import in.co.health.care.mgt.sys.entity.QuickAccessEntity;
import in.co.health.care.mgt.sys.exception.ApplicationException;
import in.co.health.care.mgt.sys.exception.DuplicateRecordException;

public interface QuickAccessService {
	
	public long add(QuickAccessEntity entity) throws DuplicateRecordException, ApplicationException;

	public void delete(QuickAccessEntity entity) throws ApplicationException;

	public QuickAccessEntity findById(long pk) throws ApplicationException;

	public QuickAccessEntity findByUserName(String userName) throws ApplicationException;

	public void update(QuickAccessEntity entity) throws DuplicateRecordException, ApplicationException;

	public List<QuickAccessEntity> list() throws ApplicationException;

	public List<QuickAccessEntity> list(int pageNo, int pageSize) throws ApplicationException;

	public List<QuickAccessEntity> search(QuickAccessEntity entity) throws ApplicationException;

	public List<QuickAccessEntity> search(QuickAccessEntity entity, int pageNo, int pageSize) throws ApplicationException;






}
