package nu.ac.th.accidentreport;

import java.util.Date;

public class ReportDataCollection {
	private AccidentData mAccidentData;
	private String mIMEI;
	private Date mDate;
	
	public ReportDataCollection() {
		this(new AccidentData(), new Date());
	}
	
	public ReportDataCollection(AccidentData accidentData) {
		this(accidentData, new Date());
	}

	public ReportDataCollection(AccidentData accidentData, Date date) {
		this(accidentData, "", date);
	}
	
	public ReportDataCollection(AccidentData accidentData, String IMEI, Date date) {
		super();
		mAccidentData = accidentData;
		mIMEI = IMEI;
		mDate = date;
	}
	
	public AccidentData getAccidentData() {
		return mAccidentData;
	}

	public void setAccidentData(AccidentData accidentData) {
		mAccidentData = accidentData;
	}

	public String getIMEI() {
		return mIMEI;
	}

	public void setIMEI(String IMEI) {
		mIMEI = IMEI;
	}
	
	public Date getDate() {
		return mDate;
	}

	public void setDate(Date date) {
		mDate = date;
	}
}