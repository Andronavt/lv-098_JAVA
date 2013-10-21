//package tc.lv.domain.test;
//
//import java.util.Collection;
//import java.util.HashSet;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Set;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;
//
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.cfg.Configuration;
//
//public class Test {
//
//	public void Test1() {
//		// SessionFactory sessionFactory = new Configuration().configure()
//		// .buildSessionFactory();
//		// Session session = sessionFactory.openSession();
//		// session.beginTransaction();
//		// session.getTransaction().commit();
//
//		EntityManagerFactory emf = Persistence
//				.createEntityManagerFactory("primary");
//		EntityManager entityManager = emf.createEntityManager();
//		entityManager.getTransaction().begin();
//
//		// Source source1 = entityManager.find(Source.class, 1);
//		// Source source2 = entityManager.find(Source.class, 2);
//		// IpV4Address ip = new IpV4Address("1");
//		// source1.addElementToSetV4(ip);
//		// source2.addElementToSetV4(ip);
//		// ip.addElementToSourceSet(source2);
//		// ip.addElementToSourceSet(source1);
//		// entityManager.persist(source1);
//		// entityManager.refresh(ip);
//
//		Source source1 = entityManager.find(Source.class, 1);
//		IpV4Address ip = new IpV4Address("1");
//		Set<IpV4Address> ip4Set = new HashSet<IpV4Address>();
//		List<IpV4Address> a = entityManager.createQuery("from IpV4Address")
//				.getResultList();
//		
//		Iterator it = a.iterator();
//		while (it.hasNext()) {
//			if (a.contains(ip)) {
//				IpV4Address temp = (IpV4Address) it.next();
//				if (temp.equals(ip)) {
//					temp.addElementToSourceSet(source1);
//				}
//				ip4Set.add(temp);
//			} else {
//				ip4Set.add(ip);
//				ip.addElementToSourceSet(source1);
//				break;
//			}
//		}
//		source1.setIpv4Set(ip4Set);
//		entityManager.persist(source1);
//		//entityManager.refresh(ip);
//		entityManager.getTransaction().commit();
//
//	}
//	public static void main(String[] args) {
//		Test test = new Test();
//		test.Test1();
//
//	}
//}
