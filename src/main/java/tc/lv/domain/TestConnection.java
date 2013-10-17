package tc.lv.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;

import tc.lv.domain.ipClasses.IpAddress;
import tc.lv.domain.ipClasses.IpV4Address;
import tc.lv.domain.ipClasses.Source;

public class TestConnection {

	public void testManyToMany() {

		Session session = HibernateUtil.getSession();
		Source src = (Source) session.get(Source.class, 1);

		// Query q = session
		// .createQuery("from tc.lv.domain.ipClasses.IpV4Address");
		//
		// List<IpV4Address> ipv4list = new ArrayList<IpV4Address>(q.list());
		Set<IpV4Address> ipv4set = new HashSet<IpV4Address>();
		IpV4Address ip1 = new IpV4Address();
		ip1.setAddress("1111");
		IpV4Address ip2 = new IpV4Address();
		ip1.setAddress("2222");
		ipv4set.add(ip2);
		ipv4set.add(ip1);

		src.setIpv4Set(ipv4set);
		session.saveOrUpdate(src);
		// System.out.println(q.list());

	}

	public void v4Test() {
		Session session = HibernateUtil.getSession();
		Query q = session
				.createQuery("from tc.lv.domain.ipClasses.IpV4Address");

		List<IpAddress> list = q.list();

		for (IpAddress ipv4 : list) {
			System.out.println(ipv4.getAddress());
			System.out.println(ipv4.getdateAdded());
			System.out.println("-------------------");
		}
	}

	public void notValidTest() {
		Session session = HibernateUtil.getSession();
		Query q = session.createQuery("from tc.lv.domain.ipClasses.NotValidIp");

		List<IpAddress> list = q.list();

		for (IpAddress ipv4 : list) {
			System.out.println(ipv4.getAddress());
			System.out.println(ipv4.getdateAdded());
			System.out.println("-------------------");
		}
	}

	public static void main(String[] args) {
		TestConnection test = new TestConnection();
		// test.v4Test();
		// test.notValidTest();
		test.testManyToMany();
	}
}
