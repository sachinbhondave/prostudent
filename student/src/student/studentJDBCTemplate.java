package student;
import java.util.List;
import javax.sql.DataSource;
import java.sql.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import student.studentvo;
import student.coursevo;
import student.admissionvo;
import org.springframework.context.support.FileSystemXmlApplicationContext;


public class studentJDBCTemplate  {
	

	static Connection DB() throws SQLException {
		  String DB_URL = "jdbc:mysql://localhost:3306/student";

			   //  Database credentials
		 String USER = "root";
		 String PASS = "sachin";
		
		  try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			
			}
		 Connection conn = null;

		 return  conn = DriverManager.getConnection(DB_URL,USER,PASS);
  
	}
	 

	      
	
  public void studentsave(studentvo student) throws SQLException
  {     PreparedStatement ps = null;
 	    System.out.println("Connecting to database...");
  		String query = "insert into student (name,father_name,post_add,per_add,sex,city,course,distirct,state,pincode,email,birth,contact) values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
  		try{
 			ps =  studentJDBCTemplate.DB().prepareStatement(query);
 			System.out.println("reg_name"+student.getName());
 			ps.setString(1, student.getName());
 			ps.setString(2, student.getFathername());
			ps.setString(3, student.getPostadd());
			ps.setString(4, student.getPeradd());
 			ps.setString(5, student.getSex());
			ps.setString(6, student.getCity());
			ps.setString(7, student.getCourse());
 			ps.setString(8, student.getDistrict());
			ps.setString(9, student.getState());
			ps.setString(10, student.getPincode());
 			ps.setString(11, student.getEmail());
			ps.setString(12, student.getBirth());
			ps.setString(13, student.getContact());
 			int out = ps.executeUpdate();
 			System.out.println("reg_name"+out);

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
        	
		 String query123 = "select * from student st ,admission ad where ad.name =? and ad.name=st.name";
		 ps= studentJDBCTemplate.DB().prepareStatement(query123);
	     ps.setString(1, name);
		 rs=ps.executeQuery();
		 while (rs.next())
 	     {
	           for (int i=1 ; i<19 ; i++) 
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
  
  
}
  

