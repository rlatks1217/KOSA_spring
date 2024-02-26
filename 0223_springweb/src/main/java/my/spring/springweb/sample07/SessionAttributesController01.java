package my.spring.springweb.sample07;

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
@SessionAttributes(names= {"data1", "data2"})//value 생략가능
//names/value 둘다 써도 됨
//일반적으로 위의 배열에는 Model객체의 key값들이 들어감 -> key값에 해당하는 value가 session 객체 안에도 저장됨!

@RequestMapping(value="/sessionAttributesTest01")
public class SessionAttributesController01 {

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
	
	@PostMapping
	public String handler(
			@ModelAttribute("data1") String str1, //Model객체에서 data1이라는 key값으로 데이터를 받아옴
			@ModelAttribute("data2") String str2,
			@RequestParam(value= "msg") String requestMsg,
			@ModelAttribute("newStudent") Student studentVO,
			Model model) {
		//Command객체를 새로 만들어 Model에 저장하기 위해 써주는 key값에 대하여 그 key값에 해당하는 value가 Model에 이미 있는 경우 
		//Model의 해당 key값에 지금 만들어진 데이터(Command객체)가 저장됨(똑같은 key값에 새로운 value로 덮어쓰는 거지)
		
		log.debug("handler 호출되었습니다! "+ str1 + ", "+ str2);
		log.debug("msg " + requestMsg);
		log.debug("studentVO " + studentVO);
		
		model.addAttribute("mykey", "하하하하");
		
		return "sample07/sessionResult01";
	}
	//model 객체의 경우 request Scope이기 때문에 요청을 받고 응답하고 나서는 사라지는 객체임 (일회성이라는 의미임)
}
