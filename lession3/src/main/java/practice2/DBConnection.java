package practice2;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class DBConnection {
	private static SessionFactory sessionFactory;
	static {
		try {
			StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
					
					.configure("hibernate.cfg.xml").build();

			Metadata metaData = new MetadataSources(standardRegistry).getMetadataBuilder().build();

			sessionFactory = metaData.getSessionFactoryBuilder().build();		
			}catch(Exception e) {
				
				System.err.println("Can't connect to the server ");
			}
	}
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}