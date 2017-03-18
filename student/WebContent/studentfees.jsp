<!DOCTYPE html>
<%@page import="com.itextpdf.text.log.SysoLogger"%>
<html>
<head>
<title>Aviation School | student Registration</title>
<meta charset="UTF-8" />
<link rel="stylesheet" type="text/css" href="styles/style.css" />
<!-- <script type="text/javascript" src="resoures/p5.js"></script>  -->
 
 
<%@ page import="student.studentJDBCTemplate " %>
<%@ page import= "javax.sql.DataSource" %>
<%@ page import="student.DBconnection " %>
<%@ page import= "java.sql.*" %>
<%@ page import= "java.util.*" %>
<%@ page import ="java.io.File" %>
<%@ page import ="java.io.FileInputStream" %>
<%@ page import ="java.io.IOException" %>
<%@ page import ="java.io.InputStream" %>
<%@ page import ="javax.servlet.http.HttpServlet" %>
<%@ page import ="javax.servlet.http.HttpServletRequest" %>
<%@ page import ="javax.servlet.http.HttpServletResponse" %>
<%@ page import ="javax.servlet.http.Part" %>
<%@ page import ="javax.servlet.http.HttpSession" %>
<%@ page import ="javax.servlet.http.HttpSessionEvent" %>
 


<!--[if IE 6]><link rel="stylesheet" type="text/css" href="styles/ie6.css" /><![endif]-->
</head>
<body bgcolor="#E6E6FA">

<div id="page">
  <div id="header">
    <div id="section">
      <div><a href="index.jsp"><img src="images/images.jpg" alt="" /></a></div>
     <span>Future school <br />
      <br />
      + 9766578770</span> </div>
    <ul>
      <li><a href="index.jsp">Home</a></li>
      <li ><a href="about.jsp">student Registration</a></li>
      <li class="current"> <a href="admissions.jsp">Admissions</a></li>
      <li><a href="training-courses.jsp">Training Courses</a></li>
      <li><a href="blog.jsp">Student billing</a></li>
      <li><a href="school-calendar.jsp">School Calendar</a></li>
      <li><a href="contact-us.jsp">Contact us</a></li>
      <li><a href="studentsearch.jsp">student search & invoice</a></li>
    </ul>
  </div>
  <div id="content" bgcolor="#E6E6FA">
    <div >

<%

String recordedinsert ="yet_to_insert";

HttpSession session1 = request.getSession();
String name= (String) session.getAttribute("BC");
if(name!=null)
{
    System.out.println("studentName"+name.toString());
    recordedinsert="inserted_succcessfully_clickNEXT";
} 

%>

<form id="myform" name="myform" action="admissiondetailsave" enctype="multipart/form-data"  method="Post" >
<center><font size=4><b>Student admission certificate upload </b></font></center>
<table>

<tr>
<td>Birth Certificate</td>
 <td><input type="file" name="photo" size="30"/></td>
</tr>

 	 	 
<tr>
<td>School leaving Certificate</td>
<td><input type="file" name="LC" id="LC" size="30"  ></td>

</tr> 	 	 
 	 	 
<tr>
<td>Address Proof</td>
<td><input type="file" name="AddressProof" id="AddressProof" size="30"  ></td>

</tr> 	

 <tr>
<td>save details</td>
<td> <input type="submit" value="save">

</td>
<label id="other"> <%= recordedinsert %> </label>

<td> <a href="takeimage.jsp">TakePhoto</a>  

</td>

</tr>
</table>

</form>



<br><br>

    </div>
  </div>
  <div id="footer">
    <div>
      <div id="connect"> <a href="#"><img src="images/icon-facebook.gif" alt="" /></a> <a href="#"><img src="images/icon-twitter.gif" alt="" /></a> <a href="#"><img src="images/icon-youtube.gif" alt="" /></a> </div>
      <div class="section">
        <ul>
          <li><a href="index.jsp">Home</a></li>
          <li><a href="about.jsp">student Registration</a></li>
          <li><a href="admissions.jsp">Admissions</a></li>
          <li><a href="training-courses.jsp">Training Courses</a></li>
          <li><a href="career.jsp">Career</a></li>
             <li class="last"><a href="contact-us.jsp">Contact us</a></li>
                   <li><a href="printregistration.jsp">print_registration_student</a></li>
             
          <li class="last"><a href="contact-us.jsp">Contact us</a></li>
        </ul>
      </div>
    </div>
  </div>
</div>




</body>





</html>