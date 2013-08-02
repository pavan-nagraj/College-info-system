<%@ page contentType="text/html; charset=iso-8859-1" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page
    import = "java.sql.*"
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<title>Untitled Document</title>
</head>
<%!
    int i=0;
   String StudentName;
   String Usn;
   String ProjectTitle;
   String SeminarDate;
   String Platform;
   String Time;;
   Connection con;
   Statement stmt;
  %>
 
 
 <%
 StudentName = request.getParameter("sname");
 Usn = request.getParameter("usn");
 ProjectTitle = request.getParameter("ptitle");
 SeminarDate = request.getParameter("sdate");
 Platform = request.getParameter("platform");
  Time = request.getParameter("time");
 
 %>
 
 <%
   try
   {
     Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	 con = DriverManager.getConnection("jdbc:odbc:mobile");
	 stmt = con.createStatement();
	 i=stmt.executeUpdate("insert into Seminar values('"+StudentName+"','"+Usn+"','"+ProjectTitle+"','"+SeminarDate+"','"+Time+"','"+Platform+"')");
     System.out.println("Values are inserted into seminar table");
   }
   catch(Exception e)
   {
    System.out.println(e);
   }
   if(i==1)
   response.sendRedirect("/College/Success.jsp?back=/College/Proj_Sem.jsp");
   
 
 %> 

<body>
</body>
</html>

