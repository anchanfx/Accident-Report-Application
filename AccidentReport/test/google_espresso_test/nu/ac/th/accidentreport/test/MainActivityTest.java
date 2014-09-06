package nu.ac.th.accidentreport.test;

import nu.ac.th.accidentreport.MainActivity;
import nu.ac.th.accidentreport.R;

//Some Espresso Related imports
import static com.google.android.apps.common.testing.ui.espresso.Espresso.*;
import static com.google.android.apps.common.testing.ui.espresso.action.ViewActions.*;
import static com.google.android.apps.common.testing.ui.espresso.assertion.ViewAssertions.*;
import static com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers.*;
import static org.hamcrest.Matchers.*;

import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.MediumTest;

@MediumTest
public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {
	
	public MainActivityTest() {
		super(MainActivity.class);
		// TODO Auto-generated constructor stub
	}

	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		 getActivity();
	}
	
	//It uses JUnit 3 so remember to prefix your test methods
	//with the word "test"
	public void testSimple() {
		onView(withId(R.id.btn_report))
			.check(matches(not(isEnabled())));
	}
}
