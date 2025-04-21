package myProject;

import java.sql.*;

public class DB클래스 {
	static boolean DB로그인(String id1, String pwd1) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // mysql8 부터.. 
			String url = "jdbc:mysql://localhost:3306/" + "member_db"; 
			String opt = "?useUnicode=true&characterEncoding=UTF-8&useSSL=false&serverTimezone=UTC"; // mysql8부터 추가 : "useSSL=false&serverTimezone=UTC" 
			url += opt;
			Connection   con = DriverManager.getConnection(url, "root", "woo991020*");
			Statement    st  = con.createStatement();
			
 		    String  SQL = "SELECT * FROM member  WHERE id1 = '" + id1 + "' and pass1='"+pwd1+"'";    
			ResultSet rs = st.executeQuery( SQL );
				
			boolean 찾았음 = false;
			while( rs.next() ) {	
				// 찾은 레코드가  있으면 이 부분이 한 번 실행됨
				찾았음 = true;
			}
			return 찾았음;
		}catch(Exception 예외) {
			
			return false;			
		}	
		
	}	
}
