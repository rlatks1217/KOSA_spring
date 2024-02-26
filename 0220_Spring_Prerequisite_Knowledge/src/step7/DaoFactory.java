package step7;

import step7.dao.ConnectionMaker;
import step7.dao.SimpleMakeConnection;
import step7.dao.UserDao;

//Application Context의 역할을 모델링해본 것임
public class DaoFactory {
	//Factory의 역할 : 객체를 생성하는 방법을 결정하고 그렇게 만들어진 오브젝트는 반환하는 역할을 담당하는 Object(객체)
	//여기서 말하는 Factory는 앞서 언급되었던 Method Factory 패턴하고는 다름
	//객체 간의 연결을 해주는 기능(정확히는 한 객체를 다른 객체 안으로 주입해주는 기능)을 수행하는 역할을 함 
	//=> 특정 로직을 처리하는 애가 아님(Business logic이 없음)
	
	public UserDao userDao() {
		
//		UserDao dao = new UserDao(new SimpleMakeConnection());
		//위의 코드같은 경우 여러 DAO가 생겨날 경우 new + 생성자호출() 이라는 부분이 중복되므로 관심사의 분리를 해줘야 함
		//그래서 밑의 코드처럼 하나의 메소드로 만들어서 관심사의 분리를 해준 코드로 작성한 것임
		UserDao dao = new UserDao(ConnectionMaker());
		
		return dao;
	}
	
	public ConnectionMaker ConnectionMaker() {
		return new SimpleMakeConnection();
	}
}
