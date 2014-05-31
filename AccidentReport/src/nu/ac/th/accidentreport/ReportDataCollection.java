package nu.ac.th.accidentreport;

public class ReportDataCollection {
	private AccidentReportData mAccidentReportData;
	
	public ReportDataCollection() {
		this(new AccidentReportData());
	}

	public ReportDataCollection(AccidentReportData accidentReportData) {
		super();
		mAccidentReportData = accidentReportData;
	}

	public AccidentReportData getAccidentReportData() {
		return mAccidentReportData;
	}
}