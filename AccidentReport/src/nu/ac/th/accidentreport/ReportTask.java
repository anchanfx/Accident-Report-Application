package nu.ac.th.accidentreport;

import android.os.AsyncTask;

public class ReportTask extends AsyncTask<Void, Void, Void> {
	private ServerConnector mServerConnector;
	private ReportTaskListener mReportTaskListener;
	private ReportDataCollection mReportDataCollection;
	
	public ReportTask(ServerConnector serverConnector,
						ReportTaskListener reportTaskListener,
						ReportDataCollection reportDataCollection) {
		super();
		mServerConnector = serverConnector;
		mReportTaskListener = reportTaskListener;
		mReportDataCollection = reportDataCollection;	
	}

	@Override
	protected Void doInBackground(Void... params) {
		AcknowledgeDataCollection acknowledgeDataCollection = null;
		
		mServerConnector.sendReport(mReportDataCollection);
		mReportTaskListener.onReportSent();
		
		acknowledgeDataCollection = mServerConnector.receieveAcknowledgement();
		mReportTaskListener.onAcknowledgementReceived(acknowledgeDataCollection);
	
		return null;
	}
}
