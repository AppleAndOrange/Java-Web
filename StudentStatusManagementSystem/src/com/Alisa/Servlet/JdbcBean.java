package com.Alisa.Servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcBean {  
      private String DBDriver="com.mysql.jdbc.Driver";  
      private String DBUrl="jdbc:mysql://localhost:3306/management";  
      private String DBUser="root";  
      private String DBPassword="root";  
      public Connection conn=null;  
      public ResultSet rs=null;  
      public ResultSet query(String sql)throws Exception{  
          try{  
              conn=connection();
              Statement stmt=conn.createStatement();  
              rs=stmt.executeQuery(sql);  
              System.out.println("rs");
              return rs;  
          }  
          catch(SQLException e){  
        	  System.err.println("e.getMessage()");
              System.out.println(e.getMessage());  
          }  
          return null;  
      }
      public boolean insert(String sql){
		try {
			conn=connection();
			Statement stmt;
			stmt = conn.createStatement();
			stmt.execute(sql);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
           return false;
      }
      public Connection connection(){
    	  try {
			Class.forName(DBDriver);
			conn=DriverManager.getConnection(DBUrl,DBUser,DBPassword);
			return conn;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;  
         
      }
       
}  