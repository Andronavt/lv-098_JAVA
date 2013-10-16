package tc.lv.domain;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import tc.lv.domain.ipclasses.IpAddress;
import tc.lv.domain.ipclasses.IpV4Address;

public class TestConnection {

	public void v4Test() {
		Session session = HibernateUtil.getSession();
		Query q = session
				.createQuery("from tc.lv.domain.ipclasses.IpV4Address");

		List<IpAddress> list = q.list();

		for (IpAddress ipv4 : list) {
			System.out.println(ipv4.getAddress());
			System.out.println(ipv4.getdateAdded());
			System.out.println("-------------------");
		}
	}
	
	public void notValidTest() {
		Session session = HibernateUtil.getSession();
		Query q = session
				.createQuery("from tc.lv.domain.ipclasses.NotValidIp");

		List<IpAddress> list = q.list();

		for (IpAddress ipv4 : list) {
			System.out.println(ipv4.getAddress());
			System.out.println(ipv4.getdateAdded());
			System.out.println("-------------------");
		}
	}
	
	public static void main(String[] args) {
		TestConnection test= new TestConnection();
		test.v4Test();
		test.notValidTest();
	}
}
