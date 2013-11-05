package tc.lv.dao;

import java.util.Collection;

public interface BlackListDao {
    
    public void deleteIpV4FromBL(String address);

    public void addIpV4ToBL(String address);

    public void addIpV4ListToBL(Collection<String> list);

    public void deleteIpV6FromBL(String address);

    public void addIpV6ToBL(String address);

    public void addIpV6ListToBL(Collection<String> list);
}
