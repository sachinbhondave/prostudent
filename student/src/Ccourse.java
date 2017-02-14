

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import student.studentvo;
import student.coursevo;
import student.studentJDBCTemplate;


/**
 * Servlet implementation class Ccourse
 */
@WebServlet("/Ccourse")
public class Ccourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
	studentJDBCTemplate save=new studentJDBCTemplate();
	
	coursevo course=new coursevo();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ccourse() {
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
		doGet(request, response);
		
		
		try {
			course=save.retriveCoursedetails("sachin","string");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
