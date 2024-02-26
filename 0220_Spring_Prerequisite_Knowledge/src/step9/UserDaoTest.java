package step9;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import step9.dao.UserDao;
import step9.vo.User;

public class UserDaoTest {

	public static void main(String[] args) throws Exception{
		
		//데이터 입력
		
		//입력할 data 전달할 VO 생성
		User user = new User();
		user.setId("aaa");
		user.setPassword("1111");
		user.setName("하하하");
		
		
//		UserDao dao = new DaoFactory().userDao();
		//이렇게 직접 썼던 부분을 Application Context를 생성한 후 Application Context에게 UserDao객체를 요청해서 받은 다음 사용할 것
		ApplicationContext context = 
				new AnnotationConfigApplicationContext(DaoFactory.class); //Application Context 생성/ 설정정보를 가진 클래스를 인자로 넣어줌
		UserDao dao = context.getBean("userDao", UserDao.class); //Bean 요청 --> 인자로 Bean의 id를 넣어줌 --> 해당 id에 해당하는 Bean을 반환하게 됨
		UserDao dao1 = context.getBean("userDao", UserDao.class); 
		
		System.out.println(dao);
		System.out.println(dao1);
		//같은 객체를 꺼내옴
		
		dao.insertUser(user); 
		
		User result = dao.selectUser("aaa");
		
		System.out.println("사용자 이름 : "+result.getName());
		
		((AnnotationConfigApplicationContext)context).close();
		
	}
}
