package practice3;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import practice2.DBConnection;
import practice2.Product;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Servlet implementation class SchoolServlet
 */
public class SchoolServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.setContentType("text/html");
		
		SessionFactory factery= SchoolDataConnection.getSessionFactory();
		
		PrintWriter out = response.getWriter();
		
		
		Session sess = factery.openSession();
		
		List<School> list1 = sess.createQuery("from School").list();
		
		for(School b: list1) {
			out.println("id "+b.getId()+" Student name "+b.getStudent_name()+" Teacher name"+b.getTeacher_name()+"<br>");
		}
		
		sess.close();
		out.close();
	}
}
