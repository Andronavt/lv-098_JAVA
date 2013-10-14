package Test.First.domain;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OpenBSDParser implements ParserInterface {
	private List<Ip> arrayOfIpObjects = new ArrayList<Ip>();
	private IpV4Validator validatorv4 = new IpV4Validator();
	private IpV6Validator validatorv6 = new IpV6Validator();
	private BufferedReader br = null;

	public OpenBSDParser() {
		try {
			br = new BufferedReader(new FileReader("resource3.txt"));
		} catch (FileNotFoundException e1) {
			System.out.println("There is no such file... SORRY");
			e1.printStackTrace();
		}
	}

	public ArrayList<Ip> parse() throws IOException {

		String lineToParce = br.readLine();
		Ip tempObject = null;
		long timeout = System.currentTimeMillis();
		String ip;
		while (lineToParce != null) {
			if (!lineToParce.contains("#")) {
				ip = lineToParce.trim();
				// System.out.println(ip);
				if (validatorv4.validate(ip) == true) {
					tempObject = new ipv4_addresses();
					tempObject.setAddress(ip);
				} else if (validatorv6.validate(ip)) {
					tempObject = new ipv6_addresses();
					tempObject.setAddress(ip);
				} else {
					lineToParce = br.readLine();
					continue;
				}
				arrayOfIpObjects.add(tempObject);
				// System.out.println(tempObject.getAddress());
				tempObject = null;
				lineToParce = br.readLine();
			} else {
				lineToParce = br.readLine();
				continue;
			}
		}
		timeout = System.currentTimeMillis() - timeout;
		System.out.println(timeout);
		br.close();
		return (ArrayList<Ip>) arrayOfIpObjects;
	}
}
