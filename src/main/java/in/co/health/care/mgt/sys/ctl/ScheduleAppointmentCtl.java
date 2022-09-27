package in.co.health.care.mgt.sys.ctl;

import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import in.co.health.care.mgt.sys.entity.DoctorEntity;
import in.co.health.care.mgt.sys.entity.UserEntity;
import in.co.health.care.mgt.sys.exception.ApplicationException;
import in.co.health.care.mgt.sys.form.DoctorProfileForm;
import in.co.health.care.mgt.sys.service.UserService;

@Controller
public class ScheduleAppointmentCtl extends BaseCtl {

	private Logger log = Logger.getLogger(LoginCtl.class.getName());

	@Autowired
	private UserService userService;

	@GetMapping("/schedule-appointment")
	public String doctorSignUp(@ModelAttribute("form") DoctorProfileForm form, Model model) {
		log.info("LoginCtl login display method start");
		model.addAttribute("list", null);
		log.info("LoginCtl login display method start");
		return "schedule-appointment";
	}

	@RequestMapping(value = "/schedule-appointment", method = { RequestMethod.POST })
	public String searchList(@ModelAttribute("form") DoctorProfileForm form,
			@RequestParam(required = false) String operation, Long vid, HttpSession session, Model model) {
		try {
			if (OP_RESET.equalsIgnoreCase(operation)) {
				return "redirect://schedule-appointment";
			}

			int pageNo = form.getPageNo();
			int pageSize = form.getPageSize();

			if (OP_NEXT.equals(operation)) {
				pageNo++;
			} else if (OP_PREVIOUS.equals(operation)) {
				pageNo--;
			} else if (OP_NEW.equals(operation)) {
				return "redirect:/schedule-appointment";
			}

			pageNo = (pageNo < 1) ? 1 : pageNo;
			pageSize = (pageSize < 1) ? 10 : pageSize;

			if (OP_DELETE.equals(operation)) {
				pageNo = 1;
				if (form.getIds() != null) {
					for (long id : form.getIds()) {
						UserEntity dto = new UserEntity();
						dto.setId(id);
						userService.delete(dto);
					}
					model.addAttribute("success", "Deleted Successfully!!!");
				} else {
					model.addAttribute("error", "Select at least one record");
				}
			}
			UserEntity dto = (UserEntity) form.getDTO();

			//UserEntity uDto = (UserEntity) session.getAttribute("user");

			List<UserEntity> list;
			System.out.println(dto.getDoctor().getSpecialization());
			list = userService.findByRoleAndSpecialization(2L, dto.getDoctor().getSpecialization());

			List<UserEntity> totallist = userService.list();
			model.addAttribute("list", list);

			if (list.size() == 0 && !OP_DELETE.equalsIgnoreCase(operation)) {
				model.addAttribute("error", "Record not found");
				model.addAttribute("list", null);
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
			return "redirect:/schedule-appointment";
		}

		return "schedule-appointment";
	}

}
