package nu.ac.th.accidentreport;

public abstract class ServerConnector {	
	public abstract void sendReport(ReportDataCollection reportDataCollection);
	public abstract AcknowledgeDataCollection receieveAcknowledgement();
}
