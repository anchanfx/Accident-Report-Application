package nu.ac.th.accidentreport;

public class ServerErrorException extends ApplicationException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1964312185510092973L;
	public static final int NO_CONNECTION = R.string.no_connection;
	public static final int NO_RESPOND = R.string.no_respond;
	
	public ServerErrorException() {
		super();
	}

	public ServerErrorException(int stringId) {
		super(stringId);
	}
}
