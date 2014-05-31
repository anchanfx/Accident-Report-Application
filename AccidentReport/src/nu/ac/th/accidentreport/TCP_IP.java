package nu.ac.th.accidentreport;

import java.util.List;
import org.apache.http.NameValuePair;

public class TCP_IP extends ServerConnector {
	private static final String SERVER_URL = "http://nuaccrepo.mywebcommunity.org/faxtest.php";
	
	@Override
	public void sendReport(ReportDataCollection reportDataCollection) {
		List<NameValuePair> nameValuePairs = 
				ReportDataCollectionAdapter.toNameValuePairs(reportDataCollection);
		HttpProcessor.postRequest(SERVER_URL, nameValuePairs);
	}

	@Override
	public AcknowledgeDataCollection receieveAcknowledgement() {
		AcknowledgeDataCollection acknowledgeDataCollection = null;
		
		return acknowledgeDataCollection;
	}
}
