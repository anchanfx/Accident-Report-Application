package nu.ac.th.accidentreport;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ReportDataCollectionAdapter {

	public static List<NameValuePair> toNameValuePairs(ReportDataCollection reportDataCollection) {
		List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		AccidentReportData accidentReportData = reportDataCollection.getAccidentReportData();
		
		// AccidentReportData
		// Position
		nameValuePairs.add(
				new BasicNameValuePair("Latitude", 
						String.valueOf(accidentReportData.getPosition().getLatitude())));
		nameValuePairs.add(
				new BasicNameValuePair("Longitude", 
						String.valueOf(accidentReportData.getPosition().getLongitude())));
		// AdditionalInfo
		nameValuePairs.add(
				new BasicNameValuePair("AccidentType", 
						String.valueOf(accidentReportData.getAdditionalInfo().getAccidentType())));
		nameValuePairs.add(
				new BasicNameValuePair("AmountOfInjured", 
						String.valueOf(accidentReportData.getAdditionalInfo().getAmountOfInjured())));
		nameValuePairs.add(
				new BasicNameValuePair("AmountOfDead", 
						String.valueOf(accidentReportData.getAdditionalInfo().getAmountOfDead())));
		nameValuePairs.add(
				new BasicNameValuePair("TrafficBlocked", 
						String.valueOf(accidentReportData.getAdditionalInfo().isTrafficBlocked())));
		nameValuePairs.add(
				new BasicNameValuePair("Message", 
						String.valueOf(accidentReportData.getAdditionalInfo().getMessage())));
		// Date
		nameValuePairs.add(
				new BasicNameValuePair("Date", 
						String.valueOf(accidentReportData.getReportDate().toString())));
		
		return nameValuePairs;
	}	
}
