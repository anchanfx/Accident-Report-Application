package nu.ac.th.accidentreport;

import org.json.JSONException;
import org.json.JSONObject;

public class AcknowledgeDataCollectionAdapter {

	public static AcknowledgeDataCollection fromJSON(JSONObject jsonObject) throws ApplicationException {
		AcknowledgeDataCollection acknowledgeDataCollection = null;
		AcknowledgeInfo acknowledgeInfo = null;
		
		try {
			JSONObject jsonObject_AcknowledgeInfo = 
					jsonObject.getJSONObject(JSONKeys.JSON_OBJECT_ACKNOWLEDGE_INFO);
			
			acknowledgeInfo = new AcknowledgeInfo(
					jsonObject_AcknowledgeInfo.getString(JSONKeys.MESSAGE));
		} catch (JSONException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			throw new ServerErrorException(ServerErrorException.NO_RESPOND);
		}
		
		acknowledgeDataCollection = new AcknowledgeDataCollection(acknowledgeInfo);
		
		return acknowledgeDataCollection;
	}
}
