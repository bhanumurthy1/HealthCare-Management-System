
package in.co.health.care.mgt.sys.serviceimpl;

import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import in.co.health.care.mgt.sys.entity.UserEntity;
import in.co.health.care.mgt.sys.exception.ApplicationException;
import in.co.health.care.mgt.sys.exception.DuplicateRecordException;
import in.co.health.care.mgt.sys.repository.UserRespository;
import in.co.health.care.mgt.sys.service.UserService;
import in.co.health.care.mgt.sys.util.EmailBuilder;

@Service
public class UserServiceImpl implements UserService {

	private static Logger log = Logger.getLogger(UserServiceImpl.class.getName());

	@Autowired
	private UserRespository repository;

	@Autowired
	private EntityManager entityManager;

	@Autowired
	private JavaMailSender javaMailSender;

	@Override
	@Transactional
	public long add(UserEntity entity) throws DuplicateRecordException, ApplicationException {
		log.info("UserServiceImpl Add method start");
		long pk = 0;
		try {
			UserEntity existentity = repository.findByUserName(entity.getUserName());
			if (existentity != null)
				throw new DuplicateRecordException("UserName Already Exist");
			pk = repository.save(entity).getId();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ApplicationException("Exaception getting in UserServiceImpl add() : " + e.getMessage());
		}
		log.info("UserServiceImpl Add method end");
		return pk;
	}

	@Override

	@Transactional
	public void delete(UserEntity entity) throws ApplicationException {
		log.info("UserServiceImpl delete method start");
		try {
			repository.delete(entity);
		} catch (Exception e) {
			throw new ApplicationException("Exaception getting in UserServiceImpl delete() : " + e.getMessage());
		}
		log.info("UserServiceImpl delete method end");

	}

	@Override
	@Transactional
	public UserEntity findById(long pk) throws ApplicationException {
		log.info("UserServiceImpl findById method start");
		UserEntity entity = null;
		try {
			entity = repository.findById(pk).get();
		} catch (Exception e) {
			throw new ApplicationException("Exaception getting in UserServiceImpl findById() : " + e.getMessage());
		}
		log.info("UserServiceImpl findById method end");
		return entity;
	}

	@Override
	@Transactional
	public UserEntity findByUserName(String userName) throws ApplicationException {
		log.info("UserServiceImpl findByUserName method start");
		UserEntity entity = null;
		try {
			entity = repository.findByUserName(userName);
		} catch (Exception e) {
			throw new ApplicationException(
					"Exaception getting in UserServiceImpl findByUserName() : " + e.getMessage());
		}
		log.info("UserServiceImpl findByUserName method end");
		return entity;
	}

	@Override
	@Transactional
	public void update(UserEntity entity) throws DuplicateRecordException, ApplicationException {
		log.info("UserServiceImpl update method start");
		try {
			UserEntity existentity = repository.findByUserName(entity.getUserName());
			if (existentity != null && entity.getId() != existentity.getId())
				throw new DuplicateRecordException("User Name Id Already Exist");
			repository.saveAndFlush(entity);
		} catch (Exception e) {
			throw new ApplicationException("Exaception getting in UserServiceImpl update() : " + e.getMessage());
		}
		log.info("UserServiceImpl update method end");
	}

	@Override
	@Transactional
	public List<UserEntity> list() throws ApplicationException {
		log.info("UserServiceImpl list method start");
		List<UserEntity> list = null;
		try {
			list = repository.findAll();
		} catch (Exception e) {
			throw new ApplicationException("Exaception getting in UserServiceImpl list() : " + e.getMessage());
		}
		log.info("UserServiceImpl list method end");
		return list;
	}

	@Override
	@Transactional
	public List<UserEntity> list(int pageNo, int pageSize) throws ApplicationException {
		log.info("UserServiceImpl list method start");
		List<UserEntity> list = null;
		try {
			Pageable pageable = PageRequest.of(pageNo, pageSize);
			list = repository.findAll(pageable).getContent();
		} catch (Exception e) {
			throw new ApplicationException("Exaception getting in UserServiceImpl list() : " + e.getMessage());
		}
		log.info("UserServiceImpl list method end");
		return list;
	}

	@Override
	@Transactional
	public List<UserEntity> search(UserEntity entity) throws ApplicationException {
		log.info("UserServiceImpl search method start");
		List<UserEntity> list = null;
		try {
			list = repository.findAll();
		} catch (Exception e) {
			throw new ApplicationException("Exaception getting in UserServiceImpl search() : " + e.getMessage());
		}
		log.info("UserServiceImpl search method end");
		return list;
	}

	@Override
	@Transactional
	public List<UserEntity> findByRoleAndSpecialization(long roleId, String specialization)
			throws ApplicationException {
		log.info("UserServiceImpl findByRoleAndSpecialization method start");
		List<UserEntity> list = null;
		try {
			list = repository.findByRoleAndSpecialization(roleId, specialization);
		} catch (Exception e) {
			throw new ApplicationException("Exaception getting in UserServiceImpl search() : " + e.getMessage());
		}
		log.info("UserServiceImpl findByRoleAndSpecialization method end");
		return list;
	}

	@Override
	@Transactional
	public List<UserEntity> search(UserEntity entity, int pageNo, int pageSize) throws ApplicationException {
		log.info("UserServiceImpl search method start");
		List<UserEntity> list = null;
		try {
			Session session = entityManager.unwrap(Session.class);
			StringBuffer hql = new StringBuffer("from UserEntity as u where 1=1 ");
			if (entity != null) {
				if (entity.getId() > 0) {
					hql.append("and u.id = " + entity.getId());
				}
				if (entity.getFirstName() != null && entity.getFirstName().length() > 0) {
					hql.append("and u.firstName like '%" + entity.getFirstName() + "%'");
				}
				if (entity.getLastName() != null && entity.getLastName().length() > 0) {
					hql.append("and u.lastName like '%" + entity.getLastName() + "%'");
				}

				if (entity.getRoleId() > 0) {
					hql.append("and u.role =" + entity.getRoleId());
				}
			}

			hql.append(" and u.role not in (1) order by id desc");
			Query<UserEntity> query = session.createQuery(hql.toString(), UserEntity.class);
			if (pageNo > 0) {
				pageNo = (pageNo - 1) * pageSize;
				query.setFirstResult(pageNo);
				query.setMaxResults(pageSize);
			}
			list = query.getResultList();
		} catch (Exception e) {
			throw new ApplicationException("Exaception getting in UserServiceImpl search() : " + e.getMessage());
		}
		log.info("UserServiceImpl search method end");
		return list;
	}

	@Override

	@Transactional
	public UserEntity authentication(UserEntity entity) throws ApplicationException {
		log.info("UserServiceImpl authentication method start");
		try {
			entity = repository.findByUserNameAndPassword(entity.getUserName(), entity.getPassword());
		} catch (Exception e) {
			throw new ApplicationException(
					"Exaception getting in UserServiceImpl authentication() : " + e.getMessage());
		}
		log.info("UserServiceImpl authentication method end");
		return entity;
	}

	@Override

	@Transactional
	public boolean changePassword(Long id, String oldPassword, String newPassword) throws ApplicationException {
		log.info("UserServiceImpl  changePassword method start");
		boolean pass = false;
		try {
			UserEntity entityExist = findById(id);
			if (entityExist != null && entityExist.getPassword().equals(oldPassword)) {
				entityExist.setPassword(newPassword);
				repository.saveAndFlush(entityExist);
				pass = true;
			} else {
				pass = false;
			}
		} catch (Exception e) {
			throw new ApplicationException(
					"Exaception getting in UserServiceImpl changePassword() : " + e.getMessage());
		}
		log.info("UserServiceImpl  changePassword method End");
		return pass;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public boolean forgetPassword(String email) throws ApplicationException {
		log.info("UserServiceImpl  forgetPassword method start");
		boolean pass = false;
		try {
			UserEntity entityExist = repository.findByUserName(email);

			if (entityExist != null) {

				HashMap<String, String> map = new HashMap<String, String>();
				map.put("firstName", entityExist.getFirstName());
				map.put("lastName", entityExist.getLastName());
				map.put("login", entityExist.getUserName());
				map.put("password", entityExist.getPassword());

				String message = EmailBuilder.getForgetPasswordMessage(map);

				MimeMessage msg = javaMailSender.createMimeMessage();

				try {
					MimeMessageHelper helper = new MimeMessageHelper(msg);
					helper.setTo(entityExist.getEmailId());
					helper.setSubject("Health Care Forget Password");
					//helper.setText(message, true);
					helper.setText(message, true);
					javaMailSender.send(msg);
				} catch (MessagingException e) {
					e.printStackTrace();
					return false;
				}

			} else {
				pass = false;
			}

		} catch (Exception e) {
			throw new ApplicationException(
					"Exaception getting in UserServiceImpl forgetPassword() : " + e.getMessage());
		}
		log.info("UserServiceImpl  forgetPassword method end");
		return pass;
	}

	@Override
	public long register(UserEntity entity) throws DuplicateRecordException, ApplicationException {
		long pk = add(entity);

		HashMap<String, String> map = new HashMap<String, String>();
		map.put("firstName", entity.getFirstName());
		map.put("lastName", entity.getLastName());
		map.put("login", entity.getUserName());
		map.put("password", entity.getPassword());
		String message = EmailBuilder.getUserRegistration(map);
		MimeMessage msg = javaMailSender.createMimeMessage();
		try {
			MimeMessageHelper helper = new MimeMessageHelper(msg);
			helper.setTo(entity.getEmailId());
			helper.setSubject("Health Care Managment Registration Successfully!!!");
			helper.setText(message, true);
			javaMailSender.send(msg);
		} catch (MessagingException e) {
			e.printStackTrace();
		}

		return pk;
	}

}
