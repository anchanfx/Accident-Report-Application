package nu.ac.th.accidentreport;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class FillAdditionalInfoActivity extends Activity {
	private Button btnSubmit;
	private OnClickListener btnSubmitListener;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fill_additional_info);
		
		createInterfaces();
		initializeVariables();
		initializeGUIComponents();
	}
	
	private void createInterfaces() {
		btnSubmitListener = new OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
			}
		};
	}
	
	private void initializeVariables() {
		
	}
	
	private void initializeGUIComponents() {
		btnSubmit = (Button)findViewById(R.id.btn_submit_add_info);
		btnSubmit.setOnClickListener(btnSubmitListener);
	}
}
