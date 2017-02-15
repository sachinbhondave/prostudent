
import java.io.IOException;
import java.sql.SQLException;
import student.studentvo;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import student.studentJDBCTemplate;


/**
 * Servlet implementation class Csavestudent
 */
@WebServlet("/Csavestudent")
public class Csavestudent extends HttpServlet {
	
	studentvo stud=new studentvo();
	studentJDBCTemplate save=new studentJDBCTemplate();
	private static final long serialVersionUID = 1L;
       
	

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Csavestudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
 		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("name"+request.getParameter("textname"));
		
		stud.setName(request.getParameter("textname"));
 		stud.setFathername(request.getParameter("fathername"));
		stud.setPostadd(request.getParameter("paddress"));
		stud.setPeradd(request.getParameter("personaladdress"));
 		stud.setSex(request.getParameter("sex"));
  		stud.setCity(request.getParameter("City"));
		stud.setCourse(request.getParameter("Course"));
		stud.setDistrict(request.getParameter("District"));
		stud.setState(request.getParameter("State"));
		stud.setPincode(request.getParameter("pincode"));
 		stud.setEmail(request.getParameter("emailid"));
		stud.setBirth(request.getParameter("dob"));
 		stud.setContact(request.getParameter("mobileno"));
 		stud.setChoice(request.getParameter("choose"));
 		stud.setRegfee(request.getParameter("regfee"));

 		System.out.println("setContact"+request.getParameter("mobileno"));
 		
		try {
			save.studentsave(stud);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.sendRedirect("http://localhost:7767/student/about.jsp");
	}

}
