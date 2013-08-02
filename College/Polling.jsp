<%@ page contentType="text/html; charset=iso-8859-1" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<title>Untitled Document</title>
<style type="text/css">
<!--
.style1 {
	font-size: 18px;
	font-weight: bold;
}
body {
	background-image: url(images/orange_paper.gif);
}
.style4 {
	color: #99FF33;
	font-weight: bold;
	font-size: 18px;
}
-->
</style>
<script language="JavaScript" type="text/JavaScript">
<!--
function MM_reloadPage(init) {  //reloads the window if Nav4 resized
  if (init==true) with (navigator) {if ((appName=="Netscape")&&(parseInt(appVersion)==4)) {
    document.MM_pgW=innerWidth; document.MM_pgH=innerHeight; onresize=MM_reloadPage; }}
  else if (innerWidth!=document.MM_pgW || innerHeight!=document.MM_pgH) location.reload();
}
MM_reloadPage(true);
//-->
</script>
</head>

<body>
<form name="form1" method="post" action="">	
<%! Statement stmt, stmt1;
    ResultSet rs, rs1;
	Connection con;
	String quest;
	String answer;
	String qno;
	String category;
	int i=0;
%>
<%
    try
	{
	  Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	  con = DriverManager.getConnection("jdbc:odbc:mobile");
	  stmt = con.createStatement();
	  stmt1 = con.createStatement();
	  rs = stmt.executeQuery("select * from Pollquestion");
	 
%>

<div id="Layer1" class="style1" style="position:absolute; width:170px; height:29px; z-index:1; left: 224px; top: 24px;">
  <div align="center">Polling Results </div>
</div>

<div align="center">
  <p>&nbsp;</p>
  <div id="Layer2" style="position:absolute; width:358px; height:278px; z-index:2; left: 121px; top: 79px;">
    <table width="274" border="1" align="center">
	<%  	while(rs.next())
	      {   
		                         System.out.println("in first while");
	         qno=rs.getString("id");
		     quest = rs.getString("question");
		     System.out.println("in first while"+qno+quest);
   %> 
      <tr>
        <td width="74"><div align="left">.<%=qno%>
              <input name="qno" type="hidden" size="10" value="Q.<%=qno%>"onClick="this.blur()" >
        </div></td>
        <td width="184"><div align="left"><%=quest%>
              <input name="question" type="hidden" size="30" value="<%=quest%>" onClick="this.blur()">
        </div></td>
      </tr>
	  <% rs1=stmt1.executeQuery("select * from poll where id='"+qno+"'");
	     while(rs1.next())
		 {
		    
		    System.out.println("in sec while");
		    category=rs1.getString("category");
		    answer = rs1.getString("answer");  
	%>	   
      <tr>
        <td ><div align="left"><%= category %>
              <input name="category" type="hidden" size="10"value="<%= category %>" onClick="this.blur()"> 
          </div></td>
        <td><div align="left"><%=answer%>
              <input name="answer" type="hidden" size="30" value="<%=answer%>" onClick="this.blur()">
        </div></td>
      </tr>
	  <% 
	  } }
	   %>
	
    </table>
	<%  System.out.println("outside");
	  
	  System.out.println("^^^^^^ ");
	}
	catch(Exception e)
	{
	   System.out.println(e);
	 }    
	  %>
  </div>
</div></form>
<div id="Layer3" style="position:absolute; width:126px; height:43px; z-index:3; left: 320px; top: 383px;">
  
</div>
<p>&nbsp;</p>
</body>
</html>

