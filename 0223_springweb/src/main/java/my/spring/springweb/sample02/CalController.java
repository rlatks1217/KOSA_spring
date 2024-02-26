package my.spring.springweb.sample02;

import javax.servlet.http.HttpServletRequest;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import my.spring.springweb.HomeController;

@Controller
@RequestMapping("/calc.do")
public class CalController {

//	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@PostMapping
	public ModelAndView process(HttpServletRequest request,@RequestParam("firstNum") int num1, int secondNum, String operator, Model model) {
		//사용자가 보내준 데이터를 받아야 함 
		//->HttpServletRequest request을 써서 요청에 대한 정보로 만들어진 request객체(물론 Application Context가 만듬)를 주입받아서 처리할 수도 있음
		//하지만 spring에서는 더 편한 방법이 있음
		//@RequestParam("보내준 데이터의 key값")을 써주면 파라미터로 데이터가 들어옴(primitive type or String인 경우 이렇게 받는다)
		//이렇게 받으면 알아서 형변환 까지 해줌
		//심지어 들어오는 데이터의 key값과 매개변수의 이름이 같으면 @RequestParam("firstNum")이라는 어노테이션 자체를 생략해줄 수도 있음(secondNum처럼)
		//하지만 생략하는 것이 권장은 아님 왜? 넘어오는 인자가 VO인 경우가 있음 이럴 때 vo를 받아줄 매개변수 앞에 생략되어 있는 것이 @RequestParam("key값")이 아니므로 잘못 작동할 수가 있음
		
		ModelAndView mav = new ModelAndView();
		String viewName = "";
		
		if(operator.equals("div") && secondNum == 0 ) { //분모가 0일 경우
			viewName= "sample02/errorResult"; //java script 같은 경우에는 무한대 개념이 있어서 오류는 안 남 but 자바는 오류을 뱉음
			mav.addObject("msg", "나눗셈은 0으로 나눌 수 없어요");
		}else { 
			int result = 0;
			if(operator.equals("plus")) {
				result = num1 + secondNum;
			}else if (operator.equals("minus")) {
				result = num1 - secondNum;
			}else if (operator.equals("mul")) {
				result = num1 * secondNum;
			}
			viewName= "sample02/calcResult"; //java script 같은 경우에는 무한대 개념이 있어서 오류는 안 남 but 자바는 오류을 뱉음
			mav.addObject("msg", result);
		}
		
		mav.setViewName(viewName); //view도 넣어줌
		
		return mav;
	}
}
