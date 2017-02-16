<!DOCTYPE html>
<%@page import="com.itextpdf.text.log.SysoLogger"%>
<html>
<head>
<title>Aviation School | student Registration</title>
<meta charset="UTF-8" />
<link rel="stylesheet" type="text/css" href="styles/style.css" />
<script type="text/javascript" src="validate.js"></script>
<%@ page import="student.studentJDBCTemplate" %>
<%@ page import= "javax.sql.DataSource" %>
<%@ page import= "java.sql.*" %>
<%@ page import= "java.util.*" %>
<%@ page import= "student.studentvo" %> 

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
 
 <form action="Cstudentregistrationdetails" method=Post name="Studentreg">
  
  <div id="content" bgcolor="#E6E6FA">
    <div >
    
   <%
   ArrayList<Integer> al=new ArrayList<Integer>();
   ArrayList<String> alname=new ArrayList<String>();
   ArrayList<String> alexamdate=new ArrayList<String>();
   ArrayList<String> alfees=new ArrayList<String>();
 

String reg_fee="";
Properties properties = new Properties();
properties.setProperty("user", "root");
properties.setProperty("password", "sachin");
properties.setProperty("useSSL", "false");
properties.setProperty("autoReconnect", "true");
 
Connection connection = null;
Statement statement = null;
ResultSet rs1 = null;
ResultSet rs2 = null;

  try
  {
Class.forName("com.mysql.jdbc.Driver"); 
  }
  catch(Exception e)
  {
	  e.fillInStackTrace();
  }
  
java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student",properties); 
PreparedStatement st=null;
PreparedStatement st1=null;

String executeQuery1="SELECT jk.studentid,jk.name,jk.examdate,jk.reg_fees FROM student jk WHERE jk.studentid ORDER BY jk.studentid DESC limit 5 "; 

st= con.prepareStatement(executeQuery1);  

rs1=st.executeQuery();


while(rs1.next()) 
{ 
 al.add(rs1.getInt("studentid"));
 alname.add(rs1.getString("name"));
 alexamdate.add(rs1.getString("examdate"));
 alfees.add(rs1.getString("reg_fees"));


} 
  
int option23232 =al.get(0);

con.close();
%>



    
    
 <h4  style=" color:blue;" >Last student registerd with id : <%= option23232 %> </h4> 
    
<table>   
  <tr> 
<td><B>StudentID</B></td>
<td><input type="text" name="studentid" id="studentid" size="15"></td>
</tr>
<tr>
<%   studentvo  user = new studentvo(); %>

<td><B>PrintPDF</B></td>
<td colspan="2"><input type="submit" value="GeneratePDF" /></td>
</tr>
</table>
    
<br></br>
<br></br>
 
<h4  style=" color:blue;" >Recently Enrolled Students :</h4>    
<table>   
 
<tr>
<td><B>Student ID</B></td>

<%  for(int i = 0; i < al.size(); i++)
{

   int option =al.get(i);

%>
<td><input type="Label" name="studentid" id="studentid" value="<%= option %>" size="15" disabled  style="background-color:Black; color:Lime;"></td>

 <% } 
   
   %>
</tr>




 <tr>
<td><B>Student Name</B></td>

<%  for(int i = 0; i < alname.size(); i++)
{

	String option =(alname.get(i));

%>
<td><input type="Label" name="studentid" id="studentid" value="<%= option %>" size="15" disabled style="background-color:Black; color:Lime;"></td>

 <% } 
   
   %>
</tr>

 <tr>
<td><B>Student ExamDate</B></td>

<%  for(int i = 0; i < alexamdate.size(); i++)
{

   String option =(alexamdate.get(i));

%>
<td><input type="Label" name="studentid" id="studentid" value="<%= option %>" size="15" disabled style="background-color:Black; color:Lime;"></td>


 <% } 
   
   %>
</tr>

 <tr>
<td><B>Student Fees</B></td>

<%  for(int i = 0; i < alfees.size(); i++)
{

	String option =(alfees.get(i));

%>
<td><input type="Label" name="studentid" id="studentid" value="<%= option %>" size="15" disabled style="background-color:Black; color:Lime;"></td>

 <% } 
   
   %>
</tr>

</table> 
    
        </div>
  </div>
 
 
  </form>
 
 
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
        </ul>
      </div>
    </div>
  </div>
</div>


</body>

</html>
