<%@ page contentType="text/html; charset=iso-8859-1" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<title>Untitled Document</title>
</head>
<%! String name;
    String yearOfPass;
	String email;
	String phNo;
	String compName;
	ResultSet rs;
	Connection con;
	Statement st;
%>	
<%
     name = request.getParameter("name");
     compName = request.getParameter("comp");
     yearOfPass = request.getParameter("year");
     phNo = request.getParameter("phno");
     email= request.getParameter("email");
	 
     System.out.println("got values --");
     
	 try
    {
       Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	   con = DriverManager.getConnection("jdbc:odbc:mobile");
	   st = con.createStatement();
	   int i=st.executeUpdate("insert into alumini values('"+name+"','"+yearOfPass+"','"+phNo+"','"+email+"','"+compName+"')");
       System.out.println("Values are inserted into seminar table");
		   
      if(i==1)
           response.sendRedirect("/College/Success.jsp?back=/College/AluminiDetails.jsp");
     
	}
   catch(Exception e)
   {
    System.out.println(e);
	}
   
 
 %>
<body>

</body>
</html>

