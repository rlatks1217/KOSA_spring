package my.spring.springweb.sample06.dao;

import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

@Repository("lottoDao") //해당 Component에 이름을 지정할 수 있음
public class LottoDao {
	
	Logger log = LogManager.getLogger("case3");
	
	public LottoDao() {
		log.debug("Bean 생성!!!!!!!!!");
	}

	public int selectLottoNumber() {
		
		Random rand = new Random();
		
		return rand.nextInt(6)+1; //0~6사이의 난수를 알아서 하나 반환해줌(1 더해줬으니까 1~7 사이의 난수를 반환하겠지)
	}
	
}
