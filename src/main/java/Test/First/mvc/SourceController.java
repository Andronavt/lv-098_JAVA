package Test.First.mvc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;

import Test.First.domain.Ip;
import Test.First.domain.OpenBSDParser;
import Test.First.domain.SessionFactoryUtil;
import Test.First.domain.IpSource;
import Test.First.domain.ipv4_addresses;
import Test.First.domain.ipv6_addresses;

public class SourceController {

	public static void main(String[] args) throws IOException {

		Session session = SessionFactoryUtil.getSessionFactory()
				.getCurrentSession();
		System.out.println("==========================================");
		session.beginTransaction();
		// openBSDParse(session);
		querySources(session);
		// manyToManyTest(session);
	}

	private static void querySources(Session session) {

		Query query = session.createQuery("from IpSource");
		List<IpSource> list = query.list();
		java.util.Iterator<IpSource> iter = list.iterator();
		while (iter.hasNext()) {
			IpSource source = iter.next();
			System.out.println("\n" + source.getId() + ": " + "\n"
					+ " Source Name " + source.getSource_name() + "\n"
					+ " url " + source.getUrl() + "\n" + " Date Added "
					+ source.getSource_date_added() + "\n" + " updated "
					+ source.getUpdated() + "\n" + " rank " + source.getRank()
					+ "\n" + " dirname " + source.getDirname() + "\n"
					+ " list type " + source.getList_type() + "\n"
					+ " adaptor " + source.getAdaptor() + "\n" + " dowloader "
					+ source.getDownloader() + "\n" + " md5 " + source.getMd5()
					+ "\n");
		}
		session.getTransaction().commit();
	}

	private static void openBSDParse(Session session) throws IOException {
		OpenBSDParser parser = new OpenBSDParser();
		List<Ip> a = new ArrayList<Ip>();
		a = parser.parse();
		IpSource source = (IpSource) session.load(IpSource.class, 1);

		Set<ipv4_addresses> ip4Set = new HashSet<ipv4_addresses>();
		Set<ipv6_addresses> ip6Set = new HashSet<ipv6_addresses>();
		for (Ip ipTemp : a) {
			if (ipTemp.getClass() == ipv4_addresses.class)
				ip4Set.add((ipv4_addresses) ipTemp);
			else
				ip6Set.add((ipv6_addresses) ipTemp);
		}
		source.setIpv4Set(ip4Set);
		source.setIpv6Set(ip6Set);
		session.saveOrUpdate(source);
		session.getTransaction().commit();

	}
}
