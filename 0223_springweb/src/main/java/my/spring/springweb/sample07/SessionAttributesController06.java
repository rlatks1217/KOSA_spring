package my.spring.springweb.sample07;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import my.spring.springweb.sample07.vo.Student;

@Controller
@SessionAttributes(value= {"data1","shin"})

@RequestMapping(value="/sessionAttributesTest06")
public class SessionAttributesController06 {

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
	
	@ModelAttribute("newStudent")
	public Student createString2(HttpServletRequest request) {
		
		Student student = new Student();
		
		return student;
	}//여기서 먼저 Session에 빈 student객체를 저장함(Model에 저장되면서 Session에도 저장되도록 위에 어노테이션으로 설정했으니까 가능)
	
	@PostMapping
	public String handler(
			@ModelAttribute("data1") String str1, //Model객체에서 data1이라는 key값으로 데이터를 받아옴 
			@ModelAttribute("data2") String str2,
			@RequestParam(value= "msg") String requestMsg,
			@ModelAttribute("newStudent") Student studentVO) {
		//SessionAttributeController05이 오류가 안 나기 위해서는 이 handler가 호출되기 전에 미리 @ModelAttribute가 붙은 메소드를 통해 
		//데이터가 저장되지 않은 빈 객체를 만들고 Session에 저장해둠 -> 그 다음 이 handler가 호출되는 시점에 해당 객체(데이터가 들어가지 않은 상태)를 먼저 가져오고
		//setter를 통해 클라이언트가 보내준 데이터를 저장하는 과정 후 이 메소드의 인자로 주입해주게 됨
		
		//즉, 여기서는 Command 객체를 따로 만드는 과정은 없음 -> 대신 클라이언트가 보내준 데이터는 setter를 통해 Session에서 가져온 객체에 집어넣게 되는 것
		
		log.debug("handler 호출되었습니다! "+ str1 + ", "+ str2);
		log.debug("msg " + requestMsg);
		log.debug("studentVO " + studentVO);
		
		return "sample07/sessionResult05";
	}
}
