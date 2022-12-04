
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

import in.co.health.care.mgt.sys.entity.QuickAccessEntity;
import in.co.health.care.mgt.sys.entity.ScheduleSlotEntity;
import in.co.health.care.mgt.sys.exception.ApplicationException;
import in.co.health.care.mgt.sys.exception.DuplicateRecordException;
import in.co.health.care.mgt.sys.repository.QuickAccessRepository;
import in.co.health.care.mgt.sys.repository.ScheduleSlotRepository;
import in.co.health.care.mgt.sys.service.QuickAccessService;

@Service
public class QuickAccessServiceImpl implements QuickAccessService {

	private static Logger log = Logger.getLogger(QuickAccessServiceImpl.class.getName());

	@Autowired
	private QuickAccessRepository repository;

	@Autowired
	private EntityManager entityManager;

	@Autowired
	private ScheduleSlotRepository scheduleSlotRepository;

	@Override
	@Transactional
	public long add(QuickAccessEntity entity) throws DuplicateRecordException, ApplicationException {
		log.info("QuickAccessServiceImpl Add method start");
		long pk = 0;
		try {
			/*
			 * QuickAccessEntity existentity = repository.findByName(entity.getName()); if
			 * (existentity != null) throw new
			 * DuplicateRecordException("QuickAccess Already Exist");
			 */
			pk = repository.save(entity).getId();

		} catch (Exception e) {
			e.printStackTrace();
			throw new ApplicationException("Exaception getting in QuickAccessServiceImpl add() : " + e.getMessage());
		}
		log.info("QuickAccessServiceImpl Add method end");
		return pk;
	}

	@Override

	@Transactional
	public void delete(QuickAccessEntity entity) throws ApplicationException {
		log.info("QuickAccessServiceImpl delete method start");
		try {
			repository.delete(entity);
		} catch (Exception e) {
			throw new ApplicationException("Exaception getting in QuickAccessServiceImpl delete() : " + e.getMessage());
		}
		log.info("QuickAccessServiceImpl delete method end");

	}

	@Override
	@Transactional
	public QuickAccessEntity findById(long pk) throws ApplicationException {
		log.info("QuickAccessServiceImpl findById method start");
		QuickAccessEntity entity = null;
		try {
			entity = repository.findById(pk).get();
		} catch (Exception e) {
			throw new ApplicationException(
					"Exaception getting in QuickAccessServiceImpl findById() : " + e.getMessage());
		}
		log.info("QuickAccessServiceImpl findById method end");
		return entity;
	}

	@Override
	@Transactional
	public QuickAccessEntity findByUserName(String userName) throws ApplicationException {
		log.info("QuickAccessServiceImpl findByUserName method start");
		QuickAccessEntity entity = null;
		try {
			// entity = repository.findByPatientName(userName);
		} catch (Exception e) {
			throw new ApplicationException(
					"Exaception getting in QuickAccessServiceImpl findByUserName() : " + e.getMessage());
		}
		log.info("QuickAccessServiceImpl findByUserName method end");
		return entity;
	}

	@Override
	@Transactional
	public void update(QuickAccessEntity entity) throws DuplicateRecordException, ApplicationException {
		log.info("QuickAccessServiceImpl update method start");
		try {
			/*
			 * QuickAccessEntity existentity = repository.findByName(entity.getName()); if
			 * (existentity != null && entity.getId() != existentity.getId()) throw new
			 * DuplicateRecordException("User Name Id Already Exist");
			 */
			repository.saveAndFlush(entity);
		} catch (Exception e) {
			throw new ApplicationException("Exaception getting in QuickAccessServiceImpl update() : " + e.getMessage());
		}
		log.info("QuickAccessServiceImpl update method end");
	}

	@Override
	@Transactional
	public List<QuickAccessEntity> list() throws ApplicationException {
		log.info("QuickAccessServiceImpl list method start");
		List<QuickAccessEntity> list = null;
		try {
			list = repository.findAll();
		} catch (Exception e) {
			throw new ApplicationException("Exaception getting in QuickAccessServiceImpl list() : " + e.getMessage());
		}
		log.info("QuickAccessServiceImpl list method end");
		return list;
	}

	@Override
	@Transactional
	public List<QuickAccessEntity> list(int pageNo, int pageSize) throws ApplicationException {
		log.info("QuickAccessServiceImpl list method start");
		List<QuickAccessEntity> list = null;
		try {
			Pageable pageable = PageRequest.of(pageNo, pageSize);
			list = repository.findAll(pageable).getContent();
		} catch (Exception e) {
			throw new ApplicationException("Exaception getting in QuickAccessServiceImpl list() : " + e.getMessage());
		}
		log.info("QuickAccessServiceImpl list method end");
		return list;
	}

	@Override
	@Transactional
	public List<QuickAccessEntity> search(QuickAccessEntity entity) throws ApplicationException {
		log.info("QuickAccessServiceImpl search method start");
		List<QuickAccessEntity> list = null;
		try {
			list = repository.findAll();
		} catch (Exception e) {
			throw new ApplicationException("Exaception getting in QuickAccessServiceImpl search() : " + e.getMessage());
		}
		log.info("QuickAccessServiceImpl search method end");
		return list;
	}

	@Override
	@Transactional
	public List<QuickAccessEntity> search(QuickAccessEntity entity, int pageNo, int pageSize)
			throws ApplicationException {
		log.info("QuickAccessServiceImpl search method start");
		List<QuickAccessEntity> list = null;
		try {
			Session session = entityManager.unwrap(Session.class);
			StringBuffer hql = new StringBuffer("from QuickAccessEntity as u where 1=1 ");
			if (entity != null) {
				if (entity.getId() > 0) {
					hql.append("and u.id = " + entity.getId());
				}
				if (entity.getKey() != null && entity.getKey().length() > 0) {
					hql.append("and u.key like '%" + entity.getKey() + "%'");
				}
				
				if (entity.getFromScale() > 0) {
					hql.append("and "+entity.getFromScale()+" between to_scale and from_scale");
				}

			}
			Query<QuickAccessEntity> query = session.createQuery(hql.toString(), QuickAccessEntity.class);
			if (pageNo > 0) {
				pageNo = (pageNo - 1) * pageSize;
				query.setFirstResult(pageNo);
				query.setMaxResults(pageSize);
			}
			list = query.getResultList();
		} catch (Exception e) {
			throw new ApplicationException("Exaception getting in QuickAccessServiceImpl search() : " + e.getMessage());
		}
		log.info("QuickAccessServiceImpl search method end");
		return list;
	}

}
