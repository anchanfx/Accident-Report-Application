package nu.ac.th.accidentreport;

public class UserErrorException extends ApplicationException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -9184780626304778087L;
	
	public static int NO_CONNECTION = R.string.no_connection;
	
	public UserErrorException() { 
		super();
	}
	
	public UserErrorException(int stringId) {
		super(stringId);
	}
}
