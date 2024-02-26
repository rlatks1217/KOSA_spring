package step6.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import step6.vo.User;

//database 처리하는 코드를 작성
//2개의 method를 만들 것(사용자입력, 조회)
public class UserDao {
	
	ConnectionMaker ConnectionMaker; 
	
	public UserDao(ConnectionMaker ConnectionMaker) {
		this.ConnectionMaker = ConnectionMaker;
		//UserDaoTest에서 만든 객체를 주입(Injection)받은 형태가 됨(정확히는 객체의 주소값을 주입받는 형태라고 할 수 있음)
		
		//일반적으로 Injection(주입)은 2가지 형태임
		//1. 생성자를 통한 주입(일반적으로는 이것을 더 선호)
		//2. setter를 통한 주입
		//지금은 생성자를 통한 주입을 하고 있는 것임
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
