package com.ts.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAOUtility {
	private static String DRIVER_CLASS_NAME="com.mysql.jdbc.Driver";
	private static String URL="jdbc:mysql://localhost:3306/urbanspoon";
	private static String USERNAME="root";
	private static String PASSWORD="root";
	private static Connection con;
	
	static{
		try {
			Class.forName(DRIVER_CLASS_NAME);
			con=DriverManager.getConnection(URL, USERNAME, PASSWORD);		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
public static Connection getConn(){
	return con;
}

public static int getMaxId(String tableName){
	int id=0;
	Statement stmt;
	try {
		stmt = con.createStatement();
		ResultSet rs=stmt.executeQuery("select max(id) from "+tableName);
		if(rs.next()){
			id=rs.getInt(1);
		}else{
			System.out.println("no id is there in table:"+tableName);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	return id;
	
}
}
