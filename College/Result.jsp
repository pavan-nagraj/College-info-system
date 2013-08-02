<%@page import ="java.util.*"%>
<%@ include file="Database/connect.jsp" %>

<html>
<body>
<%
     
	    String usn=request.getParameter("T1");
            String per=request.getParameter("T2");
            String result=request.getParameter("T3");


               

		
		try
		{
			 
			int s1=0,s2=0,s3=0,s4=0,s5=0;
			

		PreparedStatement pst2=connection.prepareStatement("insert into Result values(?,?,?)");

		pst2.setString(1,usn);
           pst2.setString(2,per);
           pst2.setString(3,result);
               
		pst2.executeUpdate();

Statement st=connection.createStatement();






		out.print("RESULT DATA ADDED SUCCESSFULLY");

		}
	  
	catch(SQLException e)
        {
		out.print(e.getMessage());
	    }  

%>

</body>
</html>