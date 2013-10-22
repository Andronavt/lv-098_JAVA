package tc.lv.parsers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import tc.lv.domain.IpV4Address;
import tc.lv.domain.IpV6Address;
import tc.lv.domain.NotValidIp;

public class AdaporUceprotect {
	 private static final String ALL_IP = "(([0-9]{0,3}+[.]){3}+([0-9]{1,}){1})|(([0-9a-zA-Z]{4}+[:]){2}+[0-9a-zA-Z]{0,4})";
	    private BufferedReader reader;
	    private ArrayList<IpV4Address> ipV4Addresses = new ArrayList<IpV4Address>();
	    private ArrayList<IpV6Address> ipV6Addresses = new ArrayList<IpV6Address>();
	    private ArrayList<NotValidIp> notValidIp = new ArrayList<NotValidIp>();
	   
	    

	    public  ArrayList<IpV4Address> getIpV4Addresses() {
	        return this.ipV4Addresses;
	    }

	    public  ArrayList<IpV6Address> getIpV6Addresses() {
	        return this.ipV6Addresses;
	    }


	    public  ArrayList<NotValidIp> getNotValidIp() {
	        return this.notValidIp;
	    }


	    public void parse(String way) throws FileNotFoundException {
	        Matcher allIp;
	        Pattern patternIp = Pattern.compile(ALL_IP);
	        reader = new BufferedReader(new FileReader(way));
	        String line;
	        try {
	            //check IP
	            while ((line = reader.readLine()) != null) {
	                //Thread.sleep(1000);
	                allIp = patternIp.matcher(line);
	                if (allIp.find()) {
	                    line = allIp.group();
	                    if (IpValidator.isIpV4(line)) {
	                        ipV4Addresses.add(new IpV4Address(line, new Date()));
	                    } else if (IpValidator.isIpV6(line)) {
	                        ipV6Addresses.add(new IpV6Address(line, new Date()));
	                    } else {
	                        notValidIp.add(new NotValidIp(line, new Date()));
	                    }
	                }
	            }

	        } catch (Exception e) {
	        	System.out.println("ERROR");
	            e.printStackTrace();
	        }
	    }
}
