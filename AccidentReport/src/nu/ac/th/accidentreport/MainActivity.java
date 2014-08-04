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

public class MainActivity extends Activity {
	private Locator mLocator;
	private LocatorListener mLocatorListener;
	private ReportTask mReportTask;
	private ReportTaskListener mReportTaskListener;
	
	//private TextView mTextView;
	//private PopupWindow pwindo;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		initializeVariables();
		fill_additional_info();
		report();
	}
	
	private void report() {
		final Button btn = (Button) findViewById(R.id.btn_report);
		btn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//Intent intent = new Intent(getBaseContext(), ReportActivity.class);
				//startActivity(intent);
				show_report();
				
			}
		});
	}
	private PopupWindow pwindo;
	Button btnClosePopup;
	private void show_report()
	{
		try{
			LayoutInflater inflater = (LayoutInflater) MainActivity.this
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			View layout = inflater.inflate(R.layout.report, (ViewGroup) findViewById(R.id.layout_report));
			pwindo = new PopupWindow(layout, LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, true);
			pwindo.showAtLocation(layout, Gravity.CENTER, 0, 0);
			
			btnClosePopup = (Button) layout.findViewById(R.id.layout_additional_info);
			btnClosePopup.setOnClickListener(cancel_btn);
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	
	private OnClickListener cancel_btn = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			pwindo.dismiss();
			
		}
	};
	private void fill_additional_info() {
		final Button plus = (Button) findViewById(R.id.btn_fill_additional_info);
		final Button btn = (Button) findViewById(R.id.btn_fill_additional_info);
		btn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getBaseContext(), FillAdditionalActivity.class);
				startActivity(intent);
				//finish();
				//startActivityForResult(intent, 10);
				
				//LayoutInflater inflater = (LayoutInflater) MainActivity.this
				//		.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				//View layout = inflater.inflate(R.layout.fill_additional_info, (ViewGroup) findViewById(R.id.layout_fill_addional_info));
				//pwindo = new PopupWindow(layout, 600, 875, true);
				//pwindo.showAtLocation(layout, Gravity.CENTER, 0, 0);
			}
		});
	}
	
	private void initializeVariables() {
		createInterfaces();
		mLocator = new GPS(mLocatorListener, getApplicationContext());
		mReportTask = new ReportTask(new TCP_IP(), mReportTaskListener);
		
		//mTextView = (TextView)findViewById(R.id.textview);
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
			public void onReportSent(AcknowledgeDataCollection acknowledgeDataCollection) {
				// Do Something when data was sent
				//mTextView.setText(acknowledgeDataCollection.getAcknowledgeInfo().getMessage());
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
