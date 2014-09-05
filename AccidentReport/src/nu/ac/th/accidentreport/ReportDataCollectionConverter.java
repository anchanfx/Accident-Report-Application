package nu.ac.th.accidentreport;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
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
			//JSONObject jsonObject_Date = new JSONObject();
		
		AccidentData accidentReportData = reportDataCollection.getAccidentData();	
		//Date date = reportDataCollection.getDate();
		
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
			
			/*Date*/
			//jsonObject_Date.put(JSONKeys.TIME, date.getTime());
			
			jsonObject_AccidentData.put(JSONKeys.JSON_OBJECT_POSITION, jsonObject_Position);
			jsonObject_AccidentData.put(JSONKeys.JSON_OBJECT_ADDITIONAL_INFO, jsonObject_AdditionalInfo);			
			holder.put(JSONKeys.JSON_OBJECT_ACCIDENT_DATA,jsonObject_AccidentData);
			//holder.put(JSONKeys.JSON_OBJECT_DATE, jsonObject_Date);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		return holder;
	}
	
	@Deprecated
	public static List<NameValuePair> toNameValuePairs(ReportDataCollection reportDataCollection) {
		List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		AccidentData accidentReportData = reportDataCollection.getAccidentData();
		Date date = reportDataCollection.getDate();
		
		// AccidentReportData
		// Position
		nameValuePairs.add(
				new BasicNameValuePair(JSONKeys.LATITUDE, 
						String.valueOf(accidentReportData.getPosition().getLatitude())));
		nameValuePairs.add(
				new BasicNameValuePair(JSONKeys.LONGITUDE, 
						String.valueOf(accidentReportData.getPosition().getLongitude())));
		// AdditionalInfo
		nameValuePairs.add(
				new BasicNameValuePair(JSONKeys.ACCIDENT_TYPE, 
						String.valueOf(accidentReportData.getAdditionalInfo().getAccidentType())));
		nameValuePairs.add(
				new BasicNameValuePair(JSONKeys.AMOUNT_OF_INJURED, 
						String.valueOf(accidentReportData.getAdditionalInfo().getAmountOfInjured())));
		nameValuePairs.add(
				new BasicNameValuePair(JSONKeys.AMOUNT_OF_DEAD, 
						String.valueOf(accidentReportData.getAdditionalInfo().getAmountOfDead())));
		nameValuePairs.add(
				new BasicNameValuePair(JSONKeys.TRAFFIC_BLOCKED, 
						String.valueOf(accidentReportData.getAdditionalInfo().isTrafficBlocked())));
		nameValuePairs.add(
				new BasicNameValuePair(JSONKeys.MESSAGE, 
						String.valueOf(accidentReportData.getAdditionalInfo().getMessage())));
		// Date
		nameValuePairs.add(
				new BasicNameValuePair(JSONKeys.TIME, String.valueOf(date.getTime())));
		
		return nameValuePairs;
	}
}
