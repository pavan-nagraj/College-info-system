<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<span style="background-color: #FFFF00">&nbsp;</span><i><u><b><font size="6"><span style="background-color: #FFFF00">Solution 
Provider</span></font></b></u></i></p>
<p>&nbsp;</p>
<form method="POST" action="SolnStatus.jsp">
    <center>
    <table border="0" cellpadding="0" cellspacing="0" style="border-collapse: collapse" bordercolor="#111111" width="47%" id="AutoNumber1">
      <tr>
        <td width="18%">SId</td>
        <td width="82%"><input type="text" name="T1"  value="<%=request.getParameter("Qid")%>" size="20"></td>
      </tr>
      <tr>
        <td width="18%">Solution</td>
        <td width="82%"><select size="1" name="D1">
        <option>Accepted</option>
        <option>Rejected</option>
        </select></td>
      </tr>
      <tr>
        <td width="18%">Answer</td>
        <td width="82%"><p><textarea rows="4" name="S1" cols="20"></textarea></td>
      </tr>
      <tr>
        <td width="18%">&nbsp;</td>
        <td width="82%"><input type="submit" value="Submit" name="B1"><input type="reset" value="Reset" name="B2"></td>
      </tr>
    </table>
    </center>
  </div>
</form>
<p>&nbsp;</p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </p>
<p>&nbsp;</p>