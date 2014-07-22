package nu.ac.th.accidentreport;

import org.apache.http.HttpResponse;
import org.json.JSONObject;

public class TCP_IP extends ServerConnector {
	private static final String SERVER_URL = "http://nuaccrepo.mywebcommunity.org/receiveFromApp.php";
	
	@Override
	public AcknowledgeDataCollection sendReport(ReportDataCollection reportDataCollection) {
		JSONObject jsonObject = ReportDataCollectionAdapter.toJSON(reportDataCollection);
		HttpResponse httpResponse = HttpProcessor.jsonRequest(SERVER_URL, jsonObject);
		
		JSONObject jsoObject_AcknowledgeDataCollection = 
				HttpProcessor.httpResponse_to_JSONObject(httpResponse);
		AcknowledgeDataCollection acknowledgeDataCollection = 
				AcknowledgeDataCollectionAdapter.fromJSON(jsoObject_AcknowledgeDataCollection);
		
		return acknowledgeDataCollection;
	}
}
