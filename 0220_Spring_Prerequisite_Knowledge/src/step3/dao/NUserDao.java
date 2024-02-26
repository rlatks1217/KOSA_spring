package step3.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class NUserDao extends UserDao{

	@Override
	protected Connection getConnection() throws Exception {
		//이렇게 내 클래스를 구매한 회사가 내가 만든 UserDao클래스의 내용 중에 변경될 여지가 있는 부분을 재정의해서 사용할 수 있게 됨
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//2. 연결
		String jdbcUrl = "jdbc:mysql://127.0.0.1:3306/spring?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
		String id = "root";
		String pw = "test1234";
		
		Connection con = DriverManager.getConnection(jdbcUrl,id, pw);
		
		return con; 
	}
	//상속관계에 있어서 주요 로직처리 기능은 UserDao에 있지만 기능의 일부분 즉, DB에 연결하는 기능은 여기에 있는 상태임
	//이렇게 주요 기능은 상위 클래스가 가지고 있고 일부 기능만 그 클래스를 상속하는 클래스가 가지고 있는 디자인 패턴을 template method 패턴이라고 함
	//상위 클래스가 가지고 있는 전체 로직처리의 흐름 중 일부분만 하위 클래스가 가지고 있는 패턴이라고 할 수 있음(연결 - 사용자insert - 조회 중 (연결)부분만 이 하위 클래스가 가지고 있는 상태니까)
	
	
	//객체가 만들어지는 관점에서 보자!
	//getConnection()은 결국 객체를 만드는 기능이라고 할 수 있음
	//상위 클래스에서는 객체를 직접 만들지 않음(추상 메소드만 있으니까)/하위 클래스에서 오버라이딩된 메소드로 만들고 있음
	//이렇게 상위 클래스에서는 이런 객체가 있어요 정도로 명시만 하고 구체적인 객체 생성 방법은 하위클래스에서 결정(정의)하는 디자인 패턴을 Factory Method 패턴이라고 함 
	
	//즉, 지금 작성한 코드는 template method 패턴이기도 하지만 Factory Method 패턴이라고도 할 수 있는 것이다.
	
	
	//하지만 여전히 문제는 남아 있음
	//1. Java는 Single Inheritance 즉, 단일 상속만을 지원한다는 것이 문제가 될 수 있음
	//그래서 이렇게 상속을 통해 확장할 경우 다른 클래스를 상속받아야 하는 상황이 되면 그 다른 클래스는 상속받을 수 없게 됨
	
	//2. 상속은 tightly coupled되는 것이 문제가 '될 수도' 있음(일단 이것 때문이더라도 상속으로는 안 되는 것임)
	//즉, 상위클래스와 하위클래스가 강하게 결합되어 있기 때문에 재사용하는 것에 문제가 발생할 수 있음
	//(한 클래스의 변화가 다른 클래스에 영향을 많이 미친다 => 강하게 결합되어 있다고 함)
	
	
	//그러면 상속을 안 쓰고서 확장성을 어떻게 가미시키느냐??
	//연결 역할을 하는 부분만 따로 클래스로 분리시켜보자! step4로..
}
