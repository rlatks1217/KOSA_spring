package my.spring.springweb.sample07;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import my.spring.springweb.sample07.vo.Student;

@Controller
@SessionAttributes(value= {"data1", "data2"})//value 생략가능

@RequestMapping(value="/sessionAttributesTest02")
public class SessionAttributesController02 {

	Logger log = LogManager.getLogger("case3");
	
	@ModelAttribute("data1")
	public String createString1() {
		
		log.debug("createString1() 호출되었습니다!");
		
		return "createString1";
	}
	
	@ModelAttribute("data2")
	public String createString2(HttpServletRequest request) {
		
		//session을 직접 이용해 보아요!
		//기존에는 HttpSession session = request.getSession();으로 사용했었음
		HttpSession session = request.getSession(true);
		//알다시피 true는 해당 클라이언트에 대한 session객체가 있으면 그거 가져오고 없으면 만들어서 가져오라는 의미
		Student student = new Student(30, "신사임당", "국어국문");
		session.setAttribute("shin", student);
		
		log.debug("createString2() 호출되었습니다!");
		
		return "createString2";
	}
	
	@PostMapping
	public String handler(
			@ModelAttribute("data1") String str1, //Model객체에서 data1이라는 key값으로 데이터를 받아옴 
			@ModelAttribute("data2") String str2,
			@RequestParam(value= "msg") String requestMsg,
			@ModelAttribute("newStudent") Student studentVO,
			Model model) {
		
		log.debug("handler 호출되었습니다! "+ str1 + ", "+ str2);
		log.debug("msg " + requestMsg);
		log.debug("studentVO " + studentVO);
		
		model.addAttribute("mykey", "하하하하");
		
		return "sample07/sessionResult02";
	}
}
