package com.ts.us.utility;

import java.sql.*;
import com.ts.us.exception.UrbanSpoonException;

public class DAOUtility {
	private static final String INVALID_ARGUMENT_EXCEPTION = "Invalid Argument to close() method of class DAOUtility !!!";
	private static final String URL = "jdbc:mysql://localhost:3306/";
	private static final String DATABASE_NAME = "urbanspoon";
	private static final String USER_NAME = "root";
	private static final String PASSWORD = "root";
	private static final String DRIVER_NAME = "com.mysql.jdbc.Driver";

	public static Connection getConn() throws UrbanSpoonException {
		Connection connection = null;
		try {
			Class.forName(DRIVER_NAME);
			connection = DriverManager.getConnection(URL + DATABASE_NAME, USER_NAME, PASSWORD);
		} catch (ClassNotFoundException e) {
			throw new UrbanSpoonException(e.toString());
		} catch (SQLException e) {
			throw new UrbanSpoonException(e.toString());
		}
		return connection;
	}

	public static void close(Object... objects) throws UrbanSpoonException {
		if (null != objects && objects.length != 0) {
			try {
				for (Object object : objects) {
					if (null != object) {
						if (object instanceof Connection) {
							((Connection) object).close();
						} else if (object instanceof Statement) {
							((Statement) object).close();
						} else if (object instanceof PreparedStatement) {
							((PreparedStatement) object).close();
						} else if (object instanceof CallableStatement) {
							((CallableStatement) object).close();
						} else if (object instanceof ResultSet) {
							((ResultSet) object).close();
						} else {
							throw new UrbanSpoonException(INVALID_ARGUMENT_EXCEPTION);
						}
					}
				}
			} catch (SQLException e) {
				throw new UrbanSpoonException(e.toString());
			}
		}
	}

}
