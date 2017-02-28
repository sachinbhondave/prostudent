<!DOCTYPE html>
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


<script type="text/javascript">
    function submitform()
    {   debugger;
        document.getElementById("Studentdate").submit(); 
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
    
<form action="admissiondetailsave" method=Post name="Studentdate" id="Studentdate">
<table cellpadding="2" width="70%" bgcolor="99FFFF" align="center"
cellspacing="2">

<center><font size=4><b>Student admission </b></font></center>



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

String executeQueryl="select distinct  (name)  from student s, examresult e ,admissionsave sds " +
"where e.studentid=s.studentid  and s.studentid not in (select studentid from admissionsave)" +
"and e.status='pass' and s.examdate=? "; 
stl= con.prepareStatement(executeQueryl);  
stl.setString(1, one);
rsl=stl.executeQuery();

while(rsl.next()) 
{ 
 all.add(rsl.getString("name"));
}


String Course=(String) request.getAttribute("Course");
String  coursefees=null;
PreparedStatement Courseps =null;	
ResultSet Coursers = null;
String executeCoursersl="SELECT onetime FROM charge where name = ? "; 
Courseps= con.prepareStatement(executeCoursersl);  
Courseps.setString(1, Course);
Coursers=Courseps.executeQuery();

while(Coursers.next()) 
{ 
	coursefees=(Coursers.getString("onetime"));
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
</tr>

</table>

</form>

<form id="myform" name="myform" method="Get" action="admissiondetailsave">

<table>
<tr>
<td>student name</td>
 <td><select Name=studentname  id=studentname >
   <%  for(int i = 0; i < all.size(); i++) {
	   
	   String option1 = (String)all.get(i);
   %>  <option>---
   </option> 
    <option value="<%= option1 %>"><%= option1 %>
   </option>
   <% } 
    %>
</select></td>

</tr>
<tr>

<td>Course</td>
<td><select  Name=Course id=Course > 
<option value="-1" selected>select</option>
<option value="KG">KG</option>
<option value="LKG">LKG</option>
<option value="1">STD-I</option>
<option value="2">STD-II</option>
<option value="3">STD-III</option>
<option value="4">STD-IV</option>
<option value="5">STD-V</option>
<option value="6">STD-VI</option>
<option value="7">STD-VII</option>
<option value="8">STD-VIII</option>
<option value="9">STD-IX</option>
<option value="10">STD-x</option>
</select></td>

</tr>



<tr>
<td>course-paid-fees</td>
<td><input type="text" name="Coursepaidfee" id="Coursepaidfee" size="30" ></td>

</tr>

<tr>
<td>Hobby</td>
<td><input type="text" name="Hobby" id="Hobby" size="30"  ></td>

</tr>


<tr>
<td>image here</td>
<td><input type="submit" name="studentimage" id="studentimage" value="studentsubmit"
size="16" >
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