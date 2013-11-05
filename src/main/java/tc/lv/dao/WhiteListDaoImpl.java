package tc.lv.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import tc.lv.domain.IpV4Address;
import tc.lv.domain.IpV6Address;
import tc.lv.domain.Source;

@Repository
public class WhiteListDaoImpl implements WhiteListDao {

    @PersistenceContext(name = "primary")
    private EntityManager entityManager;

    public WhiteListDaoImpl() {

    }

    public Collection<IpV4Address> getWhiteIpV4List() {
	Query q = entityManager.createNamedQuery("loadWhiteIpV4List")
		.setParameter("whitelist", true);
	ArrayList<IpV4Address> list = new ArrayList<IpV4Address>();
	try {
	    list.addAll(q.getResultList());
	} catch (NoResultException e) {
	    // TODO: handle exception
	} catch (NonUniqueResultException e) {
	    // TODO: handle exception
	}
	return list;
    }

    public Collection<IpV4Address> getUndefinedIpV4List() {
	Query q = entityManager.createNamedQuery("loadUndefinedIpV4List");
	ArrayList<IpV4Address> list = new ArrayList<IpV4Address>();
	try {
	    list.addAll(q.getResultList());
	} catch (NoResultException e) {
	    // TODO: handle exception
	} catch (NonUniqueResultException e) {
	    // TODO: handle exception
	}
	return list;
    }

    public void deleteIpV4FromWL(String address) {
	Query q = entityManager.createNamedQuery("loadWhiteIpV4byName")
		.setParameter("address", address);
	try {
	    IpV4Address obj = (IpV4Address) q.getSingleResult();
	    obj.setWhiteList(false);
	    entityManager.persist(obj);
	} catch (Exception e) {
	}

    }

    public void addIpV4ToWL(String address) {
	Query q = entityManager.createNamedQuery("loadIpV4ByName")
		.setParameter("address", address);
	IpV4Address obj = null;
	try {
	    obj = (IpV4Address) q.getSingleResult();

	    obj.setWhiteList(true);

	    entityManager.persist(obj);
	} catch (NoResultException e) {
	    Source source = entityManager.find(Source.class, 4);
	    obj = new IpV4Address();
	    obj.setAddress(address);
	    obj.setdateAdded(new Date());
	    obj.setWhiteList(true);
	    obj.getSourceSet().add(source);
	    entityManager.persist(obj);
	}

    }

    public void addIpV4ListToWL(Collection<String> list) {
	for (String address : list) {
	    addIpV4ToWL(address);
	}
    }

    public Collection<IpV6Address> getWhiteIpV6List() {
	Query q = entityManager.createNamedQuery("loadWhiteIpV6List")
		.setParameter("whitelist", true);
	ArrayList<IpV6Address> list = new ArrayList<IpV6Address>();
	try {
	    list.addAll(q.getResultList());
	} catch (NoResultException e) {
	    // TODO: handle exception
	} catch (NonUniqueResultException e) {
	    // TODO: handle exception
	}
	return list;
    }

    public Collection<IpV6Address> getUndefinedIpV6List() {
	Query q = entityManager.createNamedQuery("loadUndefinedIpV6List");
	ArrayList<IpV6Address> list = new ArrayList<IpV6Address>();
	try {
	    list.addAll(q.getResultList());
	} catch (NoResultException e) {
	    // TODO: handle exception
	} catch (NonUniqueResultException e) {
	    // TODO: handle exception
	}
	return list;
    }

    public void deleteIpV6FromWL(String address) {
	Query q = entityManager.createNamedQuery("loadWhiteIpV6byName")
		.setParameter("address", address);

	try {
	    IpV6Address obj = (IpV6Address) q.getSingleResult();
	    obj.setWhiteList(false);

	    entityManager.persist(obj);
	} catch (Exception e) {
	}

    }

    public void addIpV6ToWL(String address) {
	Query q = entityManager.createNamedQuery("loadIpV6ByName")
		.setParameter("address", address);
	IpV6Address obj = null;
	try {
	    obj = (IpV6Address) q.getSingleResult();

	    obj.setWhiteList(true);

	    entityManager.persist(obj);
	} catch (NoResultException e) {
	    Source source = entityManager.find(Source.class, 4);
	    obj = new IpV6Address();
	    obj.setAddress(address);
	    obj.setdateAdded(new Date());
	    obj.setWhiteList(true);
	    obj.getSourceSet().add(source);
	    entityManager.persist(obj);
	}

    }

    public void addIpV6ListToWL(Collection<String> list) {
	for (String address : list) {
	    addIpV6ToWL(address);
	}
    }

}