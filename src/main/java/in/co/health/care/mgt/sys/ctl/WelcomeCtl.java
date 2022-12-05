package in.co.health.care.mgt.sys.ctl;

import java.util.Optional;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.co.health.care.mgt.sys.entity.ChatRoomEntity;
import in.co.health.care.mgt.sys.repository.ChatRoomRepository;

@Controller
public class WelcomeCtl {

	@Autowired
	private ChatRoomRepository chatRoomRepository;

	@GetMapping({ "/welcome", "/" })
	public String display(Model model) {
		return "welcome";
	}

	// @GetMapping("/")
	// public String index(Model model) {
	// return "index";
	// }

	@GetMapping("/aboutUs")
	public String aboutUs(Model model) {
		return "aboutUs";
	}

	@GetMapping("/contactUs")
	public String contactUs(Model model) {
		return "contactUs";
	}

	@GetMapping("/error")
	public String error(Model model) {
		return "error";
	}

	@GetMapping("/pChat")
	public String chat(@RequestParam(required = false) Long pId, Long dId, String pName, String docName, Model model,
			HttpSession session) {

		session.setAttribute("docName", docName);
		session.setAttribute("pName", pName);
		
		System.out.println("In ctl------------");
		Optional<ChatRoomEntity> findByPatientIdAndDoctorId = chatRoomRepository.findByPatientIdAndDoctorId(pId, dId);
		if(findByPatientIdAndDoctorId.isPresent()) {
			session.setAttribute("chatRoom", findByPatientIdAndDoctorId.get().getChatRoom());
			System.out.println("In ctl------------if");
		}else {
			ChatRoomEntity entity=new ChatRoomEntity();
			String uid = UUID.randomUUID().toString();
			System.out.println("In ctl------------else uid");
			entity.setChatRoom(uid);
			entity.setDoctorId(dId);
			entity.setPatientId(pId);
			chatRoomRepository.save(entity);
			session.setAttribute("chatRoom", uid);
			
			System.out.println("In ctl------------else uid------");
		}
		
		

		return "chat";
	}

}
