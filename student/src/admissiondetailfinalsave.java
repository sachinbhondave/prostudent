

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.MultipartStream.ItemInputStream;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import student.DBconnection;
import student.studentJDBCTemplate;

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
		
	     
		Connection con=null;
	    HttpSession session = request.getSession();
		
		
		String studentName=(String) session.getAttribute("studentName");
		
		String Course=(String) session.getAttribute("Course");
		String vaccination=(String) session.getAttribute("vaccination");
		String Blood=(String) session.getAttribute("Blood");
		String item1=(String) session.getAttribute("BC");
		 String item2=(String) session.getAttribute("LC");

		 String item3=(String) session.getAttribute("add");
		 System.out.println("admisiondata"+studentName+Course+vaccination+Blood);
		  
		 InputStream inputStream = null;  
 
		 String studIMG=(String) session.getAttribute("studIMG");
		
 		System.out.println("admisiondataimage"+studIMG);

 		String name =request.getParameter("name");
 		String alfeetype =request.getParameter("alfeetype");
 		String alrate =request.getParameter("alrate");
 		String alFrequency =request.getParameter("alFrequency");
 		String alDiscount =request.getParameter("alDiscount");
 		
 		String name1 =request.getParameter("name1");
 		String alfeetype1 =request.getParameter("alfeetype1");
 		String alrate1 =request.getParameter("alrate1");
 		String alFrequency1 =request.getParameter("alFrequency1");
 		String alDiscount1 =request.getParameter("alDiscount1");
 		
 		String name2 =request.getParameter("name2");
 		String alfeetype2 =request.getParameter("alfeetype2");
 		String alrate2 =request.getParameter("alrate2");
 		String alFrequency2 =request.getParameter("alFrequency2");
 		String alDiscount2 =request.getParameter("alDiscount2");
 		
 		String name3 =request.getParameter("name3");
 		String alfeetype3 =request.getParameter("alfeetype3");
 		String alrate3 =request.getParameter("alrate3");
 		String alFrequency3 =request.getParameter("alFrequency3");
 		String alDiscount3 =request.getParameter("alDiscount3");
 		
 		String name4 =request.getParameter("name4");
 		String alfeetype4 =request.getParameter("alfeetype4");
 		String alrate4 =request.getParameter("alrate4");
 		String alFrequency4 =request.getParameter("alFrequency4");
 		String alDiscount4 =request.getParameter("alDiscount4");
 		
 		DBconnection hj=new DBconnection();
 		try {
			 con= hj.DBcon();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
 		try {
 		
 			
 	 		String executeQuery="insert into admissionsave (studentid, studentname,Course,vaccination,Blood,BC,LC,add,studimg) values (?,?,?,?,?,?,?,?,?) "; 

 	      	java.sql.PreparedStatement st=null;
 		 
 			System.out.println("admisiondatastart");
 			String studentId=(String) session.getAttribute("studentnameforid");
			st=  con.prepareStatement(executeQuery);

 		 	  int studid;
 			 studid= Integer.valueOf(studentId);
 			
 			 st.setInt(1, studid);
  			 st.setString(2, studentName);
			 st.setString(3, Course);
			 st.setString(4, vaccination);
 			 st.setString(5, Blood);
 			 st.setString(6, item1);
 			 st.setString(7, item2);
 			 st.setString(8, item3);
    		 st.setString(9, studIMG);


 		    int rs;

		
			rs=st.executeUpdate();
 			System.out.println("admisiondatastartend");

 		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
 		
 		

 		
 		
 		
	
	}

}
