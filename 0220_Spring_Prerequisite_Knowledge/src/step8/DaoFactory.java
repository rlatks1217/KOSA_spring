package step8;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import step8.dao.ConnectionMaker;
import step8.dao.SimpleMakeConnection;
import step8.dao.UserDao;

//Application Context의 역할을 모델링해본 것임
@Configuration //특정 기능을 수행하는 이 어노테이션도 사실은 내부적으로 다 자바코드로 구현되어 있는 것임
public class DaoFactory {
	
	//객체로 만들어지는지 확인해보자
	public DaoFactory() {
		System.out.print("객체가 되었네? ");
		System.out.println("UserDao보다 이게 먼저 만들어짐");
	}
	
	@Bean
	public UserDao userDao() {
		
		UserDao dao = new UserDao(connectionMaker());
		
		return dao;
	}
	
	@Bean
	public ConnectionMaker connectionMaker() {
		return new SimpleMakeConnection();
	}
	
	//이 두 Bean이 Constructor injection에 사용됨
}
