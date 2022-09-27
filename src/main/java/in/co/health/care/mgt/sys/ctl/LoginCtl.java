package in.co.health.care.mgt.sys.ctl;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.util.HashMap;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.rowset.serial.SerialBlob;
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

import in.co.health.care.mgt.sys.entity.DoctorEntity;
import in.co.health.care.mgt.sys.entity.PatientEntity;
import in.co.health.care.mgt.sys.entity.ShopkeeperEntity;
import in.co.health.care.mgt.sys.entity.UserAddressDetailEntity;
import in.co.health.care.mgt.sys.entity.UserEntity;
import in.co.health.care.mgt.sys.exception.ApplicationException;
import in.co.health.care.mgt.sys.exception.DuplicateRecordException;
import in.co.health.care.mgt.sys.form.AdminProfileForm;
import in.co.health.care.mgt.sys.form.ChangePasswordForm;
import in.co.health.care.mgt.sys.form.DoctorProfileForm;
import in.co.health.care.mgt.sys.form.DoctorRegistrationForm;
import in.co.health.care.mgt.sys.form.ForgetPasswordForm;
import in.co.health.care.mgt.sys.form.LoginForm;
import in.co.health.care.mgt.sys.form.MyProfileForm;
import in.co.health.care.mgt.sys.form.PatientRegistrationForm;
import in.co.health.care.mgt.sys.form.ShopKeeperRegistrationForm;
import in.co.health.care.mgt.sys.form.ShopkeeperProfileForm;
import in.co.health.care.mgt.sys.form.UserRegistrationForm;
import in.co.health.care.mgt.sys.repository.RoleRepository;
import in.co.health.care.mgt.sys.service.UserService;
import in.co.health.care.mgt.sys.util.ControllerUtility;

@Controller
@RequestMapping
public class LoginCtl extends BaseCtl {

	private Logger log = Logger.getLogger(LoginCtl.class.getName());

	protected static final String OP_SIGNIN = "SignIn";
	protected static final String OP_SIGNUP = "SignUp";
	protected static final String OP_LOGOUT = "Logout";

	@Autowired
	private UserService service;

	@Autowired
	private RoleRepository roleRepository;

	@GetMapping("/login")
	public String display(@ModelAttribute("form") LoginForm form, @RequestParam(required = false) Long iId,
			HttpSession session, Model model) {
		log.info("LoginCtl login display method start");
		try {
			if (session.getAttribute("user") != null) {
				session.invalidate();
				model.addAttribute("success", "You have logout Successfully!!!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/error";
		}
		log.info("LoginCtl login display method End");
		return "login";
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
		
		model.addAttribute("roleList", roleRepository.findAllWithoutAdmin());

	}

	@PostMapping("/login")
	public String submit(@RequestParam String operation, HttpSession session,
			@Valid @ModelAttribute("form") LoginForm form, BindingResult result, HttpServletRequest request,
			Model model) {
		log.info("LoginCtl login submit method start");
		try {
			if (OP_SIGNUP.equalsIgnoreCase(form.getOperation())) {
				return "redirect:/user/us-signUp";
			}

			if (result.hasErrors()) {
				System.out.println(result);
				return "login";
			}

			UserEntity bean;
			bean = service.authentication((UserEntity) form.getDTO());
			if (bean != null) {
				session.setAttribute("user", bean);
				return "redirect:/welcome";
			}
			ControllerUtility.setErrorMessage("Login Id Password Invalid", model);
		} catch (ApplicationException e) {
			e.printStackTrace();
			return "redirect:/error";
		}
		log.info("LoginCtl login submit method End");
		return "login";
	}

	@GetMapping("/user-signUp")
	public String userSignUp(@ModelAttribute("form") PatientRegistrationForm form, Model model) {
		return "user-signUp";
	}

	@GetMapping("/signUp")
	public String signUp(@ModelAttribute("form") UserRegistrationForm form, Model model) {
		return "signUp";
	}

	@GetMapping("/doctor-signUp")
	public String doctorSignUp(@ModelAttribute("form") DoctorRegistrationForm form, Model model) {
		return "doctor-signUp";
	}

	@GetMapping("/shopkeeper-signUp")
	public String shopkeeperdisplay(@ModelAttribute("form") ShopKeeperRegistrationForm form, Model model) {
		return "shopkeeper-signUp";
	}

	@PostMapping("/signUp")
	public String signUp(@RequestParam String operation, @Valid @ModelAttribute("form") UserRegistrationForm form,
			BindingResult bindingResult, HttpServletRequest request, HttpSession session, Model model) {

		log.info("LoginCtl signUp submit method start");

		if (OP_RESET.equalsIgnoreCase(form.getOperation())) {
			return "redirect:/signUp";
		}

		if (bindingResult.hasErrors()) {
			System.out.println(bindingResult);
			return "signUp";
		}
		if (OP_SAVE.equalsIgnoreCase(form.getOperation())) {
			UserEntity entity = (UserEntity) populateDTO(form.getDTO(), request);
			entity = setUserNamePassword(entity);
			entity.setRole(roleRepository.findById(entity.getRoleId()).get());
			session.setAttribute("userEntity", entity);
			if (entity.getRoleId() == 4) {
				return "redirect:/user-signUp";
			} else if (entity.getRoleId() == 3) {
				return "redirect:/shopkeeper-signUp";
			} else if (entity.getRoleId() == 2) {
				return "redirect:/doctor-signUp";
			}
		}

		log.info("LoginCtl signUp submit method end");
		return "user-signUp";
	}

	@PostMapping("/user-signUp")
	public String userSubmit(@RequestParam String operation,
			@Valid @ModelAttribute("form") PatientRegistrationForm form, BindingResult bindingResult,
			HttpServletRequest request, HttpSession session, Model model) {

		log.info("LoginCtl signUp submit method start");

		if (OP_RESET.equalsIgnoreCase(form.getOperation())) {
			return "redirect:/user-signUp";
		}

		if (bindingResult.hasErrors()) {
			System.out.println(bindingResult);
			return "user-signUp";
		}

		try {
			if (OP_SAVE.equalsIgnoreCase(form.getOperation())) {
				PatientEntity entity = (PatientEntity) populateDTO(form.getDTO(), request);
				UserEntity userEntity = (UserEntity) session.getAttribute("userEntity");
				userEntity.setPatient(entity);
				service.register(userEntity);
				ControllerUtility.setSuccessMessage("Patient Registerd Successfully!!!!", model);
				return "user-signUp";
			}
		} catch (DuplicateRecordException e) {
			ControllerUtility.setErrorMessage(e.getMessage(), model);
			return "user-signUp";
		} catch (ApplicationException e) {
			e.printStackTrace();
			return "redirect:/error";
		}

		log.info("LoginCtl signUp submit method end");
		return "user-signUp";
	}

	@PostMapping("/doctor-signUp")
	public String doctorSubmit(@RequestParam String operation, @RequestParam("certificates") MultipartFile file,
			@Valid @ModelAttribute("form") DoctorRegistrationForm form, BindingResult bindingResult,
			HttpServletRequest request, HttpSession session, Model model) {

		log.info("LoginCtl signUp submit method start");

		if (OP_RESET.equalsIgnoreCase(form.getOperation())) {
			return "redirect:/doctor-signUp";
		}

		if (bindingResult.hasErrors()) {
			System.out.println(bindingResult);
			return "doctor-signUp";
		}

		try {
			if (OP_SAVE.equalsIgnoreCase(form.getOperation())) {
				DoctorEntity entity = (DoctorEntity) populateDTO(form.getDTO(), request);
				UserEntity userEntity = (UserEntity) session.getAttribute("userEntity");
				userEntity.setDoctor(entity);
				userEntity.getDoctor().setCertificates(file.getBytes());
				service.register(userEntity);
				ControllerUtility.setSuccessMessage("Doctor Registerd Successfully!!!!", model);
				return "doctor-signUp";
			}
		} catch (DuplicateRecordException e) {
			ControllerUtility.setErrorMessage(e.getMessage(), model);
			return "doctor-signUp";
		} catch (ApplicationException e) {
			e.printStackTrace();
			return "redirect:/error";
		} catch (IOException e) {
			e.printStackTrace();
			return "redirect:/error";
		}

		log.info("LoginCtl signUp submit method end");
		return "doctor-signUp";
	}

	@PostMapping("/shopkeeper-signUp")
	public String shopKeeperSubmit(@RequestParam String operation,
			@Valid @ModelAttribute("form") ShopKeeperRegistrationForm form, BindingResult bindingResult,
			HttpServletRequest request, HttpSession session, Model model) {

		log.info("LoginCtl signUp submit method start");

		if (OP_RESET.equalsIgnoreCase(form.getOperation())) {
			return "redirect:/shopkeeper-signUp";
		}

		if (bindingResult.hasErrors()) {
			System.out.println(bindingResult);
			return "shopkeeper-signUp";
		}

		try {
			if (OP_SAVE.equalsIgnoreCase(form.getOperation())) {
				ShopkeeperEntity entity = (ShopkeeperEntity) populateDTO(form.getDTO(), request);
				UserEntity userEntity = (UserEntity) session.getAttribute("userEntity");
				userEntity.setShopkeeper(entity);
				service.register(userEntity);
				ControllerUtility.setSuccessMessage("Shopkeeper Registerd Successfully!!!!", model);
				return "shopkeeper-signUp";
			}
		} catch (DuplicateRecordException e) {
			ControllerUtility.setErrorMessage(e.getMessage(), model);
			return "shopkeeper-signUp";
		} catch (ApplicationException e) {
			e.printStackTrace();
			return "redirect:/error";
		}

		log.info("LoginCtl signUp submit method end");
		return "shopkeeper-signUp";
	}

	@RequestMapping(value = "/patient-profile", method = RequestMethod.GET)
	public String displayProfile(HttpSession session, @ModelAttribute("form") MyProfileForm form, Model model) {
		log.info("LoginCtl displayProfile method Start");
		try {
			UserEntity entity = (UserEntity) session.getAttribute("user");
			form.populate(entity);
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/error";
		}

		log.info("LoginCtl displayProfile method End");
		return "patient-profile";
	}
	
	@RequestMapping(value = "/admin-profile", method = RequestMethod.GET)
	public String displayProfile(HttpSession session, @ModelAttribute("form") AdminProfileForm form, Model model) {
		log.info("LoginCtl displayProfile method Start");
		try {
			UserEntity entity = (UserEntity) session.getAttribute("user");
			form.populate(entity);
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/error";
		}

		log.info("LoginCtl displayProfile method End");
		return "admin-profile";
	}
	

	@RequestMapping(value = "/doctor-profile", method = RequestMethod.GET)
	public String doctorProfile(HttpSession session, @ModelAttribute("form") DoctorProfileForm form, Model model) {
		log.info("LoginCtl displayProfile method Start");
		try {
			UserEntity entity = (UserEntity) session.getAttribute("user");
			form.populate(entity);
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/error";
		}

		log.info("LoginCtl displayProfile method End");
		return "doctor-profile";
	}

	@RequestMapping(value = "/shopkeeper-profile", method = RequestMethod.GET)
	public String shokeeperProfile(HttpSession session, @ModelAttribute("form") ShopkeeperProfileForm form,
			Model model) {
		log.info("LoginCtl shokeeperProfile method Start");
		try {
			UserEntity entity = (UserEntity) session.getAttribute("user");
			form.populate(entity);
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/error";
		}

		log.info("LoginCtl shokeeperProfile method End");
		return "shopkeeper-profile";
	}

	@RequestMapping(value = "/patient-profile", method = RequestMethod.POST)
	public String submitProfile(HttpSession session, @ModelAttribute("form") @Valid MyProfileForm form,
			@RequestParam("profilePic") MultipartFile profilePic, BindingResult bindingResult,
			@RequestParam(required = false) String operation, HttpServletRequest request, Model model) {
		log.info("LoginCtl submitProfile method Start");
		try {
			if (OP_RESET.equalsIgnoreCase(operation)) {
				return "redirect:/patient-profile";
			}
			if (bindingResult.hasErrors()) {
				return "patient-profile";
			}
			UserEntity entity = (UserEntity) session.getAttribute("user");
			entity = (UserEntity) populateDTO(form.getDTO(), request);
			entity.setProfilePic(profilePic.getBytes());
			entity.setRole(roleRepository.findById(4L).get());
			service.update(entity);
			ControllerUtility.setSuccessMessage("Profile Update successfully", model);
		} catch (ApplicationException e) {
			e.printStackTrace();
			return "redirect:/error";
		} catch (DuplicateRecordException e) {
			ControllerUtility.setErrorMessage(e.getMessage(), model);
			return "patient-profile";
		} catch (IOException e) {
			e.printStackTrace();
			return "redirect:/error";
		}
		log.info("LoginCtl submitProfile method Start");
		return "patient-profile";
	}
	
	@RequestMapping(value = "/admin-profile", method = RequestMethod.POST)
	public String submitProfile(HttpSession session, @ModelAttribute("form") @Valid AdminProfileForm form,
			@RequestParam("profilePic") MultipartFile profilePic, BindingResult bindingResult,
			@RequestParam(required = false) String operation, HttpServletRequest request, Model model) {
		log.info("LoginCtl submitProfile method Start");
		try {
			if (OP_RESET.equalsIgnoreCase(operation)) {
				return "redirect:/admin-profile";
			}
			if (bindingResult.hasErrors()) {
				return "admin-profile";
			}
			UserEntity entity = (UserEntity) session.getAttribute("user");
			entity = (UserEntity) populateDTO(form.getDTO(), request);
			entity.setProfilePic(profilePic.getBytes());
			entity.setRole(roleRepository.findById(1L).get());
			service.update(entity);
			ControllerUtility.setSuccessMessage("Profile Update successfully", model);
		} catch (ApplicationException e) {
			e.printStackTrace();
			return "redirect:/error";
		} catch (DuplicateRecordException e) {
			ControllerUtility.setErrorMessage(e.getMessage(), model);
			return "admin-profile";
		} catch (IOException e) {
			e.printStackTrace();
			return "redirect:/error";
		}
		log.info("LoginCtl submitProfile method Start");
		return "admin-profile";
	}

	@RequestMapping(value = "/doctor-profile", method = RequestMethod.POST)
	public String doctorProfile(HttpSession session, @ModelAttribute("form") @Valid DoctorProfileForm form,
			@RequestParam("profilePic") MultipartFile profilePic,
			@RequestParam("certificates") MultipartFile certificates,BindingResult bindingResult,
			@RequestParam(required = false) String operation, HttpServletRequest request, Model model) {
		log.info("LoginCtl submitProfile method Start");
		try {
			if (OP_RESET.equalsIgnoreCase(operation)) {
				return "redirect:/doctor-profile";
			}
			if (bindingResult.hasErrors()) {
				return "doctor-profile";
			}
			UserEntity entity = (UserEntity) session.getAttribute("user");
			UserAddressDetailEntity address = entity.getAddress();
			entity = (UserEntity) populateDTO(form.getDTO(), request);
			entity.setProfilePic(profilePic.getBytes());
			entity.setRole(roleRepository.findById(2L).get());
			entity.getDoctor().setCertificates(certificates.getBytes());
			entity.setAddress(address);
			service.update(entity);
			ControllerUtility.setSuccessMessage("Profile Update successfully", model);
		} catch (ApplicationException e) {
			e.printStackTrace();
			return "redirect:/error";
		} catch (DuplicateRecordException e) {
			ControllerUtility.setErrorMessage(e.getMessage(), model);
			return "doctor-profile";
		} catch (IOException e) {
			e.printStackTrace();
			return "redirect:/error";
		}
		log.info("LoginCtl submitProfile method Start");
		return "doctor-profile";
	}

	@RequestMapping(value = "/shopkeeper-profile", method = RequestMethod.POST)
	public String shopkeeperProfile(HttpSession session, @ModelAttribute("form") @Valid ShopkeeperProfileForm form,
			@RequestParam("profilePic") MultipartFile profilePic, BindingResult bindingResult,
			@RequestParam(required = false) String operation, HttpServletRequest request, Model model) {
		log.info("LoginCtl submitProfile method Start");
		try {
			if (OP_RESET.equalsIgnoreCase(operation)) {
				return "redirect:/shopkeeper-profile";
			}
			if (bindingResult.hasErrors()) {
				return "shopkeeper-profile";
			}
			UserEntity entity = (UserEntity) session.getAttribute("user");
			UserAddressDetailEntity address = entity.getAddress();
			entity = (UserEntity) populateDTO(form.getDTO(), request);
			entity.setProfilePic(profilePic.getBytes());
			entity.setRole(roleRepository.findById(3L).get());
			entity.setAddress(address);
			service.update(entity);
			ControllerUtility.setSuccessMessage("Profile Update successfully", model);
		} catch (ApplicationException e) {
			e.printStackTrace();
			return "redirect:/error";
		} catch (DuplicateRecordException e) {
			ControllerUtility.setErrorMessage(e.getMessage(), model);
			return "shopkeeper-profile";
		} catch (IOException e) {
			e.printStackTrace();
			return "redirect:/error";
		}
		log.info("LoginCtl submitProfile method Start");
		return "shopkeeper-profile";
	}

	@RequestMapping(value = "/changepassword", method = RequestMethod.GET)
	public String displayChangePassword(@ModelAttribute("form") ChangePasswordForm form, Model model) {
		return "changePassword";
	}

	@RequestMapping(value = "/changepassword", method = RequestMethod.POST)
	public String submitChangePassword(HttpSession session, @ModelAttribute("form") @Valid ChangePasswordForm form,
			BindingResult bindingResult, Model model) {
		try {
			if (bindingResult.hasErrors()) {
				return "changePassword";
			}
			if (form.getNewPassword().equalsIgnoreCase(form.getConfirmPassword())) {
				UserEntity dto = (UserEntity) session.getAttribute("user");
				dto = service.findById(dto.getId());
				if (service.changePassword(dto.getId(), form.getOldPassword(), form.getNewPassword())) {
					ControllerUtility.setSuccessMessage("Password changed Successfully", model);
				} else {
					ControllerUtility.setErrorMessage("Old Passowors Does not Matched", model);
				}
			} else {
				ControllerUtility.setErrorMessage("New Password and confirm password does not matched", model);
			}
		} catch (ApplicationException e) {
			e.printStackTrace();
			return "redirect:/error";
		}
		return "changePassword";
	}

	@RequestMapping(value = "/forgetPassword", method = RequestMethod.GET)
	public String display(@ModelAttribute("form") ForgetPasswordForm form, HttpSession session, Model model) {
		return "forgetPassword";

	}

	/*
	 * @RequestMapping(value = "/forgetPassword", method = RequestMethod.POST)
	 * public String display(@ModelAttribute("form") @Valid ForgetPasswordForm form,
	 * BindingResult bindingResult, Model model) {
	 * 
	 * if (bindingResult.hasErrors()) { return "forgetPassword"; }
	 * 
	 * UserEntity dto = service.findByUserName(form.getEmail());
	 * 
	 * if (dto == null) { model.addAttribute("error", "Login Id does not exist"); }
	 * 
	 * if (dto != null) { service.forgetPassword(form.getEmail());
	 * model.addAttribute("success",
	 * "Password has been sent to your registered Email ID!!"); } return
	 * "forgetPassword"; }
	 */

	private UserEntity setUserNamePassword(UserEntity entity) {
		entity.setUserName(entity.getFirstName().substring(0, 2).concat(entity.getLastName().substring(0, 2))
				.concat(entity.getPhoneNo().substring(0, 2)));
		entity.setPassword(entity.getFirstName().substring(0, 2).concat(entity.getLastName().substring(0, 2))
				.concat(entity.getPhoneNo().substring(0, 2)));
		return entity;
	}

	@GetMapping("/user/getProfilePic/{id}")
	public void getStudentPhoto(HttpServletResponse response, @PathVariable("id") long id) throws Exception {

		byte[] blob = service.findById(id).getProfilePic();
		Blob bBlob = new SerialBlob(blob);

		byte[] bytes = bBlob.getBytes(1, (int) bBlob.length());
		InputStream inputStream = new ByteArrayInputStream(bytes);
		IOUtils.copy(inputStream, response.getOutputStream());
	}

}
