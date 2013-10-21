package tc.lv.repo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;

import tc.lv.domain.ipClasses.IpAddress;

public class IpV4AddressDao implements IpDaoInterface {

	@Autowired
	private SessionFactory sessionFactory = null;
	private static IpV4AddressDao ipV4AddressDao = null;

	private IpV4AddressDao() {
		sessionFactory = new Configuration().configure().buildSessionFactory();
	}

	public static IpV4AddressDao getInstance() {
		if (ipV4AddressDao == null) {
			synchronized (IpV4AddressDao.class) {
				if (ipV4AddressDao == null) {
					ipV4AddressDao = new IpV4AddressDao();
				}
			}
		}
		return ipV4AddressDao;
	}

	public boolean add(IpAddress ipAddress) {
		
		Session session = sessionFactory.openSession();
		return false;
	
	}

	public List<IpAddress> getAllIp() {

		return null;
	}

}
