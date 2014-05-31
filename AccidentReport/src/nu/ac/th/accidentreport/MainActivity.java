package nu.ac.th.accidentreport;

import java.util.Date;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity {
	private Locator mLocator;
	private LocatorListener mLocatorListener;
	private ReportTask mReportTask;
	private ReportTaskListener mReportTaskListener;
	
	private TextView mTextView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		initializeVariables();
	}
	
	private void initializeVariables() {
		createInterfaces();
		mLocator = new GPS(mLocatorListener, getApplicationContext());
		mTextView = (TextView)findViewById(R.id.textview);	
		mReportTask = new ReportTask(new TCP_IP(), mReportTaskListener);
	}
	
	private void createInterfaces() {
		mLocatorListener = new LocatorListener() {
			@Override
			public void onLocationUpdated(Position position) {
				// Update a position from locator into Textview or something
				// mTextView.setText(position.toString());
			}
		};
		
		mReportTaskListener = new ReportTaskListener() {
			@Override
			public void onReportSent() {
				// Do Something when data was sent
				//mTextView.setText("SENT!!");
			}
			
			@Override
			public void onAcknowledgementReceived(
					AcknowledgeDataCollection acknowledgeDataCollection) {
				// Do Something when ack was received
				//mTextView.setText("RECV!!");
			}
		};
	}
	
	@Override
	protected void onPause() {
		mLocator.stopLocatePosition();
		
		super.onPause();
	}

	@Override
	protected void onResume() {
		mLocator.startLocatePosition();
		//mReportTask.execute(new ReportDataCollection());
		super.onResume();
	}
}
