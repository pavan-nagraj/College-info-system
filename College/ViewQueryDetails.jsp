<%@ page import="java.sql.*"%>

<html>
<style type="text/css">
<!--
.style1 {color: #FF00FF}
-->
</style>
<body>
<div align="center" style="width: 836; height: 92">
  <center>
  <h1><u><i><font color="#0000FF" size="5">STUDENT QUERY DETAILS</font></i></u></h1>
<table style="border-collapse: collapse" bordercolor="#111111" cellspacing="1" width="802" border="0">
<tr>

 <td width="103" bgcolor="#3333FF" align="left"><font color="#FFFFFF"><b><i>
 Query</i></b><i><b>No</b></i></font></td>
 <td width="103" bgcolor="#3333FF" align="left"><font color="#FFFFFF"><b><i>
 StudentQuery</i></b></font></td>
  <td width="103" bgcolor="#3333FF" align="center"><font color="#FFFFFF"><b><i>
  Student</i></b><i><b>Name</b></i></font></td>
  
  <td width="57" bgcolor="#3333FF" align="center"><font color="#FFFFFF"><b><i>
  USN</i></b></font></td>
  <td width="81" bgcolor="#3333FF" align="center"><font color="#FFFFFF"><b><i>
  EmailId</i></b></font></td>
  <td width="140" bgcolor="#3333FF" align="center"><font color="#FFFFFF"><i><b>CNo</b></i></font></td>
  <td width="24" bgcolor="#3333FF" align="center"><font color="#FFFFFF"><i><b>Status</b></i></font></td></tr>
<%
	
    
     	
	String  s1,s2,s3,s4,s5,s6,s7,s8,s9,empid;

           Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
           Connection con = DriverManager.getConnection("jdbc:odbc:mobile");
           Statement st=con.createStatement();
           
           String query="SELECT *  FROM QueryCategory"; 
           ResultSet rs=st.executeQuery(query);
while ( rs.next()==true)
	   {
s1=rs.getString(1);
s2=rs.getString(2);
s3=rs.getString(3);
s4=rs.getString(4);
s5=rs.getString(5);
s6=rs.getString(6);
s7=rs.getString(7);



%>
<td width="112" align="center">  <%=s1%></td> 
<td width="112" align="center">  <%=s2%></td>
<td width="112" align="center">  <%=s3%></td> 
<td width="103" align="center">       <%=s4%></td> 
<td width="55" align="center">          <%=s5%></td> 
<td width="57" align="center">       <%=s6%></td> 
<td width="177" align="center">      <%=s7%></td> 

<td width="31" align="center" bgcolor="#0000FF">     
<a href="Solution.jsp?Qid=<%=s1%>"><font color="#FFFFFF"><b>Solution</b></font></a></td> 
</tr>

<%	   }

          
          
%>
</table>
  </center>
</div>
</body>
</html>