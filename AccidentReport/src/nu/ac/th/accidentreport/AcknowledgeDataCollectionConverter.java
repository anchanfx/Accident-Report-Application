package nu.ac.th.accidentreport;

import org.json.JSONException;
import org.json.JSONObject;

public class AcknowledgeDataCollectionConverter {

	public static AcknowledgeDataCollection fromJSON(JSONObject jsonObject) throws ApplicationException  {
		AcknowledgeDataCollection acknowledgeDataCollection = null;
		AcknowledgeData acknowledgeData = null;
		
		try {
			JSONObject jsonObject_AcknowledgeInfo = 
					jsonObject.getJSONObject(JSONKeys.JSON_OBJECT_ACKNOWLEDGE_DATA);
			
			acknowledgeData = new AcknowledgeData(
					jsonObject_AcknowledgeInfo.getString(JSONKeys.MESSAGE));
		} catch (JSONException e) {
			throw new ApplicationException();
		} catch (NullPointerException e) {
			throw new ApplicationException();
		}
		
		acknowledgeDataCollection = new AcknowledgeDataCollection(acknowledgeData);
		
		return acknowledgeDataCollection;
	}
}
