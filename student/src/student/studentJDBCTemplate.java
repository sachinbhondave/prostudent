package student;
import java.util.List;
import java.util.Properties;

import javax.sql.DataSource;
import java.sql.*;

//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import student.studentvo;
import student.coursevo;
import student.admissionvo;


public class studentJDBCTemplate  {
	

	static Connection DB() throws SQLException {
		  String DB_URL = "jdbc:mysql://localhost:3306/student";
		  Properties properties = new Properties();
		  properties.setProperty("user", "root");
		  properties.setProperty("password", "sachin");
		  properties.setProperty("useSSL", "false");
		  properties.setProperty("autoReconnect", "true");		
		  try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			
			}
		 Connection conn = null;

		 return  conn = DriverManager.getConnection(DB_URL,properties);
  
	}
	 

	  public void studentrxamresultsave(String status , String pers  , int studid) throws SQLException
	  { 
		    PreparedStatement ps = null;
		    String query =" insert into examresult (studentid,status,percentage) values (?,?,?)";
  			ps =  studentJDBCTemplate.DB().prepareStatement(query);
  			ps.setInt(1, studid);
  			ps.setString(2, status);
 			ps.setString(3, pers);
    		ps.executeUpdate();
            System.out.println("success_examreuslt");
	  }
	
	  
	   public ArrayList getnameandstdforstudentid(int no) throws SQLException
	   {
		  ArrayList<String> nameandstd=new ArrayList<String>();
 		  
		  if ((no > 0))
				  {
		  PreparedStatement ps=null;	
		  ResultSet rsll = null;

		    String executeQueryll="select name,course from student where studentid = ? "; 
			ps =  studentJDBCTemplate.DB().prepareStatement(executeQueryll);
			ps.setInt(1,no);
			rsll=ps.executeQuery();


		  while(rsll.next()) 
		  { 
			  nameandstd.add(rsll.getString(1));
			  nameandstd.add(rsll.getString(2));
 		  }
		  }
		return nameandstd;
		  
	  }
	  
	  
  public void studentsave(studentvo student) throws SQLException
  {     PreparedStatement ps = null;
 	    System.out.println("Connecting to database...");
  		String query = "insert into student (studentid,name,father_name,post_add,per_add,sex,city,course,distirct,state,pincode,email,birth,contact,examdate,examendate,reg_fees)"
  				+ " values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
  		
  		try{
  			ps =  studentJDBCTemplate.DB().prepareStatement(query);
 			System.out.println("reg_name"+student.getName());
 			ps.setInt(1, 0);
  			ps.setString(2, student.getName());
 			ps.setString(3, student.getFathername());
			ps.setString(4, student.getPostadd());
			ps.setString(5, student.getPeradd());
 			ps.setString(6, student.getSex());
			ps.setString(7, student.getCity());
			ps.setString(8, student.getCourse());
 			ps.setString(9, student.getDistrict());
			ps.setString(10, student.getState());
			ps.setString(11, student.getPincode());
 			ps.setString(12, student.getEmail());
			ps.setString(13, student.getBirth());
			ps.setString(14, student.getContact());
			ps.setString(15, student.getChoice());
 			System.out.println("reg_name"+student.getChoice());
 			ps.setString(16, "sachin");
			ps.setString(17, student.getRegfee());
 			System.out.println("reg_name"+student.getRegfee());
   			int out = ps.executeUpdate();
 			System.out.println("reg_namedasdasd"+out);

			if(out!=0){
				System.out.println("Employee saved with id");
			}else 
				{System.out.println("Employee save failed with id");
				}
 	}
 	catch(Exception e) {
 		e.getMessage();
 
 		
 	}
		
			   
  }
  
  
  public coursevo retriveCoursedetails(String std, String course ) throws SQLException
  {   
	  PreparedStatement ps = null;
 	  ResultSet rs=null;
	    coursevo  co =new coursevo();
		String query1 = " SELECT * FROM course cd where cd.std = ? and cd.name = ? ";  
		ps =  studentJDBCTemplate.DB().prepareStatement(query1);
	    ps.setString(1, std);	
	    ps.setString(2, course);	
        rs=ps.executeQuery();
	   try {
        while (rs.next())
	    {
	    	
	    	System.out.println("retriveCoursedetails" +rs.getString(1));
	    	co.setName( rs.getString(1));
	    	co.setFee( rs.getString(2));
	    	co.setStd(rs.getString(3));
 

	    }
	   }
	   finally {
		   rs.close();
		   ps.close();
 	   }
	  
	  
	  return co;
	  
  }
  
  
  public int Deletestudentrecord(String id) throws SQLException
  {    PreparedStatement ps = null;

		String query = "delete from student  where studentid= ? ";
				
 	try
		{
		ps = studentJDBCTemplate.DB().prepareStatement(query);
	   
		int newstud=Integer.valueOf(id);
 		ps.setInt(1,newstud);
	   
	    int out = ps.executeUpdate();
	    if(out !=0){
			System.out.println("Employee admission saved ");
		}else 
			{System.out.println("Employee save failed ");
			}
	    return out;

  }
	    finally {
			   ps.close();
	 	   }
		  
   }
  
  
  public void saveadmissiondetails(admissionvo admission) throws SQLException
  {    PreparedStatement ps = null;

		String query = "insert into admission (name,std,course,cmedium,fees) values (?,?,?,?,?)";
 	try
		{
		ps = studentJDBCTemplate.DB().prepareStatement(query);
	   
 		ps.setString(1,admission.getAdname());
	    ps.setString(2, admission.getAdstd());
		ps.setString(3,admission.getAdcourse());
		ps.setString(4, admission.getAdmedium());
	    ps.setString(5, admission.getAdfees());
	    int out = ps.executeUpdate();
	    if(out !=0){
			System.out.println("Employee admission saved ");
		}else 
			{System.out.println("Employee save failed ");
			}
  }
	    finally {
			   ps.close();
	 	   }
		  
   }
  
  
   public void studentbilling(String name,String bill) throws SQLException
   {
	   PreparedStatement ps = null;	
	   ResultSet rs=null;
	   PreparedStatement ps1= null;	
	   
	    System.out.println("inputs"+name+bill);
	    String query123 = " select fees from admission cd where cd.name= (?) ";
	    String query1= "UPDATE admission gh SET gh.fees = ? WHERE gh.name= ? ";
	    		
	    ps1 = studentJDBCTemplate.DB().prepareStatement(query123);
	    ps1.setString(1, name);
	    rs=ps1.executeQuery();
        try {
            while (rs.next())
    	    {
            System.out.println("result"+rs.toString());
     	    String billfees=rs.getString(1);
     	    System.out.println("adtimebill"+billfees);
    	    
     	    int billing=Integer.valueOf(billfees);
            int newbilling=Integer.valueOf(bill);
    	    int finalbilling=billing+newbilling;
    	    String finalbill=String.valueOf(finalbilling);
    	    System.out.println("finallbill"+finalbill);
    	    ps = studentJDBCTemplate.DB().prepareStatement(query1);
    	    ps.setString(1, finalbill);
    	    ps.setString(2, name);
    	    ps.executeUpdate();
    	   
    	    }
    	   }
    	   finally {
    		   rs.close();
    		   ps1.close();
     	   }
	   
   }

 
  
	public ArrayList getallrecordofstudent(String name) throws SQLException
   
    {    ResultSet rs=null;
	     PreparedStatement ps = null;	
	     ArrayList<String> allrecordstud=new ArrayList();
        try {
        	
		 String query123 = "select * from student st ,admission ad where ad.name =? and ad.name=st.name ";
		 ps= studentJDBCTemplate.DB().prepareStatement(query123);
	     ps.setString(1, name);
		 rs=ps.executeQuery();
		 while (rs.next())
 	     {
	           for (int i=1 ; i<24 ; i++) 
	           {
	    	   System.out.println("arraylistof allrecords"); 
		       allrecordstud.add(rs.getNString(i));
	           }
	           System.out.println("arraylistof allrecords"+allrecordstud.get(15)+allrecordstud.get(16)); 
	       
	           coursevo newdata=retriveCoursedetails(allrecordstud.get(14),allrecordstud.get(15));
	         
	           String latestfees =newdata.getFee();
	         System.out.println("arraylistof allrecords"+latestfees.toString()); 
	         int coursefees=Integer.valueOf(latestfees);
	         System.out.println("arraylistof allrecords"+coursefees); 

	         String paidfees = allrecordstud.get(17);  
	         System.out.println("arraylistof allrecords"+paidfees.toString()); 

	         int convertedpaidfees=Integer.valueOf(paidfees);
	         System.out.println("arraylistof allrecords"+convertedpaidfees); 
             if (coursefees>convertedpaidfees)
             {
            	 int finalfees=coursefees-convertedpaidfees;
                 String convertedfinalfees=String.valueOf(finalfees);
                  allrecordstud.add(convertedfinalfees);

             }
             else {
            	 
                 allrecordstud.add("no_due");
 
             }
             
             
             
		  System.out.println("arraylistof allrecords"+allrecordstud);
 			 
			 }
 	     }
 	     finally {
 		   rs.close();
 		   ps.close();
  	   }
		return allrecordstud;
    }
  
	
	public ArrayList getallrecordofstudentforregistration
	(String id) throws SQLException
	   
    {    ResultSet rs=null;
	     PreparedStatement ps = null;	
	     ArrayList<String> allrecordstud=new ArrayList();
        try {
        	
		 String query123 = "select * from student st where  st.studentid = ?";
		 ps= studentJDBCTemplate.DB().prepareStatement(query123);
		 
		 int studreg=Integer.valueOf(id);
	     ps.setInt(1, studreg);
	     
		 rs=ps.executeQuery();
		 while (rs.next())
 	     {
			  
			  
		int studentid=rs.getInt(1);
 	    System.out.println("arraylistof studentid"+studentid); 

		String studentid_new=String.valueOf(studentid);
		allrecordstud.add(studentid_new);
			 
	           for (int i=2 ; i<18 ; i++) 
	           {
	    	   System.out.println("arraylistof allrecords"); 
		       allrecordstud.add(rs.getString(i));
	           }
	          

             }
            
		 
		 if(allrecordstud.get(16).isEmpty())
             {
 
			  allrecordstud.add(16, "0");
			  System.out.println("arraylistof allrecordstud");

             }
             
             
             
		  System.out.println("arraylistof allrecords"+allrecordstud);
 			 
			 allrecordstud.remove(15);
 
 	     }
 	     finally {
 		   rs.close();
 		   ps.close();
  	   }
		return allrecordstud;
    }
  
	
	
	
	
	
public ArrayList getlast5recordsforstudent() throws SQLException
	
{
 ResultSet rs=null;
 PreparedStatement ps = null;	
ArrayList<String> last5=new ArrayList();
ArrayList<String> lastname=new ArrayList();
ArrayList<Integer> lastid=new ArrayList<Integer>();
ArrayList<String> lastidcon=new ArrayList<String>();

ArrayList<String> lastexamdate=new ArrayList();
ArrayList<String> lastfees=new ArrayList();

String querylast5 = "SELECT * FROM student jk WHERE jk.studentid ORDER BY jk.studentid DESC limit 5";	
try 
{
	
ps= studentJDBCTemplate.DB().prepareStatement(querylast5);
rs=ps.executeQuery();
while (rs.next())
 {
	
	lastid.add(rs.getInt(1));
	lastname.add(rs.getString(2));
	lastexamdate.add(rs.getString(15));
	lastfees.add(rs.getString(17));
 }

lastidcon.add(String.valueOf(lastid));
 
//last5.addAll(lastidcon);
last5.addAll(lastname);
last5.addAll(lastexamdate);
last5.addAll(lastfees);
System.out.println("gneratelast5 array"+ last5.toString());

}
 
finally {
	   rs.close();
	   ps.close();
  }
	return last5;	
   
}
  
}
