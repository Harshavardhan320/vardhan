package practice1;
import java.io.IOException;
import java.io.PrintWriter;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Hybernateservlet
 */
public class Hybernateservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	SessionFactory sess = null;

	@Override
	public void init(ServletConfig config) throws ServletException {

		super.init(config);
		// Get the SessionFactory object and the Session object
		sess = DBconnection.getSessionFactory();		
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		

		Session session = sess.openSession();
		
		out.println("connected");
		
		session.close();
		out.println("connection close");

		out.close();
	}

}
