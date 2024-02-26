package step5.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import step5.vo.User;

//database 처리하는 코드를 작성
//2개의 method를 만들 것(사용자입력, 조회)
public class UserDao {
	
	ConnectionMaker ConnectionMaker; 
	//클래스명에 대한 tightly coupled 문제는 해결!(앞서 나왔던 tightly coupled 문제들은 모두 다 다른 케이스임 그냥 tightly coupled로 인한 문제들이라 그렇게 부르는 것임)
	//생성자 안에 있는 new SimpleMakeConnection();에서 볼 수 있 듯 여전히 연결 기능을 가진 클래스는 해당 이름으로 만들어야 한다는 문제는 남아 있음
	//즉, 아직 tightly coupled 문제가 남아 있음(무조건 저 이름으로 만들어야 하니까 강하게 결합되어 있다고 볼 수 있는 것임)
	
	
	public UserDao() {
		this.ConnectionMaker = new SimpleMakeConnection();
		//그래서 사람들이 생각한 것이 이 객체를 만드는 부분도 따로 분리해보자! 라는 생각을 하기 시작함
		//여기서 객체를 생성하던 부분을 다른 곳으로 분리시켜서 주입받은 방식으로 바꿔보자 step6로.. 
	}
	
	public void insertUser(User user) throws Exception {
		
		Connection con = ConnectionMaker.getConnection();
		
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
		
		Connection con = ConnectionMaker.getConnection();
		
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
