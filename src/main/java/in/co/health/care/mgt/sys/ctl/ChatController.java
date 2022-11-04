package in.co.health.care.mgt.sys.ctl;

import java.security.Principal;

import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import in.co.health.care.mgt.sys.entity.ChatMessage;
import in.co.health.care.mgt.sys.entity.UserEntity;
import in.co.health.care.mgt.sys.exception.ApplicationException;
import in.co.health.care.mgt.sys.exception.DuplicateRecordException;
import in.co.health.care.mgt.sys.service.UserService;

@Controller
public class ChatController {

	@Autowired
	private UserService service;
	
	@GetMapping("/chat")
	public String chat(@RequestParam(required = false) Long pId,Long dId,String pName,String docName, Model model,HttpSession session) {
		
		UserEntity uDto=(UserEntity)session.getAttribute("user");
		
		if(uDto.getRole().getId()==2) {
			session.setAttribute("senderId",dId);
			session.setAttribute("reciverId",pId);
			
		}else if(uDto.getRole().getId()==4) {
			session.setAttribute("senderId",pId);
			session.setAttribute("reciverId",dId);	
		}
		
		session.setAttribute("docName",docName);
		session.setAttribute("pName",pName);
		
		return "chat";
	}

	@MessageMapping("/chat.register")
	@SendTo("/topic/public")
	public ChatMessage register(@Payload ChatMessage chatMessage, SimpMessageHeaderAccessor headerAccessor,
			final Principal pricipal) {
		headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
		try {
			UserEntity entity = service.findById(chatMessage.getSenderId());
			entity.setChatId(pricipal.getName());
			service.update(entity);
		} catch (DuplicateRecordException e) {
			e.printStackTrace();
		} catch (ApplicationException e) {
			e.printStackTrace();
		}

		return chatMessage;
	}

	@MessageMapping("/chat.send")
	@SendTo("/topic/private-message")
	public ChatMessage sendMessage(@Payload ChatMessage chatMessage, final Principal pricipal) {

		JSONObject json=new JSONObject();
		
		json.put("content", chatMessage.getContent());
		json.put("sender", chatMessage.getSender());
		json.put("senderId", chatMessage.getSenderId());
		json.put("reciverId", chatMessage.getReciverId());
		
		Unirest.setTimeouts(0, 0);
		try {
			HttpResponse<String> response = Unirest.post("http://localhost:8080/send-message")
			  .header("Content-Type", "application/json")
			  .body(json)
			  .asString();
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return chatMessage;
	}

}
