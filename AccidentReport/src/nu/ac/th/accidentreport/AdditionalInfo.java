package nu.ac.th.accidentreport;

public class AdditionalInfo {
	private static final AccidentType DEFAULT_TYPE = AccidentType.UNKNOWN;
	private static final int DEFAULT_AMOUNT = 0;
	private static final boolean DEFAULT_TRAFFIC_BLOCKED = false;
	private static final String DEFAULT_MESSAGE = "";
	
	private AccidentType mAccidentType;
	private int amountOfInjured;
	private int amountOfDead;
	private boolean trafficBlocked;
	private String message;
			
	public AdditionalInfo() {
		this(DEFAULT_TYPE, DEFAULT_AMOUNT, DEFAULT_AMOUNT, DEFAULT_TRAFFIC_BLOCKED, DEFAULT_MESSAGE);	
	}
	
	public AdditionalInfo(AccidentType accidentType,
			int amountOfInjured, int amountOfDead,
			boolean trafficBlocked, String message) {
		super();
		mAccidentType = accidentType;
		this.amountOfInjured = amountOfInjured;
		this.amountOfDead = amountOfDead;
		this.trafficBlocked = trafficBlocked;
		this.message = message;
	}

	public AccidentType getAccidentType() {
		return mAccidentType;
	}
	public void setAccidentType(AccidentType accidentType) {
		mAccidentType = accidentType;
	}
	public int getAmountOfInjured() {
		return amountOfInjured;
	}
	public void setAmountOfInjured(int amountOfInjured) {
		this.amountOfInjured = amountOfInjured;
	}
	public int getAmountOfDead() {
		return amountOfDead;
	}
	public void setAmountOfDead(int amountOfDead) {
		this.amountOfDead = amountOfDead;
	}
	public boolean isTrafficBlocked() {
		return trafficBlocked;
	}
	public void setTrafficBlocked(boolean trafficBlocked) {
		this.trafficBlocked = trafficBlocked;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
