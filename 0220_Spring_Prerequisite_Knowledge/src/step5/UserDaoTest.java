package step5;

import step5.dao.UserDao;
import step5.vo.User;

public class UserDaoTest {

	public static void main(String[] args) throws Exception{
		
		//데이터 입력
		
		//입력할 data 전달할 VO 생성
		User user = new User();
		user.setId("aaa");
		user.setPassword("1111");
		user.setName("하하하");
		
		//DAO 작성
		UserDao dao = new UserDao();
		dao.insertUser(user); 
		//저 쪽에서 throws로 예외처리를 이쪽으로 떠넘겼기 때문에 원래는 여기서 예외처리를 해줘야 함
		//하지만 지금은 테스트이므로 main method에다가 throws Exception을 적어서 JVM에게 넘기자 --> 예외처리 따로 하지 말자
		
		User result = dao.selectUser("aaa");
		
		System.out.println("사용자 이름 : "+result.getName());
		
	}
}
