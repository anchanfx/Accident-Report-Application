package nu.ac.th.accidentreport;

public abstract class ServerConnector {	
	public abstract AcknowledgeDataCollection sendReport(ReportDataCollection reportDataCollection);
}
