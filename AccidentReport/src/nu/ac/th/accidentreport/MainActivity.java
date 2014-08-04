package nu.ac.th.accidentreport;

import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;

public class MainActivity extends Activity {
	private Locator mLocator;
	private LocatorListener mLocatorListener;
	private ReportTask mReportTask;
	private ReportTaskListener mReportTaskListener;
	
	// MainActivity Components
	private TextView txtViewLongitude;
	private TextView txtViewLatitude;
	private Button btnReport;
	private OnClickListener btnReportListener;
	private Button btnAddInfo;
	private OnClickListener btnAddInfoListener;
	// Report pop-up components
	private View viewReport;
	private PopupWindow pwindoReport;
	private Button btnClosePopup;
	private OnClickListener btnClosePopupListener;
	private TextView txtViewReportMessage;
	
	// Report Data
	private ReportDataCollection mReportDataCollection;
	private AccidentData mAccidentData;
	private AdditionalInfo mAdditionalInfo;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		createInterfaces();
		initializeVariables();
		initializeGUIComponents();
		createReportPopup();
		
		updatePosition(mAccidentData.getPosition());
	}
	
	private void initializeVariables() {
		mLocator = new GPS(mLocatorListener, getApplicationContext());
		mReportTask = null;
		
		mReportDataCollection = new ReportDataCollection();
		mAccidentData = new AccidentData();
		mAdditionalInfo = mAccidentData.getAdditionalInfo();
	}
	
	private void initializeGUIComponents() {
		txtViewLongitude = (TextView)findViewById(R.id.txtview_show_longitude);
		txtViewLatitude = (TextView)findViewById(R.id.txtview_show_latitude);
		btnReport = (Button)findViewById(R.id.btn_report);
		btnReport.setOnClickListener(btnReportListener);
		btnAddInfo = (Button)findViewById(R.id.btn_fill_additional_info);
		btnAddInfo.setOnClickListener(btnAddInfoListener);
	}
	
	private void createInterfaces() {
		mLocatorListener = new LocatorListener() {
			@Override
			public void onLocationUpdated(Position position) {
				updatePosition(position);
			}
		};
		
		mReportTaskListener = new ReportTaskListener() {
			@Override
			public void onReportSent(AcknowledgeDataCollection acknowledgeDataCollection) {
				txtViewReportMessage.setText(acknowledgeDataCollection.getAcknowledgeInfo().getMessage());
			}
		};
		
		btnClosePopupListener = new OnClickListener() {
			@Override
			public void onClick(View v) {
				pwindoReport.dismiss();
				txtViewReportMessage.setText(R.string.msg_sending_data);
			}
		};
		
		btnReportListener = new OnClickListener() {	
			@Override
			public void onClick(View v) {
				showReportPopup();
				sendReport();
			}
		};
		
		btnAddInfoListener = new OnClickListener() {
			@Override
			public void onClick(View v) {
				startAdditionalInfoActivity();
			}
		};
	}
	
	private void createReportPopup()
	{
		LayoutInflater inflater = (LayoutInflater)MainActivity
				.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		viewReport = inflater.inflate(R.layout.popup_report, (ViewGroup)findViewById(R.id.layout_report));
		
		pwindoReport = new PopupWindow(viewReport, LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, true);
		
		txtViewReportMessage = (TextView)viewReport.findViewById(R.id.txtview_msg_report);
		btnClosePopup = (Button)viewReport.findViewById(R.id.btn_close_report);
		btnClosePopup.setOnClickListener(btnClosePopupListener);
	}
	
	private void updatePosition(Position position)
	{
		txtViewLongitude.setText(String.valueOf(position.getLongitude()));
		txtViewLatitude.setText(String.valueOf(position.getLatitude()));
		mAccidentData.setPosition(position);
	}
	
	private void showReportPopup()
	{
		pwindoReport.showAtLocation(viewReport, Gravity.CENTER, 0, 0);
	}
	
	private void sendReport() {
		mReportDataCollection.setAccidentData(mAccidentData);
		mReportTask = new ReportTask(new TCP_IP(), mReportTaskListener);
		mReportTask.execute(mReportDataCollection);
	}
	
	private void startAdditionalInfoActivity() {
		Intent intent = new Intent(getBaseContext(), FillAdditionalInfoActivity.class);
		startActivity(intent);
	}
	
	@Override
	protected void onPause() {
		mLocator.stopLocatePosition();
		super.onPause();
	}

	@Override
	protected void onResume() {
		mLocator.startLocatePosition();
		super.onResume();
	}
}
