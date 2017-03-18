

import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

import student.studentJDBCTemplate;

/**
 * Servlet implementation class Ctakeimage
 */
@WebServlet("/Ctakeimage")
public class Ctakeimage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	studentJDBCTemplate  stud=new   studentJDBCTemplate();
    ArrayList<String> sdata= new ArrayList<String>();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ctakeimage() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    
    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	/*protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}*/

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		  HttpSession session = request.getSession();
		if (!(request.getParameter("field")==null))
		{
		      String Image  = request.getParameter("field");
		      System.out.println("studentImage"+Image.toString());
 		      session.setAttribute("studIMG", Image);
		}
	
 			
			getServletConfig().getServletContext().getRequestDispatcher("/takeimage.jsp").forward(request,response);
			
		 
}
	
}
