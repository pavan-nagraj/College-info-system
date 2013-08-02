<%@ page contentType="text/html; charset=iso-8859-1" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<title>Success</title>

<style type="text/css">
<!--
.style1 {
	font-family: Georgia, "Times New Roman", Times, serif;
	font-weight: bold;
	font-size: 18px;
	font-style: italic;
}
body {
	background-image: url(images/yellow_fabric.gif);
}
-->
</style>
</head>
<% String back=request.getParameter("back");
%>
<body>

<p>&nbsp;</p>
<div id="Layer1" style="position:absolute; width:241px; height:115px; z-index:1; left: 261px; top: 60px;">
  <p><strong>Success....</strong></p>
  <p class="style1">Details are Regstered Successfully </p>
  <p class="style1"><a href="<%=back%>">Back</a></p>
</div>
</body>
</html>

