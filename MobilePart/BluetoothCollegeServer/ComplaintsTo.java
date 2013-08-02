import java.util.*;
import java.sql.*;
public class ComplaintsTo 
{
	
	String recData;
	String subject;
	String toName;
	String Complaint;
	String mobileNo;
	Statement stmt;
	Statement stmt1;
	
	Connection con;
	
	ResultSet rs;
	
	Value value = new Value();
	
	public void dataStore(String receive)
	{
	   recData = receive;
	   System.out.println("in complaints "+recData);
	   int i = recData.indexOf("*");
	   recData = recData.substring(i+1);
	   StringTokenizer s = new StringTokenizer(recData,"*");
	   while(s.hasMoreTokens())
	   {
	   	subject = s.nextToken();
	   	toName = s.nextToken();
	   	Complaint = s.nextToken();
	   	Complaint=Complaint.replace('$',' ');
	   	mobileNo = s.nextToken();
	   	
	   }
	   value.setMobileNo(mobileNo);
	   System.out.println("after "+subject+toName+Complaint+mobileNo);
	   
	   	try
	 	{
	 		  Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	          con=DriverManager.getConnection("jdbc:odbc:mobile");
	          stmt=con.createStatement();
	          stmt1=con.createStatement();
	
	          stmt.executeUpdate("insert into complaints values('"+toName+"','"+mobileNo+"','"+Complaint+"','"+subject+"')");
	          System.out.println("successfully inserted"); 
	        	con.close();           
	        }
	     catch(Exception e)
	     { 
	     System.out.println(e);
	     	
	     }   
	       
	     
}
}
