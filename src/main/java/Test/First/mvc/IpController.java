package Test.First.mvc;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session; 

import Test.First.domain.*;

public class IpController {
	public static void main(String[] args) throws IOException {

		Session session = SessionFactoryUtil.getSessionFactory()
				.getCurrentSession();
		System.out.println("==========================================");
		session.beginTransaction(); 
		// queryIpv4(session);
		// queryIpv6(session);
		parseIpv4Ipv6(session);

	}

	private static void queryIpv4(Session session) {

		Query query = session.createQuery("from ipv4_addresses");
		List<ipv4_addresses> list = query.list();
		java.util.Iterator<ipv4_addresses> iter = list.iterator();
		while (iter.hasNext()) {
			ipv4_addresses ip = iter.next();
			System.out.println("Ip: \"" + ip.getAddress() + "\", "
					+ ip.getDate_added());
		}
		session.getTransaction().commit();
	}

	private static void queryIpv6(Session session) {

		Query query = session.createQuery("from ipv6_addresses");
		List<ipv6_addresses> list = query.list();
		java.util.Iterator<ipv6_addresses> iter = list.iterator();
		while (iter.hasNext()) {
			ipv6_addresses ip = iter.next();
			System.out.println("Ip: \"" + ip.getAddress() + "\", "
					+ ip.getDate_added());
		}
		session.getTransaction().commit();
	}

	public static void parseIpv4Ipv6(Session session) throws IOException {

		List<Ip> a = new ArrayList<Ip>();
		OpenBSDParser parser = new OpenBSDParser();
		a = parser.parse();
		System.out.println(a.size());

		Iterator<Ip> it = a.iterator();
		ipv4_addresses ip4Temp = null;
		ipv6_addresses ip6Temp = null;

		while (it.hasNext()) {
			Ip ip = it.next();
			if (ip.getClass() == ipv4_addresses.class) {
				session.saveOrUpdate(ip);
			} else if (ip.getClass() == ipv6_addresses.class) {
				session.saveOrUpdate(ip);
			}
		}
		session.getTransaction().commit();

	}

}
