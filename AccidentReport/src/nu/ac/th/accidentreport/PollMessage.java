package nu.ac.th.accidentreport;

import java.util.concurrent.TimeUnit;

public class PollMessage implements Runnable{
	private PollMessageListener listener;
	private int pollingInterval;
	private MessagePollingRequestData pollRequestData;
	private IServerConnector connector;
	
	public PollMessage(PollMessageListener listener, int pollingInterval, 
			MessagePollingRequestData pollAccidentData, IServerConnector connector) {
		super();
		this.listener = listener;
		this.pollingInterval = pollingInterval;
		this.pollRequestData = pollAccidentData;
		this.connector = connector;
	}

	@Override
	public void run() {
		AcknowledgeDataCollection data = null;
		
		while(true) {
			try {
				try {
					data = connector.pollMessage(pollRequestData);
					listener.onDataReceived(data);
				} catch (ApplicationException e) {
					// NO CONNECTION, NO RESPOND, EMPTY RESPOND?
				}
				
				TimeUnit.SECONDS.sleep(pollingInterval);
			} catch (InterruptedException e) {
				//e.printStackTrace();
			}
		}
	}
}
