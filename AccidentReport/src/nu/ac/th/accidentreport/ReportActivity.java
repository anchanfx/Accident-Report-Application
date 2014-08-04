package nu.ac.th.accidentreport;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ReportActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.report);
		
		Button btn = (Button) findViewById(R.id.btn_cancel);
		btn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
	}
	
}
