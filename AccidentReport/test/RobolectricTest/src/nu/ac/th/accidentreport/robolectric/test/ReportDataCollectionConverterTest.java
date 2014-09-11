package nu.ac.th.accidentreport.robolectric.test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;
import nu.ac.th.accidentreport.AccidentData;
import nu.ac.th.accidentreport.AdditionalInfo;
import nu.ac.th.accidentreport.JSONKeys;
import nu.ac.th.accidentreport.Position;
import nu.ac.th.accidentreport.ReportDataCollection;
import nu.ac.th.accidentreport.ReportDataCollectionConverter;

import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

@RunWith(RobolectricTestRunner.class)
public class ReportDataCollectionConverterTest {
	
	private static final Position testPosition = new Position(55.55, 77.77);
	private static final AdditionalInfo testAdditionalInfo = new AdditionalInfo("TestType", 5, 7, true, "TestMessage");
	private static final AccidentData testAccidentData = new AccidentData(testPosition, testAdditionalInfo);
	
	private JSONObject jsonObj;
	private ReportDataCollection reportDataCollection;
	
	
	@Before
	public void setUp() throws Exception {
		reportDataCollection = new ReportDataCollection(testAccidentData);
	}

	@Test
	public void testToJSON() throws Exception {
		JSONObject actual = ReportDataCollectionConverter.toJSON(reportDataCollection);
		
		// { "AccidentData" : 
		// 		{ "Position" : { "Latitude" : 55.55, "Longitude" : 77.77 } , 
		// 		"AdditionalInfo" : { "AccidentType" : "TestType", "AmountOfInjured" : 5, "AmountOfDead" : 7, 
		//				"TrafficBlocked" : true, "Message" : "TestMessage" } } }
		String jsonString = "{ \"" + JSONKeys.JSON_OBJECT_ACCIDENT_DATA +
				
							"\" : {  \"" + JSONKeys.JSON_OBJECT_POSITION + 
							"\" : { \"" + JSONKeys.LATITUDE +
							"\" : " + testPosition.getLatitude() +
							", \"" + JSONKeys.LONGITUDE +
							"\" : " + testPosition.getLongitude() +
							
							" } ,  \"" + JSONKeys.JSON_OBJECT_ADDITIONAL_INFO +
							"\" : { \"" + JSONKeys.ACCIDENT_TYPE +
							"\" : \"" + testAdditionalInfo.getAccidentType() +
							"\", \"" + JSONKeys.AMOUNT_OF_INJURED +
							"\" : " + testAdditionalInfo.getAmountOfInjured() +
							", \"" + JSONKeys.AMOUNT_OF_DEAD +
							"\" : " + testAdditionalInfo.getAmountOfDead() +
							", \"" + JSONKeys.TRAFFIC_BLOCKED +
							"\" : " + testAdditionalInfo.isTrafficBlocked() +
							", \"" + JSONKeys.MESSAGE +
							"\" : \"" + testAdditionalInfo.getMessage() +
							"\" } } }";
		JSONObject expected = new JSONObject(jsonString);
		assertThat(actual.toString(), equalTo(expected.toString()));
	}
}
