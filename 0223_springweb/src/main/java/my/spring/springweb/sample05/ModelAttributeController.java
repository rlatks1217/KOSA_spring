package my.spring.springweb.sample05;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import my.spring.springweb.sample05.vo.User;

@Controller
public class ModelAttributeController {
	
	Logger log = LogManager.getLogger("case3");
	
	@ModelAttribute("v1")
	//Method에 붙을 경우 특이하게 동작함
	// Method에 @ModelAttribute를 지정할 때는 이름을 하나 명시해야 해요!
	//이 클래스 내에 있는 handler가 호출되어야 하는 상황이라면 무조건 이 어노테이션이 붙은 method가 handler보다 먼저 호출됨
	//어노테이션 옆에 붙어있는 문자열(v1)이 key값,return값이 value로 Model의 데이터로 저장됨
	public String createString() {
		log.debug("문자열 객체 생성");
		
		return "정처기 씹망했네 ㅋ";
	}
	
	//그럼 하나 더 있을 경우엔 어떻게 됨? 누가 먼저 호출될 지는 모름(코드 상에서 위에 있다고 먼저 호출되는 것이 아님)
	@ModelAttribute("v2")
	public User createUser() {
		log.debug("VO 객체 생성");
		
		User user = new User(25, "김산", "철학과");
		
		return user;
	}
	@ModelAttribute("data1")
	public int createNumber1() {
		log.debug("첫번째 숫자 생성");
		
		return 100;
	}
	@ModelAttribute("data2")
	public int createNumber2() {
		log.debug("두번째 숫자 생성");
		
		return 200;
	}
	
	@RequestMapping(value="modelAttribute1")
	//@ModelAttribute가 붙은 게 먼저 실행되기 때문에 handler에서 Model에서 만들어진 데이터를 이런 식으로 땡겨와서 쓸 수도 있음
	public String myMethod1(@ModelAttribute("data1") int num1, @ModelAttribute("data2") int num2, Model model) {	
		
		log.debug("handler 호출");
		
		model.addAttribute("sum", num1+num2);
		
		return "sample05/modelResult";
	}
	
	@PostMapping(value="modelAttribute2")
	public String myMethod2(User user) {//@ModelAttribute가 생략되어 있는 상태
		//이렇게 클라이언트가 보낸 데이터로 객체를 만들 수 있음(당연히 만들어주는 주체는 Application context) -> 이런 객체를 command 객체라고 함
		//대부분 vo를 이용해서 Command 객체를 생성
		
		//1. 만약  클래스 위에 @sessionAttributes가 지정되어 있으면 
		//@ModelAttribute User user 이 코드가 있을 경우 session에서  user를 찾음 (클래스명에서 앞글자만 소문자인 이름의 key값으로 된 데이터가 있는지 찾는 것)-> 있으면 그 데이터가 꽂힘
		//2. 아니라면 User의 생성자를 찾아 객체를 생성함 -> 여러 생성자가 있다면 그 생성자들 중에 인자가 가장 적은 생성자를 찾음
		//즉, 기본 생성자가 있으면 이게 선택이 됨 선택된 생성자를 이용해서 객체를 생성하는 것임
		//3. 그런 다음 초기화되지 않은 필드들은 setter를 이용해서 클라이언트가 보내준 데이터를 VO에 저장함
		//4. 생성된 객체는 Model객체의 value로 저장이 됨(key값은 클래스 이름에서 앞글자만 소문자인 상태로 저장됨) 
		//-> 그래서 사실 매개변수로 받은 vo를 따로 addAttribute를 통해서 model에 집어넣지 않아도 model객체에 들어가는 것임
		//만약 내가 value의 이름(key값)을 달리해서 저장하고 싶을 경우 @ModelAttribute("지정하고 싶은 이름")이런 식으로 지정해주면 됨
		
		log.debug("PostMapping handler 호출!");
		return "sample05/modelResult";
	}

}
