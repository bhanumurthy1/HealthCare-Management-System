
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

import in.co.health.care.mgt.sys.entity.CartEntity;
import in.co.health.care.mgt.sys.exception.ApplicationException;
import in.co.health.care.mgt.sys.exception.DuplicateRecordException;
import in.co.health.care.mgt.sys.repository.CartRepository;
import in.co.health.care.mgt.sys.service.CartService;

@Service
public class CartServiceImpl implements CartService {

	private static Logger log = Logger.getLogger(CartServiceImpl.class.getName());

	@Autowired
	private CartRepository repository;

	@Autowired
	private EntityManager entityManager;

	@Override
	@Transactional
	public long add(CartEntity entity) throws DuplicateRecordException, ApplicationException {
		log.info("CartServiceImpl Add method start");
		long pk = 0;
		try {
			/*
			 * CartEntity existentity =
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
	public void delete(CartEntity entity) throws ApplicationException {
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
	public CartEntity findById(long pk) throws ApplicationException {
		log.info("CartServiceImpl findById method start");
		CartEntity entity = null;
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
	public CartEntity findByUserName(String userName) throws ApplicationException {
		log.info("CartServiceImpl findByUserName method start");
		CartEntity entity = null;
		try {
			entity =repository.findByMedicineName(userName);
		} catch (Exception e) {
			throw new ApplicationException(
					"Exaception getting in CartServiceImpl findByUserName() : " + e.getMessage());
		}
		log.info("CartServiceImpl findByUserName method end");
		return entity;
	}

	@Override
	@Transactional
	public void update(CartEntity entity) throws DuplicateRecordException, ApplicationException {
		log.info("CartServiceImpl update method start");
		try {
			/*
			 * CartEntity existentity =
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
	public List<CartEntity> list() throws ApplicationException {
		log.info("CartServiceImpl list method start");
		List<CartEntity> list = null;
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
	public List<CartEntity> list(int pageNo, int pageSize) throws ApplicationException {
		log.info("CartServiceImpl list method start");
		List<CartEntity> list = null;
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
	public List<CartEntity> search(CartEntity entity) throws ApplicationException {
		log.info("CartServiceImpl search method start");
		List<CartEntity> list = null;
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
	public List<CartEntity> search(CartEntity entity, int pageNo, int pageSize) throws ApplicationException {
		log.info("CartServiceImpl search method start");
		List<CartEntity> list = null;
		try {
			Session session = entityManager.unwrap(Session.class);
			StringBuffer hql = new StringBuffer("from CartEntity as u where 1=1 ");
			if (entity != null) {
				if (entity.getId() > 0) {
					hql.append("and u.id = " + entity.getId());
				}
				if (entity.getMedicineName() != null && entity.getMedicineName().length() > 0) {
					hql.append("and u.medicineName like '%" + entity.getMedicineName() + "%'");
				}
				
				if (entity.getUserId() > 0) {
					hql.append("and u.userId = " + entity.getUserId());
				}
				
				if (entity.getMedicineId() > 0) {
					hql.append("and u.medicineId = " + entity.getMedicineId());
				}

			}
			Query<CartEntity> query = session.createQuery(hql.toString(), CartEntity.class);
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
