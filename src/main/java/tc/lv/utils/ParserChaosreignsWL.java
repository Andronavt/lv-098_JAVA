package tc.lv.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

import tc.lv.domain.IpV4Address;
import tc.lv.domain.IpV6Address;
import tc.lv.domain.NotValidIp;
import tc.lv.exceptions.DownloadException;

public class ParserChaosreignsWL implements Parser {
    protected static final String IP_ALL = "(([0-9]{0,3}+[.]){3}+([0-9]{1,}){1})|(([0-9a-zA-Z]{4}+[:]){2}+[0-9a-zA-Z]{0,4})";

    private static final Logger LOGGER = Logger.getLogger(ParserChaosreignsWL.class);
    private static final Pattern PATTERN = Pattern.compile(IP_ALL);

    private ParserResults parserResults = new ParserResults();

    public ParserChaosreignsWL() {
    }

    @Override
    public ParserResults parse(File file) throws DownloadException {
        LOGGER.info("START PARSING ChaosreignsWL");
        Matcher matcher;
        Scanner scanner;

        try {
            scanner = new Scanner(new BufferedReader(new FileReader(file)));

            while (scanner.hasNext()) {
                String tmpIpAddress = "";
                matcher = PATTERN.matcher(scanner.nextLine());

                if (matcher.find()) {
                    tmpIpAddress = matcher.group();

                    if (IpValidator.isIpV4(tmpIpAddress)) {
                        parserResults.addToIpV4List(new IpV4Address(tmpIpAddress, new Date(), null));
                    } else if (IpValidator.isIpV6(tmpIpAddress)) {
                        parserResults.addToIpV6List(new IpV6Address(tmpIpAddress, new Date(), null));
                    } else {
                        parserResults.addToNotValidList(new NotValidIp(tmpIpAddress, new Date()));
                    }
                }
            }

            scanner.close();

        } catch (Exception e) {
            LOGGER.error("File not found!", e);
            throw new DownloadException("File not found", e);
        }
        LOGGER.info("FINISH PARSING ChaosreignsWL");
        return parserResults;
    }
}
