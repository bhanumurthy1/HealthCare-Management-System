
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

import in.co.health.care.mgt.sys.entity.AppointmentEntity;
import in.co.health.care.mgt.sys.entity.ScheduleSlotEntity;
import in.co.health.care.mgt.sys.exception.ApplicationException;
import in.co.health.care.mgt.sys.exception.DuplicateRecordException;
import in.co.health.care.mgt.sys.repository.AppointmentRepository;
import in.co.health.care.mgt.sys.repository.ScheduleSlotRepository;
import in.co.health.care.mgt.sys.service.AppointmentService;

@Service
public class AppointmentServiceImpl implements AppointmentService {

	private static Logger log = Logger.getLogger(AppointmentServiceImpl.class.getName());

	@Autowired
	private AppointmentRepository repository;

	@Autowired
	private EntityManager entityManager;

	@Autowired
	private ScheduleSlotRepository scheduleSlotRepository;

	@Override
	@Transactional
	public long add(AppointmentEntity entity) throws DuplicateRecordException, ApplicationException {
		log.info("AppointmentServiceImpl Add method start");
		long pk = 0;
		try {
			/*
			 * AppointmentEntity existentity = repository.findByName(entity.getName()); if
			 * (existentity != null) throw new
			 * DuplicateRecordException("Appointment Already Exist");
			 */
			pk = repository.save(entity).getId();
			ScheduleSlotEntity scheduleSlotEntity = scheduleSlotRepository.findById(entity.getSlotId()).get();
			scheduleSlotEntity.setAvailable(false);
			scheduleSlotRepository.saveAndFlush(scheduleSlotEntity);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ApplicationException("Exaception getting in AppointmentServiceImpl add() : " + e.getMessage());
		}
		log.info("AppointmentServiceImpl Add method end");
		return pk;
	}

	@Override

	@Transactional
	public void delete(AppointmentEntity entity) throws ApplicationException {
		log.info("AppointmentServiceImpl delete method start");
		try {
			repository.delete(entity);
		} catch (Exception e) {
			throw new ApplicationException("Exaception getting in AppointmentServiceImpl delete() : " + e.getMessage());
		}
		log.info("AppointmentServiceImpl delete method end");

	}

	@Override
	@Transactional
	public AppointmentEntity findById(long pk) throws ApplicationException {
		log.info("AppointmentServiceImpl findById method start");
		AppointmentEntity entity = null;
		try {
			entity = repository.findById(pk).get();
		} catch (Exception e) {
			throw new ApplicationException(
					"Exaception getting in AppointmentServiceImpl findById() : " + e.getMessage());
		}
		log.info("AppointmentServiceImpl findById method end");
		return entity;
	}

	@Override
	@Transactional
	public AppointmentEntity findByUserName(String userName) throws ApplicationException {
		log.info("AppointmentServiceImpl findByUserName method start");
		AppointmentEntity entity = null;
		try {
			entity = repository.findByPatientName(userName);
		} catch (Exception e) {
			throw new ApplicationException(
					"Exaception getting in AppointmentServiceImpl findByUserName() : " + e.getMessage());
		}
		log.info("AppointmentServiceImpl findByUserName method end");
		return entity;
	}

	@Override
	@Transactional
	public void update(AppointmentEntity entity) throws DuplicateRecordException, ApplicationException {
		log.info("AppointmentServiceImpl update method start");
		try {
			/*
			 * AppointmentEntity existentity = repository.findByName(entity.getName()); if
			 * (existentity != null && entity.getId() != existentity.getId()) throw new
			 * DuplicateRecordException("User Name Id Already Exist");
			 */
			repository.saveAndFlush(entity);
		} catch (Exception e) {
			throw new ApplicationException("Exaception getting in AppointmentServiceImpl update() : " + e.getMessage());
		}
		log.info("AppointmentServiceImpl update method end");
	}

	@Override
	@Transactional
	public List<AppointmentEntity> list() throws ApplicationException {
		log.info("AppointmentServiceImpl list method start");
		List<AppointmentEntity> list = null;
		try {
			list = repository.findAll();
		} catch (Exception e) {
			throw new ApplicationException("Exaception getting in AppointmentServiceImpl list() : " + e.getMessage());
		}
		log.info("AppointmentServiceImpl list method end");
		return list;
	}

	@Override
	@Transactional
	public List<AppointmentEntity> list(int pageNo, int pageSize) throws ApplicationException {
		log.info("AppointmentServiceImpl list method start");
		List<AppointmentEntity> list = null;
		try {
			Pageable pageable = PageRequest.of(pageNo, pageSize);
			list = repository.findAll(pageable).getContent();
		} catch (Exception e) {
			throw new ApplicationException("Exaception getting in AppointmentServiceImpl list() : " + e.getMessage());
		}
		log.info("AppointmentServiceImpl list method end");
		return list;
	}

	@Override
	@Transactional
	public List<AppointmentEntity> search(AppointmentEntity entity) throws ApplicationException {
		log.info("AppointmentServiceImpl search method start");
		List<AppointmentEntity> list = null;
		try {
			list = repository.findAll();
		} catch (Exception e) {
			throw new ApplicationException("Exaception getting in AppointmentServiceImpl search() : " + e.getMessage());
		}
		log.info("AppointmentServiceImpl search method end");
		return list;
	}

	@Override
	@Transactional
	public List<AppointmentEntity> search(AppointmentEntity entity, int pageNo, int pageSize)
			throws ApplicationException {
		log.info("AppointmentServiceImpl search method start");
		List<AppointmentEntity> list = null;
		try {
			Session session = entityManager.unwrap(Session.class);
			StringBuffer hql = new StringBuffer("from AppointmentEntity as u where 1=1 ");
			if (entity != null) {
				if (entity.getId() > 0) {
					hql.append("and u.id = " + entity.getId());
				}
				if (entity.getPatientName() != null && entity.getPatientName().length() > 0) {
					hql.append("and u.patientName like '%" + entity.getPatientName() + "%'");
				}

			}
			Query<AppointmentEntity> query = session.createQuery(hql.toString(), AppointmentEntity.class);
			if (pageNo > 0) {
				pageNo = (pageNo - 1) * pageSize;
				query.setFirstResult(pageNo);
				query.setMaxResults(pageSize);
			}
			list = query.getResultList();
		} catch (Exception e) {
			throw new ApplicationException("Exaception getting in AppointmentServiceImpl search() : " + e.getMessage());
		}
		log.info("AppointmentServiceImpl search method end");
		return list;
	}

}
