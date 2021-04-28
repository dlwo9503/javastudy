package prob03;

public class CurrencyConverter {
	private static double rate;

	public static double toDollar(double d) {
		double dollar = d / rate;
		return dollar;
	}

	public static double toKRW(double d) {
		double krw = d * rate;
		return krw;
	}
	
	public static void setRate(double d) {
		rate = d;
	}

}
