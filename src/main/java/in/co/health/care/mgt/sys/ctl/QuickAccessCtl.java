package in.co.health.care.mgt.sys.ctl;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import in.co.health.care.mgt.sys.entity.QuickAccessEntity;
import in.co.health.care.mgt.sys.entity.UserEntity;
import in.co.health.care.mgt.sys.exception.ApplicationException;
import in.co.health.care.mgt.sys.exception.DuplicateRecordException;
import in.co.health.care.mgt.sys.form.QuickAccessForm;
import in.co.health.care.mgt.sys.service.QuickAccessService;
import in.co.health.care.mgt.sys.util.ControllerUtility;
import in.co.health.care.mgt.sys.util.DataUtility;

@Controller
@RequestMapping("/quickAccess")
public class QuickAccessCtl extends BaseCtl {

	private Logger log = Logger.getLogger(LoginCtl.class.getName());

	@Autowired
	private QuickAccessService service;

	@ModelAttribute
	public void preload(Model model) {

	}

	@GetMapping
	public String display(@RequestParam(required = false) Long id, Long pId, @ModelAttribute("form") QuickAccessForm form,
			HttpSession session, Model model) {
		log.info("QuickAccessCtl login display method start");
		try {
			if (form.getId() > 0) {
				QuickAccessEntity bean;
				bean = service.findById(form.getId());
				form.populate(bean);
			}
		} catch (ApplicationException e) {
			e.printStackTrace();
			return "redirect:/error";
		}
		log.info("QuickAccessCtl display method End");
		return "quickAccess";
	}
	
	@GetMapping("/page1")
	public String page1(@ModelAttribute("form") QuickAccessForm form,
			HttpSession session, Model model) {
		log.info("QuickAccessCtl login display method start");
		
		log.info("QuickAccessCtl display method End");
		return "page1";
	}

	@PostMapping
	public String submit(@Valid @ModelAttribute("form") QuickAccessForm form, BindingResult bindingResult,
			HttpSession session,HttpServletRequest request, Model model) {
		log.info("QuickAccessCtl submit display method start");
		if (OP_RESET.equalsIgnoreCase(form.getOperation())) {
			return "redirect:/quickAccess";
		}
		try {
			if (OP_SAVE.equalsIgnoreCase(form.getOperation())) {
				if (bindingResult.hasErrors()) {
					return "quickAccess";
				}
				QuickAccessEntity bean = (QuickAccessEntity)populateDTO(form.getDTO(), request);
				if (bean.getId() > 0) {
					service.update(bean);
					ControllerUtility.setSuccessMessage("QuickAccess update Successfully!!!!", model);
				} else {
					service.add(bean);
					ControllerUtility.setSuccessMessage("QuickAccess Added Successfully!!!!", model);
				}
				return "quickAccess";
			}
		} catch (DuplicateRecordException e) {
			ControllerUtility.setErrorMessage(e.getMessage(), model);
			return "quickAccess";
		} catch (ApplicationException e) {
			e.printStackTrace();
			return "redirect:/error";
		}
		log.info("QuickAccessCtl submit display method End");
		return "quickAccess";
	}

	@RequestMapping(value = "/search", method = { RequestMethod.GET, RequestMethod.POST })
	public String searchList(@ModelAttribute("form") QuickAccessForm form,
			@RequestParam(required = false) String operation, Long vid, HttpSession session, Model model) {
		log.info("QuickAccessCtl searchList display method start");
		try {

			if (OP_RESET.equalsIgnoreCase(operation)) {
				return "redirect:/quickAccess/search";
			}

			int pageNo = form.getPageNo();
			int pageSize = form.getPageSize();

			if (OP_NEXT.equals(operation)) {
				pageNo++;
			} else if (OP_PREVIOUS.equals(operation)) {
				pageNo--;
			} else if (OP_NEW.equals(operation)) {
				return "redirect:/quickAccess";
			}

			pageNo = (pageNo < 1) ? 1 : pageNo;
			pageSize = (pageSize < 1) ? 10 : pageSize;

			if (OP_DELETE.equals(operation)) {
				pageNo = 1;
				if (form.getIds() != null) {
					for (long id : form.getIds()) {
						QuickAccessEntity dto = new QuickAccessEntity();
						dto.setId(id);
						service.delete(dto);
					}
					model.addAttribute("success", "Deleted Successfully!!!");
				} else {
					model.addAttribute("error", "Select at least one record");
				}
			}
			QuickAccessEntity dto = (QuickAccessEntity) form.getDTO();

			UserEntity uDto = (UserEntity) session.getAttribute("user");

			List<QuickAccessEntity> list=null;

			
			if(dto.getKey()!=null && dto.getKey()!="") {
			list = service.search(dto, pageNo, pageSize);
			model.addAttribute("list", list);
			
			if (list.size() == 0 && !OP_DELETE.equalsIgnoreCase(operation)) {
				model.addAttribute("error", "Record not found");
				model.addAttribute("list", null);
			}
			
			long days=DataUtility.getLong(form.getDays());
			long scale=DataUtility.getLong(form.getScale());
			
			if(scale>7) {
				ControllerUtility.setErrorMessage("Please consult a doctor", model);
			} else if(scale < 5 && days>5){
				ControllerUtility.setErrorMessage("Please consult a doctor", model);
			}
			
			

			List<QuickAccessEntity> totallist = service.search(dto);

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
			}else {
			model.addAttribute("list", list);
			}
			model.addAttribute("form", form);
			
		} catch (ApplicationException e) {
			e.printStackTrace();
			return "redirect:/error";
		}
		log.info("QuickAccessCtl searchList display method End");
		return "quickAccessList";
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
