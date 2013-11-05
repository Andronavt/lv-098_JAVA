package tc.lv.utils;

public class ParseStrategy {

	private Parser strategy;
	public ParseStrategy(Parser pasrser) {
		this.strategy = pasrser;
	}
	public void setParser(Parser newParser) {
		this.strategy = newParser;
	}
	public Parser getParser() {
		return this.strategy;
	}
}
