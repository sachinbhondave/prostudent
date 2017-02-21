

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
 * Servlet implementation class Cadmissionresult
 */
@WebServlet("/Cadmissionresult")
public class Cadmissionresult extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String Interger = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cadmissionresult() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	
	 */
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
		if (!(request.getParameter("submitdata")==null))

		{
			studentJDBCTemplate save=new studentJDBCTemplate();
			System.out.println("sachin_submitdata_choose_submitidone"+request.getParameter("result"));

	    String status=request.getParameter("result");
	    String per=request.getParameter("marks");
	    
	     String studentid=request.getParameter("studentid");
			System.out.println("sachin_submitdata_choose_submitidone"+studentid);

		int stud=Integer.valueOf(studentid);

		System.out.println("sachin_submitdata_choose_submitidone"+stud);

		try {
			save.studentrxamresultsave(status,per,stud);
	        getServletConfig().getServletContext().getRequestDispatcher("/admissionresult.jsp").forward(request,response);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		}
    	
    	
		// TODO Auto-generated method stub
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		
		
			System.out.println("sachin_submitdata");
	
		
			if (!(request.getParameter("choose")==null))
			{
				if (!(request.getParameter("studentid")==null))
				{
					String studeent_id=null;
					

					ArrayList<String> studentandstd= new ArrayList<String>();
					studeent_id=request.getParameter("studentid");
					int std=Integer.valueOf(studeent_id);
					System.out.println("sachin_submitdata_choose_submitidone"+std);

					studentJDBCTemplate save=new studentJDBCTemplate();
					try {
						studentandstd=save.getnameandstdforstudentid(std);
						System.out.println("sachin_submitdata_choose_submitidone"+ studentandstd.toString());

					} catch (NumberFormatException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					request.setAttribute("studeetname", studentandstd.get(0));
					request.setAttribute("Std", studentandstd.get(1));
					request.setAttribute("Stno", studeent_id);


 
			        getServletConfig().getServletContext().getRequestDispatcher("/admissionresult.jsp").forward(request,response);
					System.out.println("sachin_submitdata_choose_submitidone");
                   ;
				}

				else {  String seldate=null;

				seldate=request.getParameter("choose");
				request.setAttribute("choose", seldate);
				System.out.println("sachin_submitdata_choose");
				
		        getServletConfig().getServletContext().getRequestDispatcher("/admissionresult.jsp").forward(request,response);
				System.out.println("sachin_submitdata_choose");
				}
				
			
			
			
			}
		
			
			
		}		
	
	
	
	

}
