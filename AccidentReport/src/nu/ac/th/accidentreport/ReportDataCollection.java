package nu.ac.th.accidentreport;

import java.util.Date;

public class ReportDataCollection {
	private AccidentData mAccidentData;
	private Date mDate;
	
	public ReportDataCollection() {
		this(new AccidentData(), new Date());
	}

	public ReportDataCollection(AccidentData accidentData, Date date) {
		super();
		mAccidentData = accidentData;
		mDate = date;
	}

	public AccidentData getAccidentReportData() {
		return mAccidentData;
	}
	
	public Date getDate() {
		return mDate;
	}

	public void setDate(Date date) {
		this.mDate = date;
	}
}