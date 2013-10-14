package Test.First.domain;

import java.io.IOException;
import java.util.List;

public interface ParserInterface {
	public List<Ip> parse() throws IOException;
}
