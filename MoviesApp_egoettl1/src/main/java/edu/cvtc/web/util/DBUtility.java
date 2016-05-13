/**
 * 
 */
package edu.cvtc.web.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Eric Goettl
 *
 */
public class DBUtility {

	public static final int TIMEOUT = 30;
	private static final String CONNECTION = "jdbc:sqlite:movie.db";
	private static final String DRIVER_NAME = "org.sqlite.JDBC";
	
	public static Connection createDbConnection() throws ClassNotFoundException, SQLException {
		Class.forName(DRIVER_NAME);
		return DriverManager.getConnection(CONNECTION);
	}
	
	public static void closeDbConnection(final Connection connection, final Statement statement) {
		try {
			if(null != connection) {
				connection.close();
			}
			if(null != statement) {
				statement.close();
			}
		} catch(final SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}
