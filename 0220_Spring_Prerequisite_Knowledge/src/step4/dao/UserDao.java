package step4.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import step4.vo.User;

//database 처리하는 코드를 작성
//2개의 method를 만들 것(사용자입력, 조회)
public class UserDao {
	
	SimpleMakeConnection simpleMakeConnection; 
	//이렇게 하게 되면 단일상속의 문제는 해결!
	//but 이렇게 하더라도 결국에는 반드시 SimpleMakeConnection라는 이름의 클래스와 getConnection()이라는 이름의 메소드는 반드시 만들어야 하는 문제가 발생함
	//즉, 배포할 때는 .class 파일로 배포가 될 텐데 이 상태는 코드를 수정할 수 없는 상태임 근데 여기에 작성된 것처럼 SimpleMakeConnection라는 클래스의 이름과 밑에 getConnection()라는 이름 강제되어 버리는 것임
	//(또한 UserDao클래스가 SimpleMakeConnection클래스에 의존하고 있다고도 볼 수 있음)
	
	//이것을 해결하기 위해 인터페이스를 사용해보자! step5로..
	
	public UserDao() {
		this.simpleMakeConnection = new SimpleMakeConnection();
	}
	
	public void insertUser(User user) throws Exception {
		
		//연결되는 기능만 가진 클래스에서 해당 메소드로 연결 객체를 땡겨옴(기능을 메소드 단위로 분리(일반 메소드 / 추상메소드 + 오버라이딩)한 게 아니라 클래스 단위로 분리한 것임!)
		Connection con = simpleMakeConnection.getConnection();
		//getConnection()이라는 메소드가 interface에 소속된 메소드가 아니라면 이 메소드명을 사용해야 한다고 일일이 사용자에게 알려줘야 하지만
		//interface에 소속된 메소드라면 implements 구문을 사용했을 때 어떤 메소드를 정의하라고 바로 뜨기 때문에 굳이 알려주지 않아도 됨
		
		//3. PreparedStatement를 만들자
		String sql = "INSERT INTO users VALUES (?, ?, ?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		pstmt.setString(1, user.getId());
		pstmt.setString(2, user.getPassword());
		pstmt.setString(3, user.getName());
		
		//4. sql 구문 실행
		int result = pstmt.executeUpdate();
		
		//5. 결과 처리
		if (result == 1) {
			System.out.println("정상 입력됨");
		}else {
			System.out.println("뭔가 이상");
		}
		
		//6.다 썼으니 resource 해제
		pstmt.close();
		con.close();
		
	}
	
	public User selectUser(String userId) throws Exception {
		
		Connection con = simpleMakeConnection.getConnection();
		
		//3. PreparedStatement를 만들자
		String sql = "SELECT * FROM users WHERE id = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		pstmt.setString(1, userId);
		
		//4. sql 구문 실행
		ResultSet rs = pstmt.executeQuery();
		
		//5. 결과 처리
		rs.next();
		User user = new User();
		user.setId(rs.getString("id"));
		user.setPassword(rs.getString("password"));
		user.setName(rs.getString("name"));
		
		//6.다 썼으니 resource 해제
		pstmt.close();
		con.close();
		
		return user;
	}
}
