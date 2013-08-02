<%@ include file="../Database/connect.jsp" %>

<html>
<body>
<p>&nbsp;</p>
<p>
  <%
   String qid=request.getParameter("T1");
   String soln=request.getParameter("D1");
   String ans=request.getParameter("S1");



Statement st;
ResultSet rs;

int qid1=Integer.parseInt(qid);
	try
	{
		 st=connection.createStatement();
         rs=st.executeQuery("select * from QueryCategory where Qid="+ qid +" ");
		if(rs.next()==true)
		 {
				st.executeUpdate("update QueryCategory set Soln='"+ soln + "',Answer='"+ ans + "' where Qid="+ qid1 +" ");
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
	     response.sendRedirect("ViewQueryDetails.jsp");
%>



</body>
</html>

