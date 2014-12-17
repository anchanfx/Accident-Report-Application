package nu.ac.th.accidentreport;

import static nu.ac.th.accidentreport.NotificationID.INCOMING_MESSAGE;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.v4.content.LocalBroadcastManager;

public class MessagePollingService extends Service {
	public static final String BROADCAST 
		= "nu.ac.th.rescueunit.MessagePollingService.BROADCAST";
	public static final String MESSAGE = "MESSAGE";
	
	private static final int POLLING_INTERVAL = 10;
	
	private Thread thread;
	private PollMessageListener threadListener;
	private LocalBroadcastManager broadcaster;
	
	private MessagePollingRequestData messagePollingRequestData;

	@Override
	public IBinder onBind(Intent arg0) {
		return null;
	}

	@Override
	public void onCreate() {
		super.onCreate();
		messagePollingRequestData = new MessagePollingRequestData("1234");//IMEI.getDeviceIMEI(this));
		broadcaster = LocalBroadcastManager.getInstance(this);
		threadListener = new PollMessageListener() {
			@Override
			public void onDataReceived(AcknowledgeDataCollection acknowledgeDataCollection) {
				processReceivedData(acknowledgeDataCollection);
			}
		};
	}
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		thread = new Thread(new PollMessage(
				threadListener, POLLING_INTERVAL, messagePollingRequestData, new TCP_IP()));
		thread.start();
		return START_STICKY;
	}
	
	private void processReceivedData(AcknowledgeDataCollection acknowledgeDataCollection) {
		notifyIncomingMessage(acknowledgeDataCollection.getAcknowledgeData().getMessage());
	}
	
	private void notifyIncomingMessage(String message) {
		PendingIntent startActivityPendingIntent = PendingIntent.getActivity(this, 0, new Intent(), 0);
		
		ApplicationNotificationParameter param
			= new ApplicationNotificationParameter(this,
					"You Receive A Message", 
					"Your Message", 
					message,
					message,
					startActivityPendingIntent, 
					INCOMING_MESSAGE);
		ApplicationNotification.sendNotification(param);
	}
	
	private void sendLocalBroadCast() {
		Intent intent = new Intent(BROADCAST);
	    intent.putExtra(MESSAGE, "");
	    broadcaster.sendBroadcast(intent);
	}
}
