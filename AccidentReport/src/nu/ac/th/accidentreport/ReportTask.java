package nu.ac.th.accidentreport;

import android.os.AsyncTask;

public class ReportTask extends AsyncTask<ReportDataCollection, Void, AcknowledgeDataCollection> {
	private ServerConnector mServerConnector;
	private ReportTaskListener mReportTaskListener;
	
	public ReportTask(ServerConnector serverConnector,
						ReportTaskListener reportTaskListener) {
		super();
		mServerConnector = serverConnector;
		mReportTaskListener = reportTaskListener;
	}

	@Override
	protected AcknowledgeDataCollection doInBackground(ReportDataCollection... reportDataCollections) {
		AcknowledgeDataCollection acknowledgeDataCollection = null;
		
		acknowledgeDataCollection = mServerConnector.sendReport(reportDataCollections[0]);

		return acknowledgeDataCollection;
	}
	
	@Override
	protected void onPostExecute(AcknowledgeDataCollection acknowledgeDataCollection) {
		mReportTaskListener.onReportSent(acknowledgeDataCollection);
	}
}
