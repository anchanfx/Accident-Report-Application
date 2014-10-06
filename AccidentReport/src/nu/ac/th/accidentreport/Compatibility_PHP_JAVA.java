package nu.ac.th.accidentreport;

public class Compatibility_PHP_JAVA {
	
	public static boolean booleanInPhpToJava(int booleanInt) {
		return booleanInt == 1;
	}
	
	public static Long timeStampInPhpToJava(Long timeStamp) {
		return timeStamp*1000;
	}
	
	public static Long timeStampInJavaToPhp(Long timeStamp) {
		return timeStamp/1000;
	}
}
