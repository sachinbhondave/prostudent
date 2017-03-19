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

DBconnection hj=new DBconnection();
Connection con= hj.DBcon();
ArrayList alname = new ArrayList();


PreparedStatement stname=null;
Statement statementname = null;
ResultSet rsname = null;
String executeQueryname="select distinct (name) from student.charge "; 
stname= con.prepareStatement(executeQueryname);  
rsname=stname.executeQuery();
while(rsname.next()) 
{ 
	alname.add(rsname.getString("name"));

} 


ArrayList alfeetype= new ArrayList();


PreparedStatement stfeetype=null;
Statement statementfeetype = null;
ResultSet rsfeetype = null;
String executeQueryfeetype="select distinct (feetype) from student.charge "; 
stfeetype= con.prepareStatement(executeQueryfeetype);  
rsfeetype=stfeetype.executeQuery();
while(rsfeetype.next()) 
{ 
	alfeetype.add(rsfeetype.getString("feetype"));

} 


ArrayList alrate = new ArrayList();

PreparedStatement strate=null;
Statement statementrate = null;
ResultSet rsrate = null;
String executeQueryrate="select distinct (rate) from student.charge "; 
strate= con.prepareStatement(executeQueryrate);  
rsrate=strate.executeQuery();
while(rsrate.next()) 
{ 
	alrate.add(rsrate.getString("rate"));

} 
 
ArrayList alFrequency = new ArrayList();


PreparedStatement stFrequency=null;
Statement statementFrequency = null;
ResultSet rsFrequency = null;
String executeQueryFrequency="select distinct (Frequency) from student.charge "; 
stFrequency= con.prepareStatement(executeQueryFrequency);  
rsFrequency=stFrequency.executeQuery();
while(rsFrequency.next()) 
{ 
	alFrequency.add(rsFrequency.getString("Frequency"));

} 


ArrayList alDiscount = new ArrayList();
String studentnameDiscount=null;
String STDDiscount=null;

PreparedStatement stDiscount=null;
Statement statementDiscount = null;
ResultSet rsDiscount = null;
String executeQueryDiscount="select distinct (Discount) from student.charge "; 
stDiscount= con.prepareStatement(executeQueryDiscount);  
rsDiscount=stDiscount.executeQuery();
while(rsDiscount.next()) 
{ 
	alDiscount.add(rsDiscount.getString("Discount"));

} 
%>

<form id="myformnew" name="myformnnew" action="admissiondetailfinalsave" method="Post" >
<center><font size=4><b>Student admission Fees structure </b></font></center>
<table>

<tr>
<td><B>Fee name</B> </td>
<td><b>Fee TYPE</b> </td>
<td><b>Fee Rate </b></td>
<td><b>Fee Frequency</b> </td>
<td><b>Fee Discount</b> </td>
</tr>

 <tr>
 <td> <select Name=name  id=name  >
   <%  for(int i = 0; i < alname.size(); i++) {
	   
	   String option1 = (String)alname.get(i);
   %>  <option>
   </option> 
    <option value="<%= option1 %>"><%= option1 %>
   </option>
   <% } 
    %>
</select></td>
 <td> <select Name=alfeetype  id=alfeetype  >
   <%  for(int i = 0; i < alfeetype.size(); i++) {
	   
	   String option1 = (String)alfeetype.get(i);
   %>  <option>
   </option> 
    <option value="<%= option1 %>"><%= option1 %>
   </option>
   <% } 
    %>
</select></td>
 <td> <select Name=alrate  id=alrate  >
   <%  for(int i = 0; i < alrate.size(); i++) {
	   
	   String option1 = (String)alrate.get(i);
   %>  <option>
   </option> 
    <option value="<%= option1 %>"><%= option1 %>
   </option>
   <% } 
    %>
</select></td>
 <td> <select Name=alFrequency  id=alFrequency  >
   <%  for(int i = 0; i < alFrequency.size(); i++) {
	   
	   String option1 = (String)alFrequency.get(i);
   %>  <option>
   </option> 
    <option value="<%= option1 %>"><%= option1 %>
   </option>
   <% } 
    %>
</select></td>


 <td> <select Name=alDiscount  id=alDiscount  >
   <%  for(int i = 0; i < alDiscount.size(); i++) {
	   
	   String option1 = (String)alDiscount.get(i);
   %>  <option>
   </option> 
    <option value="<%= option1 %>"><%= option1 %>
   </option>
   <% } 
    %>
</select></td>
</tr>
  
 
 <tr>
 <td> <select Name=name1  id=name1  >
   <%  for(int i = 0; i < alname.size(); i++) {
	   
	   String option1 = (String)alname.get(i);
   %>  <option>
   </option> 
    <option value="<%= option1 %>"><%= option1 %>
   </option>
   <% } 
    %>
</select></td>
 <td> <select Name=alfeetype1  id=alfeetype1  >
   <%  for(int i = 0; i < alfeetype.size(); i++) {
	   
	   String option1 = (String)alfeetype.get(i);
   %>  <option>
   </option> 
    <option value="<%= option1 %>"><%= option1 %>
   </option>
   <% } 
    %>
</select></td>
 <td> <select Name=alrate1  id=alrate1  >
   <%  for(int i = 0; i < alrate.size(); i++) {
	   
	   String option1 = (String)alrate.get(i);
   %>  <option>
   </option> 
    <option value="<%= option1 %>"><%= option1 %>
   </option>
   <% } 
    %>
</select></td>
 <td> <select Name=alFrequency1  id=alFrequency1  >
   <%  for(int i = 0; i < alFrequency.size(); i++) {
	   
	   String option1 = (String)alFrequency.get(i);
   %>  <option>
   </option> 
    <option value="<%= option1 %>"><%= option1 %>
   </option>
   <% } 
    %>
</select></td>


 <td> <select Name=alDiscount1  id=alDiscount1  >
   <%  for(int i = 0; i < alDiscount.size(); i++) {
	   
	   String option1 = (String)alDiscount.get(i);
   %>  <option>
   </option> 
    <option value="<%= option1 %>"><%= option1 %>
   </option>
   <% } 
    %>
</select></td>
</tr>
   
 
 
  <tr>
 <td> <select Name=name2  id=name2  >
   <%  for(int i = 0; i < alname.size(); i++) {
	   
	   String option1 = (String)alname.get(i);
   %>  <option>
   </option> 
    <option value="<%= option1 %>"><%= option1 %>
   </option>
   <% } 
    %>
</select></td>
 <td> <select Name=alfeetype2  id=alfeetype2  >
   <%  for(int i = 0; i < alfeetype.size(); i++) {
	   
	   String option1 = (String)alfeetype.get(i);
   %>  <option>
   </option> 
    <option value="<%= option1 %>"><%= option1 %>
   </option>
   <% } 
    %>
</select></td>
 <td> <select Name=alrate2  id=alrate2  >
   <%  for(int i = 0; i < alrate.size(); i++) {
	   
	   String option1 = (String)alrate.get(i);
   %>  <option>
   </option> 
    <option value="<%= option1 %>"><%= option1 %>
   </option>
   <% } 
    %>
</select></td>
 <td> <select Name=alFrequency2  id=alFrequency2  >
   <%  for(int i = 0; i < alFrequency.size(); i++) {
	   
	   String option1 = (String)alFrequency.get(i);
   %>  <option>
   </option> 
    <option value="<%= option1 %>"><%= option1 %>
   </option>
   <% } 
    %>
</select></td>


 <td> <select Name=alDiscount2  id=alDiscount2  >
   <%  for(int i = 0; i < alDiscount.size(); i++) {
	   
	   String option1 = (String)alDiscount.get(i);
   %>  <option>
   </option> 
    <option value="<%= option1 %>"><%= option1 %>
   </option>
   <% } 
    %>
</select></td>
</tr>

 <tr>
 <td> <select Name=name3  id=name3  >
   <%  for(int i = 0; i < alname.size(); i++) {
	   
	   String option1 = (String)alname.get(i);
   %>  <option>
   </option> 
    <option value="<%= option1 %>"><%= option1 %>
   </option>
   <% } 
    %>
</select></td>
 <td> <select Name=alfeetype3  id=alfeetype3  >
   <%  for(int i = 0; i < alfeetype.size(); i++) {
	   
	   String option1 = (String)alfeetype.get(i);
   %>  <option>
   </option> 
    <option value="<%= option1 %>"><%= option1 %>
   </option>
   <% } 
    %>
</select></td>
 <td> <select Name=alrate3  id=alrate3  >
   <%  for(int i = 0; i < alrate.size(); i++) {
	   
	   String option1 = (String)alrate.get(i);
   %>  <option>
   </option> 
    <option value="<%= option1 %>"><%= option1 %>
   </option>
   <% } 
    %>
</select></td>
 <td> <select Name=alFrequency3  id=alFrequency3  >
   <%  for(int i = 0; i < alFrequency.size(); i++) {
	   
	   String option1 = (String)alFrequency.get(i);
   %>  <option>
   </option> 
    <option value="<%= option1 %>"><%= option1 %>
   </option>
   <% } 
    %>
</select></td>


 <td> <select Name=alDiscount3  id=alDiscount3  >
   <%  for(int i = 0; i < alDiscount.size(); i++) {
	   
	   String option1 = (String)alDiscount.get(i);
   %>  <option>
   </option> 
    <option value="<%= option1 %>"><%= option1 %>
   </option>
   <% } 
    %>
</select></td>
</tr>
    
  <tr>
 <td> <select Name=name4  id=name4  >
   <%  for(int i = 0; i < alname.size(); i++) {
	   
	   String option1 = (String)alname.get(i);
   %>  <option>
   </option> 
    <option value="<%= option1 %>"><%= option1 %>
   </option>
   <% } 
    %>
</select></td>
 <td> <select Name=alfeetype4  id=alfeetype4  >
   <%  for(int i = 0; i < alfeetype.size(); i++) {
	   
	   String option1 = (String)alfeetype.get(i);
   %>  <option>
   </option> 
    <option value="<%= option1 %>"><%= option1 %>
   </option>
   <% } 
    %>
</select></td>
 <td> <select Name=alrate4  id=alrate4  >
   <%  for(int i = 0; i < alrate.size(); i++) {
	   
	   String option1 = (String)alrate.get(i);
   %>  <option>
   </option> 
    <option value="<%= option1 %>"><%= option1 %>
   </option>
   <% } 
    %>
</select></td>
 <td> <select Name=alFrequency4  id=alFrequency4  >
   <%  for(int i = 0; i < alFrequency.size(); i++) {
	   
	   String option1 = (String)alFrequency.get(i);
   %>  <option>
   </option> 
    <option value="<%= option1 %>"><%= option1 %>
   </option>
   <% } 
    %>
</select></td>


 <td> <select Name=alDiscount4  id=alDiscount4  >
   <%  for(int i = 0; i < alDiscount.size(); i++) {
	   
	   String option1 = (String)alDiscount.get(i);
   %>  <option>
   </option> 
    <option value="<%= option1 %>"><%= option1 %>
   </option>
   <% } 
    %>
</select></td>
</tr>
  
 <tr>
 
<td>save details</td>
<td> <input type="submit" value="save">
 </td>
 <td> <a href="takeimage.jsp">back</a>  

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