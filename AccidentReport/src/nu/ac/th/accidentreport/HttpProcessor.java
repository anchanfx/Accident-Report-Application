package nu.ac.th.accidentreport;

import java.io.IOException;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;


public class HttpProcessor {
	
	public static void postRequest(String URL, List<NameValuePair> nameValuePairs) {
		HttpClient httpClient = new DefaultHttpClient();
   	    HttpPost httpPost = new HttpPost(URL);
   	    
   	    try {
   	    	httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
   	    	httpClient.execute(httpPost);
   	    } catch (ClientProtocolException e) {
   	    	// TODO Auto-generated catch block
   	    } catch (IOException e) {
   	    	// TODO Auto-generated catch block
   	    }
	}
}
