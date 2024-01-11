package project;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class projectservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		String id = request.getParameter("id");
		
		if(id ==null) {
			out.println("Invalid Error");
			return;
		}
		
		
		String url ="jdbc:mysql://localhost:3306/phase2";
		String username ="root";
		String password ="K.harsha@2000";	
		
		Connection conn= null;
		int count =0;
		try {
			try {
				
				Class.forName("com.mysql.cj.jdbc.Driver");
				
			} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			}

			conn = DriverManager.getConnection(url, username, password);
			
			
			String subquery ="Select* from mphasis where id =";
			
			subquery = subquery.concat(id);
			
			String query = subquery;
			Statement stm  = conn.createStatement();
			ResultSet res = stm.executeQuery(query);
			
			request.getRequestDispatcher("project.html").include(request, response);
			
			
			
			while(res.next()) {

				 out.println("username "+res.getString("username"));
				 out.println("<br>");
				 out.println("prise "+res.getInt("prise"));
				 count++;
				 
			}
		} catch (SQLException e) {
			
			System.out.println("not Connected");
			
		}finally {
			if(count == 0) {
				out.println("no record found");
			}
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
