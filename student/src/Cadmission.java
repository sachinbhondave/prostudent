

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import student.admissionvo;
import student.studentJDBCTemplate;
/**
 * Servlet implementation class Cadmission
 */
@WebServlet("/Cadmission")
public class Cadmission extends HttpServlet {
	
	admissionvo admissiondetails=new admissionvo();
	studentJDBCTemplate save=new studentJDBCTemplate();
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cadmission() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    HttpSession session = request.getSession();

		// TODO Auto-generated method stub
		
		String studentId =(request.getParameter("studentId"));
		System.out.println("admision"+request.getParameter("studentId"));


		
		String studentName =(request.getParameter("studentName"));
		String Course =(request.getParameter("Course"));
		String vaccination =(request.getParameter("vaccination"));
		String Blood =(request.getParameter("Blood"));

		session.setAttribute("studentId", studentId);
		session.setAttribute("studentName", studentName);
		session.setAttribute("Course", Course);
		session.setAttribute("vaccination", vaccination);
		session.setAttribute("Blood", Blood);
		String bolld=(String) session.getAttribute(Blood);
		System.out.println("bolldgetAttribute"+bolld);

	  getServletConfig().getServletContext().getRequestDispatcher("/admissions.jsp").forward(request,response);

	

		
	}

}
