package com.ts.dao;

import java.sql.*;

import com.ts.UploadPro;

public class UploadDAO {
	
	
	
	
	
	
	
	
	public void store(UploadPro p){
		
		Connection con=DAOUtility.getConn();
		
		String query="insert into uploadfile(name,r_image) values(?,?)";
		System.out.println("query:"+query);
		try {
			PreparedStatement pstmt=con.prepareStatement(query);
			pstmt.setString(1,p.getName());
			pstmt.setString(2,p.getImageName());
			if(pstmt.executeUpdate()>=1){
			int id=DAOUtility.getMaxId("uploadfile");
			p.setId(id);
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("**successfully executed"+con);
		
		
		
		
	}
	
	public boolean updateLogoAddress(int id, String fileName) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = DAOUtility.getConn();
			preparedStatement = connection.prepareStatement("update uploadfile set r_image =? where id = ?");
			preparedStatement.setString(1, fileName);
			preparedStatement.setLong(2,id);

			if (preparedStatement.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			//throw new UrbanspoonException(e.toString());
		} finally {
			//DAOUtility.close(preparedStatement, connection);

		}
		return false;
	}




}
