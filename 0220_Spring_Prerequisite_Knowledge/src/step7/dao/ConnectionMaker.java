package step7.dao;

import java.sql.Connection;

public interface ConnectionMaker {

	public Connection getConnection() throws Exception;
	
}
