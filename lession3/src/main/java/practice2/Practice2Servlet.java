package practice2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Practice2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		response.setContentType("text/html");
		
		SessionFactory see= DBConnection.getSessionFactory();
		
		PrintWriter out = response.getWriter();
		
		
		Session sess = see.openSession();
		
		List<Product> list1 = sess.createQuery("FROM Product").list();
		
		
		
		for(Product s: list1) {
			out.print("id "+s.getId());
			out.print(" probuct_Name "+s.getProduct_name());
			out.print(" Prise "+s.getProduct_prise());
			out.print("<br>");
			
		}
	}


}
