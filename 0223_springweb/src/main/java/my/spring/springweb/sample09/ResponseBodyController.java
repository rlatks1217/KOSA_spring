package my.spring.springweb.sample09;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import my.spring.springweb.sample09.vo.User;

@RestController
@RequestMapping(value="/body")
public class ResponseBodyController {

	@GetMapping(value="/text/{id}", produces="text/plain; charset=UTF-8")
	public String method01(@PathVariable String id) {
		
		
		return "<h1>제대로 문자열만 반환함 "+id+" </h1>";
	}
	//return되는 이 문자열이 결국 Message Converter에 의해서 content type에 따른 형식으로 변환됨
	
	
	//이렇게 반환하는 것이 정석임!
	@GetMapping(value="/textObject/{id}", produces="text/plain; charset=UTF-8")
	public ResponseEntity<String> method02(@PathVariable String id) {
		String msg = "<h1>제대로 문자열만 반환함 "+id+" </h1>";
		HttpHeaders headers = new HttpHeaders(); //headers 객체를 만듬
//		headers.setContentType(new MediaType("text", "html", Charset.forName("UTF-8"))); //Content Type 정해줌(당연히 여기서 정해준 설정이 produces의 설정을 덮어쓰게 됨)
											//text/plain      		//charset=UTF-8
		headers.setContentType(null); //덮어쓰는 설정 없애주니까 content type은 produces로 설정해준 게 적용이 될 것임
		return new ResponseEntity<String>(msg, headers, HttpStatus.CREATED); //new ResponseEntity(보낼 데이터, headers객체, 상태코드)
		//generic 잡아줘야 노란색(Warning)안 뜸				//HttpStatus.OK : 상태코드 200을 의미함
														//HttpStatus.CREATED : 서버에서 새로운 데이터가 생성되었다는 뜻의 상태코드인 201을 의미함 
	}
	
	@GetMapping(value="/json/{name}", produces="application/json; charset=UTF-8")
//	@ResponseBody
	public User method03(@PathVariable String name) {
		
		User user = new User(name, "서울");

		return user;
	}
	//message Converter에 의해서 return되는 vo를 produces에 정해준 content type을 보고 알아서 데이터를 변환해줌
	//근데 지금 handler마다 @ResponseBody가 붙어있는 것을 알 수 있음(똑같은 코드가 계속 중복되는 거임 -> 한번에 처리할 수 없나? @RestController로 써서 한번에 해결!)
	
	
}
