

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.log.SysoLogger;

import student.studentJDBCTemplate;

/**
 * Servlet implementation class Ccheckpdf
 */
@WebServlet("/Ccheckpdf")
public class Ccheckpdf extends HttpServlet {
	private static final long serialVersionUID = 1L;
	studentJDBCTemplate save=new studentJDBCTemplate();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ccheckpdf() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	/*protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
*/
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		ArrayList<String> studentreg = null;
		
 			
			if((request.getParameter("studentiddelete").isEmpty()))
			{
				try {
	 		  
	 			System.out.println("getallrecordofstudentforregistration"+request.getParameter("studentid"));
	 			
	 			try
	 			{
	 			studentreg = save.getallrecordofstudentforregistration(request.getParameter("studentid"));
				System.out.println("getallrecordofstudentforregistration"+studentreg.toString());
	 			}
	 			catch(IndexOutOfBoundsException e)
	 			{	  response.sendRedirect("http://localhost:7767/student/checkpdf.jsp");  

	 				e.printStackTrace();
	 			} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	 			
				if ((studentreg==null))
				{
					String name="no_recordfound";
					String father="no_recordfound";
					String adress="no_recordfound";
					String course="no_recordfound";
					String city="no_recordfound";
					String contact="no_recordfound";
					String fess="no_recordfound";
					
				}	
				else
					{
					
					String name=studentreg.get(1);
				String father=studentreg.get(2);
				String adress=studentreg.get(3);
				String course=studentreg.get(7);
				String city=studentreg.get(6);
				String contact=studentreg.get(11);
				String fess=studentreg.get(15);

		          request.setAttribute("Name", name);
		          request.setAttribute("father", father);
		          request.setAttribute("course", course);
		          request.setAttribute("city", city);
		          request.setAttribute("adress", adress);
		          request.setAttribute("contact", contact); 
		          request.setAttribute("fess", fess);
		        
		          getServletConfig().getServletContext().getRequestDispatcher("/checkpdf.jsp").forward(request,response);
					}
				}
				finally {
					System.out.println("enetetcode");
			  	   }
			
			}
				
				
			else {
				try {
				    System.out.println("deletestudent"+request.getParameter("studentiddelete") );
				  
		 		     int k=  save.Deletestudentrecord(request.getParameter("studentiddelete"));
		 			response.sendRedirect("http://localhost:7767/student/checkpdf.jsp");  
		 			
				}
		 			 catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
				  
						}

			}
			
				
 
		} 
              
            
		
	}



