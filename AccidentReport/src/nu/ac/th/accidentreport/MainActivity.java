package nu.ac.th.accidentreport;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;


public class MainActivity extends Activity {
	private LocatorListener mLocatorListener;
	private Locator mLocator;
	
	private TextView mTextView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		initializeVariables();
	}
	
	private void initializeVariables() {
		mLocatorListener = new LocatorListener() {
			@Override
			public void onLocationUpdated(Position position) {
				// Update a position from locator into TextView
				// mTextView.setText(position.toString());
			}
		};
		
		mLocator = new GPS(mLocatorListener, getApplicationContext());
		//mTextView = (TextView)findViewById(R.id.textview);
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
