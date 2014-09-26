package nu.ac.th.accidentreport.robolectric.test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import nu.ac.th.accidentreport.AcknowledgeDataCollection;
import nu.ac.th.accidentreport.AcknowledgeDataCollectionConverter;
import nu.ac.th.accidentreport.AcknowledgeData;
import nu.ac.th.accidentreport.JSONKeys;

import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

@RunWith(RobolectricTestRunner.class)
public class AcknowledgeDataCollectionConverterTest {
	
	private final AcknowledgeData testAcknowledgeInfo = new AcknowledgeData("TEST MESSAGE");
	
	private JSONObject jsonObj;

    @Before
    public void setUp() throws Exception {
    	// "{ "AcknowledgeData" : { "Message" : "Test_Message" } }"
    	String jsonString = "{ \"" + JSONKeys.JSON_OBJECT_ACKNOWLEDGE_DATA + 
    							"\" : { \"" + JSONKeys.MESSAGE +
    							"\" : \"" + testAcknowledgeInfo.getMessage() + "\"} }";
    	jsonObj =  new JSONObject(jsonString);
    	
        /*jsonObj = new JSONObject();
      	JSONObject jsonObject_AcknowledgeInfo = new JSONObject();
      	
  		try {
  			jsonObject_AcknowledgeInfo.put(JSONKeys.MESSAGE, TEST_MESSAGE);
  			jsonObj.put(JSONKeys.JSON_OBJECT_ACKNOWLEDGE_INFO, jsonObject_AcknowledgeInfo);
  		} catch (JSONException e) {
  			throw e;
  		}*/
    }

	@Test
	public void testFromJSON() throws Exception {
		AcknowledgeDataCollection actual = AcknowledgeDataCollectionConverter.fromJSON(jsonObj);
		
		AcknowledgeDataCollection expected = new AcknowledgeDataCollection(testAcknowledgeInfo);
		
		assertThat(actual.getAcknowledgeData().getMessage(), 
					equalTo(expected.getAcknowledgeData().getMessage()));
	}
}
