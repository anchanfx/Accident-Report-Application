package nu.ac.th.accidentreport;

import java.util.Date;

public class AccidentReportData {
	private Position mPosition;
	private AdditionalInfo mAdditionalInfo;
	private Date reportDate;
	
	public AccidentReportData() {
		this(null, null, new Date());
	}

	public AccidentReportData(Position position, AdditionalInfo additionalInfo,
			Date reportDate) {
		super();
		mPosition = position;
		this.reportDate = reportDate;
		mAdditionalInfo = additionalInfo;
	}

	public Position getPosition() {
		return mPosition;
	}

	public void setPosition(Position position) {
		mPosition = position;
	}

	public AdditionalInfo getAdditionalInfo() {
		return mAdditionalInfo;
	}

	public void setAdditionalInfo(AdditionalInfo additionalInfo) {
		mAdditionalInfo = additionalInfo;
	}
	
	public Date getReportDate() {
		return reportDate;
	}

	public void setReportDate(Date reportDate) {
		this.reportDate = reportDate;
	}
}	
