<%@ page contentType="text/html; charset=iso-8859-1" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<title>Untitled Document</title>
<script language="JavaScript" type="text/JavaScript">
<!--
function MM_reloadPage(init) {  //reloads the window if Nav4 resized
  if (init==true) with (navigator) {if ((appName=="Netscape")&&(parseInt(appVersion)==4)) {
    document.MM_pgW=innerWidth; document.MM_pgH=innerHeight; onresize=MM_reloadPage; }}
  else if (innerWidth!=document.MM_pgW || innerHeight!=document.MM_pgH) location.reload();
}
MM_reloadPage(true);
//-->
</script>
<style type="text/css">
<!--
.style2 {
	font-family: "Courier New", Courier, mono;
	font-size: 24px;
	color: #00FFCC;
}
body {
	background-image: url(images/gray_aluminum.gif);
}
.style3 {
	font-family: "Courier New", Courier, mono;
	font-size: 24px;
	color: #00FFCC;
	font-weight: bold;
}
.style5 {color: #00FFCC}
-->
</style>
</head>

<body>
<form name="form2" method="post" action="/College/webpages/InsertExamDetails.jsp">
<div align="center">
  <p>&nbsp;</p>
  <div id="Layer2" class="style2" style="position:absolute; width:76px; height:37px; z-index:2; left: 223px; top: 339px;">
    
      <input type="submit" name="Submit" value="Submit">
   
  </div>
  <div id="Layer4" class="style2" style="position:absolute; width:74px; height:26px; z-index:4; left: 434px; top: 342px;"><a href="/College/webpages/AdminHome.htm"><strong>Back</strong></a></div>
  <div id="Layer3" class="style2" style="position:absolute; width:62px; height:43px; z-index:3; left: 314px; top: 337px;">
    
      <input type="reset" name="Reset" value="Reset">
    
  </div>
  <p class="style3">EXAMINATION   TIME   TABLE</p>
  <div id="Layer1" style="position:absolute; width:524px; height:217px; z-index:1; left: 71px; top: 82px;">  
    <p>&nbsp;</p>
    <table width="352" height="170" border="1">
      <tr>
        <th width="172" scope="row"><div align="left" class="style5">Exam Fee : </div></th>
        <td width="212">
          <input type="text" name="examfees">
        </td>
      </tr>
      <tr>
        <th scope="row"><div align="left" class="style5">Last Date : </div></th>
        <td>
          <input type="text" name="lastdate">
          (Please enter in the format 13/Jun/2005 ) </td>
      </tr>
      <tr>
        <th scope="row"><div align="left" class="style5">Date of Examination: </div></th>
        <td>
          <input type="text" name="examdate">
        </td>
      </tr>
      <tr>
        <th scope="row"><div align="left" class="style5">Time of Examination: </div></th>
        <td>
          <input type="text" name="time">
        </td>
      </tr>
      <tr>
        <th scope="row"><div align="left" class="style5">Examination Center: </div></th>
        <td>
          <input type="text" name="center">
        </td>
      </tr>
    </table>
    <p>&nbsp;</p>
  </div>
  <p>&nbsp;</p>
</div>
</form>
</body>
</html>

