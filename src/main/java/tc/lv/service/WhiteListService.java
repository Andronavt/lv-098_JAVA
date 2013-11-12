package tc.lv.service;

import java.util.Collection;

import tc.lv.domain.IpV4Address;
import tc.lv.domain.IpV6Address;
import tc.lv.exceptions.DBException;
import tc.lv.exceptions.DBIllegalArgumentException;
import tc.lv.exceptions.DBIllegalStateException;
import tc.lv.exceptions.DBPersistanceException;

public interface WhiteListService {
    public void deleteIpV4(String address) throws DBPersistanceException,
	    DBIllegalArgumentException, DBIllegalStateException, DBException;

    public void deleteIpV6(String address) throws DBPersistanceException,
	    DBIllegalArgumentException, DBIllegalStateException, DBException;

    public void saveIpV4(String address) throws DBPersistanceException,
	    DBIllegalArgumentException, DBIllegalStateException, DBException;

    public void saveIpV6(String address) throws DBPersistanceException,
	    DBIllegalArgumentException, DBIllegalStateException, DBException;

    public Collection<IpV4Address> loadIpV4List()
	    throws DBPersistanceException, DBIllegalArgumentException,
	    DBIllegalStateException, DBException;

    public Collection<IpV6Address> loadIpV6List()
	    throws DBPersistanceException, DBIllegalArgumentException,
	    DBIllegalStateException, DBException;

    public Collection<IpV4Address> loadIpV4ListByRange(int from, int count)
	    throws DBPersistanceException, DBIllegalArgumentException,
	    DBIllegalStateException, DBException;

    public Collection<IpV6Address> loadIpV6ListByRange(int from, int count)
	    throws DBPersistanceException, DBIllegalArgumentException,
	    DBIllegalStateException, DBException;
}
