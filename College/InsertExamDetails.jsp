<%@ page contentType="text/html; charset=iso-8859-1" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.sql.*" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<title>Untitled Document</title>
</head>

<body>
<%! 
	Connection con;
	Statement st;
	ResultSet rs;
	String examFees;
    String lastDate,examDate,time,center;
%>

<%  
  examFees=request.getParameter("examfees");
  System.out.println("Exame fees "+examFees);
  lastDate=request.getParameter("lastdate");
  System.out.println("last date "+lastDate);
  examDate=request.getParameter("examdate");
  System.out.println("Exame Date "+examDate);
  time=request.getParameter("time");
  System.out.println("time "+time);
  center=request.getParameter("center");
System.out.println("center "+center);

	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
     con=DriverManager.getConnection("jdbc:odbc:mobile");	
	 st=con.createStatement();
	 int z=st.executeUpdate("insert into  examdetails values('"+examFees+"','"+lastDate+"','"+examDate+"','"+time+"','"+center+"')");
	 System.out.println("Inserted successfully");
	 response.sendRedirect("/College/webpages/Success.jsp?back=/College/webpages/ExamDetails.html");
	 %>
	 

</body>
</html>

