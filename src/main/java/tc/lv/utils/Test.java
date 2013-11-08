package tc.lv.utils;

import java.util.List;

public class Test {
	public static void main(String[] args) {
		Downloader downloader = new Downloader();
		ParserChaosreignsWL parserChaosreignsWL = new ParserChaosreignsWL();
		ParserOpenBSD parserOpenBSD = new ParserOpenBSD();
		ParserUceprotect parserUceprotect = new ParserUceprotect();
		
		
		
//		parserOpenBSD.parse(downloader.downloadFile("http://www.openbsd.org/spamd/traplist.gz", "D:\\textfiles\\"));
		
		parserUceprotect.parse(downloader.downloadFile("http://wget-mirrors.uceprotect.net/rbldnsd-all/dnsbl-1.uceprotect.net.gz", "D:\\textfiles\\"));
		
//		parserChaosreignsWL.parse(downloader
//				.downloadFile("http://www.chaosreigns.com/iprep/iprep.txt",
		// "D:\\textfiles\\"));

		System.out.println();
	}
}
