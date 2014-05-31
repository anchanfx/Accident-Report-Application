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
		
		mServerConnector.sendReport(reportDataCollections[0]);
		publishProgress((Void[])null);
		
		acknowledgeDataCollection = mServerConnector.receieveAcknowledgement();

		return acknowledgeDataCollection;
	}
	
	@Override
	protected void onProgressUpdate(Void... values) {
		mReportTaskListener.onReportSent();
	}
	
	@Override
	protected void onPostExecute(AcknowledgeDataCollection acknowledgeDataCollection) {
		mReportTaskListener.onAcknowledgementReceived(acknowledgeDataCollection);
	}
}
