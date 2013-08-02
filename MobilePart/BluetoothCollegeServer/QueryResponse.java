import java.util.*;
import java.sql.*;

public class QueryResponse 
{
	
	String recMesg;
	String Title;
	Connection con;
	Statement stmt,stmt1;
	ResultSet rs,rs1;
	Value val = new Value();
	String uname;
	
	String date;
	String topic;
	String platform;
	String response;
	String time;
	String name="";
	String yearOfPass;
	String compName;
	String emailId;
	String phNo;
	String alName;

	public String sendResponse(String msg)
	{
	   System.out.println("in response");
	   
	   recMesg = msg;
	   int i = recMesg.indexOf("*");
	   Title = recMesg.substring(i+1);
	   Title=Title.replace('$',' ');
	   System.out.println("name in response " + Title);
	   
	   uname = val.getName();
	   System.out.println("name is "+uname);
	   try
	   {
	   	 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	   	 con = DriverManager.getConnection("jdbc:odbc:mobile");
	   	 stmt = con.createStatement();
	   	 stmt1= con.createStatement();
	   	 
	   	 if(recMesg.startsWith("PS"))
	   	 { 
	   	     rs = stmt.executeQuery("select * from Seminar where sname='"+uname+"' and (ptitle='"+Title+"' or platform='"+Title+"')");
	   	     System.out.println("after execute");
	   	     response = "";   

		  while (rs.next())
	   	   {
	   	 	  System.out.println("in if");
	   	 	
	   	 	  topic = rs.getString("ptitle");
	   	 	  date = rs.getString("semdate");
	   	 	  platform = rs.getString("platform");
	   	 	  time = rs.getString("time");
			  
			  response += "PS"+"*"+topic+"*"+platform+"*"+time+"*"+date+"#"; // Record.
		      System.out.println("\nResponse :  " + response+"\n");	   	 
	   	    }

	   	    rs.close();
	   	    }

	   	    else if(recMesg.startsWith("Alumini"))
	   	    {
	   	       rs1=	stmt1.executeQuery("select * from alumini  where yearofpassout='"+Title+"'or compname='"+Title+"'");
	   	       name="";
	   	       while(rs1.next())
	   	       {
	   	          name+="*"+rs1.getString("name");
	   	          	  
	   	       }
	   	       response = "Alumini"+name;
	   	    
	   	    }
	   	    else if(recMesg.startsWith("DT"))
	   	    {
	   	      	rs1=stmt1.executeQuery("select * from alumini  where name='"+Title+"'");
	   	       
	   	       while(rs1.next())
	   	       {
	   	       	 yearOfPass= rs1.getString("yearofpassout");
	   	       	 phNo = rs1.getString("phno");
	   	       	 emailId = rs1.getString("email");
	   	       	 alName  = rs1.getString("name");
	   	       	 compName = rs1.getString("compname");
	   	       	 response = "DT"+"*"+alName+"*"+yearOfPass+"*"+phNo+"*"+emailId+"*"+compName;
	   	        }
	   	    }
	      }
	   	catch(Exception e)
	   	{
	   		System.out.println(e);
	   	}
	   System.out.println("return "+response);	
	  return response ; 	
	}
}