<!DOCTYPE html>
<html>
<head>
<title>Aviation School | student Registration</title>
<meta charset="UTF-8" />
<link rel="stylesheet" type="text/css" href="styles/style.css" />
<!-- <script type="text/javascript" src="validate.js"></script> -->
<%@ page import="student.studentJDBCTemplate " %>
<%@ page import= "javax.sql.DataSource" %>
<%@ page import="student.DBconnection " %>

<%@ page import= "java.sql.*" %>
<%@ page import= "java.util.*" %>
<script type="text/javascript">
    function submitform()
    {   debugger;
        document.getElementById("Studentdate").submit(); 
    }
    
    function submitform1()
    {   debugger;
        document.getElementById("studentidform").submit(); 
    }
    </script>
  


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
      <li class="current"><a href="about.jsp">student Registration</a></li>
      <li><a href="admissions.jsp">Admissions</a></li>
      <li><a href="training-courses.jsp">Training Courses</a></li>
      <li><a href="blog.jsp">Student billing</a></li>
      <li><a href="school-calendar.jsp">School Calendar</a></li>
      <li><a href="contact-us.jsp">Contact us</a></li>
      <li><a href="studentsearch.jsp">student search & invoice</a></li>
    </ul>
  </div>
  <div id="content" bgcolor="#E6E6FA">
    <div >
    
<form action="Cadmissionresult" method=Post name="Studentdate" id="Studentdate">
<table cellpadding="2" width="70%" bgcolor="99FFFF" align="center"
cellspacing="2">

<center><font size=4><b>Student admission result entry</b></font></center>
<%

DBconnection hj=new DBconnection();
Connection con= hj.DBcon();
ArrayList al = new ArrayList();
String studentname=null;
String STD=null;

PreparedStatement st=null;
Statement statement = null;
ResultSet rs = null;
String executeQuery="select examdate from student.exam "; 
st= con.prepareStatement(executeQuery);  
rs=st.executeQuery();
while(rs.next()) 
{ 
 al.add(rs.getString("examdate"));

} 


ArrayList all = new ArrayList();


PreparedStatement stl=null;	
ResultSet rsl = null;
String one=(String) request.getAttribute("choose");

String executeQueryl="  select studentid  from student.student s  where  s.examdate = ? and s.studentid  not in (select studentid from examresult ) "; 
stl= con.prepareStatement(executeQueryl);  
stl.setString(1, one);
rsl=stl.executeQuery();

while(rsl.next()) 
{ 
 all.add(rsl.getInt("studentid"));

}




String studentid=null;
String name=null;
String STd =null;
if (!(request.getAttribute("studeetname")==null))
{
	 name =(String)request.getAttribute("studeetname");
	 STd=(String)request.getAttribute("Std");
	 studentid =(String)request.getAttribute("Stno");
}



%>

<tr>
<td> EntranceExam-Date</td>
 <td><select Name=choose id=choose  onchange="submitform(this.value);">
  <option value="select">select
   </option>
   <%  for(int i = 0; i < al.size(); i++) {
           String option = (String)al.get(i);
   %>
  
   <option value="<%= option %>"><%= option %>
   </option>
   <% } 
   
   %>
</select></td>

<td>Student-id</td>
 <td><select Name=studentid  id=studentid  onchange="submitform(this.value); ">
   <%  for(int i = 0; i < all.size(); i++) {
	   
	   Integer option1 = (Integer)all.get(i);
   %>  <option>---
   </option> 
    <option value="<%= option1 %>"><%= option1 %>
   </option>
   <% } 
    %>
</select></td>

</tr>
<tr>

</tr>
</table>
</form>



<br><br>
<form action="Cadmissionresult" method=get name="Studentdata" align="center" >

<table  align="center" cellpadding="3">
<tr>


<td>Name</td>
<td><input type="text" name="studentName" id="studentName"  value =<%=name %>
size="16" disabled></td>

<td>STD</td>
<td><input type="text" name="studentStd" id="studentStd"  value = <%= STd %>
size="16" disabled></td>

<td><input type="hidden" name="studentid"  value =<%=studentid %>  /> </td>

</tr>
<br><br>

<tr>

 <td>marks</td>
<td><input type="text" name="marks" id="marks"  
size="12"></td>

<td>result</td>
<td><input type="text" name="result" id="result"
size="12"></td>
</tr>
<tr align="center">
<td colspan="2"><input type="submit"  name="submitdata" value="submitdata" /></td>
</tr>
</table>
      
 </form>  
      
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