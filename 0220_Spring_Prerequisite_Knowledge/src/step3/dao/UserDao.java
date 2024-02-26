package step3.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import step3.vo.User;

//database 처리하는 코드를 작성
//2개의 method를 만들 것(사용자입력, 조회)
public abstract class UserDao {
	
	protected abstract Connection getConnection() throws Exception; 
	//상속을 통해 확장성 있는 코드로 만들 것이기 때문에 패키지가 달라도 상속관계에 있을 경우 해당 메소드를 사용할 수 있도록 하기 위해 접근제어자를 protected로 잡는다
	
	public void insertUser(User user) throws Exception {
		
		Connection con = getConnection();
		
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
		
		//중복되는 기능 메소드를 호출하는 방식으로 바꿈
		Connection con = getConnection();
		
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
