
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

import in.co.health.care.mgt.sys.entity.ShopkeeperEntity;
import in.co.health.care.mgt.sys.exception.ApplicationException;
import in.co.health.care.mgt.sys.exception.DuplicateRecordException;
import in.co.health.care.mgt.sys.repository.ShopkeeperRepository;
import in.co.health.care.mgt.sys.service.ShopkeeperService;

@Service
public class ShopkeeperServiceImpl implements ShopkeeperService {

	private static Logger log = Logger.getLogger(ShopkeeperServiceImpl.class.getName());

	@Autowired
	private ShopkeeperRepository repository;

	@Autowired
	private EntityManager entityManager;

	@Override
	@Transactional
	public long add(ShopkeeperEntity entity) throws DuplicateRecordException, ApplicationException {
		log.info("ShopkeeperServiceImpl Add method start");
		long pk = 0;
		try {
			ShopkeeperEntity existentity = repository.findByShopName(entity.getShopName());
			if (existentity != null)
				throw new DuplicateRecordException("Shopkeeper Already Exist");
			pk = repository.save(entity).getId();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ApplicationException("Exaception getting in ShopkeeperServiceImpl add() : " + e.getMessage());
		}
		log.info("ShopkeeperServiceImpl Add method end");
		return pk;
	}

	@Override

	@Transactional
	public void delete(ShopkeeperEntity entity) throws ApplicationException {
		log.info("ShopkeeperServiceImpl delete method start");
		try {
			repository.delete(entity);
		} catch (Exception e) {
			throw new ApplicationException("Exaception getting in ShopkeeperServiceImpl delete() : " + e.getMessage());
		}
		log.info("ShopkeeperServiceImpl delete method end");

	}

	@Override
	@Transactional
	public ShopkeeperEntity findById(long pk) throws ApplicationException {
		log.info("ShopkeeperServiceImpl findById method start");
		ShopkeeperEntity entity = null;
		try {
			entity = repository.findById(pk).get();
		} catch (Exception e) {
			throw new ApplicationException("Exaception getting in ShopkeeperServiceImpl findById() : " + e.getMessage());
		}
		log.info("ShopkeeperServiceImpl findById method end");
		return entity;
	}

	@Override
	@Transactional
	public ShopkeeperEntity findByUserName(String userName) throws ApplicationException {
		log.info("ShopkeeperServiceImpl findByUserName method start");
		ShopkeeperEntity entity = null;
		try {
			entity = repository.findByShopName(userName);
		} catch (Exception e) {
			throw new ApplicationException(
					"Exaception getting in ShopkeeperServiceImpl findByUserName() : " + e.getMessage());
		}
		log.info("ShopkeeperServiceImpl findByUserName method end");
		return entity;
	}

	@Override
	@Transactional
	public void update(ShopkeeperEntity entity) throws DuplicateRecordException, ApplicationException {
		log.info("ShopkeeperServiceImpl update method start");
		try {
			ShopkeeperEntity existentity = repository.findByShopName(entity.getShopName());
			if (existentity != null && entity.getId() != existentity.getId())
				throw new DuplicateRecordException("User Name Id Already Exist");
			repository.saveAndFlush(entity);
		} catch (Exception e) {
			throw new ApplicationException("Exaception getting in ShopkeeperServiceImpl update() : " + e.getMessage());
		}
		log.info("ShopkeeperServiceImpl update method end");
	}

	@Override
	@Transactional
	public List<ShopkeeperEntity> list() throws ApplicationException {
		log.info("ShopkeeperServiceImpl list method start");
		List<ShopkeeperEntity> list = null;
		try {
			list = repository.findAll();
		} catch (Exception e) {
			throw new ApplicationException("Exaception getting in ShopkeeperServiceImpl list() : " + e.getMessage());
		}
		log.info("ShopkeeperServiceImpl list method end");
		return list;
	}

	@Override
	@Transactional
	public List<ShopkeeperEntity> list(int pageNo, int pageSize) throws ApplicationException {
		log.info("ShopkeeperServiceImpl list method start");
		List<ShopkeeperEntity> list = null;
		try {
			Pageable pageable = PageRequest.of(pageNo, pageSize);
			list = repository.findAll(pageable).getContent();
		} catch (Exception e) {
			throw new ApplicationException("Exaception getting in ShopkeeperServiceImpl list() : " + e.getMessage());
		}
		log.info("ShopkeeperServiceImpl list method end");
		return list;
	}

	@Override
	@Transactional
	public List<ShopkeeperEntity> search(ShopkeeperEntity entity) throws ApplicationException {
		log.info("ShopkeeperServiceImpl search method start");
		List<ShopkeeperEntity> list = null;
		try {
			list = repository.findAll();
		} catch (Exception e) {
			throw new ApplicationException("Exaception getting in ShopkeeperServiceImpl search() : " + e.getMessage());
		}
		log.info("ShopkeeperServiceImpl search method end");
		return list;
	}

	@Override
	@Transactional
	public List<ShopkeeperEntity> search(ShopkeeperEntity entity, int pageNo, int pageSize) throws ApplicationException {
		log.info("ShopkeeperServiceImpl search method start");
		List<ShopkeeperEntity> list = null;
		try {
			Session session = entityManager.unwrap(Session.class);
			StringBuffer hql = new StringBuffer("from ShopkeeperEntity as u where 1=1 ");
			if (entity != null) {
				if (entity.getId() > 0) {
					hql.append("and u.id = " + entity.getId());
				}
				if (entity.getShopName() != null && entity.getShopName().length() > 0) {
					hql.append("and u.shopName like '%" + entity.getShopName() + "%'");
				}

			}
			Query<ShopkeeperEntity> query = session.createQuery(hql.toString(), ShopkeeperEntity.class);
			if (pageNo > 0) {
				pageNo = (pageNo - 1) * pageSize;
				query.setFirstResult(pageNo);
				query.setMaxResults(pageSize);
			}
			list = query.getResultList();
		} catch (Exception e) {
			throw new ApplicationException("Exaception getting in ShopkeeperServiceImpl search() : " + e.getMessage());
		}
		log.info("ShopkeeperServiceImpl search method end");
		return list;
	}

}
