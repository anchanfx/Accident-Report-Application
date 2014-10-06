package nu.ac.th.accidentreport;

import static nu.ac.th.accidentreport.Compatibility_PHP_JAVA.*;

import java.util.Date;

import org.json.JSONException;
import org.json.JSONObject;

public class ReportDataCollectionConverter {
	
	/* Doesn't convert Date into JSON Object because of using server time instead
	 * So Date is not sent to server
	 */
	public static JSONObject toJSON(ReportDataCollection reportDataCollection) {
		JSONObject holder = new JSONObject();
			JSONObject jsonObject_AccidentData = new JSONObject();
				JSONObject jsonObject_Position = new JSONObject();
				JSONObject jsonObject_AdditionalInfo = new JSONObject();
		
		AccidentData accidentReportData = reportDataCollection.getAccidentData();	
		Date date = reportDataCollection.getDate();
		
		try {
			/*AccidentData*/
			/*Position*/
			jsonObject_Position.put(JSONKeys.LATITUDE, 
					accidentReportData.getPosition().getLatitude());
			jsonObject_Position.put(JSONKeys.LONGITUDE, 
					accidentReportData.getPosition().getLongitude());
			
			/*AdditionalInfo*/
			jsonObject_AdditionalInfo.put(JSONKeys.ACCIDENT_TYPE, 
					accidentReportData.getAdditionalInfo().getAccidentType());
			jsonObject_AdditionalInfo.put(JSONKeys.AMOUNT_OF_INJURED, 
					accidentReportData.getAdditionalInfo().getAmountOfInjured());
			jsonObject_AdditionalInfo.put(JSONKeys.AMOUNT_OF_DEAD, 
					accidentReportData.getAdditionalInfo().getAmountOfDead());
			jsonObject_AdditionalInfo.put(JSONKeys.TRAFFIC_BLOCKED, 
					accidentReportData.getAdditionalInfo().isTrafficBlocked());
			jsonObject_AdditionalInfo.put(JSONKeys.MESSAGE, 
					accidentReportData.getAdditionalInfo().getMessage());
			
			
			jsonObject_AccidentData.put(JSONKeys.JSON_OBJECT_POSITION, jsonObject_Position);
			jsonObject_AccidentData.put(JSONKeys.JSON_OBJECT_ADDITIONAL_INFO, jsonObject_AdditionalInfo);			
			holder.put(JSONKeys.JSON_OBJECT_ACCIDENT_DATA,jsonObject_AccidentData);
			holder.put(JSONKeys.DATE_TIME, timeStampInJavaToPhp(date.getTime()));
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		return holder;
	}
}
