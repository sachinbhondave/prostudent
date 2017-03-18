

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		
	    HttpSession session = request.getSession();

		
		String studentId=(String) session.getAttribute("studentnameforid");
		String studentName=(String) session.getAttribute("studentName");
		String Course=(String) session.getAttribute("Course");
		String vaccination=(String) session.getAttribute("vaccination");
		String Blood=(String) session.getAttribute("Blood");

		System.out.println("admisiondata"+studentId+studentName+Course+vaccination+Blood);
		
		String BC=(String) session.getAttribute("BC");
		String LC=(String) session.getAttribute("LC");
		String add=(String) session.getAttribute("add");
	//	System.out.println("admisiondataupload"+BC+LC+add);
		
		String studIMG=(String) session.getAttribute("studIMG");
		
		System.out.println("admisiondataimage"+studIMG);

		
		
		
	}

}
