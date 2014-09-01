package nu.ac.th.accidentreport;

public interface ServerConnector {	
	public  AcknowledgeDataCollection sendReport(ReportDataCollection reportDataCollection) throws ApplicationException;
}
