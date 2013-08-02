<%@ include file="Database/connect.jsp" %>
<%@ page import="java.util.Date" %>

<%
    
        String username=request.getParameter("username");      

        String Password=request.getParameter("password");
        
        

        String Message="Invalid User Name & Password! Try Again";

	    
try
{
	   String sql="SELECT * FROM studreg where sname='"+username+"' and pword='"+Password+"'";
        Statement stmt = connection.createStatement();
	    ResultSet rs =stmt.executeQuery(sql);
		String utype="";
	   if(rs.next())
	    {
	    response.sendRedirect("download.jsp");
           }
	    else
	    {
	    response.sendRedirect("wronglogin.html");
          }
}

catch(Exception e)
{out.print(e);}
%>

