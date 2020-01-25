package com.server.jfromc.postgres;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import java.sql.*;
import java.util.Random;
import java.net.*;
import java.io.*; 
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

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

	public JSONObject login(JSONObject obj) {
		// TODO Auto-generated method stub
JSONObject result=new JSONObject();		
try {
String userid=obj.get("userid").toString();
String password=obj.get("password").toString();
Random rnd = new Random();
int n = 100000 + rnd.nextInt(900000);
String tempid=n+"";
String url = "jdbc:postgresql://localhost:5432/postgres";
Connection conn = DriverManager.getConnection(url,"postgres","postgres");
String sqlString="select username from users where username='"+userid+"' and password='"+password+"'";
ResultSet resultSet = conn.prepareStatement(sqlString).executeQuery();
System.out.println(sqlString);
 String id="";
if(resultSet.next()){
id=resultSet.getString("username" );
Random rndd = new Random();
int nn = 100000 + rndd.nextInt(900000);
  // PreparedStatement ps = conn.prepareStatement("update users set tempid='"+nn+"' where username='"+userid+"'");
  // ps.executeUpdate();
  // ps.close();
//System.out.println("id:"+id);
   result.put("status","yes");
} else{
//System.out.println("id:"+id);
  result.put("status","no");
}
resultSet.close();
conn.close();
} catch (Exception e) {
System.out.println("Excel Sample : "+e);
}
System.out.println(result);
return result;	
	}


}
