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
.style4 {font-size: 24px}
.style5 {font-size: 18px}
body {
	background-image: url(images/blue_paper.gif);
}
.style6 {
	font-size: 24px;
	font-family: "Courier New", Courier, mono;
	font-weight: bold;
}
-->
</style>
</head>

<body>
 <form name="form1" method="post" action="/College/webpages/InsertInternalMarks.jsp">
<p align="center" class="style6"> Internal Marks </p>
<p align="center" class="style4">&nbsp;</p>
<div id="Layer9" style="position:absolute; width:757px; height:178px; z-index:9; left: 146px; top: 229px;">
  
 
  <table width="577" border="1">
    <tr>
      <th width="92" scope="row">&nbsp;</th>
      <td width="129">I Internal Marks </td>
      <td width="130"><div align="center">II Internal Marks </div></td>
      <td width="125"><div align="center">III Internal Marks </div></td>
      <td width="190">Max Marks </td>
      </tr>
    <tr>
      <th scope="row"><div align="left">Subject1:</div></th>
      <td>
        <input name="s1first" type="text" size="15">
</td>
      <td><input name="s1second" type="text" size="15"></td>
      <td><input name="s1third" type="text" size="15"></td>
      <td><input name="s1max" type="text" size="15"></td>
      </tr>
    <tr>
      <th scope="row"><div align="left">Subject2:</div></th>
      <td><input name="s2first" type="text" size="15"></td>
      <td><input name="s2second" type="text" size="15"></td>
      <td><input name="s2third" type="text" size="15"></td>
      <td><input name="s2max" type="text" size="15"></td>
      </tr>
    <tr>
      <th scope="row"><div align="left">Subject3:</div></th>
      <td><input name="s3first" type="text" size="15"></td>
      <td><input name="s3second" type="text" size="15"></td>
      <td><input name="s3third" type="text" size="15"></td>
      <td><input name="s3max" type="text" size="15"></td>
      </tr>
    <tr>
      <th scope="row"><div align="left">Subject4:</div></th>
      <td><input name="s4first" type="text" size="15"></td>
      <td><input name="s4second" type="text" size="15"></td>
      <td><input name="s4third" type="text" size="15"></td>
      <td><input name="s4max" type="text" size="15"></td>
      </tr>
    <tr>
      <th scope="row"><div align="left">Subject5:</div></th>
      <td><input name="s5first" type="text" size="15"></td>
      <td><input name="s5second" type="text" size="15"></td>
      <td><input name="s5third" type="text" size="15"></td>
      <td><input name="s5max" type="text" size="15"></td>
      </tr>
  </table>
</div>
<div id="Layer10" style="position:absolute; width:118px; height:49px; z-index:10; top: 440px; left: 457px;">
  
    <input type="reset" name="Reset" value="Reset">
  
</div>
<div id="Layer10" style="position:absolute; width:64px; height:24px; z-index:10; top: 439px; left: 391px;">
  
    <input type="submit" name="Submit" value="Submit">
</div>
<div id="Layer11" style="position:absolute; width:60px; height:18px; z-index:11; left: 515px; top: 441px;"><a href="/College/webpages/AdminHome.htm" class="style5">Back</a></div>
<div id="Layer1" style="position:absolute; width:457px; height:149px; z-index:12; left: 204px; top: 50px;">
  <table width="309">
    <tr>
      <th width="137" scope="row"><div align="left">Student's Name: </div></th>
      <td width="156">
        <input type="text" name="sname">
      </td>
    </tr>
    <tr>
      <th scope="row"><div align="left">Usn:</div></th>
      <td>
        <input type="text" name="usn">
      </td>
    </tr>
    <tr>
      <th scope="row"><div align="left">Semester:</div></th>
      <td>
        <input type="text" name="sem">
      </td>
    </tr>
    <tr>
      <th height="40" scope="row"><div align="left">Degree:</div></th>
      <td>
        <input type="text" name="deg">
      </td>
    </tr>
  </table>
</div></form>
</body>
</html>

