

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.Iterator;
import java.util.List;
import javax.servlet.annotation.MultipartConfig;
import org.apache.commons.fileupload.*;
import org.apache.commons.io.output.*;
import org.apache.commons.fileupload.servlet.*;
import org.apache.commons.fileupload.disk.*;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.Part;

import student.DBconnection;
import student.studentJDBCTemplate;

/**
 * Servlet implementation class Cadmissionresult
 */
@WebServlet("/admissiondetailsave")
public class admissiondetailsave extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String Interger = null;
	 String Course=null;
	 String seldate=null;
     String studentname=null;
     String Hobby=null;
     String Coursepaidfee=null;
     
     String    BirtCertificate=null;
     String    vaccination=null;
     String  Blood=null;
     String   AddressProof=null;
     InputStream   name =null;	 
     InputStream   LC =null;	 
     InputStream    add =null;	 
     Connection	con=null;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public admissiondetailsave() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	
	 */
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	

    	System.out.println("sachin_submitdata");
    	
		
		if (!(request.getParameter("choose")==null))
		{

            /* if (!(request.getParameter("Course").contains("-1")))
             {
            	 
            	 name=request.getParameter("studentname");
             	 Course=request.getParameter("Course");
 				request.setAttribute("Course", Course);
 				System.out.println("course and name" + Course + name);
 				
 		        getServletConfig().getServletContext().getRequestDispatcher("/admisiondetailsave.jsp").forward(request,response);
 				System.out.println("sachinCourse"); 
            	 
            	 
             }
             */
        
             
			seldate=request.getParameter("choose");
			request.setAttribute("choose", seldate);
			System.out.println("sachin_submitdaif ta_choose");
			//if(request.getParameter("Course").contains("-1"))
			//{
	        getServletConfig().getServletContext().getRequestDispatcher("/admissions.jsp").forward(request,response);
			//}
	        System.out.println("sachin_submitdata_choose");
			}
    	
    	
	
		
		
		}
    	
    
		// TODO Auto-generated method stub
  //  }
    
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        
        HttpSession session = request.getSession();


      
       
			 Course =request.getParameter("Course");
	         studentname=request.getParameter("studentName");
	         Coursepaidfee=request.getParameter("Coursepaidfee");
	         Hobby=request.getParameter("Hobby");
	         BirtCertificate=request.getParameter("photo");
	     

	        	
	         boolean isMultiPart = ServletFileUpload.isMultipartContent(request);
	         if (isMultiPart) {
	             FileItemFactory factory = new DiskFileItemFactory();
	             ServletFileUpload upload = new ServletFileUpload(factory);
	             List items = null;
	 			try {
	 				items = upload.parseRequest(request);
	  				
	 			} catch (FileUploadException e) {
	 				// TODO Auto-generated catch block
	 				e.printStackTrace();
	 			}
	             Iterator<FileItem> iter = items.iterator();

	             while (iter.hasNext()) {

	                 FileItem fileItem = iter.next();
	                 if (!fileItem.isFormField()) {

	                     processFormField(fileItem,session);
	                 } else {
	                 }
	             }
	             
	         }
	      
	         
	         SBsave( request);
	         
	         String name= (String) session.getAttribute("add");

 	         session.setAttribute("UserName", Course);			
 			 getServletConfig().getServletContext().getRequestDispatcher("/admisiondetailsave.jsp").forward(request,response);

		}

	private void processFormField(FileItem item,HttpSession session) {

        //String na = item.getFieldName();
             if (item.getFieldName().equals("photo")) {
            try {
				name = item.getInputStream();
	  			System.out.println("admisiondatastartgetInputStream" +name);

			} catch (IOException e) {
	  			System.out.println("admisiondatastartgetInputStream" +name);

				// TODO Auto-generated catch block
				e.printStackTrace();
			}
              
              
 	       //  session.setAttribute("BC", name);			

        } else if (item.getFieldName().equals("LC")) {
             try {
				LC = item.getInputStream();
	  			System.out.println("admisiondatastartgetInputStream" +LC);

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

 	      //   session.setAttribute("LC", LC);			

        } else if (item.getFieldName().equals("AddressProof")) {
        	
             try {
				add = item.getInputStream();
	  			System.out.println("admisiondatastartgetInputStream" +add);

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

 	      //   session.setAttribute("add", add);			


           
        }
   
          
	}
			
	
		
			
	  public void SBsave ( HttpServletRequest request ){   
          
	        HttpSession session = request.getSession();

          DBconnection hj=new DBconnection();
   		try {
  		con= hj.DBcon();
  		} catch (SQLException e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  		}
   		
   		try {
   	 		
  		/*	
  	 		String executeQuery=" insert into admissionsave (studentid,BC) values (?,?) " ; 
  	 		String executeQuery1=" UPDATE admissionsave SET  AP= ? WHERE studentid = ? ";
   	 		String executeQuery2=" UPDATE admissionsave SET  LC= ?  WHERE studentid = ? "; 

  	      	java.sql.PreparedStatement st=null;
  	      	java.sql.PreparedStatement st1=null;
  	      	java.sql.PreparedStatement st2=null;

  			System.out.println("admisiondatastart" +name);
  			String studentId=(String) session.getAttribute("studentnameforid");
 			st= con.prepareStatement(executeQuery);
 			st1= con.prepareStatement(executeQuery1);
 			st2= con.prepareStatement(executeQuery2);

  			System.out.println("admisiondatastart_id" +studentId);

  		 	 int studid;
  			 studid= 15;
  			
  			 st.setInt(1, studid);
  			 st.setBlob(2, name);
  			 st.executeUpdate();
  			 st1.setBlob(1, add);
  			 st1.setInt(2, studid);
  			 st1.executeUpdate();

  			 st2.setBlob(1, LC);
 			 st2.setInt(2, studid);
  			 st2.executeUpdate();*/
  	      	java.sql.PreparedStatement st=null;

  	 		String executeQuery=" insert into admissionsave(studentid,BC,LC,AP) values (?,?,?,?) " ; 

   			
   			System.out.println("admisiondatastart" +name);
  			String studentId=(String) session.getAttribute("studentnameforid");
   			System.out.println("admisiondatastartstudentId" +studentId);
 			st= con.prepareStatement(executeQuery);

  			int stuid=Integer.valueOf(studentId);
  	      	
  	     	 st.setInt(1, stuid);
			 st.setBlob(2, name);
			 st.setBlob(3, LC);
			 st.setBlob(4, add);

			 st.executeUpdate();
  			System.out.println("admisiondatastartend");

  		} catch (SQLException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}  
          
	}
		 
	
	
	
	

}
