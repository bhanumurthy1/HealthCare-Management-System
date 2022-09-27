package in.co.health.care.mgt.sys.ctl;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import in.co.health.care.mgt.sys.entity.BaseEntity;
import in.co.health.care.mgt.sys.entity.UserEntity;
import in.co.health.care.mgt.sys.util.DataUtility;
import in.co.health.care.mgt.sys.util.DataValidator;

public class BaseCtl {

	protected static final String OP_SAVE = "Save";
	protected static final String OP_NEW = "New";
	protected static final String OP_DELETE = "Delete";
	protected static final String OP_COMPARE = "Compare";
	protected static final String OP_UPDATE = "Update";
	protected static final String OP_CANCEL = "Cancel";
	protected static final String OP_ERROR = "Error";
	protected static final String OP_NEXT = "Next";
	protected static final String OP_PREVIOUS = "Previous";
	protected static final String OP_LOGOUT = "Logout";
	protected static final String OP_GO = "Go";
	protected static final String OP_GET = "Get";
	protected static final String OP_RESET = "Reset";
	protected static final String OP_PAY = "Pay";

	public static final String SUCCESS = "success";
	public static final String ERROR = "error";

	protected BaseEntity populateDTO(BaseEntity dto, HttpServletRequest request) {
		String createdBy = request.getParameter("createdBy");
		String modifiedBy = null;
		UserEntity userbean = (UserEntity) request.getSession().getAttribute("user");
		if (userbean == null) {
			createdBy = "root";
			modifiedBy = "root";
		} else {

			modifiedBy = userbean.getUserName();

			if ("null".equalsIgnoreCase(createdBy) || DataValidator.isNull(createdBy)) {
				createdBy = modifiedBy;
			}
		}
		dto.setCreatedBy(createdBy);
		dto.setModifiedBy(modifiedBy);

		long cdt = DataUtility.getLong(request.getParameter("createdDatetime"));

		if (cdt > 0) {
			dto.setCreatedDatetime(DataUtility.getTimestamp(cdt));
		} else {
			dto.setCreatedDatetime(DataUtility.getCurrentTimestamp());
		}

		dto.setModifiedDatetime(DataUtility.getCurrentTimestamp());
		return dto;
	}
	

	@ModelAttribute
	public void preload(Model model) {

		HashMap<String, String> map = new HashMap<String, String>();
		map.put("Male", "Male");
		map.put("Female", "Female");
		model.addAttribute("gender", map);
		
		HashMap<String, String> map1 = new HashMap<String, String>();
		 map1.put("Allergists/Immunologists", "Allergists/Immunologists");
		 map1.put("Anesthesiologists", "Anesthesiologists");
		 map1.put("Cardiologists", "Cardiologists");
		 map1.put("Colon and Rectal Surgeons", "Colon and Rectal Surgeons");
		 map1.put("Critical Care Medicine Specialists", "Critical Care Medicine Specialists");
		 map1.put("Dermatologists", "Dermatologists");
		 map1.put("Endocrinologists", "Endocrinologists");
		 map1.put("Emergency Medicine Specialists", "Emergency Medicine Specialists");
		 map1.put("Family Physicians", "Family Physicians");
		 map1.put("Gastroenterologists", "Gastroenterologists");
		 map1.put("Geriatric Medicine Specialists", "Geriatric Medicine Specialists");
		 map1.put("Hematologists", "Hematologists");
		 map1.put("Hospice and Palliative Medicine Specialists", "Hospice and Palliative Medicine Specialists");
		 map1.put("Infectious Disease Specialists", "Infectious Disease Specialists");
		 map1.put("Internists", "Internists");
		 map1.put("Medical Geneticists", "Medical Geneticists");
		 map1.put("Nephrologists", "Nephrologists");
		 map1.put("Neurologists", "Neurologists");
		 map1.put("Obstetricians and Gynecologists", "Obstetricians and Gynecologists");
		 map1.put("Oncologists", "Oncologists");
		 map1.put("Ophthalmologists", "Ophthalmologists");
		 map1.put("Osteopaths", "Osteopaths");
		 map1.put("Otolaryngologists", "Otolaryngologists");
		 map1.put("Pathologists", "Pathologists");
		 map1.put("Pediatricians", "Pediatricians");
		 map1.put("Physiatrists", "Physiatrists");
		 map1.put("Plastic Surgeons", "Plastic Surgeons");
		 map1.put("Podiatrists", "Podiatrists");
		 map1.put("Preventive Medicine Specialists", "Preventive Medicine Specialists");
		 map1.put("Psychiatrists", "Psychiatrists");
		 map1.put("Pulmonologists", "Pulmonologists");
		 map1.put("Radiologists", "Radiologists");
		 map1.put("Rheumatologists", "Rheumatologists");
		 map1.put("Sleep Medicine Specialists", "Sleep Medicine Specialists");
		 map1.put("PsychiSports Medicine Specialistsatrists", "Sports Medicine Specialists");
		 map1.put("Urologists", "Urologists");
		 map1.put("General Surgeons", "General Surgeons");
		 model.addAttribute("docSpecial", map1);


	}

}
