package nu.ac.th.accidentreport;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FillAdditionalActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fill_additional_info);
		//PopupWindow popup_windows = new PopupWindow(this);
		
		Button btn = (Button) findViewById(R.id.btn_submit_add_info);
		btn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
	}

}