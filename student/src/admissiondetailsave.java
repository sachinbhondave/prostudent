

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
    	
		if (!(request.getParameter("Course")==null))

		{

	         Course=request.getParameter("Course");
	         studentname=request.getParameter("studentname");
	         Coursepaidfee=request.getParameter("Coursepaidfee");
	         Hobby=request.getParameter("Hobby");

 			 request.setAttribute("Course", Course);
 			 request.setAttribute("studentname", studentname);
 			 request.setAttribute("Coursepaidfee", Coursepaidfee);
 			 request.setAttribute("Hobby", Hobby);


			System.out.println("doGetsubmitidone"+Course);

			 getServletConfig().getServletContext().getRequestDispatcher("/takeimage.jsp").forward(request,response);
				System.out.println("doGet_choose");

		}
		
		
		}
    	
    
		// TODO Auto-generated method stub
  //  }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		
		
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
		        getServletConfig().getServletContext().getRequestDispatcher("/admisiondetailsave.jsp").forward(request,response);
				//}
		        System.out.println("sachin_submitdata_choose");
				}
				
			
			
			
			}
		
			
	

	
	
	

}
