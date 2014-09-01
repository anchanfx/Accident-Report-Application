package nu.ac.th.accidentreport;

public interface IServerConnector {	
	public  AcknowledgeDataCollection sendReport(ReportDataCollection reportDataCollection) throws ApplicationException;
}
