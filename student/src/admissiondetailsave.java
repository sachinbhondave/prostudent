

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
     String   LC=null;
     String   AddressProof=null;
			 
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
	      //   FileInputStream fis=new FileInputStream(request.getParameter("photo")); 
	         System.out.println("studentname"+studentname+Coursepaidfee+Hobby+BirtCertificate);

	         /*vaccination=request.getParameter("vaccination");
	         Blood=request.getParameter("Blood");
	         LC=request.getParameter("LC");
	         AddressProof=request.getParameter("AddressProof");
*/
	         /* File imgfile = new File("photo");
              FileInputStream fin = new FileInputStream(imgfile);
	             System.out.println("findata"+fin);

	         
	         // obtains the upload file part in this multipart request
	         Part filePart = request.getPart("photo");
	         if (filePart != null) {
	             // prints out some information for debugging
	             System.out.println(filePart.getName());
	             System.out.println(filePart.getSize());
	             System.out.println(filePart.getContentType());
	             InputStream inputStream = null; 

	             // obtains input stream of the upload file
	             inputStream = filePart.getInputStream();
	           
	             System.out.println("filePart.getName()"+inputStream); }
*/
	        	
	         boolean isMultiPart = ServletFileUpload.isMultipartContent(request);
	         if (isMultiPart) {
	             FileItemFactory factory = new DiskFileItemFactory();
	             ServletFileUpload upload = new ServletFileUpload(factory);
	             List items = null;
	 			try {
	 				items = upload.parseRequest(request);
	 		         System.out.println("studentnameServletFileUpload"+items.toString());
	  				
	 			} catch (FileUploadException e) {
	 				// TODO Auto-generated catch block
	 				e.printStackTrace();
	 			}
	             Iterator<FileItem> iter = items.iterator();
 		         System.out.println("studentnameServletFileUpload2"+iter.hasNext());

	             while (iter.hasNext()) {
	 		         System.out.println("studentnameServletFileUpload3"+iter.hasNext());

	                 FileItem fileItem = iter.next();
	                 if (!fileItem.isFormField()) {
		 		         System.out.println("studentnameServletFileUpload4"+fileItem.toString());

	                     processFormField(fileItem,session);
	                 } else {
	                 }
	             }
	             
	         }
	       
	         String name= (String) session.getAttribute("add");

 	         session.setAttribute("UserName", Course);			
 			 getServletConfig().getServletContext().getRequestDispatcher("/admisiondetailsave.jsp").forward(request,response);

		}

	private void processFormField(FileItem item,HttpSession session) {

        //String na = item.getFieldName();
             if (item.getFieldName().equals("photo")) {
              String   name = item.getString();
 	         session.setAttribute("BC", name);			

        } else if (item.getFieldName().equals("LC")) {
        	String    LC = item.getString();
 	         session.setAttribute("LC", LC);			

        } else if (item.getFieldName().equals("AddressProof")) {
            String add = item.getString();
 	         session.setAttribute("add", add);			


           
        }
   
	}
		 
			
		
		
			
	

	
	
	

}
