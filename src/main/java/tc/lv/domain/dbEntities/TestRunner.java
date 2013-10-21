package tc.lv.domain.dbEntities;

import java.io.FileNotFoundException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import tc.lv.domain.parsers.AdaporUceprotect;
import tc.lv.domain.parsers.AdaptorChaosreignsWL;
import tc.lv.repo.SourceDao;

public class TestRunner {

	public static void main(String[] args) throws FileNotFoundException {
		SourceDao sourceDao = new SourceDao();
		AdaptorChaosreignsWL adaptorChaosreignsWL = new AdaptorChaosreignsWL();
		adaptorChaosreignsWL.parse("C:\\Users\\Oleg\\Desktop\\resource2.txt");
		AdaporUceprotect adaporUceprotect = new AdaporUceprotect();
		adaporUceprotect.parse("C:\\Users\\Oleg\\Desktop\\resource4.txt");
		long timeout = System.currentTimeMillis();
		
//		sourceDao.addIpV4SetToSource(1, adaptorChaosreignsWL.getIpv4List());
//		sourceDao.addIpV6SetToSource(1, adaptorChaosreignsWL.getIpv6List());
//		sourceDao.addNotValidSetToSource(1, adaptorChaosreignsWL.getNotValidList());
		sourceDao.addIpV4SetToSource(2, adaporUceprotect.getIpV4Addresses());
		sourceDao.addIpV6SetToSource(2, adaporUceprotect.getIpV6Addresses());
		sourceDao.addNotValidSetToSource(2, adaporUceprotect.getNotValidIp());
		System.out.println(System.currentTimeMillis()-timeout);

//		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
//		Session session = sessionFactory.openSession();
//		session.beginTransaction();
//		session.getTransaction().commit();
		

	}

}
