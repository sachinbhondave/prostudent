

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
		// TODO Auto-generated method stub
		System.out.println("admision"+request.getParameter("textname"));
		admissiondetails.setAdname(request.getParameter("textname"));
		admissiondetails.setAdstd(request.getParameter("std"));
		admissiondetails.setAdcourse(request.getParameter("Course"));
		admissiondetails.setAdmedium(request.getParameter("CourseM"));
		admissiondetails.setAdfees(request.getParameter("Fees"));
		try {
			save.saveadmissiondetails(admissiondetails);
 			response.sendRedirect("http://localhost:7767/student/admissions.jsp");  
 		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
