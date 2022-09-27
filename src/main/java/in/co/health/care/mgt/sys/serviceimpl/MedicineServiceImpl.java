
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

import in.co.health.care.mgt.sys.entity.MedicineEntity;
import in.co.health.care.mgt.sys.exception.ApplicationException;
import in.co.health.care.mgt.sys.exception.DuplicateRecordException;
import in.co.health.care.mgt.sys.repository.MedicineRepository;
import in.co.health.care.mgt.sys.service.MedicineService;

@Service
public class MedicineServiceImpl implements MedicineService {

	private static Logger log = Logger.getLogger(MedicineServiceImpl.class.getName());

	@Autowired
	private MedicineRepository repository;

	@Autowired
	private EntityManager entityManager;

	@Override
	@Transactional
	public long add(MedicineEntity entity) throws DuplicateRecordException, ApplicationException {
		log.info("MedicineServiceImpl Add method start");
		long pk = 0;
		try {
			MedicineEntity existentity = repository.findByName(entity.getName());
			if (existentity != null)
				throw new DuplicateRecordException("Medicine Already Exist");
			pk = repository.save(entity).getId();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ApplicationException("Exaception getting in MedicineServiceImpl add() : " + e.getMessage());
		}
		log.info("MedicineServiceImpl Add method end");
		return pk;
	}

	@Override

	@Transactional
	public void delete(MedicineEntity entity) throws ApplicationException {
		log.info("MedicineServiceImpl delete method start");
		try {
			repository.delete(entity);
		} catch (Exception e) {
			throw new ApplicationException("Exaception getting in MedicineServiceImpl delete() : " + e.getMessage());
		}
		log.info("MedicineServiceImpl delete method end");

	}

	@Override
	@Transactional
	public MedicineEntity findById(long pk) throws ApplicationException {
		log.info("MedicineServiceImpl findById method start");
		MedicineEntity entity = null;
		try {
			entity = repository.findById(pk).get();
		} catch (Exception e) {
			throw new ApplicationException("Exaception getting in MedicineServiceImpl findById() : " + e.getMessage());
		}
		log.info("MedicineServiceImpl findById method end");
		return entity;
	}

	@Override
	@Transactional
	public MedicineEntity findByUserName(String userName) throws ApplicationException {
		log.info("MedicineServiceImpl findByUserName method start");
		MedicineEntity entity = null;
		try {
			entity = repository.findByName(userName);
		} catch (Exception e) {
			throw new ApplicationException(
					"Exaception getting in MedicineServiceImpl findByUserName() : " + e.getMessage());
		}
		log.info("MedicineServiceImpl findByUserName method end");
		return entity;
	}

	@Override
	@Transactional
	public void update(MedicineEntity entity) throws DuplicateRecordException, ApplicationException {
		log.info("MedicineServiceImpl update method start");
		try {
			MedicineEntity existentity = repository.findByName(entity.getName());
			if (existentity != null && entity.getId() != existentity.getId())
				throw new DuplicateRecordException("User Name Id Already Exist");
			repository.saveAndFlush(entity);
		} catch (Exception e) {
			throw new ApplicationException("Exaception getting in MedicineServiceImpl update() : " + e.getMessage());
		}
		log.info("MedicineServiceImpl update method end");
	}

	@Override
	@Transactional
	public List<MedicineEntity> list() throws ApplicationException {
		log.info("MedicineServiceImpl list method start");
		List<MedicineEntity> list = null;
		try {
			list = repository.findAll();
		} catch (Exception e) {
			throw new ApplicationException("Exaception getting in MedicineServiceImpl list() : " + e.getMessage());
		}
		log.info("MedicineServiceImpl list method end");
		return list;
	}

	@Override
	@Transactional
	public List<MedicineEntity> list(int pageNo, int pageSize) throws ApplicationException {
		log.info("MedicineServiceImpl list method start");
		List<MedicineEntity> list = null;
		try {
			Pageable pageable = PageRequest.of(pageNo, pageSize);
			list = repository.findAll(pageable).getContent();
		} catch (Exception e) {
			throw new ApplicationException("Exaception getting in MedicineServiceImpl list() : " + e.getMessage());
		}
		log.info("MedicineServiceImpl list method end");
		return list;
	}

	@Override
	@Transactional
	public List<MedicineEntity> search(MedicineEntity entity) throws ApplicationException {
		log.info("MedicineServiceImpl search method start");
		List<MedicineEntity> list = null;
		try {
			list = repository.findAll();
		} catch (Exception e) {
			throw new ApplicationException("Exaception getting in MedicineServiceImpl search() : " + e.getMessage());
		}
		log.info("MedicineServiceImpl search method end");
		return list;
	}

	@Override
	@Transactional
	public List<MedicineEntity> search(MedicineEntity entity, int pageNo, int pageSize) throws ApplicationException {
		log.info("MedicineServiceImpl search method start");
		List<MedicineEntity> list = null;
		try {
			Session session = entityManager.unwrap(Session.class);
			StringBuffer hql = new StringBuffer("from MedicineEntity as u where 1=1 ");
			if (entity != null) {
				if (entity.getId() > 0) {
					hql.append("and u.id = " + entity.getId());
				}
				if (entity.getName() != null && entity.getName().length() > 0) {
					hql.append("and u.name like '%" + entity.getName() + "%'");
				}

			}
			Query<MedicineEntity> query = session.createQuery(hql.toString(), MedicineEntity.class);
			if (pageNo > 0) {
				pageNo = (pageNo - 1) * pageSize;
				query.setFirstResult(pageNo);
				query.setMaxResults(pageSize);
			}
			list = query.getResultList();
		} catch (Exception e) {
			throw new ApplicationException("Exaception getting in MedicineServiceImpl search() : " + e.getMessage());
		}
		log.info("MedicineServiceImpl search method end");
		return list;
	}

}
