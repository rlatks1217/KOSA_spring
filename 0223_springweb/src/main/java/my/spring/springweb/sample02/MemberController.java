package my.spring.springweb.sample02;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import my.spring.springweb.sample02.vo.Member2;

@Controller
public class MemberController {
	
//	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@PostMapping(value="member1")
	public ModelAndView myMethod1(@RequestParam(value="name", defaultValue="없음")String name, String phone, String id, String pw, Model model) {
		//defaultValue="없음" 만약에 데이터가 넘어오지 않았을 경우에 값을 대체할 default value를 설정할 수 있음
		//@RequestParam(value="name", defaultValue="없음") 이 어노테이션이 실제로 데이터를 받아서 매개변수에 매핑해주는 것임
		//@RequestParam라는 어노테이션이 없으면 defaulteValue를 설정해줄 수 없음
		//당연히 default value는 data Type에 맞게 설정을 해줘야 함(int -> 0 / String -> null이나 지금처럼 "없음" 이런 거로 설정)
		
//		logger.debug(name);
		ModelAndView mav = new ModelAndView();
//		mav.addObject("name", name);
//		mav.addObject("id", id);
//		mav.addObject("phone", phone);
//		mav.addObject("password", pw);
		//addObject를 사용할 경우 model이 아니라 request객체에 데이터가 들어가게 됨
		
		//Model에 데이터 집어넣음
		model.addAttribute("name", name);
		model.addAttribute("id", id);
		model.addAttribute("phone", phone);
		model.addAttribute("password", pw);
		
		mav.setViewName("sample02/memberView");
		
		return mav;
	}
	//setViewName으로 파일명만 mav에 넣어주고 mav를 dispatcher Servlet이 받으면 받은 이 객체를 가지고 
	//view Resolver에게 해당 파일을 찾아달라고 한 다음 기존에 알고 있는 과정으로 처리함
	//(단, setView나 mav에 View 객체를 만들어서 넣어줄 경우에는 view Resolver를 거치지 않음)
	
	//왜 굳이 이렇게 하냐?? 이렇게 하는 방법도 있다 이거야
	
	@PostMapping(value="member2")
	public ModelAndView myMethod2(Member2 vo, Model model) { 
		//이렇게 vo타입으로 매개변수를 써주면 자동으로 vo 안의 필드와 보낸 데이터의 key값이 같으면 자동으로 vo객체를 하나 만들어서 그 안의 필드에 해당 데이터들을 다 넣어주고 그 vo를 여기에 주입까지 해줌 
		//Member2 vo처럼 매개변수로 객체 타입을 썼을 때는 @ModelAttribute가 생략되어 있는 것이라고 스프링이 알아서 판단함
		//primitive type의 경우 @RequsetParam이 생략되어 있다고 스프링이 알아서 판단함
		
//		logger.debug(vo.toString()); //당연히 오버라이딩된 toString이 호출될 것
		//정말로 클라이언트가 보내준 데이터가 만들어진 vo에 들어가는지 확인 --> 진짜 들어옴
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("memberVO", vo);
		
		mav.setViewName("sample02/memberView");
		
		return mav;
	}
	
	@PostMapping(value="member3")
//	public String myMethod3(@ModelAttribute Member2 vo) { //@ModelAttribute 없어도 되긴 함
	public String myMethod3(@ModelAttribute(value="mem") Member2 vo) { //@ModelAttribute 없어도 되긴 함
		//즉, 매개변수를 객체로 쓰게 되면 그 객체가 Model의 Attribute가 됨
		//이 때 아무런 설정이 없으면  model에 저장되는 데이터의 key값은 member2(앞 글자만 소문자)로 정해짐
		//value를 써서 해당 객체가 저장될 key값을 따로 설정해줄 수도 있음(RequestParam의 value와는 다른 역할임
		
//		logger.debug(vo.toString()); //당연히 오버라이딩된 toString이 호출될 것
		
		return "sample02/memberView";
	}
	
	@PostMapping(value="member4")
	public String myMethod4(Member2 vo, @RequestParam String address, Model model) {
		//@RequestParam 뒤에 (value="key값")만 생략하는 것도 가능함(매개변수와 넘어오는 key값이 같으면 매핑시켜주는 것은 똑같음) 
		//--> 하지만 @RequestParam을 통째로 생략해도 똑같이 동작하므로 그냥 다 생략하자
		
		//vo의 필드보다 많은 데이터가 넘어올 경우에는 key값이 필드에 해당하지 않는 나머지 데이터는 따로 RequestParam을 받으면 됨
		
//		logger.debug(vo.toString()); //당연히 오버라이딩된 toString이 호출될 것
		
		model.addAttribute("address", address);
		
		return "sample02/memberView";
	}

}
