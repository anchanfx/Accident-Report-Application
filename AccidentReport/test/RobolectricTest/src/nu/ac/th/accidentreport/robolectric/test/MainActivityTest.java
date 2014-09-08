package nu.ac.th.accidentreport.robolectric.test;

// Import from project under test
import nu.ac.th.accidentreport.MainActivity;

// Import from Robolectric
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

// Import from Mockito
import org.mockito.Mockito;

// Import from JUNIT
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;

import static org.hamcrest.CoreMatchers.equalTo;

@RunWith(RobolectricTestRunner.class)
public class MainActivityTest{

    MainActivity activity;

    @Before
    public void setup()
    {
        this.activity = Robolectric.buildActivity(MainActivity.class).create().get();
    }

    @Test
    public void shouldAlwaysPass() throws Exception 
    {
        //String hello = this.activity.getString(R.string.hello_world);
        //assertThat(hello, equalTo("Hello world!"));
    	assertThat("AAAA", equalTo("AAAA"));
    }
    
    @Test
    public void shouldAlwaysFail() throws Exception 
    {
        //String hello = this.activity.getString(R.string.hello_world);
        //assertThat(hello, equalTo("Hello world!"));
    	fail();
    }
}
