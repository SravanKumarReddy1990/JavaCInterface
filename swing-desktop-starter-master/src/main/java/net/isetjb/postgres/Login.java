package net.isetjb.postgres;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import java.sql.*;
import java.util.Random;
import java.net.*;
import java.io.*; 

/**
 * Servlet implementation class ExcelSample
 */
public class Login{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();

		// TODO Auto-generated constructor stubs
	}

	public static void login(String userid,String password) {
		// TODO Auto-generated method stub
		
				try {

Random rnd = new Random();
int n = 100000 + rnd.nextInt(900000);
String tempid=n+"";


					 String url = "jdbc:postgresql://localhost:5432/postgres";
            Connection conn = DriverManager.getConnection(url,"postgres","postgres");

ResultSet resultSet = conn.prepareStatement("select username from users where username='"+userid+"' and password='"+password+"'").executeQuery();
 String id="";
while(resultSet.next()){
id=resultSet.getString("username" );
Random rndd = new Random();
int nn = 100000 + rndd.nextInt(900000);

  // PreparedStatement ps = conn.prepareStatement("update users set tempid='"+nn+"' where username='"+userid+"'");
  // ps.executeUpdate();
  // ps.close();
System.out.println("id:"+id);
   

}  
resultSet.close();
conn.close();

				} catch (Exception e) {
					System.out.println("Excel Sample : "+e);
				}
			
		

	}


}
