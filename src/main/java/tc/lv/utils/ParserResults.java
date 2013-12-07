package tc.lv.utils;

import java.util.ArrayList;

import tc.lv.domain.IpV4Address;
import tc.lv.domain.IpV6Address;
import tc.lv.domain.NotValidIp;

public class ParserResults {

    private ArrayList<IpV4Address> ipV4List = new ArrayList<IpV4Address>();
    private ArrayList<IpV6Address> ipV6List = new ArrayList<IpV6Address>();
    private ArrayList<NotValidIp> notValidList = new ArrayList<NotValidIp>();
    private int sourceId;

    public ArrayList<IpV4Address> getIpV4List() {
        return ipV4List;
    }

    public void setIpV4List(ArrayList<IpV4Address> ipV4List) {
        this.ipV4List = ipV4List;
    }

    public ArrayList<IpV6Address> getIpV6List() {
        return ipV6List;
    }

    public void setIpV6List(ArrayList<IpV6Address> ipV6List) {
        this.ipV6List = ipV6List;
    }

    public ArrayList<NotValidIp> getNotValidList() {
        return notValidList;
    }

    public void setNotValidList(ArrayList<NotValidIp> notValidList) {
        this.notValidList = notValidList;
    }

    public int getSourceId() {
        return sourceId;
    }

    public void setSourceId(int sourceId) {
        this.sourceId = sourceId;
    }

    public void addToIpV4List(IpV4Address address) {
        ipV4List.add(address);
    }

    public void addToIpV6List(IpV6Address address) {
        ipV6List.add(address);
    }

    public void addToNotValidList(NotValidIp address) {
        notValidList.add(address);
    }

}
