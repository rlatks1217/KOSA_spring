package my.spring.springweb.sample06.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import my.spring.springweb.sample06.dao.LottoDao;
import my.spring.springweb.sample06.vo.Lotto;

@Service
public class LottoService {
	
	
	Logger log = LogManager.getLogger("case3");
	
//	 @Resource(name = "lottoDao") //import가 안 될 경우 dependency 설정에 문제가 있거나 Java 버전이 1.8이상이 아닌 것이다.
	
	@Autowired
	@Qualifier(value="lottoDao")
	private LottoDao dao;

	public LottoService() {
		// TODO Auto-generated constructor stub
	}
	
	public boolean checkLottoNumber(Lotto lotto) {
		// 일반적인 로직처리를 진행
		// DB처리를 함 - DAO가 필요 - bean으로 등록 후 주입
		boolean result = false;	// 당첨여부
		int randomNumber = dao.selectLottoNumber();	// dao를 이용해서 당첨번호 알아오기
		
		log.debug("내가 선택한 로또번호: " + lotto.getLottoNum());
		log.debug("로또 당첨번호 : " + randomNumber);
		
		if(randomNumber == lotto.getLottoNum()) {
			result = true;
		}
		
		return result;
	}
}

