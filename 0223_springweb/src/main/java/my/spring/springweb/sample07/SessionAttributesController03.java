package my.spring.springweb.sample07;

import javax.servlet.http.HttpServletRequest;

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
@SessionAttributes(value= {"data1", "shin"})
//즉,이렇게 작성해주면 Model에 저장하는 데이터의 key가 위에 써있는 문자열 중 하나에 해당할 때 Session 객체에도 같은 key와 value로 저장해주게 되는 것임

@RequestMapping(value="/sessionAttributesTest03")
public class SessionAttributesController03 {

	Logger log = LogManager.getLogger("case3");
	
	@ModelAttribute("data1")
	public String createString1() {
		
		log.debug("createString1() 호출되었습니다!");
		
		return "createString1";
	}
	@ModelAttribute("data2")
	public String createString2() {
		
		log.debug("createString2() 호출되었습니다!");
		
		return "createString2";
	}
	
	@ModelAttribute("shin")
	public Student createString2(HttpServletRequest request) {
		
		Student student = new Student(30, "신사임당", "국어국문");
		
		return student;
	}
	
	@PostMapping
	public String handler(
			@ModelAttribute("data1") String str1, //Model객체에서 data1이라는 key값으로 데이터를 받아옴 
			@ModelAttribute("data2") String str2,
			@RequestParam(value="msg") String requestMsg,
			@ModelAttribute("newStudent") Student studentVO, 
			//만일 @ModelAttribute("newStudent")가 붙은 메소드가 위에 있을 경우 해당 메소드가 먼저 실행되고
			//뒤이어 newStudent라는 key를 통해 전달되는 파라미터 즉,value(객체)가 Model객체의 해당 key값에 대한 value로 덮어쓰게 될 것임
			Model model) {
		
		log.debug("handler 호출되었습니다! "+ str1 + ", "+ str2);
		log.debug("msg " + requestMsg);
		log.debug("studentVO " + studentVO);
		
		return "sample07/sessionResult03";
	}
}
