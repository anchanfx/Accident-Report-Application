package nu.ac.th.accidentreport;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ReportActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.popup_report);
		
		Button btn = (Button) findViewById(R.id.layout_additional_info);
		btn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
	}
	
}
