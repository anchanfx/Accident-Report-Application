package nu.ac.th.accidentreport.robolectric.test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;
import static org.robolectric.Robolectric.buildActivity;
import static org.robolectric.Robolectric.shadowOf;
import nu.ac.th.accidentreport.FillAdditionalInfoActivity;
import nu.ac.th.accidentreport.MainActivity;
import nu.ac.th.accidentreport.R;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.shadows.ShadowActivity;
import org.robolectric.util.ActivityController;

import android.content.Intent;

@RunWith(RobolectricTestRunner.class)
public class MainActivityTest{

	private final ActivityController<MainActivity> controller = buildActivity(MainActivity.class);
	private MainActivity mainActivity;
	
    @Before
    public void setup()
    {
        this.mainActivity = controller.create().get();
    }
    
    @Test
    public void clickFillAdditionalInfo_shouldStartFillAdditionalInfoActivity() throws Exception 
    {
    	 ShadowActivity shadowActivity = shadowOf(mainActivity);
    	 mainActivity.findViewById(R.id.btn_fill_additional_info).performClick();
    	 
    	 String expected = new Intent(mainActivity, FillAdditionalInfoActivity.class).getComponent().getClassName();
    	 String actual = shadowActivity.getNextStartedActivity().getComponent().getClassName();
    
         assertThat(expected, equalTo(actual));
    }
    
    @Test
    public void whenGPSIsNotYetReceived_reportButtonShouldBeDisable() throws Exception
    {
    	boolean expected = false;
    	boolean actual = mainActivity.findViewById(R.id.btn_report).isEnabled();
    	
    	
    	assertThat(expected, equalTo(actual));
    }
    
    @Test
    public void whenGPSIsReceived_reportButtonShouldBeEnable() throws Exception
    {
    	// TODO
    }
    
    @Test
    public void reportButtonShouldBeEnable_whenGPSIsReceived() throws Exception
    {
    	// TODO
    }
    
    @Test
    public void clickReport_shouldStartReportPopup() throws Exception
    {
    	// TODO
    }
}
