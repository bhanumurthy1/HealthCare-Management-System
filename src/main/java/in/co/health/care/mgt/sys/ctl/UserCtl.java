package in.co.health.care.mgt.sys.ctl;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.util.List;
import java.util.logging.Logger;

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

import in.co.health.care.mgt.sys.entity.UserEntity;
import in.co.health.care.mgt.sys.exception.ApplicationException;
import in.co.health.care.mgt.sys.exception.DuplicateRecordException;
import in.co.health.care.mgt.sys.form.UserForm;
import in.co.health.care.mgt.sys.service.UserService;
import in.co.health.care.mgt.sys.util.ControllerUtility;

@Controller
@RequestMapping("/user")
public class UserCtl extends BaseCtl {

	private Logger log = Logger.getLogger(LoginCtl.class.getName());

	@Autowired
	private UserService service;

	@ModelAttribute
	public void preload(Model model) {
	}

	@GetMapping
	public String display(@RequestParam(required = false) Long id, Long pId, @ModelAttribute("form") UserForm form,
			HttpSession session, Model model) {
		log.info("UserCtl login display method start");
		try {
			if (form.getId() > 0) {
				UserEntity bean;
				bean = service.findById(form.getId());
				form.populate(bean);
			}
		} catch (ApplicationException e) {
			e.printStackTrace();
			return "redirect:/error";
		}
		log.info("UserCtl display method End");
		return "User";
	}

	@PostMapping
	public String submit(@Valid @ModelAttribute("form") UserForm form, BindingResult bindingResult, HttpSession session,
			HttpServletResponse request, Model model) {
		log.info("UserCtl submit display method start");
		if (OP_RESET.equalsIgnoreCase(form.getOperation())) {
			return "redirect:/user";
		}
		try {
			if (OP_SAVE.equalsIgnoreCase(form.getOperation())) {
				if (bindingResult.hasErrors()) {
					return "user";
				}
				UserEntity bean = (UserEntity) populateDTO(form.getDTO(), null);
				if (bean.getId() > 0) {
					service.update(bean);
					ControllerUtility.setSuccessMessage("User update Successfully!!!!", model);
				} else {
					service.add(bean);
					ControllerUtility.setSuccessMessage("User Added Successfully!!!!", model);
				}
				return "user";
			}
		} catch (DuplicateRecordException e) {
			ControllerUtility.setErrorMessage(e.getMessage(), model);
			return "user";
		} catch (ApplicationException e) {
			e.printStackTrace();
			return "redirect:/error";
		}
		log.info("UserCtl submit display method End");
		return "user";
	}

	@RequestMapping(value = "/search", method = { RequestMethod.GET, RequestMethod.POST })
	public String searchList(@ModelAttribute("form") UserForm form, @RequestParam(required = false) String operation,
			Long vid, HttpSession session, Model model) {
		log.info("UserCtl searchList display method start");
		try {

			if (OP_RESET.equalsIgnoreCase(operation)) {
				return "redirect:/user/search";
			}

			int pageNo = form.getPageNo();
			int pageSize = form.getPageSize();

			if (OP_NEXT.equals(operation)) {
				pageNo++;
			} else if (OP_PREVIOUS.equals(operation)) {
				pageNo--;
			} else if (OP_NEW.equals(operation)) {
				return "redirect:/user";
			}

			pageNo = (pageNo < 1) ? 1 : pageNo;
			pageSize = (pageSize < 1) ? 10 : pageSize;

			if (OP_DELETE.equals(operation)) {
				pageNo = 1;
				if (form.getIds() != null) {
					for (long id : form.getIds()) {
						UserEntity dto = new UserEntity();
						dto.setId(id);
						service.delete(dto);
					}
					model.addAttribute("success", "Deleted Successfully!!!");
				} else {
					model.addAttribute("error", "Select at least one record");
				}
			}
			UserEntity dto = (UserEntity) form.getDTO();

			UserEntity uDto = (UserEntity) session.getAttribute("user");

			
			List<UserEntity> list;

			list = service.search(dto, pageNo, pageSize);

			List<UserEntity> totallist = service.search(dto);
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
		log.info("UserCtl searchList display method End");
		return "userList";
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
