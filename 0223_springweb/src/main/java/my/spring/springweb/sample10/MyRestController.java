package my.spring.springweb.sample10;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/rest/user")
public class MyRestController {
	
	Logger log = LogManager.getLogger("case3");
	
	@GetMapping
	public ResponseEntity<?> method01(String id, String name) {
		
		log.debug("Get 방식으로 호출되었어요!");
		log.debug(id + " " + name);
		
		return null;
	}
	
	@DeleteMapping
	public ResponseEntity<?> method02(String id, String name) {
		log.debug("Delete 방식으로 호출되었어요!");
		log.debug(id + " " + name);
		//데이터가 안 들어왔음을 알 수 있음 왜?
		//Put과 Delete도 RequestBody에 데이터가 담겨서 옴 -> 원래는 RequestBody의 내용을 Parsing 해줘야 함(POST의 경우에는 알아서 톰캣이 해줬음)
		//근데 Put과 Delete의 경우에는 Parsing이 이뤄지지 않아서 데이터가 제대로 들어오지 않는 거임 -> 톰캣 설정을 바꿔줘야 함
		//server.xml -> 63번째에 태그에 parseBodyMethods="POST, PUT, DELETE" 추가
		
		return null;
	}

}
