package nu.ac.th.accidentreport;

import org.apache.http.HttpResponse;
import org.json.JSONObject;

public class TCP_IP extends ServerConnector {
	private static final String SERVER_URL = 
			"http://nuaccrepo.mywebcommunity.org/ReportServer/reportAccident.php";
	
	@Override
	public AcknowledgeDataCollection sendReport(ReportDataCollection reportDataCollection) throws ApplicationException {
		JSONObject jsonObject = ReportDataCollectionAdapter.toJSON(reportDataCollection);
		HttpResponse httpResponse = HttpProcessor.jsonRequest(SERVER_URL, jsonObject);
		
		JSONObject jsonObject_AcknowledgeDataCollection = 
				HttpProcessor.httpResponse_to_JSONObject(httpResponse);

		AcknowledgeDataCollection acknowledgeDataCollection = 
				AcknowledgeDataCollectionAdapter.fromJSON(jsonObject_AcknowledgeDataCollection);
		
		return acknowledgeDataCollection;
	}
}
