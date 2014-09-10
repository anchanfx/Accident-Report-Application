package nu.ac.th.accidentreport.espresso.test;

import com.google.android.apps.common.testing.ui.espresso.ViewInteraction;
import com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers;

import nu.ac.th.accidentreport.FillAdditionalInfoActivity;
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
	}

	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		getActivity();
	}
	
	//It uses JUnit 3 so remember to prefix your test methods
	//with the word "test"
	public void test_WhenGPSIsNotYetReceived_ReportButtonShouldBeDisable() {
		onView(withId(R.id.btn_report))
			.check(matches(not(isEnabled())));
	}
	
	public void test_ClickFillAdditionalInfo_ShouldStartFillAdditionalInfoActivity() {
		onView(withId(R.id.btn_fill_additional_info))
			.perform(click());
		onView(withId(R.id.txtview_accident_type))
			.check(matches(isDisplayed()));
	}
}
