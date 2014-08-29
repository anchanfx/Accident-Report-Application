package nu.ac.th.accidentreport;

public interface ReportTaskListener {
	
	public void onAcknowledgeReceived(AcknowledgeDataCollection acknowledgeDataCollection);
	public void onCaughtException(ApplicationException exception);
}
