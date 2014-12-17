package nu.ac.th.accidentreport;

import static nu.ac.th.accidentreport.HttpProcessor.*;

import org.apache.http.HttpResponse;
import org.json.JSONObject;

public class TCP_IP implements IServerConnector {
	private static final String SERVER_URL = 
			"http://nuaccrepo.mywebcommunity.org/ReportServer/reportAccident.php";
	private static final String POLL_MESSAGE_URL = 
			"http://nuaccrepo.mywebcommunity.org/ReportServer/pollAccidentReporterMessage.php";
	
	@Override
	public AcknowledgeDataCollection sendReport(ReportDataCollection reportDataCollection) throws ApplicationException {
		JSONObject jsonObject = ReportDataCollectionConverter.toJSON(reportDataCollection);
		HttpResponse httpResponse = jsonRequest(SERVER_URL, jsonObject);
		
		JSONObject jsonObject_AcknowledgeDataCollection = httpResponse_to_JSONObject(httpResponse);

		AcknowledgeDataCollection acknowledgeDataCollection = 
				AcknowledgeDataCollectionConverter.fromJSON(jsonObject_AcknowledgeDataCollection);
		
		return acknowledgeDataCollection;
	}
	
	@Override
	public AcknowledgeDataCollection pollMessage(MessagePollingRequestData messagePollingRequestData) throws ApplicationException {
		JSONObject jsonObject = MessagePollingRequestDataConverter.toJSON(messagePollingRequestData);
		HttpResponse httpResponse = jsonRequest(POLL_MESSAGE_URL, jsonObject);
		
		JSONObject jsonObject_AcknowledgeDataCollection = httpResponse_to_JSONObject(httpResponse);
		
		AcknowledgeDataCollection acknowledgeDataCollection = 
				AcknowledgeDataCollectionConverter.fromJSON(jsonObject_AcknowledgeDataCollection);
		
		return acknowledgeDataCollection;
	}
}
