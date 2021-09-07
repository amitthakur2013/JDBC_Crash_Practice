package com.student.manage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.Statement;

public class StudentDao {

	public static boolean insertStudent(Student st) {
		
		boolean f=false;
		try {
			Connection con=CP.createC();
			String q="Insert into students(sname,sphone,scity) values(?,?,?)";
			PreparedStatement pstmt=con.prepareStatement(q);
			
			//set the values
			pstmt.setString(1, st.getStudentName());
			pstmt.setString(2, st.getStudentPhone());
			pstmt.setString(3, st.getStudentCity());
			
			//execute
			pstmt.executeUpdate();
			f=true;
			
			con.close();
					
			
		} catch (Exception e) {
			e.printStackTrace();
		
		}
		return f;
	}
	
	public static boolean deleteStudent(int sid) {
		boolean f=false;
		try {
			Connection con=CP.createC();
			String q="Delete from students where sid=?";
			PreparedStatement pstmt=con.prepareStatement(q);
			
			pstmt.setInt(1, sid);
			
			pstmt.executeUpdate();
			f=true;
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return f;
		
	}
	
	public static void showAll() {
		
		try {
			Connection con=CP.createC();
			String q="select * from students";
			Statement stmt=con.createStatement();
			
			ResultSet set= stmt.executeQuery(q);
			
			while(set.next()) {
				int id=set.getInt(1);
				String name=set.getString(2);
				String phone = set.getString(3);
				String city = set.getString(4);
				
				System.out.println("ID: "+id+" Name: "+name);
			}
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	
	}
	
}
