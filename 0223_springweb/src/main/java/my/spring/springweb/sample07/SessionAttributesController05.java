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
//이 클래스는 에러나는 것이 당연함(밑의 이유 참고)

@Controller
@SessionAttributes(value= {"data1", "newStudent", "shin"})

@RequestMapping(value="/sessionAttributesTest05")
public class SessionAttributesController05 {

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
		
		log.debug("createString2() 호출되었습니다!");
		
		return student;
	}
	
	@PostMapping
	public String handler(
			@ModelAttribute("data1") String str1,
			@ModelAttribute("data2") String str2,
			@RequestParam(value= "msg") String requestMsg,
			@ModelAttribute("newStudent") Student studentVO) {
		
		//@SessionAttributes 라는 어노테이션이 있으면 @ModelAttribute를 통해 Command 객체를 만드는 과정은 기존에 알고 있던 것과는 좀 다르게 동작함
		
		
		//기존에는 @ModelAttribute("정해줄 key값")매개변수를 하게 되면 Command 객체를 만들어서 클라이언트가 보내준 데이터를 그 객체 안에 집어넣고 해당객체를 
		//인자로 handler에 인자로 집어넣어준다고 알고 있었음 + Model객체에도 해당 데이터를 집어넣음
		
		//하지만 이 어노테이션이 있을 경우
		//@ModelAttribute("key값")에 써준 key값이 @SessionAttributes 옆에 붙어있는 배열 속 문자열들 중 같은 문자열이 있으면
		//Model과 Session에 해당 key값(newStudent)에 해당하는 value를 가져오겠다는 의미가 됨(그래서 Model,Session에 그 key값에 해당하는 value(객체)가 없으면 오류가 나게 됨)
		//즉, Command 객체를 만드는 동작은 일어나지 않음
		//-> ModelAttribute("newStudent")가 붙은 handler로 객체를 만들고 return해주는 과정 만들어주면 해결
		
		
		//반면, @SessionAttributes 옆에 붙어있는 배열 속 문자열들 중 같은 문자열이 없으면 기존에 알고 있던 동작을 수행하는 것임(이 때 새로운 Command객체를 만드는 거지)
		//이 경우 Session에는 해당 객체가 저장되지 않는 것임
		
		log.debug("handler 호출되었습니다! "+ str1 + ", "+ str2);
		log.debug("msg " + requestMsg);
		log.debug("studentVO " + studentVO);
		
		return "sample07/sessionResult05";
	}
}
//해당 데이터나 객체를 찾을 때는 Model -> Session 순으로 찾음