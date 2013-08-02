<%@ page language="java" %>
<HTml>
<HEAD><TITLE>Display file upload form to the user</TITLE></HEAD>  
  <BODY> 


<FORM  ENCTYPE="multipart/form-data" ACTION="upload.jsp" METHOD=POST>
		
		
		
		<br><br><br>
	  <center><table border="2" >
                    <tr><center><td colspan="2"><p align=
"center"><B>UPLOADING THE MATERIAL</B><center>
                      <p></p>
                      </td></tr>
                    <tr><td><b>Choose the file To Upload:</b>
</td>
                    <td><INPUT NAME="F1" TYPE="file" size="20"></td></tr>
					<tr><td colspan="2">
<p align="right"><INPUT TYPE="submit" VALUE="Send File" ></p></td></tr>
             <table>
     </center>      
     </FORM>
  <p align="right">&nbsp;</p>
  <p align="right">&nbsp;</p>
  </BODY>
</HTML>