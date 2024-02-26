package my.spring.springweb.sample07;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import my.spring.springweb.sample07.vo.Member;

@Controller
@SessionAttributes(value= {"memberInfo"})
public class MemberRegisterController {

	Logger log = LogManager.getLogger("case3");
	
	//처음에 session의 key 만들어주는 역할
	//위에서 명시한 배열 안의 문자열들 중 여기에 명시한 key값과 일치하는 문자열이 있는경우 value와 함께 실제로 key값이 Session객체 안에 생김 
	// -> value도 집어넣어 주지만 key값을 만들어주는 역할이라고도 할 수 있는 거지
	@ModelAttribute("memberInfo") //memberInfo가 key값
	public Member createMember() {
		
		log.debug("createMember()가 호출되었어요");
		
		Member member = new Member();
		
		return member;
	}
	// 데이터를 만들어 Model객체에 저장하면서 세션에 저장된 경우 세션에 해당 key에 대한 value 즉, 데이터가 있으면 이후에는 해당 컨트롤러의 handler가 호출되어도 
	//@ModelAttribute가 붙은 메소드(물론 이 메소드의 return값으로 저장하려는 데이터가 이미 Session에 있는 경우)는 호출 되지 않음
	
	@GetMapping(value = "memberRegisterStep1")
	public String handler1() {
		
		log.debug("회원가입 첫 페이지로 입장!");
		
		return "sample07/step1";
	}
	
	@PostMapping(value = "memberRegisterStep2")
	public String handler2(@ModelAttribute("memberInfo") Member member ) {
		
		log.debug("회원가입 두번째 페이지 입장!");
		log.debug(member);
		
		return "sample07/step2";
	}
	
	@PostMapping(value = "memberRegisterStep3")
	public String handler3(@ModelAttribute("memberInfo") Member member,SessionStatus SessionStatus ) {
		//SessionStatus status : session 안에 있던 member객체를 날리기 위해서 주입받음
		log.debug("회원가입 세번째 페이지 입장!");
		log.debug(member); //사용자의 모든 정보가 다 출력될 것!
		
		//만약 받아온 정보를 DB에 저장하는 과정이 여기에 있다면 이 과정 이후에는 해당 객체는 더이상 쓸모가 없음 -> 없애주는 게 맞음
		
		SessionStatus.setComplete(); //key값을 제거(당연히 쌍으로 묶여있던 value도 같이 날아갈 것)
		
		return "redirect:/memberRegisterStep1";
		//redirect:/url 이라고 쓰면 redirect 방식으로 동작함(redirect는 요청이 Get방식임)
		//redirection : 요청 자체를 다른 url로 다시 하게 만드는 것 -> url 주소창에 다시 요청받은 url로 주소가 바뀌는 게 보임
		//forwarding : 요청을 받는 놈이 또 다른 놈한테 요청을 이어받게끔 넘기는 것 -> url 주소창에 주소가 바뀌는 것은 보이지 않음
	}
}
