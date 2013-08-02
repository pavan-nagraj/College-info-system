<%@ page contentType="text/html; charset=iso-8859-1" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ page
     import = "java.sql.*"
%>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<title>Untitled Document</title>
</head>
<%! String Studentname;
    String Usn;
	String Semester;
	String Degree;
 
 	int Totalsub1;
	int Totalsub2;
	int Totalsub3;
	int Totalsub4;
    int Totalsub5;
	
    int  Attsub1;
	int Attsub2;
	int Attsub3;
	int Attsub4;
    int Attsub5;
	int Reqsub1;
	int Reqsub2;
	int Reqsub3;
	int Reqsub4;
    int Reqsub5;
	String Percentage1, Percentage2,Percentage3,Percentage4,Percentage5;
	
    
	Connection con;
	Statement stmt,stmt1;
	

%>
<%
Studentname=request.getParameter("sname");
System.out.println(Studentname);
Usn = request.getParameter("usn");
System.out.println(Usn);
Semester = request.getParameter("sem");
System.out.println(Semester);
Degree = request.getParameter("deg");
System.out.println(Degree);

Totalsub1= Integer.parseInt(request.getParameter("tsub1"));
System.out.println(Totalsub1);
Totalsub2= Integer.parseInt(request.getParameter("tsub2"));
System.out.println(Totalsub2);
Totalsub3= Integer.parseInt(request.getParameter("tsub3"));
System.out.println(Totalsub3);
Totalsub4=Integer.parseInt( request.getParameter("tsub4"));
System.out.println(Totalsub4);
Totalsub5= Integer.parseInt(request.getParameter("tsub5"));

Attsub1= Integer.parseInt(request.getParameter("asub1"));
Attsub2 = Integer.parseInt(request.getParameter("asub2"));
Attsub3 = Integer.parseInt(request.getParameter("asub3"));
Attsub4 = Integer.parseInt(request.getParameter("asub4"));
Attsub5 = Integer.parseInt(request.getParameter("asub5"));

Reqsub1 = Integer.parseInt(request.getParameter("rsub1"));
Reqsub2 = Integer.parseInt(request.getParameter("rsub2"));
Reqsub3 = Integer.parseInt(request.getParameter("rsub3"));
Reqsub4= Integer.parseInt(request.getParameter("rsub4"));
Reqsub5= Integer.parseInt(request.getParameter("rsub5"));

System.out.println("values obtained");
%>


<%
    if(Attsub1 == 25)
	{
	    Percentage1 =" 75%";
    }
	else if( ((Attsub1 < 25)&& (Attsub1 > 20)) || (Attsub1 == 20))
	{		
        Percentage1 = "70%";
     }
	 else if(Attsub1 < 20)
	 { 
         Percentage1 = "65%";
		} 
		
	 else 
	    Percentage1 = "Shortage"; 
	System.out.println("obtained "+Percentage1);
	if(Attsub2 == 25)
	{
	    Percentage2 =" 75%";
    }
	else if( ((Attsub2 < 25)&& (Attsub2 > 20)) || (Attsub2 == 20))
	{		
        Percentage2= "70%";
     }
	 else if(Attsub2 < 20 )
	 { 
         Percentage2= "65%";
	 } 
		
	 else 
	    Percentage2= "Shortage"; 
	System.out.println("obtained "+Percentage2);
	
	if(Attsub3 == 25)
	{
	    Percentage3 =" 75%";
    }
	else if( ((Attsub3 < 25)&& (Attsub3 > 20)) || (Attsub3 == 20))
	{		
        Percentage3= "70%";
     }
	 else if(Attsub3 < 20 )
	 { 
         Percentage3= "65%";
	 } 
		
	 else 
	    Percentage3= "Shortage"; 
	System.out.println("obtained "+Percentage3);
	
	if(Attsub4 == 25)
	{
	    Percentage4 =" 75%";
    }
	else if( ((Attsub4 < 25)&& (Attsub4> 20)) || (Attsub4 == 20))
	{		
        Percentage4= "70%";
     }
	 else if(Attsub2 < 20 )
	 { 
         Percentage4= "65%";
	 } 
		
	 else 
	    Percentage4= "Shortage"; 
	System.out.println("obtained "+Percentage4);
	
	if(Attsub5 == 25)
	{
	    Percentage5 =" 75%";
    }
	else if( ((Attsub5 < 25)&& (Attsub5 > 20)) || (Attsub5 == 20))
	{		
        Percentage5= "70%";
     }
	 else if(Attsub5 < 20 )
	 { 
         Percentage5= "65%";
	 } 
		
	 else 
	    Percentage5= "Shortage"; 
	System.out.println("obtained "+Percentage5);
	
   try
   {
   Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
   con = DriverManager.getConnection("jdbc:odbc:mobile");
   stmt = con.createStatement();
   stmt1 = con.createStatement();
   stmt1.executeUpdate("insert into student values('"+Studentname+"','"+Usn+"','"+Semester+"','"+Degree+"')");
  
  stmt.executeUpdate("insert into Attendance values('Subj1','"+Attsub1+"','"+Totalsub1+"','"+Reqsub1+"','"+Usn+"','"+Percentage1+"')");
  stmt.executeUpdate("insert into Attendance values('Subj2','"+Attsub2+"','"+Totalsub2+"','"+Reqsub2+"','"+Usn+"','"+Percentage2+"')");
  stmt.executeUpdate("insert into Attendance values('Subj3','"+Attsub3+"','"+Totalsub3+"','"+Reqsub3+"','"+Usn+"','"+Percentage3+"')");
  stmt.executeUpdate("insert into Attendance values('Subj4','"+Attsub4+"','"+Totalsub4+"','"+Reqsub4+"','"+Usn+"','"+Percentage4+"')");
  stmt.executeUpdate("insert into Attendance values('Subj5','"+Attsub5+"','"+Totalsub5+"','"+Reqsub5+"','"+Usn+"','"+Percentage5+"')");
  System.out.println("Values are inserted successfully");
  
   response.sendRedirect("/College/Success.jsp?back=/College/webpages/enterattendance.jsp");
   }
   catch(Exception e)
   {
   System.out.println(e);
   }






%>

<body>

</body>
</html>

