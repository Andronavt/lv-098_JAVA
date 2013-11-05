package tc.lv.utils;

import java.util.List;

public class Test {
	public static void main(String[] args) {
		Downloader downloader = new Downloader();
		String name = downloader
				.downloadFile("http://www.chaosreigns.com/iprep/iprep.txt","D:\\textfiles\\");
//		String name = downloader
//				.downloadFile("http://www.openbsd.org/spamd/traplist.gz");
		System.out.println(name);
	}
}
