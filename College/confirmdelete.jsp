<%@ page import="java.sql.*"%>

<html>
<style type="text/css">
<!--
.style1 {color: #FF00FF}
-->
</style>
<body>

<%
	
    


      String fid=request.getParameter("Fid");


         int id=Integer.parseInt(fid);

           Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
           Connection con = DriverManager.getConnection("jdbc:odbc:mobile");
           
           String query="delete  from UploadedFile where fid="+id+" "; 
          


 PreparedStatement pst=con.prepareStatement(query);

                   pst.executeUpdate();



out.println("File Deleted Successfully");



%>





</body>
</html>









   