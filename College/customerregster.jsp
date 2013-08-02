<%@page import ="java.util.*"%>
<%@ include file="Database/connect.jsp" %>

<html>
<body>
<%
     
	      String cname=request.getParameter("cname");
            String pass=request.getParameter("pass");
            String uid=request.getParameter("T1");
            String madd=request.getParameter("S1");
            String padd=request.getParameter("S2");
            String cnoll=request.getParameter("T2");
            String mobile=request.getParameter("T3");
            String email=request.getParameter("T4");
            String dt=request.getParameter("T5");

String ccat="Student";

               

		
		try
		{
			 
			int s1=0,s2=0,s3=0,s4=0,s5=0;
			

		PreparedStatement pst2=connection.prepareStatement("insert into studreg values(?,?,?,?,?,?,?,?,?)");

		pst2.setString(1,cname);
           pst2.setString(2,pass);
           pst2.setString(3,dt);
           pst2.setString(4,pass);
           pst2.setString(5,madd);  
         pst2.setString(6,padd);  
         pst2.setString(7,cnoll);   
        pst2.setString(8,mobile); 
          pst2.setString(9,email);	    
		s2=pst2.executeUpdate();

Statement st=connection.createStatement();

st.executeQuery("insert into  login values('"+cname+"','"+pass+"','"+ccat+"')");




		out.print("CUSTOMER DATA ADDED SUCCESSFULLY");

		}
	  
	catch(SQLException e)
        {
		out.print(e.getMessage());
	    }  

%>
<p><a href="index.html">Back</a></p>

</body>
</html>