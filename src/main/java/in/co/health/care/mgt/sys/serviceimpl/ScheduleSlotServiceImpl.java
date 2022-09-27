
package in.co.health.care.mgt.sys.serviceimpl;

import java.util.Date;
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

import in.co.health.care.mgt.sys.entity.ScheduleSlotEntity;
import in.co.health.care.mgt.sys.exception.ApplicationException;
import in.co.health.care.mgt.sys.exception.DuplicateRecordException;
import in.co.health.care.mgt.sys.repository.ScheduleSlotRepository;
import in.co.health.care.mgt.sys.service.ScheduleSlotService;

@Service
public class ScheduleSlotServiceImpl implements ScheduleSlotService {

	private static Logger log = Logger.getLogger(ScheduleSlotServiceImpl.class.getName());

	@Autowired
	private ScheduleSlotRepository repository;

	@Autowired
	private EntityManager entityManager;

	@Override
	@Transactional
	public long add(ScheduleSlotEntity entity) throws DuplicateRecordException, ApplicationException {
		log.info("ScheduleSlotServiceImpl Add method start");
		long pk = 0;
		try {
			ScheduleSlotEntity existentity = repository.findBySlotAndDoctorIdAndScheduledate(entity.getSlot(),entity.getDoctorId(), entity.getScheduledate());
			if (existentity != null)
				throw new DuplicateRecordException("ScheduleSlot Already Exist");
			pk = repository.save(entity).getId();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ApplicationException("Exaception getting in ScheduleSlotServiceImpl add() : " + e.getMessage());
		}
		log.info("ScheduleSlotServiceImpl Add method end");
		return pk;
	}

	@Override

	@Transactional
	public void delete(ScheduleSlotEntity entity) throws ApplicationException {
		log.info("ScheduleSlotServiceImpl delete method start");
		try {
			repository.delete(entity);
		} catch (Exception e) {
			throw new ApplicationException("Exaception getting in ScheduleSlotServiceImpl delete() : " + e.getMessage());
		}
		log.info("ScheduleSlotServiceImpl delete method end");

	}

	@Override
	@Transactional
	public ScheduleSlotEntity findById(long pk) throws ApplicationException {
		log.info("ScheduleSlotServiceImpl findById method start");
		ScheduleSlotEntity entity = null;
		try {
			entity = repository.findById(pk).get();
		} catch (Exception e) {
			throw new ApplicationException("Exaception getting in ScheduleSlotServiceImpl findById() : " + e.getMessage());
		}
		log.info("ScheduleSlotServiceImpl findById method end");
		return entity;
	}

	@Override
	@Transactional
	public ScheduleSlotEntity findBySlot(String slot,long id,Date date) throws ApplicationException {
		log.info("ScheduleSlotServiceImpl findByUserName method start");
		ScheduleSlotEntity entity = null;
		try {
			entity = repository.findBySlotAndDoctorIdAndScheduledate(slot, id, date);
		} catch (Exception e) {
			throw new ApplicationException(
					"Exaception getting in ScheduleSlotServiceImpl findByUserName() : " + e.getMessage());
		}
		log.info("ScheduleSlotServiceImpl findByUserName method end");
		return entity;
	}

	@Override
	@Transactional
	public void update(ScheduleSlotEntity entity) throws DuplicateRecordException, ApplicationException {
		log.info("ScheduleSlotServiceImpl update method start");
		try {
			ScheduleSlotEntity existentity = repository.findBySlotAndDoctorIdAndScheduledate(entity.getSlot(),entity.getDoctorId(), entity.getScheduledate());
			if (existentity != null && entity.getId() != existentity.getId())
				throw new DuplicateRecordException("User Name Id Already Exist");
			repository.saveAndFlush(entity);
		} catch (Exception e) {
			throw new ApplicationException("Exaception getting in ScheduleSlotServiceImpl update() : " + e.getMessage());
		}
		log.info("ScheduleSlotServiceImpl update method end");
	}

	@Override
	@Transactional
	public List<ScheduleSlotEntity> list() throws ApplicationException {
		log.info("ScheduleSlotServiceImpl list method start");
		List<ScheduleSlotEntity> list = null;
		try {
			list = repository.findAll();
		} catch (Exception e) {
			throw new ApplicationException("Exaception getting in ScheduleSlotServiceImpl list() : " + e.getMessage());
		}
		log.info("ScheduleSlotServiceImpl list method end");
		return list;
	}

	@Override
	@Transactional
	public List<ScheduleSlotEntity> list(int pageNo, int pageSize) throws ApplicationException {
		log.info("ScheduleSlotServiceImpl list method start");
		List<ScheduleSlotEntity> list = null;
		try {
			Pageable pageable = PageRequest.of(pageNo, pageSize);
			list = repository.findAll(pageable).getContent();
		} catch (Exception e) {
			throw new ApplicationException("Exaception getting in ScheduleSlotServiceImpl list() : " + e.getMessage());
		}
		log.info("ScheduleSlotServiceImpl list method end");
		return list;
	}

	@Override
	@Transactional
	public List<ScheduleSlotEntity> search(ScheduleSlotEntity entity) throws ApplicationException {
		log.info("ScheduleSlotServiceImpl search method start");
		List<ScheduleSlotEntity> list = null;
		try {
			list = repository.findAll();
		} catch (Exception e) {
			throw new ApplicationException("Exaception getting in ScheduleSlotServiceImpl search() : " + e.getMessage());
		}
		log.info("ScheduleSlotServiceImpl search method end");
		return list;
	}

	@Override
	@Transactional
	public List<ScheduleSlotEntity> search(ScheduleSlotEntity entity, int pageNo, int pageSize) throws ApplicationException {
		log.info("ScheduleSlotServiceImpl search method start");
		List<ScheduleSlotEntity> list = null;
		try {
			Session session = entityManager.unwrap(Session.class);
			StringBuffer hql = new StringBuffer("from ScheduleSlotEntity as u where 1=1 ");
			if (entity != null) {
				if (entity.getId() > 0) {
					hql.append("and u.id = " + entity.getId());
				}
				if (entity.getDoctorId() > 0) {
					hql.append("and u.doctorId = " + entity.getDoctorId());
				}
				/*
				 * if (entity.getScheduledate()!=null && entity.getScheduledate().getTime()>0) {
				 * hql.append("and date(u.scheduledate) = '" + new
				 * java.sql.Date(entity.getScheduledate().getTime())+"'"); }
				 */
				if (entity.getSlot() != null && entity.getSlot().length() > 0) {
					hql.append("and u.name like '%" + entity.getSlot() + "%'");
				}
				

			}
			Query<ScheduleSlotEntity> query = session.createQuery(hql.toString(), ScheduleSlotEntity.class);
			if (pageNo > 0) {
				pageNo = (pageNo - 1) * pageSize;
				query.setFirstResult(pageNo);
				query.setMaxResults(pageSize);
			}
			list = query.getResultList();
		} catch (Exception e) {
			throw new ApplicationException("Exaception getting in ScheduleSlotServiceImpl search() : " + e.getMessage());
		}
		log.info("ScheduleSlotServiceImpl search method end");
		return list;
	}

}
