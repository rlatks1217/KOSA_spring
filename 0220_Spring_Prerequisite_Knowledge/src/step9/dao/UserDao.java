package step9.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import step9.vo.User;

//database 처리하는 코드를 작성
//2개의 method를 만들 것(사용자입력, 조회)
public class UserDao {
	
	ConnectionMaker connectionMaker; 
	
	public UserDao() {
		//사용하지 않아도 Default 생성자는 무조건 명시해주자
		System.out.println("기본 생성자 호출!");
	}
	
	public UserDao(ConnectionMaker connectionMaker) {
		this.connectionMaker = connectionMaker;
		System.out.println("UserDao도 객체로 만들어지나?");
	}
	
	//setter 통한 Injection을 해보자!
	public void setConnectionMaker(ConnectionMaker connectionMaker) {
		this.connectionMaker = connectionMaker;
		System.out.println("setter호출!");
	}
	
	public void insertUser(User user) throws Exception {
		
		Connection con = connectionMaker.getConnection();

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
		
		Connection con = connectionMaker.getConnection();
		
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
