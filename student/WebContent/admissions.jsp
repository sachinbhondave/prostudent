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


<script type="text/javascript">
    function submitform()
    {   debugger;
        document.getElementById("Studentdate").submit(); 
    }
    
    
    function name_click(){
    value_select = document.getElementById("studentId").value;
    window.location.replace("admissions.jsp?studentId="+value_select);
    alert(value_select);
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
    
<form action="admissiondetailsave" method=Get name="Studentdate" id="Studentdate">
<table cellpadding="2" width="70%" bgcolor="99FFFF" align="center"
cellspacing="2">

<center><font size=4><b>Student admission Process start </b></font></center>



<%

String recordedinsert ="yet_to_insert";

HttpSession session1 = request.getSession();
String name= (String) session.getAttribute("studentName");
if(name!=null)
{
    System.out.println("studentName"+name.toString());
    recordedinsert="Last_inserted_succcessfully"+name.toString()+"ClickNEXT";
}
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

String executeQueryl=" select distinct (e.studentid)  from student s, examresult e ,admissionsave sds " +
		"where e.studentid=s.studentid  and s.studentid not in (select studentid from admissionsave)" +
		"and e.status='pass' and s.examdate=? "; 
stl= con.prepareStatement(executeQueryl);  
stl.setString(1, one);
rsl=stl.executeQuery();

while(rsl.next()) 
{ 
 all.add(rsl.getInt("studentid"));

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

String studentiddata=null;

String  studentnameforid= null;
studentnameforid=(String) request.getParameter("studentId");
System.out.println("dataidasdadad"+studentnameforid);

if  (studentnameforid !=null)
{
    request.setAttribute("studentnameforid",studentnameforid);
 
	int studid=Integer.valueOf(studentnameforid);

PreparedStatement studentnameps =null;	
ResultSet studentnamers = null;
String studentnameq="SELECT name FROM student where studentid = ? "; 
studentnameps= con.prepareStatement(studentnameq);  
studentnameps.setInt(1, studid);
studentnamers=studentnameps.executeQuery();

while(studentnamers.next()) 
{ 
	studentiddata=(studentnamers.getString("name"));
    System.out.println("dataid"+studentiddata);

}
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




<form id="myform" name="myform" action="Cadmission"  method="post" >

<table>
<tr>
<td>studentId</td>
 <td> <select Name=studentId  id=studentId  onchange="name_click(this.value)">
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
<td>student-Name</td>
<td><input type="text" Name=studentName  id=studentName  value="<%=studentiddata %>" >   </td>

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
<td>Hobby</td>
<td><input type="text" name="Hobby" id="Hobby" size="30"  ></td>

</tr>



 <tr>
<td>vaccination Detail</td>
<td><input type="text" name="vaccination" id="vaccination" size="30"  ></td>

</tr> 		 
	
<tr>
<td>Blood Group	 </td>
<td><input type="text" name="Blood" id="Blood" size="30"  ></td>
 <tr>
 
<td>save details</td>
<td> <input type="submit" value="save">
<label id="other"> <%= recordedinsert %> </label>
<td> <input type="hidden" name="success" >

<td> <a href="admisiondetailsave.jsp">NEXT</a>  

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