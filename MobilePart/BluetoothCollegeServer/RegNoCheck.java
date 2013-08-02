import java.io.*;
import java.sql.*;
import java.util.*;

public class RegNoCheck 
{
	
	  String regNo, subjName;
	  ResultSet rs,rs1,rs2;
	  Statement stmt,stmt1,stmt2;
	  Connection con;
	  String msg;
	  String uid,usrid;
	  String subj;
	  
	  String avg, average;
	  
	 public String NumberCheck(String num)
	 {
	 
	    uid = num;	 	
	 	 
	 	System.out.println("got in regNo"+uid);
	 	int i =uid.indexOf("*");
	 	
	 	String usrid = uid.substring(i);
	 	
	 	System.out.println("val "+usrid);
	 	
	 	StringTokenizer st= new StringTokenizer(usrid,"*");	 	
	 	while(st.hasMoreTokens())
	 	{ 
	 	  System.out.println("&&&& ");
	 	  regNo =st.nextToken();
	 	  subjName=st.nextToken();	   	
	 	}
	 	
	 	System.out.println("l "+regNo+subjName);
	 	
	 	
	 	try
	 	{
	 		  Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	          con=DriverManager.getConnection("jdbc:odbc:mobile");
	          stmt=con.createStatement();
	          stmt1=con.createStatement();
	          stmt2=con.createStatement();
	          rs= stmt.executeQuery("select * from studreg where usn='"+regNo+"' ");
	          if(rs.next())
	          {
	          	msg ="Valid"; 
	          	System.out.println("success");
	          	
	          }
	          else
	          {
	            msg="Invalid";
	            
	            System.out.println("Invalid");
	            
	          } 
	         rs.close();
	         System.out.println("1111");
	         
	         if(uid.startsWith("I"))
	         {
	           rs1=stmt1.executeQuery("select * from Internals where usn='"+regNo+"'");
	           System.out.println("$$$$");
	         while(rs1.next())
	         {
	         	
	         	System.out.println("in while");
	         	
	            subj=rs1.getString("subject");	
	            System.out.println("aaaa "+subj);
	            boolean value=subj.equals(subjName);
	            System.out.println("Value---"+value);
	            if(value)	
	            {
	            	System.out.println("in if");
	              avg= rs1.getString("average");
	              average = "AVG"+"*"+avg;	
	            }
	           else if(subj.equals(subjName))
	            {
	              avg= rs1.getString("average");
	              average = "AVG"+"*"+avg;	
	            }
	            else if(subj.equals(subjName))
	            {
	              avg= rs1.getString("average");
	              average = "AVG"+"*"+avg;	
	            }
	            else if(subj.equals(subjName))
	            {
	              avg= rs1.getString("average");
	              average = "AVG"+"*"+avg;	
	            }
	            else if(subj.equals(subjName))
	            {
	              avg= rs1.getString("average");
	              average = "AVG"+"*"+avg;	
	            }
	            
	         }
	         
	        } 
	        else if(uid.startsWith("A"))
	        {
	        	rs2= stmt2.executeQuery("select * from Attendance where usn='"+regNo+"'");
	        	System.out.println("******************************************");
	        	while(rs2.next())
	         {
	         	
	         	System.out.println("in while");
	         	
	            subj=rs2.getString("subject");	
	            System.out.println("aaaa "+subj);
	            boolean value=subj.equals(subjName);
	            System.out.println("Value---"+value);
	            if(value)	
	            {
	            	System.out.println("in if");
	            	
	              avg= rs2.getString("Percentage");
	              average = "Percentage"+"*"+avg;	
	            }
	           else if(subj.equals(subjName))
	            {
	              avg= rs2.getString("Percentage");
	              average = "Percentage"+"*"+avg;	
	            }
	            else if(subj.equals(subjName))
	            {
	              avg= rs2.getString("Percentage");
	              average = "Percentage"+"*"+avg;	
	            }
	            else if(subj.equals(subjName))
	            {
	              avg= rs2.getString("Percentage");
	              average = "Percentage"+"*"+avg;	
	            }
	            else if(subj.equals(subjName))
	            {
	              avg= rs2.getString("Percentage");
	              average = "Percentage"+"*"+avg;	
	            }
	            
	         }
	        }
	         
	       }   
	       
	      catch(Exception e)
	      {
	      	System.out.println(e);
	      }     
	       System.out.println("returning "+average);
	       return average;   
	 	}
	 
}