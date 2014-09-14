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
import android.widget.Toast;

public class MainActivity extends Activity {
	public static final int ACTIVITY_CODE = 0;
	
	private ILocator mILocator;
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
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		createInterfaces();
		initializeVariables();
		initializeGUIComponents();
		createReportPopup();
	}
	
	private void initializeVariables() {
		mILocator = new GPS(mLocatorListener, new Position(), getApplicationContext());
		mReportTask = null;
		
		mReportDataCollection = new ReportDataCollection();
		mAccidentData = new AccidentData();
	}
	
	private void initializeGUIComponents() {
		txtViewLongitude = (TextView)findViewById(R.id.txtview_show_longitude);
		txtViewLatitude = (TextView)findViewById(R.id.txtview_show_latitude);
		btnReport = (Button)findViewById(R.id.btn_report);
		btnReport.setOnClickListener(btnReportListener);
		btnReport.setEnabled(false);
		btnAddInfo = (Button)findViewById(R.id.btn_fill_additional_info);
		btnAddInfo.setOnClickListener(btnAddInfoListener);
	}
	
	private void createInterfaces() {
		mLocatorListener = new LocatorListener() {
			@Override
			public void onLocationUpdated(Position position) {
				onPositionReceived(position);
			}
		};
		
		mReportTaskListener = new ReportTaskListener() {
			@Override
			public void onAcknowledgeReceived(AcknowledgeDataCollection acknowledgeDataCollection) {
				updateAcknowledgement(acknowledgeDataCollection);
			}

			@Override
			public void onCaughtException(ApplicationException exception) {
				handleReportException(exception);
			}
		};
		
		btnClosePopupListener = new OnClickListener() {
			@Override
			public void onClick(View v) {
				closePopup();
			}
		};
		
		btnReportListener = new OnClickListener() {	
			@Override
			public void onClick(View v) {
				reportAccident();
			}
		};
		
		btnAddInfoListener = new OnClickListener() {
			@Override
			public void onClick(View v) {
				startAdditionalInfoActivity();
			}
		};
	}
	
	private void createReportPopup() {
		LayoutInflater inflater = (LayoutInflater)MainActivity
				.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		viewReport = inflater.inflate(R.layout.popup_report, (ViewGroup)findViewById(R.id.layout_report));
		
		pwindoReport = new PopupWindow(viewReport, LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, true);
		
		txtViewReportMessage = (TextView)viewReport.findViewById(R.id.txtview_msg_report);
		btnClosePopup = (Button)viewReport.findViewById(R.id.btn_close_report);
		btnClosePopup.setOnClickListener(btnClosePopupListener);
	}
	
	private void onPositionReceived(Position position) {
		updatePosition(position);
		btnReport.setEnabled(true);
		alertOnUpdatePosition();
	}
	
	private void updatePosition(Position position) {
		txtViewLongitude.setText(String.valueOf(position.getLongitude()));
		txtViewLatitude.setText(String.valueOf(position.getLatitude()));
		mAccidentData.setPosition(position);
	}
	
	private void alertOnUpdatePosition() {
		Toast.makeText(getApplicationContext(), R.string.position_updated, 
				   Toast.LENGTH_SHORT).show();
	}
	
	private void reportAccident() {
			showReportPopup();
			sendReport();
	}
	
	private void showReportPopup() {
		txtViewReportMessage.setText(R.string.msg_sending_data);
		pwindoReport.showAtLocation(viewReport, Gravity.CENTER, 0, 0);
	}
	
	private void sendReport() {
		mReportDataCollection.setAccidentData(mAccidentData);
		mReportTask = new ReportTask(new TCP_IP(), mReportTaskListener);
		
		mReportTask.execute(mReportDataCollection);
	}
	
	private void updateAcknowledgement(AcknowledgeDataCollection acknowledgeDataCollection) {
		txtViewReportMessage.setText(acknowledgeDataCollection.getAcknowledgeData().getMessage());
	}
	
	private void handleReportException(ApplicationException exception) {
		txtViewReportMessage.setText(exception.getStringId());
	}
	
	private void closePopup() {
		pwindoReport.dismiss();
	}
	
	private void startAdditionalInfoActivity() {
		Intent intent = new Intent(getBaseContext(), FillAdditionalInfoActivity.class);
		intent.putExtra(FillAdditionalInfoActivity.EXTRA_ADDITIONAL_INFO, 
				mAccidentData.getAdditionalInfo());
		startActivityForResult(intent, FillAdditionalInfoActivity.ACTIVITY_CODE);
	}
	
	@Override
	protected void onPause() {
		mILocator.stopLocatePosition();
		super.onPause();
	}

	@Override
	protected void onResume() {
		mILocator.startLocatePosition();
		super.onResume();
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if(resultCode == RESULT_OK)
		{
			updateAdditionalInfo((AdditionalInfo)data.getSerializableExtra(
					 FillAdditionalInfoActivity.EXTRA_ADDITIONAL_INFO));;
		}
	}
	
	private void updateAdditionalInfo(AdditionalInfo additionalInfo) {
		mAccidentData.setAdditionalInfo(additionalInfo);
	}
}
