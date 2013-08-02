<%@ include file="../Database/connect.jsp" %>

<html>

<body bgcolor=#FFFFFF >

<table border=0 width="393" style="border-collapse: collapse" bordercolor="#111111" cellpadding="0" cellspacing="0">
  <td align="center" bgcolor="#00FF00" width="156"><b>StudentOpinion</b></td>

  <td align="center" bgcolor="#00FF00" width="221"><b>OpinionAbout</b></td>
  </tr>





<%
	
      	
	String s1, s2, s3,s4;

      	try 
	{
           
           String query="select * FROM poll"; 
           Statement st=connection.createStatement();
           ResultSet rs=st.executeQuery(query);
	   while ( rs.next() )
	   {
		s1=rs.getString(1);
		s2=rs.getString(2);
		
		
%>

<tr>
	<td align="center" bgcolor="#FFFFFF" width="156"><%out.println(s1);%>&nbsp;</td>
    <td align="center" bgcolor="#FFFFFF" width="221"><%out.println(s2);%></td>
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
	<td align="center" bgcolor="#00FF00" width="156">&nbsp;</td>
    <td align="center" bgcolor="#00FF00" width="221">&nbsp;</td>
</tr>


</table>
</form>
</body>
</html>