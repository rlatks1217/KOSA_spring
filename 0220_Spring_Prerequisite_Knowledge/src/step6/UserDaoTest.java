package step6;

import step6.dao.ConnectionMaker;
import step6.dao.SimpleMakeConnection;
import step6.dao.UserDao;
import step6.vo.User;

public class UserDaoTest {

	public static void main(String[] args) throws Exception{
		
		//데이터 입력
		
		//입력할 data 전달할 VO 생성
		User user = new User();
		user.setId("aaa");
		user.setPassword("1111");
		user.setName("하하하");
		
		ConnectionMaker connectionMaker = new SimpleMakeConnection();
		//Connection 객체를 반환할 메소드를 가지고 있는 객체 --> 이걸 주입해줄 것
		//연결 기능(정확히는 연결정보를 담고 있고 연결을 해주는 부분)을 interface를 통해 완전히 분리시켰다고 볼 수 있음
		//그리고 이렇게  특정 기능을 인터페이스로 분리시키는 디자인패턴을 Strategy 패턴이라고 함
		
		//--> 분리한 기능을 필요할 때마다 주입해서 사용하게 됨(정확히는 당연히 그 기능을 특정 객체가 가지고 있을 것이므로 그 객체를 주입해서 사용한다는 것이지)
		//여기서  SimpleMakeConnection같은 것 즉, 따로 떨어져 나간 부분을 전략(Strategy)이라고 할 수 있음
		//즉, 전략(Strategy)패턴은 누군가 해당 전략을 주입해주는 객체가 필요함
		//지금은 이 클래스에서 연결객체를 반환하는 메소드를 가진 객체를 만들어서 주입하고 있지만 이것은 제대로 된 관심사의 분리가 된 것이 아님(공통된 관심사를 가진 애들끼리 묶어서 분리해야 제대로 된 것) 
		//지금 이 클래스(UserDaoTest)는 온전히 테스트의 기능만을 수행해야 하니까 별도의 클래스(다른 관심사인 해당 전략을 만들어 주입해주는 역할을 하는 애)가 따로 필요함
		
		//DAO 작성
		UserDao dao = new UserDao(connectionMaker);
		dao.insertUser(user); 
		//저 쪽에서 throws로 예외처리를 이쪽으로 떠넘겼기 때문에 원래는 여기서 예외처리를 해줘야 함
		//하지만 지금은 테스트이므로 main method에다가 throws Exception을 적어서 JVM에게 넘기자 --> 예외처리 따로 하지 말자
		
		User result = dao.selectUser("aaa");
		
		System.out.println("사용자 이름 : "+result.getName());
		
	}
	
	//결국 하고 싶은 얘기 : 직접 내가 작성함으로써 지금은 연결하는 데에 사용되는 객체를 내가 결정해서 내가 만들고 있음
	//그런데 Spring에서는 이것을 Application Context가 알아서 하게 되니까 제어의 주체가 나에서 Application Context로 바뀌었다고 해서 제어의 역전(IOC)라고 한다 step 7으로...  
}
