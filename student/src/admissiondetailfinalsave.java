

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.MultipartStream.ItemInputStream;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import student.DBconnection;
import student.studentJDBCTemplate;

/**
 * Servlet implementation class admissiondetailfinalsave
 */
@WebServlet("/admissiondetailfinalsave")
public class admissiondetailfinalsave extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public admissiondetailfinalsave() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	     
		Connection con=null;
	    HttpSession session = request.getSession();
		
		/*
		String studentName=(String) session.getAttribute("studentName");
		
		String Course=(String) session.getAttribute("Course");
		String vaccination=(String) session.getAttribute("vaccination");
		String Blood=(String) session.getAttribute("Blood");
		String item1=(String) session.getAttribute("BC");
		 String item2=(String) session.getAttribute("LC");

		 String item3=(String) session.getAttribute("add");
		 System.out.println("admisiondata"+studentName+Course+vaccination+Blood);*/
		  String studentid = (String)session.getAttribute("studentnameforid");
          int studid=Integer.valueOf(studentid);
		//  int studid=20;
		// InputStream inputStream = null;  
 
	//	 String studIMG=(String) session.getAttribute("studIMG");
		
 		System.out.println("admisiondataimage"+studid);

 		String name0 =request.getParameter("name");
 		String alfeetype0 =request.getParameter("alfeetype");
 		String alrate0 =request.getParameter("alrate");
 		String alFrequency0 =request.getParameter("alFrequency");
 		String alDiscount0 =request.getParameter("alDiscount");
 		
 		String name01 =request.getParameter("name1");
 		String alfeetype01 =request.getParameter("alfeetype1");
 		String alrate01 =request.getParameter("alrate1");
 		String alFrequency01 =request.getParameter("alFrequency1");
 		String alDiscount01 =request.getParameter("alDiscount1");
 		
 		String name012 =request.getParameter("name2");
 		String alfeetype012 =request.getParameter("alfeetype2");
 		String alrate012 =request.getParameter("alrate2");
 		String alFrequency012 =request.getParameter("alFrequency2");
 		String alDiscount012 =request.getParameter("alDiscount2");
 		
 		String name0123 =request.getParameter("name3");
 		String alfeetype0123 =request.getParameter("alfeetype3");
 		String alrate0123 =request.getParameter("alrate3");
 		String alFrequency0123 =request.getParameter("alFrequency3");
 		String alDiscount0123 =request.getParameter("alDiscount3");
 		
 		String name01234 =request.getParameter("name4");
 		String alfeetype01234 =request.getParameter("alfeetype4");
 		String alrate01234 =request.getParameter("alrate4");
 		String alFrequency01234 =request.getParameter("alFrequency4");
 		String alDiscount01234 =request.getParameter("alDiscount4");
 		
 		DBconnection hj=new DBconnection();
 		try {
			 con= hj.DBcon();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
 		try {
 		  	String namex=null;
	       	String alfeetypex=null;
	       	String alratex=null;
 	       	String alFrequencyx=null;
 	       	String alDiscountx=null;

 			
 	 		String executeQuery="insert into admissionfees (studentid,feename,feetype_std,rate,freq,discount) values (?,?,?,?,?,?) "; 

 	      	java.sql.PreparedStatement st=null;
 		 
 	         namex=name0;
	       	 alfeetypex=alfeetype0;
	       	 alratex=alrate0;
	       	 alFrequencyx=alFrequency0;
	       	 alDiscountx=alDiscount0;
 	      	
	       	 for (int i=1 ;i<6; i++)
 	      	{
 	      	
 			System.out.println("admisiondatastart" + i);
 			
 			//String studentId=(String) session.getAttribute("studentnameforid");
			st=con.prepareStatement(executeQuery);
			if (i==1)
            {
 			 st.setInt(1, studid);
  			 st.setString(2, namex);
			 st.setString(3, alfeetypex);
			 st.setString(4, alratex);
 			 st.setString(5, alFrequencyx);
 			 st.setString(6, alDiscountx);
   		     
            }
             if (i==2)
             {
             namex=name01;
     	     alfeetypex=alfeetype01;
    	     alratex=alrate01;
	       	 alFrequencyx=alFrequency01;
	       	 alDiscountx=alDiscount01;
             }
             if (i==3)
             {  
            	 
             namex=name012;
     	     alfeetypex=alfeetype012;
    	     alratex=alrate012;
	       	 alFrequencyx=alFrequency012;
	       	 alDiscountx=alDiscount012;
            	 
             }
             if (i==4)
             {  
            	 
             namex=name0123;
     	     alfeetypex=alfeetype0123;
    	     alratex=alrate0123;
	       	 alFrequencyx=alFrequency0123;
	       	 alDiscountx=alDiscount0123;
            	 
             }
             if (i==5)
             {  
            	 
             namex=name01234;
     	     alfeetypex=alfeetype01234;
    	     alratex=alrate01234;
	       	 alFrequencyx=alFrequency01234;
	       	 alDiscountx=alDiscount01234;
            	 
             }
             int rs;
			rs=st.executeUpdate();
 			System.out.println("admisiondatastartend");
 	      	}
	       	getServletConfig().getServletContext().getRequestDispatcher("/admissions.jsp").forward(request,response);
 		
 		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
 		
 		

 		
 		
 		
	
	}

}
