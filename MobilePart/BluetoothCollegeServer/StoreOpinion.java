import java.sql.*;
import java.util.*;
public class StoreOpinion
{
	Connection con;
	Statement st;
	StringTokenizer stz;
	
	String s,qid;
	String answer;
	String category;
	String response;
	
	public StoreOpinion()
	{
		try{		
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			con=DriverManager.getConnection("jdbc:odbc:mobile");
			st = con.createStatement();
		} catch(Exception e)
		{
			System.out.println("Error "+e);
		}
	}
	
	public String storeData(String ans)
	{
	
		System.out.println("ans "+ans);
	
		stz=new StringTokenizer(ans,"*");
		while(stz.hasMoreElements())
		{
			stz.nextToken();
			category=stz.nextToken();
			qid=stz.nextToken();
			answer=stz.nextToken();
			answer=answer.replace('$',' '); // Hai$Hello.
		}
	
		System.out.println("Qid "+qid);
		
		
		System.out.println("ans "+answer);
		try{
        st.executeUpdate("insert into poll values('"+qid+"','"+answer+"','"+category+"')");
		System.out.println("inserted successfully");
		response = "POLL *"+"Success";
		
		}catch(Exception e)
		{
			System.out.println("Error "+e);
		}
		return response;
	}
}
