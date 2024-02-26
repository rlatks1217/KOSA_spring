package my.spring.springweb.sample02;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JSTLExampleController {

	@RequestMapping(value="/jstlExample") //method호출방식을 명시하지 않으면 기본적으로는 GET방식임(Form 태그에서도 마찬가지)
	public String myMethod(Model model) {
		
		List<String> list = new ArrayList<>();
		
		list.add("홍길동");
		list.add("헤헿");
		list.add("호잇");
		
		model.addAttribute("myNum", 100);
		model.addAttribute("myList", list);
		
		return "sample02/jstlExample";
	}
	//return되는 값이 없으면 dispatcherServlet이 RequestMapping에 적혀있는 url이름으로 문자열을 return받은 것처럼 url이름으로 view Resolver에게 파일을 찾게 됨 
	
	
}
