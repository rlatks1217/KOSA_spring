package step4;

import step3.dao.NUserDao;
import step3.vo.User;

public class UserDaoTest {

	public static void main(String[] args) throws Exception{
		
		//데이터 입력
		
		//입력할 data 전달할 VO 생성
		User user = new User();
		user.setId("aaa");
		user.setPassword("1111");
		user.setName("하하하");
		
		//DAO 작성
		NUserDao dao = new NUserDao();
		dao.insertUser(user); 
		
		User result = dao.selectUser("aaa");
		
		System.out.println("사용자 이름 : "+result.getName());
		
	}
}
