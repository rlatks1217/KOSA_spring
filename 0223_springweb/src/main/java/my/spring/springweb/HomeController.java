package my.spring.springweb;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
//	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	//sysout 대신 사용할 용도(그냥 sysout 쓰면 안 되나요? 쓰면 안 되는 이유는 퍼포먼스에 문제를 일으킬 수 있음/또한 logger를 사용하는 게 특정시점의 로직 수행에 대한 확인을 하기에 용이함
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	//전에 일일이 서블릿 클래스를 하나씩 만들어서 처리했던 request를 어노테이션을 통해 한 클래스(일반 클래스)의 메소드 단위로 request를 받을 수 있게 됨
	//하나의 DispatcherServlet이 모든 요청을 받기 때문에 이런 디자인 패턴을 Front Controller Pattern이라고 함
	//httpServlet을 상속하지 않기 때문에 다른 클래스를 상속할 수 있게 되었으므로 확장성이 증대되었다고 할 수 있음
	//handler는 요청을 결국 넘겨받게 되는 컨트롤러 클래스 자체를 말하기도 하고 그 컨트롤러 클래스 안에 RequestMapping이 붙은 method를 지칭하기도 함
	
	//value : 식별자(url) / method : method 호출 방식
	//value = "/"이기 때문에 url에 프로젝트명/ 까지만 쓰면 이 메소드가 호출 될 것
	public String home(Locale locale, Model model) {//Locale도 자동 주입되는 객체이긴 한데 중요하지 않음
//		logger.debug("dasdasdasda");
		//handler인 method는 Model 객체를 파라미터로 받을 수 있음
		//Model타입의 객체는 handler의 파라미터로 주입될 수 있음(항상 되는 것이 아님!)
		//주입을 해주는 주체는 Application Context임(매개변수로 써줄 때마다 만들어서 주입을 해주는 것임(당연히 그래서 싱글톤이 아닌 거지!))
		//Model객체는 하는 역할이 request와 비슷함 scope(생명주기) 또한 request와 같음
		//이 객체에 처리된 결과를 담으면 jsp에서 그 결과를 Model객체 안에서 가져다가 쓸 수 있음
		//(el문법을 쓰면 request scope인 객체에 접근할 수 있음 그래서 ${}을 사용해야 하는 것임 -- 자세한 건 내일)
//		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		model.addAttribute("kk", "ㅎㅇㅎㅇㅎㅇ" );
		
		return "home";
	}
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String home2(Locale locale, Model model, HttpServletRequest request) {
		//필요하다면 request객체도 주입 받을 수 있음 이 역시 매개변수를 써주기만 하면 알아서 Application Context가 주입해줌
		//--> 매개변수로만 써주면  Application Context가 알아서 만들어서 주입해준다는 것을 알 수 있음
		//method 이름으로 호출하는 것이 아니기 때문에 method 이름은 어떻게 지어도 상관없음
//		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
}
