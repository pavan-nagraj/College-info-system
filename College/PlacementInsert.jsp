<%@ page contentType="text/html; charset=iso-8859-1" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<title></title>
</head>
<%! Statement st;
    Connection con;
	ResultSet rs;
	
	String compName;
	String cutOff;
	String interDate;
	String interTime;
	String backLogs;
	String Venue;
%>
<% 

  compName = request.getParameter("compname");
  cutOff = request.getParameter("cutoff");
  interDate = request.getParameter("date");
  interTime = request.getParameter("time");
  backLogs = request.getParameter("backlogs");
  Venue = request.getParameter("venue");
  System.out.println("got values");
  
  try
  {
     Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	 con=DriverManager.getConnection("jdbc:odbc:mobile");
	 st=con.createStatement();
	 int x= st.executeUpdate("insert into placementnotice values('"+compName+"','"+cutOff+"','"+interDate+"','"+interTime+"','"+backLogs+"','"+Venue+"')");
	 response.sendRedirect("/College/Success.jsp?back=/College/PlacementNotice.jsp");
	  if(x==1)
	  {  
	     System.out.println("inserted");
		 }
 }
 catch(Exception e)
 {
   System.out.println(" error "+e);
   }		 
%>  
	
<body>

</body>
</html>

