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
    
<form action="Csavestudent" method=Post name="StudentRegistration" onsubmit="return(validate());">
<table cellpadding="2" width="70%" bgcolor="99FFFF" align="center"
cellspacing="2">

<tr>
<td colspan=2>
<center><font size=4><b>Student Registration Form</b></font></center>
</td>
</tr>

<tr>
<td>Name</td>
<td><input type=text name=textname id="textname" size="30"></td>
</tr>

<tr>
<td>Father Name</td>
<td><input type="text" name="fathername" id="fathername"
size="30"></td>
</tr>
<tr>
<td>Postal Address</td>
<td><input type="text" name="paddress" id="paddress" size="30"></td>
</tr>

<tr>
<td>Personal Address</td>
<td><input type="text" name="personaladdress"
id="personaladdress" size="30"></td>
</tr>

<tr>
<td>Sex</td>
<td><input type="radio" name="sex" value="male" size="10">Male
<input type="radio" name="sex" value="Female" size="10">Female</td>
</tr>

<tr>
<td>City</td>
<td><select name="City">
<option value="-1" selected>select..</option>
<option value="New Delhi">NEW DELHI</option>
<option value="Mumbai">MUMBAI</option>
<option value="Goa">GOA</option>
<option value="Patna">PATNA</option>
</select></td>
</tr>

<tr>
<td>Course</td>
<td><select name="Course">
<option value="-1" selected>select..</option>
<option value="B.Tech">B.TECH</option>
<option value="MCA">MCA</option>
<option value="MBA">MBA</option>
<option value="BCA">BCA</option>
</select></td>
</tr>

<tr>
<td>District</td>
<td><select name="District">
<option value="-1" selected>select..</option>
<option value="Nalanda">NALANDA</option>
<option value="UP">UP</option>
<option value="Goa">GOA</option>
<option value="Patna">PATNA</option>
</select></td>

</tr>

<tr>
<td>State</td>
<td><select Name="State">
<option value="-1" selected>select..</option>
<option value="New Delhi">NEW DELHI</option>
<option value="Mumbai">MUMBAI</option>
<option value="Goa">GOA</option>
<option value="Bihar">BIHAR</option>
</select></td>
</tr>
<tr>

<tr>
<td>Student-STD</td>
<td><select Name="STD" id="STD"  onchange="jsFunction(this.value);">>
<option value="1" selected>select..</option>
<option value="1">KG</option>
<option value="1">LKG</option>
<option value="2">STD1</option>
<option value="2">STD2</option>
<option value="2">STD3</option>
<option value="2">STD4</option>
<option value="3">STD5</option>
<option value="3">STD6</option>
<option value="3">STD7</option>
<option value="3">STD8</option>
<option value="3">STD9</option>
<option value="3">STD10</option>
 
</select></td>
</tr>

<%
ArrayList al = new ArrayList();
String reg_fee="";
Properties properties = new Properties();
properties.setProperty("user", "root");
properties.setProperty("password", "sachin");
properties.setProperty("useSSL", "false");
properties.setProperty("autoReconnect", "false");
 
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

String ne="1";
String executeQuery="select examdate from student.exam "; 
String executeQuery1="SELECT kl.onetime FROM student.charge kl where kl.name='registration' "; 

st= con.prepareStatement(executeQuery);  
st1= con.prepareStatement(executeQuery1);  

rs1=st.executeQuery();

rs2=st1.executeQuery();

while(rs1.next()) 
{ 
 al.add(rs1.getString("examdate"));

} 
 

while(rs2.next()) 
{ 

  reg_fee=(rs2.getString("onetime"));
} 

%>





<tr>
<td>PinCode</td>
<td><input type="text" name="pincode" id="pincode" size="30"></td>

</tr>
<tr>
<td>EmailId</td>
<td><input type="text" name="emailid" id="emailid" size="30"></td>
</tr>

<tr>
<td>DOB</td>
<td><input type="text" name="dob" id="dob" size="30"></td>
</tr>

<tr>
<td>MobileNo</td>
<td><input type="text" name="mobileno" id="mobileno" size="30"></td>
</tr>
<tr>


<tr>
<td>Exam-Date</td>
 <td><select Name=choose id=choose>
   <%  for(int i = 0; i < al.size(); i++) {
           String option = (String)al.get(i);
   %>
  
   <option value="<%= option %>"><%= option %>
   </option>
   <% } 
   
   %>
</select></td>
</tr>
<tr>

<tr>
<td>Registration-Fees</td>
<td><input type="text" name="regfee" id="regfee" value="<%= reg_fee  %>" size="30"></td>
</tr>
<tr>

<td><input type="reset"></td>
<td colspan="2"><input type="submit" value="Submit Form" /></td>
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
        </ul>
      </div>
    </div>
  </div>
</div>


</body>
<script>

function validate()
{ 
   if( document.StudentRegistration.textname.value == "" )
   {
     alert( "Please provide your Name!" );
     document.StudentRegistration.textname.focus() ;
     return false;
   }
   if( document.StudentRegistration.fathername.value == "" )
   {
     alert( "Please provide your Father Name!" );
     document.StudentRegistration.fathername.focus() ;
     return false;
   }
   
   if( document.StudentRegistration.paddress.value == "" )
   {
     alert( "Please provide your Postal Address!" );
     document.StudentRegistration.paddress.focus() ;
     return false;
   }
   if( document.StudentRegistration.personaladdress.value == "" )
   {
     alert( "Please provide your Personal Address!" );
     document.StudentRegistration.personaladdress.focus() ;
     return false;
   }
   if ( ( StudentRegistration.sex[0].checked == false ) && ( StudentRegistration.sex[1].checked == false ) )
   {
   alert ( "Please choose your Gender: Male or Female" );
   return false;
   }   
   if( document.StudentRegistration.City.value == "-1" )
   {
     alert( "Please provide your City!" );
     document.StudentRegistration.City.focus() ;
     return false;
   }   
   if( document.StudentRegistration.Course.value == "-1" )
   {
     alert( "Please provide your Course!" );
    
     return false;
   }   
   if( document.StudentRegistration.District.value == "-1" )
   {
     alert( "Please provide your Select District!" );
    
     return false;
   }   
   if( document.StudentRegistration.State.value == "-1" )
   {
     alert( "Please provide your Select State!" );
     
     return false;
   }
   if( document.StudentRegistration.pincode.value == "" ||
           isNaN( document.StudentRegistration.pincode.value) ||
           document.StudentRegistration.pincode.value.length != 6 )
   {
     alert( "Please provide a pincode in the format ######." );
     document.StudentRegistration.pincode.focus() ;
     return false;
   }
 var email = document.StudentRegistration.emailid.value;
  atpos = email.indexOf("@");
  dotpos = email.lastIndexOf(".");
 if (email == "" || atpos < 1 || ( dotpos - atpos < 2 )) 
 {
     alert("Please enter correct email ID")
     document.StudentRegistration.emailid.focus() ;
     return false;
 }
  if( document.StudentRegistration.dob.value == "" )
   {
     alert( "Please provide your DOB!" );
     document.StudentRegistration.dob.focus() ;
     return false;
   }
  if( document.StudentRegistration.mobileno.value == "" ||
           isNaN( document.StudentRegistration.mobileno.value) ||
           document.StudentRegistration.mobileno.value.length != 10 )
   {
     alert( "Please provide a Mobile No in the format 123." );
     document.StudentRegistration.mobileno.focus() ;
     return false;
   }
   return( true );
}

function jsFunction(value)
{
 var sac=document.getElementById("STD").value;
 
	
}

</script>


</html>