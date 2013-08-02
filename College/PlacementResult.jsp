<%@ page contentType="text/html; charset=iso-8859-1" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<title>Placement Results</title>

<style type="text/css">
<!--
.style1 {font-size: 18px}
.style2 {
	font-size: 16px;
	font-weight: bold;
}
.style3 {font-size: 16px; }
body {
	background-image: url(images/teal_paper.gif);
}
.style4 {
	font-family: "Courier New", Courier, mono;
	font-size: 24px;
}
-->
</style>
</head>
<script language="JavaScript" >
function checkval()
{
   if((frm.compname.value).length==0)
   {
     alert(" Enter Name of the Company");
	 frm.compname.focus();
	 return false;
   }
   if((frm.studname.value).length==0)
   {
     alert(" Enter Name of Student");
	 frm.studname.focus();
	 return false;
   }
   if((frm.studselect.value).length ==0)
   {
     alert("Enter no of students selected ");
	 frm.studselect.focus();
	 return false;
	}
	if((frm.offer.value).length ==0)
	{
	 alert("enter offer details");
	 frm.offer.focus();
	 return false;
	}
   if((frm.info.value).length==0)
   {
   alert("Enter Information about Company");
   frm.info.focus();
   return false;
   }
        return true;
  }


</script>

<body>
<form name="frm" method="post" action="/College/ResultsInsert.jsp" onSubmit="return checkval()">
<h3 align="center">&nbsp;</h3>
<h3 align="center" class="style4">PLACEMENT  RESULTS</h3>
<p align="center" class="style4">&nbsp;</p>
<div id="Layer1" style="position:absolute; width:444px; height:190px; z-index:1; left: 244px; top: 109px;">
  <table width="383" height="164">
    <tr>
      <th width="190" height="30" scope="col"><div align="left" class="style3">Company Name:</div></th>
      <th width="191" scope="col"><div align="left">
      
          <input type="text" name="compname">
        
      </div></th>
    </tr>
    <tr>
      <td height="30"><span class="style2">Student's Name: </span></td>
      <td>
        <input type="text" name="studname">
     </td>
    </tr>
    <tr>
      <td height="30"><span class="style2">No.Of Students Selected: </span></td>
      <td>
        <input type="text" name="studselect">
      </td>
    </tr>
    <tr>
      <td height="30"><span class="style2">Offer Letter Details: </span></td>
      <td>
        <input type="text" name="offer">
     </td>
    </tr>
    <tr>
      <td height="30"><span class="style2">Information about Company : </span></td>
      <td>
        <input type="text" name="info">
      </td>
    </tr>
  </table>
  <table width="383" height="38">
    <tr>
      <td width="185" height="30"><span class="style2">USN : </span></td>
      <td width="186"><input type="text" name="usn">
      </td>
    </tr>
  </table>
</div>
<div id="Layer4" class="style1" style="position:absolute; width:48px; height:29px; z-index:3; left: 514px; top: 311px;"><a href="/College/Adminmenu.htm">Back</a></div>
<div id="Layer2" style="position:absolute; width:77px; height:41px; z-index:2; left: 396px; top: 329px;">
  <div id="Layer3" style="position:absolute; width:55px; height:26px; z-index:1; left: -108px; top: -4px;">
    
      <input type="submit" name="Submit" value="Submit">
    
  </div>
  
    <input type="reset" name="Reset" value="Reset">
 
</div>
<p align="center">&nbsp;</p> </form>
</body>
</html>

