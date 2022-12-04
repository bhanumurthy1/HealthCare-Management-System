package in.co.health.care.mgt.sys.ctl;

import java.util.logging.Logger;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import in.co.health.care.mgt.sys.exception.ApplicationException;
import in.co.health.care.mgt.sys.service.MedicineService;

@Component
public class SchedulerController {
	
	private static Logger log = Logger.getLogger(SchedulerController.class.getName());
	
	@Autowired
	private MedicineService service;
	
	//@Scheduled(cron = "0 * * ? * *")
	@Scheduled(cron = "0 15 * ? * *")
	@Transactional(rollbackOn = Exception.class)
	public void expiryDateSchedulor() {
		log.info("SchedulerController expiryDateSchedulor method start");
		try {
			System.out.println("Schedulor running");
			service.expireyDateSchedulor();
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("SchedulerController expiryDateSchedulor method end");
	}
	

}
