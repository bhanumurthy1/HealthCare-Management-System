package in.co.health.care.mgt.sys.ctl;

import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import in.co.health.care.mgt.sys.entity.AppointmentEntity;
import in.co.health.care.mgt.sys.entity.DoctorEntity;
import in.co.health.care.mgt.sys.entity.MedicineEntity;
import in.co.health.care.mgt.sys.entity.ScheduleSlotEntity;
import in.co.health.care.mgt.sys.entity.UserEntity;
import in.co.health.care.mgt.sys.exception.ApplicationException;
import in.co.health.care.mgt.sys.exception.DuplicateRecordException;
import in.co.health.care.mgt.sys.form.AppointmentForm;
import in.co.health.care.mgt.sys.form.MedicineForm;
import in.co.health.care.mgt.sys.form.UpdatePrescriptionForm;
import in.co.health.care.mgt.sys.service.AppointmentService;
import in.co.health.care.mgt.sys.service.ScheduleSlotService;
import in.co.health.care.mgt.sys.service.UserService;
import in.co.health.care.mgt.sys.util.ControllerUtility;
import in.co.health.care.mgt.sys.util.DataUtility;
import in.co.health.care.mgt.sys.util.EmailBuilder;

@Controller
@RequestMapping("/appointment")
public class AppointmentCtl extends BaseCtl {

	private Logger log = Logger.getLogger(LoginCtl.class.getName());

	@Autowired
	private AppointmentService service;

	@Autowired
	private ScheduleSlotService scheduleSlotService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	@ModelAttribute
	public void preload(Model model) {

	}
	@GetMapping
	public String display(@RequestParam(required = false) Long id, Long sId, @ModelAttribute("form") AppointmentForm form,
			HttpSession session, Model model) {
		log.info("AppointmentCtl login display method start");
		try {
			if (form.getId() > 0) {
				AppointmentEntity bean;
				bean = service.findById(form.getId());
				form.populate(bean);
			}
			 sId=DataUtility.getLong(String.valueOf(sId));
			 if(sId>0) {
				 ScheduleSlotEntity sEntity = scheduleSlotService.findById(sId);
				 UserEntity uEntity=(UserEntity)session.getAttribute("user");
				 UserEntity doctor = userService.findById(sEntity.getDoctorId());
				 AppointmentEntity bean=new AppointmentEntity();
				 bean.setAppointmentDate(sEntity.getScheduledate());
				 bean.setDoctorId(doctor.getId());
				 bean.setDoctorName(doctor.getFirstName()+" "+doctor.getLastName());
				 bean.setPatientId(uEntity.getId());
				 bean.setSlot(sEntity.getSlot());
				 bean.setSlotId(sEntity.getId());
				 form.populate(bean);
			 }else {
				 return "redirect:/schedule-appointment";
			 }
			
		} catch (ApplicationException e) {
			e.printStackTrace();
			return "redirect:/error";
		}
		log.info("AppointmentCtl display method End");
		return "appointment";
	}
	
	@GetMapping("/updatePrescription")
	public String updatePre(@RequestParam(required = false) Long id, Long aId, @ModelAttribute("form") UpdatePrescriptionForm form,
			HttpSession session, Model model) {
		log.info("AppointmentCtl login display method start");
		try {
			aId=DataUtility.getLong(String.valueOf(aId));
			 if(aId>0) {
				session.setAttribute("aId", aId);
			 }else {
				 return "redirect:/appointment/search";
			 }
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/error";
		}
		log.info("AppointmentCtl display method End");
		return "updatePrescription";
	}

	@PostMapping("/updatePrescription")
	public String submit(@Valid @ModelAttribute("form") UpdatePrescriptionForm form, BindingResult bindingResult,
			HttpSession session,HttpServletRequest request, Model model) {
		log.info("AppointmentCtl submit display method start");
		if (OP_RESET.equalsIgnoreCase(form.getOperation())) {
			return "redirect:/updatePrescription";
		}
		try {
			if (OP_SAVE.equalsIgnoreCase(form.getOperation())) {
					long aId=DataUtility.getLong(String.valueOf(session.getAttribute("aId")));
					AppointmentEntity findById = service.findById(aId);
					findById.setPrescription(form.getPrescription());
					service.update(findById);
					
					HashMap<String, String> map = new HashMap<String, String>();
					map.put("prescription", findById.getPrescription());
					String message = EmailBuilder.getUpdatePrecription(map);
					MimeMessage msg = javaMailSender.createMimeMessage();
					try {
						MimeMessageHelper helper = new MimeMessageHelper(msg);
						helper.setTo(userService.findById(findById.getPatientId()).getEmailId());
						helper.setSubject("Health Care Managment  Update Prescription Successfully!!!");
						helper.setText(message, true);
						javaMailSender.send(msg);
					} catch (MessagingException e) {
						e.printStackTrace();
					}
					
					ControllerUtility.setSuccessMessage("Prescription Added Successfully", model);
				return "updatePrescription";
			}
		} catch (DuplicateRecordException e) {
			ControllerUtility.setErrorMessage(e.getMessage(), model);
			return "updatePrescription";
		} catch (ApplicationException e) {
			e.printStackTrace();
			return "redirect:/error";
		}
		log.info("AppointmentCtl submit display method End");
		return "updatePrescription";
	}
	
	
	@PostMapping
	public String submit(@Valid @ModelAttribute("form") AppointmentForm form, BindingResult bindingResult,
			HttpSession session,HttpServletRequest request, Model model) {
		log.info("MedicineCtl submit display method start");
		if (OP_RESET.equalsIgnoreCase(form.getOperation())) {
			return "redirect:/appointment";
		}
		try {
			if (OP_SAVE.equalsIgnoreCase(form.getOperation())) {
				if (bindingResult.hasErrors()) {
					return "appointment";
				}
				AppointmentEntity bean = (AppointmentEntity)populateDTO(form.getDTO(), request);
				if (bean.getId() > 0) {
					service.update(bean);
					ControllerUtility.setSuccessMessage("Appointment update Successfully!!!!", model);
				} else {
					bean.setChatRoom("/"+bean.getDoctorName().substring(0, 2)+bean.getPatientName().substring(0, 2));
					service.add(bean);
					ControllerUtility.setSuccessMessage("Appointment Added Successfully!!!!", model);
				}
				return "appointment";
			}
		} catch (DuplicateRecordException e) {
			ControllerUtility.setErrorMessage(e.getMessage(), model);
			return "appointment";
		} catch (ApplicationException e) {
			e.printStackTrace();
			return "redirect:/error";
		}
		log.info("MedicineCtl submit display method End");
		return "appointment";
	}

	@RequestMapping(value = "/search", method = { RequestMethod.GET, RequestMethod.POST })
	public String searchList(@ModelAttribute("form") AppointmentForm form,
			@RequestParam(required = false) String operation, Long vid, HttpSession session, Model model) {
		log.info("AppointmentCtl searchList display method start");
		try {

			if (OP_RESET.equalsIgnoreCase(operation)) {
				return "redirect:/appointment/search";
			}

			int pageNo = form.getPageNo();
			int pageSize = form.getPageSize();

			if (OP_NEXT.equals(operation)) {
				pageNo++;
			} else if (OP_PREVIOUS.equals(operation)) {
				pageNo--;
			} else if (OP_NEW.equals(operation)) {
				return "redirect:/appointment";
			}

			pageNo = (pageNo < 1) ? 1 : pageNo;
			pageSize = (pageSize < 1) ? 10 : pageSize;

			if (OP_DELETE.equals(operation)) {
				pageNo = 1;
				if (form.getIds() != null) {
					for (long id : form.getIds()) {
						AppointmentEntity dto = new AppointmentEntity();
						dto.setId(id);
						service.delete(dto);
					}
					model.addAttribute("success", "Deleted Successfully!!!");
				} else {
					model.addAttribute("error", "Select at least one record");
				}
			}
			AppointmentEntity dto = (AppointmentEntity) form.getDTO();

			UserEntity uDto = (UserEntity) session.getAttribute("user");
			
			if(uDto.getRole().getId()==2) {
				dto.setDoctorId(uDto.getId());
			}else if(uDto.getRole().getId()==4) {
				dto.setPatientId(uDto.getId());
			}

			List<AppointmentEntity> list;

			
			
			list = service.search(dto, pageNo, pageSize);

			List<AppointmentEntity> totallist = service.search(dto);
			model.addAttribute("list", list);

			if (list.size() == 0 && !OP_DELETE.equalsIgnoreCase(operation)) {
				model.addAttribute("error", "Record not found");
			}

			int listsize = list.size();
			int total = totallist.size();
			int pageNoPageSize = pageNo * pageSize;

			form.setPageNo(pageNo);
			form.setPageSize(pageSize);
			model.addAttribute("pageNo", pageNo);
			model.addAttribute("pageSize", pageSize);
			model.addAttribute("listsize", listsize);
			model.addAttribute("total", total);
			model.addAttribute("pagenosize", pageNoPageSize);
			model.addAttribute("form", form);
		} catch (ApplicationException e) {
			e.printStackTrace();
			return "redirect:/error";
		}
		log.info("AppointmentCtl searchList display method End");
		return "appointmentList";
	}

	/*
	 * @GetMapping("/getImage/{id}") public void getStudentPhoto(HttpServletResponse
	 * response, @PathVariable("id") long id) throws Exception {
	 * response.setContentType("image/jpeg");
	 * 
	 * Blob blb = service.getImageById(id);
	 * 
	 * byte[] bytes = blb.getBytes(1, (int) blb.length()); InputStream inputStream =
	 * new ByteArrayInputStream(bytes); IOUtils.copy(inputStream,
	 * response.getOutputStream()); }
	 */

}
