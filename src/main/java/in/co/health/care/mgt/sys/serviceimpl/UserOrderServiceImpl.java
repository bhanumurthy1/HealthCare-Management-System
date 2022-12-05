
package in.co.health.care.mgt.sys.serviceimpl;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.co.health.care.mgt.sys.entity.UserOrderEntity;
import in.co.health.care.mgt.sys.exception.ApplicationException;
import in.co.health.care.mgt.sys.exception.DuplicateRecordException;
import in.co.health.care.mgt.sys.repository.CartRepository;
import in.co.health.care.mgt.sys.repository.UserOrderRepository;
import in.co.health.care.mgt.sys.service.CartService;
import in.co.health.care.mgt.sys.service.UserOrderService;

@Service
public class UserOrderServiceImpl implements UserOrderService {

	private static Logger log = Logger.getLogger(UserOrderServiceImpl.class.getName());

	@Autowired
	private UserOrderRepository repository;

	@Autowired
	private EntityManager entityManager;

	@Override
	@Transactional
	public long add(UserOrderEntity entity) throws DuplicateRecordException, ApplicationException {
		log.info("CartServiceImpl Add method start");
		long pk = 0;
		try {
			/*
			 * UserOrderEntity existentity =
			 * repository.findByMedicineName(entity.getMedicineName()); if (existentity !=
			 * null) throw new DuplicateRecordException("Cart Already Exist");
			 */
			pk = repository.save(entity).getId();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ApplicationException("Exaception getting in CartServiceImpl add() : " + e.getMessage());
		}
		log.info("CartServiceImpl Add method end");
		return pk;
	}

	@Override

	@Transactional
	public void delete(UserOrderEntity entity) throws ApplicationException {
		log.info("CartServiceImpl delete method start");
		try {
			repository.delete(entity);
		} catch (Exception e) {
			throw new ApplicationException("Exaception getting in CartServiceImpl delete() : " + e.getMessage());
		}
		log.info("CartServiceImpl delete method end");

	}

	@Override
	@Transactional
	public UserOrderEntity findById(long pk) throws ApplicationException {
		log.info("CartServiceImpl findById method start");
		UserOrderEntity entity = null;
		try {
			entity = repository.findById(pk).get();
		} catch (Exception e) {
			throw new ApplicationException("Exaception getting in CartServiceImpl findById() : " + e.getMessage());
		}
		log.info("CartServiceImpl findById method end");
		return entity;
	}

	@Override
	@Transactional
	public UserOrderEntity findByUserName(String userName) throws ApplicationException {
		log.info("CartServiceImpl findByUserName method start");
		UserOrderEntity entity = null;
		try {
			//entity =repository.findByMedicineName(userName);
		} catch (Exception e) {
			throw new ApplicationException(
					"Exaception getting in CartServiceImpl findByUserName() : " + e.getMessage());
		}
		log.info("CartServiceImpl findByUserName method end");
		return entity;
	}

	@Override
	@Transactional
	public void update(UserOrderEntity entity) throws DuplicateRecordException, ApplicationException {
		log.info("CartServiceImpl update method start");
		try {
			/*
			 * UserOrderEntity existentity =
			 * repository.findByMedicineName(entity.getMedicineName()); if (existentity !=
			 * null && entity.getId() != existentity.getId()) throw new
			 * DuplicateRecordException("User Name Id Already Exist");
			 */
			repository.saveAndFlush(entity);
		} catch (Exception e) {
			throw new ApplicationException("Exaception getting in CartServiceImpl update() : " + e.getMessage());
		}
		log.info("CartServiceImpl update method end");
	}

	@Override
	@Transactional
	public List<UserOrderEntity> list() throws ApplicationException {
		log.info("CartServiceImpl list method start");
		List<UserOrderEntity> list = null;
		try {
			list = repository.findAll();
		} catch (Exception e) {
			throw new ApplicationException("Exaception getting in CartServiceImpl list() : " + e.getMessage());
		}
		log.info("CartServiceImpl list method end");
		return list;
	}

	@Override
	@Transactional
	public List<UserOrderEntity> list(int pageNo, int pageSize) throws ApplicationException {
		log.info("CartServiceImpl list method start");
		List<UserOrderEntity> list = null;
		try {
			Pageable pageable = PageRequest.of(pageNo, pageSize);
			list = repository.findAll(pageable).getContent();
		} catch (Exception e) {
			throw new ApplicationException("Exaception getting in CartServiceImpl list() : " + e.getMessage());
		}
		log.info("CartServiceImpl list method end");
		return list;
	}

	@Override
	@Transactional
	public List<UserOrderEntity> search(UserOrderEntity entity) throws ApplicationException {
		log.info("CartServiceImpl search method start");
		List<UserOrderEntity> list = null;
		try {
			list = repository.findAll();
		} catch (Exception e) {
			throw new ApplicationException("Exaception getting in CartServiceImpl search() : " + e.getMessage());
		}
		log.info("CartServiceImpl search method end");
		return list;
	}

	@Override
	@Transactional
	public List<UserOrderEntity> search(UserOrderEntity entity, int pageNo, int pageSize) throws ApplicationException {
		log.info("CartServiceImpl search method start");
		List<UserOrderEntity> list = null;
		try {
			Session session = entityManager.unwrap(Session.class);
			StringBuffer hql = new StringBuffer("from UserOrderEntity as u where 1=1 ");
			if (entity != null) {
				if (entity.getId() > 0) {
					hql.append("and u.id = " + entity.getId());
				}
				if (entity.getOrderId() > 0) {
					hql.append("and u.id = " + entity.getOrderId());
				}
				if (entity.getUserId() > 0) {
					hql.append("and u.userId = " + entity.getUserId());
				}
				
				

			}
			Query<UserOrderEntity> query = session.createQuery(hql.toString(), UserOrderEntity.class);
			if (pageNo > 0) {
				pageNo = (pageNo - 1) * pageSize;
				query.setFirstResult(pageNo);
				query.setMaxResults(pageSize);
			}
			list = query.getResultList();
		} catch (Exception e) {
			throw new ApplicationException("Exaception getting in CartServiceImpl search() : " + e.getMessage());
		}
		log.info("CartServiceImpl search method end");
		return list;
	}

}
