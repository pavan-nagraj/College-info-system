<%@ include file="../Database/connect.jsp" %>

<html>
<body>
<p>&nbsp;</p>
<p>
  <%
   String Licid=request.getParameter("T1");
   String soln=request.getParameter("D1");

Statement st;
ResultSet rs;

int Lid=Integer.parseInt(Licid);
	try
	{
		 st=connection.createStatement();
         rs=st.executeQuery("select * from LicenseCategory where LNo="+ Lid +" ");
		if(rs.next()==true)
		 {
				st.executeUpdate("update LicenseCategory set Soln='"+ soln + "' where LNo="+ Lid +" ");
		 }
else 
{

out.print("Can Not Give Solution");
}

	}
	catch(Exception e)
	{
		System.out.print(e);
	}
	     response.sendRedirect("ViewLicenceDetails.jsp");
%>



</body>
</html>

