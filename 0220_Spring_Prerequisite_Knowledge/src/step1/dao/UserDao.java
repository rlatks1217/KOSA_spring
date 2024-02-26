package step1.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import step1.vo.User;

//database 처리하는 코드를 작성
//2개의 method를 만들 것(사용자입력, 조회)
public class UserDao {
	
	public void insertUser(User user) throws Exception {
		
		//순수 JDBC를 이용하여 database처리를 할 것
		//6단계
		//1. driver loading
		Class.forName("com.mysql.cj.jdbc.Driver");//com.mysql.cj.jdbc : package명 / Driver : 클래스명
		
		//2. 연결
		String jdbcUrl = "jdbc:mysql://127.0.0.1:3306/spring?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
		String id = "root";
		String pw = "test1234";
		
		Connection con = DriverManager.getConnection(jdbcUrl,id, pw); //인자 순서 : jdbc url, 사용자id, 사용자pw 순서 지켜줘야 함
		
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
		
		//1. driver loading
		Class.forName("com.mysql.cj.jdbc.Driver");//com.mysql.cj.jdbc : package명 / Driver : 클래스명
		
		//2. 연결
		String jdbcUrl = "jdbc:mysql://127.0.0.1:3306/spring?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
		String id = "root";
		String pw = "test1234";
		
		Connection con = DriverManager.getConnection(jdbcUrl, id, pw);
		
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
