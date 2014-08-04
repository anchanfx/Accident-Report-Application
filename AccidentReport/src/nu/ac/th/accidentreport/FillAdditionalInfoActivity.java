package nu.ac.th.accidentreport;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class FillAdditionalInfoActivity extends Activity {
	public static final String EXTRA_ADDITIONAL_INFO = "nu.ac.th.accidentreport.additional_info";
	public static final int ACTIVITY_CODE = 1;
	
	// FillAdditionalInfoActivity Contents
	private Button btnSubmit;
	private OnClickListener btnSubmitListener;
	private EditText edtTxtAccidentType;
	private EditText edtTxtAmountOfInjured;
	private EditText edtTxtAmountOfDead;
	private CheckBox chkBoxTrafficBlocked;
	private EditText edtTxtMessage;
	// Data
	private AdditionalInfo mAdditionalInfo;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fill_additional_info);
		
		createInterfaces();
		initializeVariables();
		initializeGUIComponents();
		updateGUI();
	}
	
	private void createInterfaces() {
		btnSubmitListener = new OnClickListener() {
			@Override
			public void onClick(View v) {
				submit();
			}
		};
	}
	
	private void initializeVariables() {
		Bundle args = this.getIntent().getExtras();
		if(args!=null)
			mAdditionalInfo = (AdditionalInfo)args.getSerializable(EXTRA_ADDITIONAL_INFO);
	}
	
	private void initializeGUIComponents() {
		edtTxtAccidentType = (EditText)findViewById(R.id.edittxt_input_accident_type);
		edtTxtAmountOfInjured = (EditText)findViewById(R.id.edittxt_input_injured);
		edtTxtAmountOfDead = (EditText)findViewById(R.id.edittxt_input_dead);
		chkBoxTrafficBlocked = (CheckBox)findViewById(R.id.chkbox_traffic_blocked_yes);
		edtTxtMessage = (EditText)findViewById(R.id.edittxt_message);
		
		btnSubmit = (Button)findViewById(R.id.btn_submit_add_info);
		btnSubmit.setOnClickListener(btnSubmitListener);
	}
	
	private void submit() {
		updateData();
		Intent resultIntent = new Intent();
		resultIntent.putExtra(EXTRA_ADDITIONAL_INFO, mAdditionalInfo);
		setResult(Activity.RESULT_OK, resultIntent);
		finish();
	}
	
	private void updateGUI() {
		edtTxtAccidentType.setText(mAdditionalInfo.getAccidentType());
		edtTxtAmountOfInjured.setText(String.valueOf(mAdditionalInfo.getAmountOfInjured()));
		edtTxtAmountOfDead.setText(String.valueOf(mAdditionalInfo.getAmountOfDead()));
		chkBoxTrafficBlocked.setChecked(mAdditionalInfo.isTrafficBlocked());
		edtTxtMessage.setText(mAdditionalInfo.getMessage());
	}
	
	private void updateData() {
		mAdditionalInfo.setAccidentType(edtTxtAccidentType.getText().toString());
		mAdditionalInfo.setAmountOfInjured(Integer.parseInt(edtTxtAmountOfInjured.getText().toString()));
		mAdditionalInfo.setAmountOfDead(Integer.parseInt(edtTxtAmountOfDead.getText().toString()));
		mAdditionalInfo.setTrafficBlocked(chkBoxTrafficBlocked.isChecked());
		mAdditionalInfo.setMessage(edtTxtMessage.getText().toString());
	}

	@Override
	public void onBackPressed() {
		super.onBackPressed();
	}
}
