package nu.ac.th.accidentreport;

public class AdditionalInfo {
	private static final AccidentType DEFAULT_TYPE = AccidentType.UNKNOWN;
	private static final int DEFAULT_AMOUNT = 0;
	private static final boolean DEFAULT_TRAFFIC_BLOCKED = false;
	private static final String DEFAULT_MESSAGE = "";
	
	private AccidentType mAccidentType;
	private int amountOfInjuredPerson;
	private int amountOfDeadlyPerson;
	private boolean trafficBlocked;
	private String message;
			
	public AdditionalInfo() {
		this(DEFAULT_TYPE, DEFAULT_AMOUNT, DEFAULT_AMOUNT, DEFAULT_TRAFFIC_BLOCKED, DEFAULT_MESSAGE);	
	}
	
	public AdditionalInfo(AccidentType accidentType,
			int amountOfInjuredPerson, int amountOfDeadlyPerson,
			boolean trafficBlocked, String message) {
		super();
		mAccidentType = accidentType;
		this.amountOfInjuredPerson = amountOfInjuredPerson;
		this.amountOfDeadlyPerson = amountOfDeadlyPerson;
		this.trafficBlocked = trafficBlocked;
		this.message = message;
	}

	public AccidentType getAccidentType() {
		return mAccidentType;
	}
	public void setAccidentType(AccidentType accidentType) {
		mAccidentType = accidentType;
	}
	public int getAmountOfInjuredPerson() {
		return amountOfInjuredPerson;
	}
	public void setAmountOfInjuredPerson(int amountOfInjuredPerson) {
		this.amountOfInjuredPerson = amountOfInjuredPerson;
	}
	public int getAmountOfDeadlyPerson() {
		return amountOfDeadlyPerson;
	}
	public void setAmountOfDeadlyPerson(int amountOfDeadlyPerson) {
		this.amountOfDeadlyPerson = amountOfDeadlyPerson;
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
