package nu.ac.th.accidentreport;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

public class ReportDataCollectionAdapter {
	
	public static JSONObject toJSON(ReportDataCollection reportDataCollection) {
		JSONObject holder = new JSONObject();
		JSONObject jsonObject_AccidentReportData = new JSONObject();
		JSONObject jsonObject_Position = new JSONObject();
		JSONObject jsonObject_AdditionalInfo = new JSONObject();
		JSONObject jsonObject_Date = new JSONObject();
		
		AccidentReportData accidentReportData = reportDataCollection.getAccidentReportData();	
		
		try {
			//AccidentReportData
			//Position
			jsonObject_Position.put(JSONKeys.LATITUDE, 
					accidentReportData.getPosition().getLatitude());
			jsonObject_Position.put(JSONKeys.LONGITUDE, 
					accidentReportData.getPosition().getLongitude());
			
			//AdditionalInfo
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
			
			//Date
			jsonObject_Date.put(JSONKeys.DATE, 
					String.valueOf(accidentReportData.getDate().toString()));
			
			jsonObject_AccidentReportData.put(JSONKeys.JSON_OBJECT_POSITION, jsonObject_Position);
			jsonObject_AccidentReportData.put(JSONKeys.JSON_OBJECT_ADDITIONAL_INFO, jsonObject_AdditionalInfo);
			jsonObject_AccidentReportData.put(JSONKeys.JSON_OBJECT_DATE, jsonObject_Date);
			holder.put(JSONKeys.ACCIDENT_REPORT_DATA,jsonObject_AccidentReportData);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		return holder;
	}
	
	@Deprecated
	public static List<NameValuePair> toNameValuePairs(ReportDataCollection reportDataCollection) {
		List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		AccidentReportData accidentReportData = reportDataCollection.getAccidentReportData();
		
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
				new BasicNameValuePair(JSONKeys.DATE, 
						String.valueOf(accidentReportData.getDate().toString())));
		
		return nameValuePairs;
	}
	
	
}
