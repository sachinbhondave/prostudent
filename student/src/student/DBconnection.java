package student;

import java.util.List;
import java.util.Properties;

import javax.sql.DataSource;
import java.sql.*;

//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
import java.util.ArrayList;


public class DBconnection {
 
	static	public Connection DBcon() throws SQLException
		
		
		{
			  String DB_URL = "jdbc:mysql://localhost:3306/student";
			  Properties properties = new Properties();
			  properties.setProperty("user", "root");
			  properties.setProperty("password", "sachin");
			  properties.setProperty("useSSL", "false");
			  properties.setProperty("autoReconnect", "true");		
			  try {
					Class.forName("com.mysql.jdbc.Driver");
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				
				}
			 Connection conn = null;

			 return  conn = DriverManager.getConnection(DB_URL,properties);
	  
		}
}
