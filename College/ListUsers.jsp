<%@ include file="../Database/connect.jsp" %>

<html>

<body bgcolor=#FFFFFF >

<table border=0 width="792" style="border-collapse: collapse" bordercolor="#111111" cellpadding="0" cellspacing="0" align="left">
<tr><td bgcolor="#FF6600" width="94"><b>USERNAME</b></td>

  <td bgcolor="#FF6600" width="83"><b>UID</b></td>
  <td bgcolor="#FF6600" width="187"><b>Maddress</b></td>
  <td bgcolor="#FF6600" width="158"><b>PAddress</b></td>
  <td bgcolor="#FF6600" width="78"><b>Land Line</b></td>
  <td bgcolor="#FF6600" width="75"><b>Mobile</b></td>

  <td bgcolor="#FF6600" width="71"><b>Mailid</b></td>
  </tr>





<%
	
      	
	String  s2, s3,s4,s5,s6,cid,s7;

      	try 
	{
           
           String query="select * FROM studreg"; 
           Statement st=connection.createStatement();
           ResultSet rs=st.executeQuery(query);
	   while ( rs.next() )
	   {
		cid=rs.getString(1);
		s2=rs.getString(4);
            s3=rs.getString(5);
		s4=rs.getString(6);
		s5=rs.getString(7);
		s6=rs.getString(8);
		s7=rs.getString(9);

%>

<tr>
	<td bgcolor="#FFFFFF" width="94"><%out.println(cid);%>&nbsp;</td>
    <td bgcolor="#FFFFFF" width="83"><%out.println(s2);%>&nbsp;</td>
    <td bgcolor="#FFFFFF" width="187"><%out.println(s3);%>&nbsp;</td>
    <td bgcolor="#FFFFFF" width="158"><%out.println(s4);%>&nbsp;
 <td bgcolor="#FFFFFF" width="78"><%out.println(s5);%>&nbsp;</td>

 <td bgcolor="#FFFFFF" width="75"><%out.println(s6);%>&nbsp;</td>
 <td bgcolor="#FFFFFF" width="71"><%out.println(s7);%>&nbsp;</td>

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
	<td bgcolor="#FF6600" width="94">&nbsp;</td>
    <td bgcolor="#FF6600" width="83">&nbsp;</td>
    <td bgcolor="#FF6600" width="187">&nbsp;</td>
    <td bgcolor="#FF6600" width="158">&nbsp;<td bgcolor="#FF6600" width="78">&nbsp;</td>

 <td bgcolor="#FF6600" width="75">&nbsp;</td>
 <td bgcolor="#FF6600" width="71">&nbsp;</td>

</tr>


</table>
</form>
<p>&nbsp;</p>
</body>
</html>