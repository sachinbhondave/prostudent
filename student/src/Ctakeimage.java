

import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import student.DBconnection;
import student.studentJDBCTemplate;

/**
 * Servlet implementation class Ctakeimage
 */
@WebServlet("/Ctakeimage")
public class Ctakeimage extends HttpServlet {
	private static final long serialVersionUID = 1L;
    ArrayList<String> sdata= new ArrayList<String>();
    InputStream   image =null;	 
    studentJDBCTemplate  stud=new   studentJDBCTemplate();
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 

 {
        HttpSession session = request.getSession();

		// TODO Auto-generated method stub
		if (!(request.getParameter("field")==null))
		{
			  String Image  = request.getParameter("field");
			  String studentid = (String) session.getAttribute("studentnameforid");
			  String studentName  = (String) session.getAttribute("studentName");
		      String Course  = (String) session.getAttribute("Course");
		      String vaccination  =(String) session.getAttribute("vaccination");
 		      String blood   =(String) session.getAttribute("Blood");

		     System.out.println("data"+Image);
		    
		        sdata.add(Image);	
				sdata.add(studentid);	
				sdata.add(studentName);					
				sdata.add(Course);	
				sdata.add(vaccination);					
				sdata.add(blood);					

		}
		try {
			
			
			
			stud.savefinaladmission(sdata);
			sdata.clear();
			getServletConfig().getServletContext().getRequestDispatcher("/takeimage.jsp").forward(request,response);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 
	
	}
}
