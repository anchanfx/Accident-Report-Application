package nu.ac.th.accidentreport;

import android.os.AsyncTask;

public class ReportTask extends AsyncTask<ReportDataCollection, Void, AcknowledgeDataCollection> {
	private IServerConnector mServerConnector;
	private ReportTaskListener mReportTaskListener;
	private ApplicationException caughtException;
	
	public ReportTask(IServerConnector serverConnector,
						ReportTaskListener reportTaskListener) {
		super();
		mServerConnector = serverConnector;
		mReportTaskListener = reportTaskListener;
		caughtException = null;
	}

	@Override
	protected AcknowledgeDataCollection doInBackground(ReportDataCollection... reportDataCollections) {
		AcknowledgeDataCollection acknowledgeDataCollection = null;
		
		try {
			acknowledgeDataCollection = mServerConnector.sendReport(reportDataCollections[0]);
		} catch (ApplicationException e) {
			caughtException = e;
		}

		return acknowledgeDataCollection;
	}
	
	@Override
	protected void onPostExecute(AcknowledgeDataCollection acknowledgeDataCollection) {
		
		if(caughtException != null) {
			mReportTaskListener.onCaughtException(caughtException);
		} else {
			mReportTaskListener.onAcknowledgeReceived(acknowledgeDataCollection);
		}
	}
}