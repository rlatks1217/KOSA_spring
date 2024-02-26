package my.spring.springweb.sample08;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;

import my.spring.springweb.common.ApplicationContextProvider;

@Controller
public class RequestMappingProducesController {

//	@Autowired
//	private Gson gson;
	
	Logger log = LogManager.getLogger("case3");
	
	
	@RequestMapping(value="testProduces1")
	public String method01(Model model) {
		
		model.addAttribute("msg", "헤헤헤헤헿");
		
		return "sample08/requestMappingProducesView";
	}
	
	@RequestMapping(value="testProduces2", produces ="application/json; charset=utf-8")
	public String method02(Model model) {
		//이렇게 여기서 설정해줘도 JSP파일에서의 설정에 의해 이 설정이 무시되는 것을 확인할 수 있음
		//(JSP 파일에서의 설정(해당 파일의 코드를 뭘로 인식할지 최상단에(디렉티브 설정) 명시되어 있음)이 이 설정을 덮어쓰고 있는 것임)
		
		
		model.addAttribute("msg", "헤헤헤헤헿");
		
		return "sample08/requestMappingProducesView";
	}
	
	@RequestMapping(value="testProduces3", produces ="text/html; charset=UTF-8")
	public void method03(Model model, HttpServletResponse response) {
		//jsp 이용해서 처리하지 않을 것이기 때문에 return 타입 void로 잡음 -> 여기서 다이렉트로 클라이언트에 응답해줄 것!
		//Stream을 열기 위해 response객체를 주입 받음
		
		try {
			response.setContentType("text/html; charset=UTF-8"); //지금은 return을 통해 보내고 있는 것이 아니기 때문에 이렇게 설정해주는 것이 필요함
			PrintWriter out = response.getWriter();
			
			out.println("<html><head></head>");
			out.println("<body><h1>응아ㅏ아아아아아ㅏ아악!</h1></body></html>");
			out.close();
			//글자가 깨지는 것을 확인할 수 있음
			//지금은 return을 통해서가 아니라 결과를 직접 Stream을 열어서 보내고 있기 때문에 저 produces의 설정은 무시되는 거임
			//@ResponseBody를 사용하면서 return될 경우 Message Converter에 의해 produces으로 설정해준 contentType으로 변환이 되고 그 다음 adapter에게 전달이 됨
			//그래서 따로 stream에 대해 content Type 설정을 해줘야 함
			
			//이 경우에도 Stream을 통해 데이터를 보낼 때 Rendering까지 해서 클라이언트에 응답을 보내게 됨
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@RequestMapping(value="testProduces4", produces ="application/json; charset=UTF-8")
	public void method04(Model model, HttpServletResponse response) {
		
		try {
			response.setContentType("application/json; charset=UTF-8");
			PrintWriter out = response.getWriter();
			
			Map<String, String> map = new HashMap<String, String>();
			
			map.put("userName", "홍효원");
			map.put("userAge", "20");
			map.put("userAddr", "서울");
			
			//이 데이터를 json문자열로 변형해야 함
			//그리고 나서 Stream을 통해 클라이언트에게 보내주면 됨
//			Gson gson = new Gson();
			//Gson의 경우에도 stateless인 객체이기 때문에 singleton으로 사용하면 참 좋겠다! 
			//-> 어노테이션으로 Bean으로 등록하자!(자동은 안 됨! 외부 라이브러리는 수동으로 등록해야 함->LibraryController 참고!)
			//등록 후 gson을 받을 필드 선언 후 @Autowired를 통해 주입받게 구성하자
			//@Autowired를 통해 필드에 주입받아서 쓰는 것이 아니라 필요할 때마다 getBean과 같은 기능을 통해 가져다가 쓸 수는 없을까?
			//이게 가능하도록 interface를 제공해줌 -> application context를 사용할 수 있도록 해주는 기능을 가지고 있음
			//이 인터페이스가 ApplicationContextAware이라는 놈임 그래서 이 인터페이스를 구현한 구현체를 Bean으로 등록해야 함
			//이렇게 @Autowired를 사용하는 것과 이 인터페이스를 사용하는 것 2가지 방법으로 사용할 수 있는 것임
			ApplicationContext ctx = ApplicationContextProvider.getApplicationContext();
			Gson gson = ctx.getBean("gson", Gson.class);
			//casting해줘야 되니까 Gson.class를 인자로 넣어줌
			String jsonStr = gson.toJson(map);
			
			out.println(jsonStr);
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Bean을 수동으로 등록할 경우 얻는 이점
		//1. 외부 라이브러리를 Bean으로 등록해서 효율적으로 사용이 가능
		//2. program이 크기가 커지고 자주 기능이 변경되는 경우에는 인터페이스를 기반으로 구현 클래스를 수동으로 등록해서 전략 패턴을 이용하면 쉽게 대처할 수 있음
		//수동으로 등록하기 위해 사용하는 클래스가 인터페이스를 구현하게 만들어서 여기서 필드를 인터페이스 타입으로 잡은 후 주입 받게 하는 것이 좋다는 얘기(기능이 바뀌어도 여기 코드는 수정할 필요 없으니까)
		
	}
	//Client Side Rendering은 없음(클라이언트는 Rendering하지 않음)
	//Server Side Rendering이 이뤄지는 중(서버가 Rendering까지 해서 돌려줌)
	//Server Side Rendering 같은 경우 Render과정이 따로 추가되기 때문에 그냥 응답했을 때보다는 느려짐
	//ajax Call back 함수인 success 안에서 태그를 생성하는 경우에는 browser가 rendering을 하는 것임
	
}
