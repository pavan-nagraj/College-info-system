<%@ include file="../Database/connect.jsp" %>

<html>

<body bgcolor=#FFFFFF >

<table border=0 width="633" style="border-collapse: collapse" bordercolor="#111111" cellpadding="0" cellspacing="0">
<tr>
  <td align="justify" bgcolor="#00FF00" width="180" valign="baseline" height="0">
  <b>Complaints To</b></td>
  <td align="justify" bgcolor="#00FF00" width="143" valign="baseline" height="0"><b>
  Student Mobile No</b></td>

  <td align="justify" bgcolor="#00FF00" width="100" valign="baseline" height="0"><b>Complaints</b></td>
  <td align="justify" bgcolor="#00FF00" width="182" valign="baseline" height="0">
  <b>Complaint Category</b></td>
  </tr>





<%
	
      	
	String s1, s2, s3,s4;

      	try 
	{
           
           String query="select * FROM complaints"; 
           Statement st=connection.createStatement();
           ResultSet rs=st.executeQuery(query);
	   while ( rs.next() )
	   {
		s1=rs.getString(1);
		s2=rs.getString(2);
            s3=rs.getString(3);
		s4=rs.getString(4);
		
		
%>

<tr>
	<td align="center" bgcolor="#FFFFFF" width="180" valign="baseline" height="0"><%out.println(s1);%>&nbsp;</td>
    <td align="center" bgcolor="#FFFFFF" width="143" valign="baseline" height="0"><%out.println(s2);%>&nbsp;</td>
    <td align="center" bgcolor="#FFFFFF" width="100" valign="baseline" height="0"><%out.println(s3);%>&nbsp;</td>
    <td align="center" bgcolor="#FFFFFF" width="182" valign="baseline" height="0"><%out.println(s4);%>&nbsp;</td>
</tr>


<%

	   }

           connection.close();
          }
         
          catch(Exception e)
          {
            out.println(e.getMessage());
          }
%>

<tr>
	<td align="justify" bgcolor="#00FF00" width="180" valign="baseline" height="0">&nbsp;</td>
    <td align="justify" bgcolor="#00FF00" width="143" valign="baseline" height="0">&nbsp;</td>
    <td align="justify" bgcolor="#00FF00" width="100" valign="baseline" height="0">&nbsp;</td>
    <td align="justify" bgcolor="#00FF00" width="182" valign="baseline" height="0">&nbsp;</td>
</tr>


</table>
</form>
</body>
</html>