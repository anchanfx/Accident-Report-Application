package nu.ac.th.accidentreport;

import org.json.JSONException;
import org.json.JSONObject;

public class MessagePollingRequestDataConverter {

	public static JSONObject toJSON(MessagePollingRequestData messagePollingRequestData) throws ApplicationException {
		JSONObject holder = new JSONObject();
		
		try {
			/*IMEI*/
			holder.put(JSONKeys.IMEI, messagePollingRequestData.getImei());
		} catch (JSONException e) {
			e.printStackTrace();
		}
	
		return holder;
	}
}
