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
<%
Connection con;
Statement stmt,stmt1;
int i=0;

String StudentName;
String Usn;
String Semester;
String Degree;

int Sub1_1Marks;
int Sub1_2Marks;
int Sub1_3Marks;
int Sub1_avg;
int Sub1_max;
String Sub1_Remarks;


int Sub2_1Marks;
int Sub2_2Marks;
int Sub2_3Marks;
int Sub2_avg;
int Sub2_max;
String Sub2_Remarks;


int Sub3_1Marks;
int Sub3_2Marks;
int Sub3_3Marks;
int Sub3_avg;
int Sub3_max;
String Sub3_Remarks;



int Sub4_1Marks;
int Sub4_2Marks;
int Sub4_3Marks;
int Sub4_avg;
int Sub4_max;
String Sub4_Remarks;



int Sub5_1Marks;
int Sub5_2Marks;
int Sub5_3Marks;
int Sub5_avg;
int Sub5_max;
String Sub5_Remarks;

%>

<%

 StudentName=request.getParameter("sname");
 System.out.println(StudentName);
 Usn=request.getParameter("usn");
 Semester=request.getParameter("sem");
 Degree=request.getParameter("deg");
 
 Sub1_1Marks =Integer.parseInt(request.getParameter("s1first"));
 System.out.println("iii"+Sub1_1Marks);
 Sub1_2Marks =Integer.parseInt(request.getParameter("s1second"));
 Sub1_3Marks =Integer.parseInt(request.getParameter("s1third"));
 Sub1_avg=(Sub1_1Marks+Sub1_2Marks+Sub1_3Marks)/3 ;
 Sub1_max=Integer.parseInt(request.getParameter("s1max"));
 
 System.out.println("s1avg   "+Sub1_avg);
 //Sub1_Remarks=request.getParameter("s1grade");
 
 Sub2_1Marks =Integer.parseInt( request.getParameter("s2first"));
 Sub2_2Marks =Integer.parseInt(request.getParameter("s2second"));
 Sub2_3Marks =Integer.parseInt(request.getParameter("s2third"));
 Sub2_max=Integer.parseInt(request.getParameter("s2max"));
 
 Sub2_avg=(Sub2_1Marks+Sub2_2Marks+Sub2_3Marks)/3 ;
// Sub2_Remarks=request.getParameter("s2grade");
 System.out.println("sub2  "+Sub2_avg);
 
 Sub3_1Marks = Integer.parseInt(request.getParameter("s3first"));
 Sub3_2Marks =Integer.parseInt(request.getParameter("s3second"));
 Sub3_3Marks =Integer.parseInt(request.getParameter("s3third"));
 Sub3_max=Integer.parseInt(request.getParameter("s3max"));
 
 Sub3_avg=(Sub3_1Marks+Sub3_2Marks+Sub3_3Marks)/3 ;
 //Sub3_Remarks=request.getParameter("s3grade");
 System.out.println("sub3  "+Sub3_avg);
 
 Sub4_1Marks = Integer.parseInt(request.getParameter("s4first"));
 Sub4_2Marks =Integer.parseInt(request.getParameter("s4second"));
 Sub4_3Marks =Integer.parseInt(request.getParameter("s4third"));
 Sub4_max=Integer.parseInt(request.getParameter("s4max"));
 Sub4_avg=(Sub4_1Marks+Sub4_2Marks+Sub4_3Marks)/3 ;
 //ub4_Remarks=request.getParameter("s4grade");
 System.out.println("sub4  "+Sub4_avg);
 
 Sub5_1Marks = Integer.parseInt(request.getParameter("s5first"));
 Sub5_2Marks =Integer.parseInt(request.getParameter("s5second"));
 Sub5_3Marks =Integer.parseInt(request.getParameter("s5third"));
 Sub5_max=Integer.parseInt(request.getParameter("s5max"));
 Sub5_avg=(Sub5_1Marks+Sub5_2Marks+Sub5_3Marks)/3 ;
 System.out.println("sub5 "+Sub5_avg);
 
 //Sub5_Remarks=request.getParameter("s5grade");
 System.out.println("got values");
%>


<% 
  try
   {
     Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	 con = DriverManager.getConnection("jdbc:odbc:mobile");
	 stmt = con.createStatement();
	 stmt1 = con.createStatement();
	 stmt1.executeUpdate("insert into student values('"+StudentName+"','"+Usn+"','"+Degree+"','"+Semester+"')");
	 
	 stmt.executeUpdate("insert into Internals values('Subj1','"+Sub1_1Marks+"','"+Sub1_2Marks+"','"+Sub1_3Marks+"','"+Sub1_max+"','"+Sub1_avg+"','"+Usn+"')");
     stmt.executeUpdate("insert into Internals values('Subj2','"+Sub2_1Marks+"','"+Sub2_2Marks+"','"+Sub2_3Marks+"','"+Sub2_max+"','"+Sub2_avg+"','"+Usn+"')");
	 stmt.executeUpdate("insert into Internals values('Subj3','"+Sub3_1Marks+"','"+Sub3_2Marks+"','"+Sub3_3Marks+"','"+Sub3_max+"','"+Sub3_avg+"','"+Usn+"')");
	 stmt.executeUpdate("insert into Internals values('Subj4','"+Sub4_1Marks+"','"+Sub4_2Marks+"','"+Sub4_3Marks+"','"+Sub4_max+"','"+Sub4_avg+"','"+Usn+"')");
	 stmt.executeUpdate("insert into Internals values('Subj5','"+Sub5_1Marks+"','"+Sub5_2Marks+"','"+Sub5_3Marks+"','"+Sub5_max+"','"+Sub5_avg+"','"+Usn+"')");
	 		response.sendRedirect("/College/webpages/Success.jsp?back=/College/webpages/InternalMarks.html");								  
												
   }
 catch(Exception e)
 {
 System.out.println(e);
 }




%>

<body>
</body>
</html>

