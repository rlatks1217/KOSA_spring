package step7;

import step7.dao.UserDao;
import step7.vo.User;

public class UserDaoTest {

	public static void main(String[] args) throws Exception{
		
		//데이터 입력
		
		//입력할 data 전달할 VO 생성
		User user = new User();
		user.setId("aaa");
		user.setPassword("1111");
		user.setName("하하하");
		
//		ConnectionMaker connectionMaker = new SimpleMakeConnection();
//		UserDao dao = new UserDao(connectionMaker);
		//위의 2가지 기능을 DaoFactory가 할 것임
		
//		UserDao dao = (new DaoFactory()).userDao(); //우선순위가 new DaoFactory()가 높음 그래서 괄호 빼도 됨
		UserDao dao = new DaoFactory().userDao();
		UserDao dao1 = new DaoFactory().userDao();
		//이렇게 코드를 작성하면 새로운 객체를 2개 만들게 되는 것임
		
		dao.insertUser(user); 
		
		User result = dao.selectUser("aaa");
		
		System.out.println("사용자 이름 : "+result.getName());
		
	}
}
