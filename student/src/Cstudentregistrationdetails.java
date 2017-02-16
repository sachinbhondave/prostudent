

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
 * Servlet implementation class Cstudentregistrationdetails
 */
@WebServlet("/Cstudentregistrationdetails")
public class Cstudentregistrationdetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
	studentJDBCTemplate save=new studentJDBCTemplate();
  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cstudentregistrationdetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<String> studentreg = null;
		try {
			
			
			System.out.println("getallrecordofstudentforregistration"+request.getParameter("studentid"));
			
			studentreg = save.getallrecordofstudentforregistration(request.getParameter("studentid"));
			System.out.println("getallrecordofstudentforregistration"+studentreg.toString());
			PdfGenerator genPdf=new PdfGenerator();
			genPdf.generateInvoice(studentreg);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
 
			

		}
		
		
		
		
			response.sendRedirect("http://localhost:7767/student/about.jsp");  

	}

}
