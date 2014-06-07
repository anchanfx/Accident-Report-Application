package nu.ac.th.accidentreport;

import org.json.JSONException;
import org.json.JSONObject;

public class AcknowledgeDataCollectionAdapter {

	public static AcknowledgeDataCollection fromJSON(JSONObject jsonObject) {
		AcknowledgeDataCollection acknowledgeDataCollection = null;
		AcknowledgeInfo acknowledgeInfo = null;
		
		try {
			JSONObject jsoObject_AcknowledgeInfo = 
					jsonObject.getJSONObject(JSONKeys.JSON_OBJECT_ACKNOWLEDGE_INFO);
			
			acknowledgeInfo = new AcknowledgeInfo(
					jsoObject_AcknowledgeInfo.getString(JSONKeys.MESSAGE)
					);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		acknowledgeDataCollection = new AcknowledgeDataCollection(acknowledgeInfo);
		
		return acknowledgeDataCollection;
	}
}
