<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
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
</head>

<body>
<h3>ATTENDANCE REGISTRATION FOR COMPUTER SCIENCE DEPARTMENT</h3>
<p>&nbsp;</p>
<div id="Layer1" style="position:absolute; width:545px; height:403px; z-index:1; left: 130px; top: 67px;">
  <table width="276" border="0">
    <tr>
      <th width="151" scope="col"><div align="left">Student Name : </div></th>
      <th width="109" scope="col">
        <input type="text" name="textfield">
      </th>
    </tr>
    <tr>
      <th scope="col"><div align="left">USN : </div></th>
      <th scope="col">
        <input type="text" name="textfield">
      </th>
    </tr>
    <tr>
      <th height="27" scope="col"><div align="left">Semester:</div></th>
      <th scope="col"><form name="form1" method="post" action="">
        <input type="text" name="textfield">
      </form></th>
    </tr>
    <tr>
      <th scope="col"><div align="left">Department : </div></th>
      <th scope="col">
        <input type="text" name="textfield">
      </th>
    </tr>
  </table>
  <p>&nbsp;</p>
  <table width="501" border="1">
    <tr>
      <th width="82" scope="col"><div align="left"></div></th>
      <th width="86" scope="col"><div align="left">Total class </div></th>
      <th width="71" scope="col"><div align="right">Attended </div></th>
      <th width="73" scope="col">Required</th>
      <th width="75" scope="col">Obtained</th>
      <th width="74" scope="col">Remarks</th>
    </tr>
    <tr>
      <th scope="row"><div align="left">Subject1:</div></th>
      <td>45</td>
      <td>35</td>
      <td>35</td>
      <td>30</td>
      <td>k</td>
    </tr>
    <tr>
      <th scope="row"><div align="left">Subject2:</div></th>
      <td>45</td>
      <td>35</td>
      <td>35</td>
      <td>30</td>
      <td>k</td>
    </tr>
    <tr>
      <th scope="row"><div align="left">Subject3:</div></th>
      <td>45</td>
      <td>35</td>
      <td>35</td>
      <td>30</td>
      <td>k</td>
    </tr>
    <tr>
      <th scope="row"><div align="left">Subject4:</div></th>
      <td>45</td>
      <td>35</td>
      <td>35</td>
      <td>30</td>
      <td>k</td>
    </tr>
  </table>
  <div id="Layer2" style="position:absolute; width:174px; height:22px; z-index:1; left: 190px; top: 343px;">
    <form name="form2" method="post" action="InsertAttendance.jsp">
      <input type="submit" name="Submit" value="Register">
      <input type="submit" name="Submit" value="Reset">    
    </form>
  </div>
</div>
</body>
</html>

