package project;
import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class ProjectProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	//getting value from parameter product name price;
        String productName = request.getParameter("productName");
        double productPrice = Double.parseDouble(request.getParameter("productPrice"));

        Product product = new Product();
        product.setName(productName);
        product.setPrice(productPrice);

        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        
        Session session = sessionFactory.openSession();
        
        Transaction transaction = session.beginTransaction();

        try {
            session.save(product);
            transaction.commit();
            response.getWriter().println("Product added successfully!");
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            response.getWriter().println("Failed to add product.");
        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}
