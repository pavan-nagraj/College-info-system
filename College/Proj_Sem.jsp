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
.style1 {font-size: 18px}
.style2 {
	font-family: "Courier New", Courier, mono;
	font-size: 24px;
}
.style3 {
	font-size: 24px;
	font-weight: bold;
	color: #FF0066;
}
body {
	background-image: url(images/tan_paper.gif);
}
.style4 {font-family: "Courier New", Courier, mono; font-size: 24px; color: #FF0066; }
.style5 {
	color: #FF0033;
	font-weight: bold;
	font-size: 16px;
}
.style8 {color: #FF0066}
.style9 {color: #FF0066; font-weight: bold; }
-->
</style>
</head>

<body>
<form name="form1" method="post" action="/College/Proj_Sem_Insert.jsp">
<h3 align="center" class="style4">PROJECT/SEMINAR DETAILS</h3>
<p align="center" class="style2">&nbsp;</p>
<div id="Layer1" style="position:absolute; width:297px; height:154px; z-index:1; left: 211px; top: 85px;">
  <table width="296">
    <tr>
      <th width="119" scope="row"><div align="left" class="style5"><span class="style8">Student's Name</span>:</div></th>
      <td width="161">
        <input type="text" name="sname">
     </td>
    </tr>
    <tr>
      <th scope="row"><div align="left" class="style9">USN:</div></th>
      <td>
        <input type="text" name="usn">
      </td>
    </tr>
    <tr>
      <th scope="row"><div align="left" class="style8"><strong>Project Title: </strong></div></th>
      <td>
        <input type="text" name="ptitle">
      </td>
    </tr>
    <tr>
      <th scope="row"><div align="left" class="style8"><strong> Date: </strong></div></th>
      <td>
        <input type="text" name="sdate">
     </td>
    </tr>
    <tr>
      <th scope="row"><div align="left" class="style8">Time:</div></th>
      <td>
        <input type="text" name="time">
      </td>
    </tr>
    <tr>
      <th scope="row"><div align="left" class="style8"><strong>Platform:</strong></div></th>
      <td>
        <input type="text" name="platform">
      </td>
    </tr>
  </table>
</div>
<p>&nbsp;</p>
<p>&nbsp;</p>
<div id="Layer2" class="style1" style="position:absolute; width:51px; height:3px; z-index:2; left: 259px; top: 286px;">
  
    <input type="submit" name="Submit" value="Submit">
</div>
<div id="Layer3" class="style1" style="position:absolute; width:50px; height:27px; z-index:3; top: 286px; left: 331px;">
  <form name="form2" method="post" action="">
    <input type="reset" name="Reset" value="Reset">
</div>

</body>
</html>

