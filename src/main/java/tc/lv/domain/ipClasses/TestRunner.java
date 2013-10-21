package tc.lv.domain.ipClasses;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestRunner {

	public static void main(String[] args) {
		 SessionFactory sessionFactory = new Configuration().configure()
		 .buildSessionFactory();
		 Session session = sessionFactory.openSession();
		 session.beginTransaction();
		 session.getTransaction().commit();
		 
	}

}
