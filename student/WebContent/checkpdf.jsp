<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%@ page import="student.studentJDBCTemplate" %>
<%@ page import= "javax.sql.DataSource" %>
<%@ page import= "java.sql.*" %>
<%@ page import= "java.util.*" %>
<%@ page import= "student.studentvo" %> 


</head>




<form action="Ccheckpdf" method=Post name="Studentchkpdf">
<body bgcolor="silver" font-color="red">
<table>

<h3  style=" color:blue;">Enter student ID</h3> 
<td  style=" color:blue;"><B>StudentID</B></td>
<td  style=" color:blue;"><input type="text" name="studentid" id="studentid" size="15"></td>
</tr>
<tr>
<td  style=" color:blue;"><B>checkPDF</B></td>
<td colspan="2"  style=" color:blue;"><input type="submit"  /></td>
</tr>
</table>
   
   
<a href="printregistration.jsp"><h4 style=" color:blue;" >GO Back.</h4></a>
<table>

<h3  style=" color:blue;">Enter student ID for delete</h3> 
<td  style=" color:blue;"><B>StudentID</B></td>
<td  style=" color:blue;"><input type="text" name="studentiddelete" id="studentiddelete" size="15"></td>
</tr>
<tr>
<td  style=" color:blue;"><B>StudentDelete</B></td>
<td colspan="2"  style=" color:blue;"><input type="submit" /></td>
</tr>
</table>

<table border='0' width='480px' cellpadding='0' cellspacing='0' align='center'> 
<th><h3  style=" color:blue;">Registration data</h3></th>


<tr>
    <td align='center'>Name:</td>
    <td>"<%= request.getAttribute("Name") %>"</td>
</tr>
<tr> <td>&nbsp;</td> </tr>
<tr>
    <td align='center'>father:</td>
    <td>"<%= request.getAttribute("father") %>"</td>
</tr>
<tr> <td>&nbsp;</td> </tr>
<tr>
    <td align='center'>city:</td>
    <td>"<%= request.getAttribute("city") %>"</td>
</tr>
<tr> <td>&nbsp;</td> </tr>
<tr>
    <td align='center'>Address:</td>
    <td>"<%= request.getAttribute("adress") %>"</td>
</tr>
<tr> <td>&nbsp;</td> </tr>
<tr>
    <td align='center'>course:</td>
    <td>"<%= request.getAttribute("course") %>"</td>
</tr>
<tr> <td>&nbsp;</td> </tr>
<tr>
    <td align='center'>Email:</td>
    <td>"<%= request.getAttribute("contact") %>"</td>
</tr>
<tr> <td>&nbsp;</td> </tr>
<tr>
    <td align='center'>Fees:</td>
    <td>"<%= request.getAttribute("fess") %>"</td>
</tr>
<tr> <td>&nbsp;</td> </tr>

</table>

</table>
</body>
</form>

</html>