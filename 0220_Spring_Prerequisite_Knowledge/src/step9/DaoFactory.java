package step9;


import step9.dao.ConnectionMaker;
import step9.dao.SimpleMakeConnection;
import step9.dao.UserDao;

public class DaoFactory {
	
	public DaoFactory() {
		System.out.print("객체가 되었네? ");
		System.out.println("UserDao보다 이게 먼저 만들어짐");
	}
	
	public UserDao userDao() {
		
//		UserDao dao = new UserDao(connectionMaker());
		//위처럼 생성자를 통한 주입과 밑에처럼 setter를 통한 주입은 xml 설정에서 다르게 생겼음 
		UserDao dao = new UserDao();
		dao.setConnectionMaker(connectionMaker());
		
		
		return dao;
	}
	
	public ConnectionMaker connectionMaker() {
		return new SimpleMakeConnection();
	}
	
}
