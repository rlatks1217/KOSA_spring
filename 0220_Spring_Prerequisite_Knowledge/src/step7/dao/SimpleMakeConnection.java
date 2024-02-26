package step7.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class SimpleMakeConnection implements ConnectionMaker{

	@Override
	public Connection getConnection() throws Exception {
		//순수 JDBC를 이용하여 database처리를 할 것
		//6단계
		//1. driver loading
		Class.forName("com.mysql.cj.jdbc.Driver");//com.mysql.cj.jdbc : package명 / Driver : 클래스명
		
		//2. 연결
		String jdbcUrl = "jdbc:mysql://127.0.0.1:3306/spring?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
		String id = "root";
		String pw = "test1234";
		
		Connection con = DriverManager.getConnection(jdbcUrl,id, pw); //인자 순서 : jdbc url, 사용자id, 사용자pw 순서 지켜줘야 함
		
		return con; 
	}
	
	
}
