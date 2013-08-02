<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<title>Attendance Entry</title>
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
body {
	background-image: url(images/yellow_paper.gif);
}
.style2 {
	font-size: 24px;
	font-family: "Courier New", Courier, mono;
	font-weight: bold;
}
-->
</style>
</head>

<body>
<h3>&nbsp; </h3>
<div id="Layer4" class="style2" style="position:absolute; width:259px; height:41px; z-index:2; left: 235px; top: 23px;">
  <p>Attendance Details </p>
</div>
<h3>&nbsp; </h3>
<h3>&nbsp;  </h3>
<p>&nbsp;</p>

<form name="form2" method="post" action="InsertAttendance.jsp">
<div id="Layer1" style="position:absolute; width:545px; height:403px; z-index:1; left: 154px; top: 88px;">
  <table width="276" border="0">
    <tr>
      <th width="151" scope="col"><div align="left">Student Name : </div></th>
      <th width="109" scope="col">
        <input type="text" name="sname">
      </th>
    </tr>
    <tr>
      <th scope="col"><div align="left">USN : </div></th>
      <th scope="col">
        <input type="text" name="usn">
      </th>
    </tr>
    <tr>
      <th height="27" scope="col"><div align="left">Semester:</div></th>
      <th scope="col">
        <input type="text" name="sem">
    </th>
    </tr>
    <tr>
      <th height="24" scope="col"><div align="left">Degree: </div></th>
      <th scope="col">
        <input type="text" name="deg">
      </th>
    </tr>
  </table>
  <p>&nbsp;</p>
  <table width="447" border="1">
    <tr>
      <th width="75" scope="row"><div align="left"></div></th>
      <td width="120"><strong>Attended Classes </strong></td>
      <td width="117"><div align="center"><strong>Total Classes </strong></div></td>
      <td width="107"><strong> Required</strong></td>
    </tr>
    <tr>
      <th scope="row"><div align="left"><strong>Subject1</strong></div></th>
      <td>
        <input name="asub1" type="text" size="10">
      </td>
      <td>
        <input name="tsub1" type="text" size="10">
      </td>
      <td>
        <input name="rsub1" type="text" size="10">
      </td>
    </tr>
    <tr>
      <th scope="row"><div align="left"><strong>Subject2</strong></div></th>
      <td>
        <input name="asub2" type="text" size="10">
      </td>
      <td>
        <input name="tsub2" type="text" size="10">
      </td>
      <td>
        <input name="rsub2" type="text" size="10">
      </td>
    </tr>
    <tr>
      <th scope="row"><div align="left"><strong>Subject3</strong></div></th>
      <td>
        <input name="asub3" type="text" size="10">
     </td>
      <td>
        <input name="tsub3" type="text" size="10">
      </td>
      <td>
        <input name="rsub3" type="text" size="10">
     </td>
    </tr>
    <tr>
      <th scope="row"><div align="left"><strong>Subject4</strong></div></th>
      <td>
        <input name="asub4" type="text" size="10">
      </td>
      <td>
        <input name="tsub4" type="text" size="10">
      </td>
      <td>
        <input name="rsub4" type="text" size="10">
      </td>
    </tr>
    <tr>
      <th scope="row"><div align="left"><strong>Subject5</strong></div></th>
      <td>
        <input name="asub5" type="text" size="10">
      </td>
      <td>
        <input name="tsub5" type="text" size="10">
      </td>
      <td>
        <input name="rsub5" type="text" size="10">
      </td>
    </tr>
  </table>
  <p>&nbsp;</p>
  <div id="Layer2" style="position:absolute; width:174px; height:22px; z-index:1; left: 197px; top: 434px;">
    
      <input type="submit" name="Submit" value="Submit">
      <input type="submit" name="Submit" value="Reset"> 
  </div>
  <div id="Layer3" class="style1" style="position:absolute; width:200px; height:54px; z-index:2; left: 338px; top: 424px;"><a href="/College/webpages/AdminHome.htm">Back</a></div>
</div>
</body>
</html>

