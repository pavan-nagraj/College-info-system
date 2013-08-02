<%@ page contentType="text/html; charset=iso-8859-1" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<title>Untitled Document</title>

<style type="text/css">
<!--
.style1 {
	font-size: 24px;
	font-weight: bold;
}
.style2 {
	font-size: 24;
	font-weight: bold;
}
.style3 {
	font-size: 24px;
	color: #FFCC33;
}
.style4 {
	font-family: "Courier New", Courier, mono;
	font-size: 24px;
	color: #FFCC33;
}
body {
	background-image: url(images/lavender_paper.gif);
}
.style6 {
	color: #FFCC33;
	font-weight: bold;
}
.style7 {color: #FFCC33}
-->
</style>
</head>

<body>

<form name="frm" method="post" action="/College/PlacementInsert.jsp">
<h3 align="center" class="style4">&nbsp; </h3>
<h3 align="center" class="style4">PLACEMENT  NOTICE  BOARD</h3>
<p align="center">&nbsp;</p>
<div id="Layer1" style="position:absolute; width:264px; height:224px; z-index:1; left: 228px; top: 107px;">
  <table width="306" border="1">
    <tr>
      <th width="136" height="37" scope="row"><div align="left" class="style6">Company Name: </div></th>
      <th width="154" scope="row">
        <input type="text" name="compname">
      </th>
    </tr>
    <tr>
      <th scope="row"><div align="left" class="style7">Cutoff Percentage: </div></th>
      <th scope="row">
        <input type="text" name="cutoff">
      </th>
    </tr>
    <tr>
      <th scope="row"><div align="left" class="style7">Date of Interview:</div></th>
      <th scope="row"><input type="text" name="date"></th>
    </tr>
    <tr>
      <th scope="row"><div align="left" class="style7">Time of Interview: </div></th>
      <th scope="row"><input type="text" name="time"></th>
    </tr>
    <tr>
      <th scope="row"><div align="left" class="style7">BackLogs : </div></th>
      <th scope="row"><input type="text" name="backlogs"></th>
    </tr>
    <tr>
      <th scope="row"><div align="left" class="style7">Venue:</div></th>
      <th scope="row"><input type="text" name="venue"></th>
    </tr>
  </table>
</div>
<p align="center">&nbsp;</p>
<div id="Layer2" style="position:absolute; width:78px; height:37px; z-index:2; left: 233px; top: 328px;">
  
    <input type="submit" name="Submit" value="Submit">
</div>
<div id="Layer3" style="position:absolute; width:80px; height:38px; z-index:3; top: 323px; left: 325px;">
 
    <input type="reset" name="Reset" value="Reset">
  
</div>
<div id="Layer4" style="position:absolute; width:50px; height:29px; z-index:4; top: 322px; left: 416px;">
  <div align="center" class="style1"><a href="/College/PlacementResult.jsp" class="style7">Next</a></div>
</div>
<div id="Layer6" style="position:absolute; width:85px; height:29px; z-index:6; top: 323px; left: 476px;">
  <div align="center" class="style2"><a href="/College/AdminMenu.htm" class="style3">Back</a></div>
</div>
<div id="Layer5" style="position:absolute; width:0px; height:49px; z-index:5; top: 177px; left: 305px;"></div>
</form>
</body>
</html>

