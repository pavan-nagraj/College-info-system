<%@ page contentType="text/html; charset=iso-8859-1" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<title>Untitled Document</title>
</head>
<%! Statement st;
    Connection con;
	ResultSet rs;
	
	String compName;
	String studentName;
	int studentSelected;
	String offerDetails;
	String compInfo;
	
%>
<% 

  compName = request.getParameter("compname");
  studentName = request.getParameter("studname");
  studentSelected =Integer.parseInt(request.getParameter("studselect"));
  offerDetails = request.getParameter("offer");
  compInfo= request.getParameter("info");
  String usn=request.getParameter("usn");
 
  System.out.println("got values");
  
  try
  {
     Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	 con=DriverManager.getConnection("jdbc:odbc:mobile");
	 st=con.createStatement();
	 int x= st.executeUpdate("insert into placementresult values('"+compName+"','"+studentName+"','"+studentSelected+"','"+offerDetails+"','"+compInfo+"','"+usn+"')");
	 if(x==1)
	  {   response.sendRedirect("/College/Success.jsp?back=/College/PlacementResult.jsp");
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

