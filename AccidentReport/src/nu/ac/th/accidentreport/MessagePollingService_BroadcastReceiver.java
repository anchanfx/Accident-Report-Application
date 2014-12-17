package nu.ac.th.accidentreport;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class MessagePollingService_BroadcastReceiver  extends BroadcastReceiver {
	
	@Override
	public void onReceive(Context context, Intent intent) {
		Intent serviceIntent = new Intent(context, MessagePollingService.class);
		context.startService(serviceIntent);
	}
}
