package step8;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import step8.dao.UserDao;
import step8.vo.User;

public class UserDaoTest {

	public static void main(String[] args) throws Exception{
		
		//데이터 입력
		
		//입력할 data 전달할 VO 생성
		User user = new User();
		user.setId("aaa");
		user.setPassword("1111");
		user.setName("하하하");
		
		
//		UserDao dao = new DaoFactory().userDao();
		//이렇게 직접 썼던 부분을 Application Context를 생성한 후 UserDao객체를 자동으로 생성해줬던 Application Context에게 UserDao객체를 요청해서 받은 다음 사용할 것
		ApplicationContext context = 
				new AnnotationConfigApplicationContext(DaoFactory.class); //Application Context 생성/ 설정정보를 가진 클래스를 인자로 넣어줌
		UserDao dao = context.getBean("userDao", UserDao.class); //Bean 요청 --> 인자로 Bean의 id를 넣어줌 --> id에 해당하는 Bean을 반환하게 됨
		//반환될 때 그 동안 request.getAttribute나 session.getAttribute 와 같이 Object 타입으로 반환됨
		//그래서 원래는 casting 해줘야 하는데 받아올 때마다 하는 것이 불편해! 그래서 id명 뒤에 casting될 클래스를 인자로 주는 방식으로 사용!
		//Bean 어노테이션이 붙어있는 메소드명이 id라고 했으니 메소드명으로 해당 Bean을 꺼내옴
		UserDao dao1 = context.getBean("userDao", UserDao.class); 
		
		System.out.println(dao);
		System.out.println(dao1);
		//객체를 새로 만들어주는 게 아니라 기존의 만들어져 있던 객체를 가져온다는 것을 알 수 있음(즉, 싱글톤 패턴으로 객체를 관리한다고 할 수 있는 것)
		//일반 클래스를 싱글톤으로 만들기 위해서는 특정 설정을 해줘야 하는데 Application Context가 그런 설정없이도 자동으로 Bean이라는 애로 등록하면 싱글톤으로 관리하게 되는 것
		//(물론 scope이 다른 설정일 때는 제외)
		//즉, 그 객체들을 담고 있기 때문에 Application Context는 Singleton의 저장소 역할도 한다고 할 수 있음
		
		//근데 왜 Bean을 Singleton으로 관리하는 것인가?
		//이 Spring은 서버쪽 어플리케이션을 작성하기 위해서 사용함 근데 이 서버라는 곳은 원래 여러 클라이언트가 공유해서 사용하는 것임
		//즉, 이 서버 안의 객체들은 여러 클라이언트에 의해서 사용되기 때문에 객체 하나만 만들어서 사용하는 것이 훨씬 효율적임!
		//ex) 게시판 프로젝트할 때 service객체를 메소드를 호출할 때마다 생성했던 것처럼 계속 만들게 되면 클라이언트가 
		//요청할 때마다 생성하는 꼴이 되고 그렇게 되면 혼자 테스트할 때는 괜찮아보여도 실제로 운영할 때는 과부하가 일어나서 동작이 느려지거나 제대로 동작하지 않을 수도 있음
		//그래서 객체 하나만 생성해서 메소드만 다르게 호출하는 효율적인 방식으로 사용하기 시작함 --> 이게 singleton인 것
		
		//그런데 VO처럼 계속 다른 상태값을 가지고 있어야 하는 객체는 Bean으로 등록해서 공유되게끔 사용할 수 없음!
		
		
		dao.insertUser(user); 
		
		User result = dao.selectUser("aaa");
		
		System.out.println("사용자 이름 : "+result.getName());
		
		((AnnotationConfigApplicationContext)context).close();
	}
}
