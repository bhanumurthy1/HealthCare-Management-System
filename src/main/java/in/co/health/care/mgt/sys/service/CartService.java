package in.co.health.care.mgt.sys.service;

import java.util.List;

import in.co.health.care.mgt.sys.entity.CartEntity;
import in.co.health.care.mgt.sys.exception.ApplicationException;
import in.co.health.care.mgt.sys.exception.DuplicateRecordException;

public interface CartService {
	
	public long add(CartEntity entity) throws DuplicateRecordException, ApplicationException;

	public void delete(CartEntity entity) throws ApplicationException;

	public CartEntity findById(long pk) throws ApplicationException;

	public CartEntity findByUserName(String userName) throws ApplicationException;

	public void update(CartEntity entity) throws DuplicateRecordException, ApplicationException;

	public List<CartEntity> list() throws ApplicationException;

	public List<CartEntity> list(int pageNo, int pageSize) throws ApplicationException;

	public List<CartEntity> search(CartEntity entity) throws ApplicationException;

	public List<CartEntity> search(CartEntity entity, int pageNo, int pageSize) throws ApplicationException;






}
