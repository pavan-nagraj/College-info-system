import java.io.*;
import java.sql.*;
import java.util.*;

public class LoginCheck 
{
	
	  String usrname, pass;
	  ResultSet rs;
	  Statement stmt;
	  Connection con;
	  String msg;
	  String uid;
	  String category;
	  Value val = new Value();
	  
	 public String Check(String usrpass)
	 {
	 
	   	uid=usrpass;	 	
	 		 	
	 	int i =uid.indexOf("*");
	 	String usrid = uid.substring(i);
	 	System.out.println("val "+usrid);
	 	
	 	StringTokenizer st= new StringTokenizer(usrid,"*");
	 	
	 	while(st.hasMoreTokens())
	 	{ 
	 	  System.out.println("in while ");
	 	   usrname=st.nextToken();
	 	   pass=st.nextToken();
	 	  System.out.println("hhhh "); 	
	 	}
	 	
	 	System.out.println("l :"+usrname+ " "+pass);
	 	
	 	
	 	try
	 	{
	 		  Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	          con=DriverManager.getConnection("jdbc:odbc:mobile");
	          stmt=con.createStatement();
	          rs= stmt.executeQuery("select * from login where username='"+usrname+"' and password='"+pass+"' ");
	          
	          if(rs.next())
	          {
	          	category = rs.getString("Category");
	          	msg =category+"*"+"Logged"; 
	          	System.out.println("success");
	          	val.setName(usrname);
	          	System.out.println("value set:"+msg);
	          	
	          	
	          }
	          else
	          {
	            msg="Invalid"+"*"+"Fail";
	            
	            System.out.println("Invalid");
	          } 
	          
	      }     
	      catch(Exception e)
	      {
	      	System.out.println(e);
	      }     
	       
	       return msg;   
	 	}
	 
}

