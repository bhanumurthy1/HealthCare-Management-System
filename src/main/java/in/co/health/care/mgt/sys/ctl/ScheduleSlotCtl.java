package in.co.health.care.mgt.sys.ctl;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import in.co.health.care.mgt.sys.entity.ScheduleSlotEntity;
import in.co.health.care.mgt.sys.entity.UserEntity;
import in.co.health.care.mgt.sys.exception.ApplicationException;
import in.co.health.care.mgt.sys.exception.DuplicateRecordException;
import in.co.health.care.mgt.sys.form.ScheduleSlotForm;
import in.co.health.care.mgt.sys.repository.UserRespository;
import in.co.health.care.mgt.sys.service.ScheduleSlotService;
import in.co.health.care.mgt.sys.util.ControllerUtility;
import in.co.health.care.mgt.sys.util.DataUtility;

@Controller
@RequestMapping("/scheduleSlot")
public class ScheduleSlotCtl extends BaseCtl {

	private Logger log = Logger.getLogger(LoginCtl.class.getName());

	@Autowired
	private ScheduleSlotService service;

	@Autowired
	private UserRespository userRespository;

	@ModelAttribute
	public void preload(Model model) {

		//model.addAttribute("docList", userRespository.findByRoleId(2L));

	}

	@GetMapping
	public String display(@RequestParam(required = false) Long id, Long pId,
			@ModelAttribute("form") ScheduleSlotForm form, HttpSession session, Model model) {
		log.info("ScheduleSlotCtl login display method start");
		try {
			if (form.getId() > 0) {
				ScheduleSlotEntity bean;
				bean = service.findById(form.getId());
				form.populate(bean);
			}
		} catch (ApplicationException e) {
			e.printStackTrace();
			return "redirect:/error";
		}
		log.info("ScheduleSlotCtl display method End");
		return "scheduleSlot";
	}

	@PostMapping
	public String submit(@Valid @ModelAttribute("form") ScheduleSlotForm form, BindingResult bindingResult,
			HttpSession session, HttpServletRequest request, Model model) {
		log.info("ScheduleSlotCtl submit display method start");
		if (OP_RESET.equalsIgnoreCase(form.getOperation())) {
			return "redirect:/scheduleSlot";
		}
		try {
			if (OP_SAVE.equalsIgnoreCase(form.getOperation())) {
				if (bindingResult.hasErrors()) {
					return "scheduleSlot";
				}
				ScheduleSlotEntity bean = (ScheduleSlotEntity) populateDTO(form.getDTO(), request);
				UserEntity uDto = (UserEntity) session.getAttribute("user");
				if (bean.getId() > 0) {
					bean.setDoctorId(uDto.getId());
					service.update(bean);
					ControllerUtility.setSuccessMessage("ScheduleSlot update Successfully!!!!", model);
				} else {
					bean.setDoctorId(uDto.getId());
					service.add(bean);
					ControllerUtility.setSuccessMessage("ScheduleSlot Added Successfully!!!!", model);
				}
				return "scheduleSlot";
			}
		} catch (DuplicateRecordException e) {
			ControllerUtility.setErrorMessage(e.getMessage(), model);
			return "scheduleSlot";
		} catch (ApplicationException e) {
			e.printStackTrace();
			return "redirect:/error";
		}
		log.info("ScheduleSlotCtl submit display method End");
		return "scheduleSlot";
	}

	@RequestMapping(value = "/search", method = { RequestMethod.GET, RequestMethod.POST })
	public String searchList(@ModelAttribute("form") ScheduleSlotForm form,
			@RequestParam(required = false) String operation, Long dId, HttpSession session, Model model) {
		log.info("ScheduleSlotCtl searchList display method start");
		try {

			if (OP_RESET.equalsIgnoreCase(operation)) {
				return "redirect:/scheduleSlot/search";
			}

			int pageNo = form.getPageNo();
			int pageSize = form.getPageSize();

			if (OP_NEXT.equals(operation)) {
				pageNo++;
			} else if (OP_PREVIOUS.equals(operation)) {
				pageNo--;
			} else if (OP_NEW.equals(operation)) {
				return "redirect:/scheduleSlot";
			}

			pageNo = (pageNo < 1) ? 1 : pageNo;
			pageSize = (pageSize < 1) ? 10 : pageSize;

			if (OP_DELETE.equals(operation)) {
				pageNo = 1;
				if (form.getIds() != null) {
					for (long id : form.getIds()) {
						ScheduleSlotEntity dto = new ScheduleSlotEntity();
						dto.setId(id);
						service.delete(dto);
					}
					model.addAttribute("success", "Deleted Successfully!!!");
				} else {
					model.addAttribute("error", "Select at least one record");
				}
			}
			ScheduleSlotEntity dto = (ScheduleSlotEntity) form.getDTO();

			UserEntity uDto = (UserEntity) session.getAttribute("user");

			List<ScheduleSlotEntity> list;
			if(uDto.getRole().getId()==2) {
				dto.setDoctorId(uDto.getId());
			}
			
			dId=DataUtility.getLong(String.valueOf(dId));
			if(dId>0) {
				dto.setDoctorId(dId);
				dto.setScheduledate(new Date());
			}
			list = service.search(dto, pageNo, pageSize);

			List<ScheduleSlotEntity> totallist = service.search(dto);
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
		log.info("ScheduleSlotCtl searchList display method End");
		return "scheduleSlotList";
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
