import java.sql.*;
import java.util.*;

public class StudentQuery 
{
	String recData;
	Statement stmt,stmt1;
	Connection con;
	ResultSet rs;
	String sName;
	String response;
	String email;
	String phno;
	String sem;
	String deg;
	String sub,subj;
	String res,res1;
	public String queryData(String Msg)
	{
		recData = Msg;
		System.out.println("in Student "+recData);
		
		int i = recData.indexOf("*");
	    recData = recData.substring(i+1);
	     
	     
	     try
	 	{
	 	      Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	          con=DriverManager.getConnection("jdbc:odbc:mobile");
	          stmt=con.createStatement();
	          stmt1=con.createStatement();
	
	
	         if(Msg.startsWith("ST"))
	         {
	         
	          rs= stmt.executeQuery("select * from studreg where dept ='"+recData+"' or semester = '"+recData+"'"); 
	          System.out.println("successfully inserted"); 
	          sName="";
	          while(rs.next())
	          {
	          	sName +="*"+ rs.getString("sname");
	          	System.out.println("name is "+sName);
	          	
	          }
	          response = "ST"+sName;
	        	           
	        }
	       
	       else if(Msg.startsWith("IN"))
	        {
				rs = stmt.executeQuery("SELECT * FROM STUDREG WHERE sname = '"+recData+"'");
	        	
	        	if(rs.next()) {
	        		sName = rs.getString("sname");
	        		phno = rs.getString("mobno");
	        		email = rs.getString("emailid");	        		
	        	}
					    
	        	response="IN*"+ sName + "*" + phno + "*" + email;
	        	System.out.println("\nResponse : " + response);	        	
	        }
	         else if(Msg.startsWith("MR"))
	        {
				rs = stmt.executeQuery("SELECT * FROM Internals WHERE usn = '"+recData+"'");
	        if(rs.next())
	        {
	        	//	sub=res+"*"
	        	sub= rs.getString("average");
	        	subj= rs.getString(1);
	        }   
	             	while(rs.next())
	        	{
	           		res= rs.getString("average");
	        		sub+="*"+res;
	        	  	res1= rs.getString(1);
	        		//sub="*"+subj+"*"+sub+"*"+res;
	        		subj+="*"+res1;
	        	}
					    
	        	response="MR*"+sub+"*"+subj;
	        	System.out.println("\nResponse : " + response);	        	
	        }
	        
	        
	        else if(Msg.startsWith("EX"))
	        {
	        	System.out.println("hi i am here");
	        		rs = stmt.executeQuery("SELECT * FROM examdetails");
	        		if(rs.next())
	        		{
	        			response="EX*"+rs.getString(1)+"*"+rs.getString(2)+"*"+rs.getString(3)+"*"+rs.getString(4)+"*"+rs.getString(5);
	        		}
	        
	        }
	        //con.close();
	          else if(Msg.startsWith("LB"))
	        {
	        	System.out.println("hi i am here");
	        		rs = stmt.executeQuery("SELECT * FROM Library where usn='"+recData+"'");
	        		while(rs.next())
	        		{
	        			response="LB*"+rs.getString(5)+"*"+rs.getString(8)+"*"+rs.getString(9)+"*"+rs.getString(12);
	        		}
	        
	        }
	        else if(Msg.startsWith("AT"))
	        {
	        
				rs = stmt.executeQuery("SELECT * FROM Attendance WHERE usn ='"+recData+"'");
	        if(rs.next())
	        {
	        	//	sub=res+"*"
	        	sub= rs.getString("percentage");
	        	subj= rs.getString(1);
	        }   
	             	while(rs.next())
	        	{
	           		res= rs.getString("percentage");
	        		sub+="*"+res;
	        	  	res1= rs.getString(1);
	        		//sub="*"+subj+"*"+sub+"*"+res;
	        		subj+="*"+res1;
	        	}
					    
	        	response="AT*"+sub+"*"+subj;
	        	System.out.println("\nResponse : " + response);	        	
	        
	        }
	        
	        
	    } 
	     catch(Exception e)
	     { 
	     System.out.println(e);
	     	
	     }   
	     System.out.println("\nReturning : "+ response + "\n");  
	     return response;  
	}
}