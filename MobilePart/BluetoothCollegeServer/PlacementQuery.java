import java.util.*;
import java.sql.*;
public class PlacementQuery 
{	
	Statement stmt;
	Connection con;
	ResultSet rs;
	
	String recMesg;
	String USN;
	String response;
	
	public String sendData(String Msg)
	{
		recMesg = Msg;
		System.out.println("in Student "+recMesg);
		
		  StringTokenizer stz = new StringTokenizer(recMesg,"*");
		  while(stz.hasMoreTokens())
		  {
		  	 stz.nextToken();
		  	 USN = stz.nextToken();
		  }
	     System.out.println("reg "+USN);
	     try
	 	{
	 		  Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	          con=DriverManager.getConnection("jdbc:odbc:mobile");
	          stmt=con.createStatement();
	          rs = stmt.executeQuery("select * from placementresult where usn='"+USN+"'");
	          if(rs.next())
	          {
	          	 response ="PL*"+ "U have Been selected";
	          } 
	          else
	             response ="PL*"+ "Sorry Not Selected";
	    }
	    catch(Exception e)
	    {
	    	System.out.println(e);
	    }
	    return response;
	 }
}	 
	    