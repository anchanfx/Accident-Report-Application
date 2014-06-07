package nu.ac.th.accidentreport;

import java.util.Date;

public class AccidentReportData {
	private Position mPosition;
	private AdditionalInfo mAdditionalInfo;
	private Date date;
	
	public AccidentReportData() {
		this(new Position(), new AdditionalInfo(), new Date());
	}

	public AccidentReportData(Position position, AdditionalInfo additionalInfo,
			Date date) {
		super();
		mPosition = position;
		this.date = date;
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
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}	
