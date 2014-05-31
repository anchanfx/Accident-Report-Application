package nu.ac.th.accidentreport;

public interface ReportTaskListener {
	
	public void onReportSent();
	public void onAcknowledgementReceived(AcknowledgeDataCollection acknowledgeDataCollection);
}
