package my.spring.springweb.sample06;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import my.spring.springweb.sample06.service.LottoService;
import my.spring.springweb.sample06.vo.Lotto;

@Controller
public class LottoController {
	
	Logger log = LogManager.getLogger("case3");
	
	@Autowired
	LottoService service;
	//@Service를 통해 Bean으로 만든 서비스 instance를 @Autowired를 통해 여기 주입
	
	@GetMapping("lotto")
	//쿼리스트링 형태로 들어온 데이터는 @PathVariable로 받아서 사용할 수 없음(다른 형태니까)
	public String lottoProcess(Lotto lotto, @PathVariable("g")String g) { //@ModelAttribute 생략
		//필드와 넘어오는 데이터의 key값이 같아야 함
		
		//service 객체 생성
//		service = new LottoService(); //이렇게 써주면 주입받은 객체 말고 새로운 Service객체를 만들어 사용하게 되는 것임, 당연히 얘한테는 Dao가 주입되지 않으니까 쓸 수 없지
		//이런 식으로 클라이언트가 이 과정을 할 때마다 객체(instance)를 생성하게 구현할 경우 낭비야...
		//service는 비스니스로직만 처리하는 객체이기 때문에 statless(따로 데이터를 저장하지 않음)

		//주입 받은 객체를 사용하자
		boolean result = service.checkLottoNumber(lotto);
		
		if (result) {
			lotto.setLottoResult("그라췌~~~~!");
		}else {
			lotto.setLottoResult("꽝이다 이자싀가~~");
		}
		
		return "sample06/lottoView";
	}
}
