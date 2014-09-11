package nu.ac.th.accidentreport.espresso.test;

import static com.google.android.apps.common.testing.ui.espresso.Espresso.closeSoftKeyboard;
import static com.google.android.apps.common.testing.ui.espresso.Espresso.onView;
import static com.google.android.apps.common.testing.ui.espresso.Espresso.pressBack;
import static com.google.android.apps.common.testing.ui.espresso.action.ViewActions.clearText;
import static com.google.android.apps.common.testing.ui.espresso.action.ViewActions.click;
import static com.google.android.apps.common.testing.ui.espresso.action.ViewActions.typeText;
import static com.google.android.apps.common.testing.ui.espresso.assertion.ViewAssertions.matches;
import static com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers.isDisplayed;
import static com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers.isEnabled;
import static com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers.withId;
import static com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers.withText;
import static com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers.isChecked;
import static org.hamcrest.Matchers.not;
import nu.ac.th.accidentreport.MainActivity;
import nu.ac.th.accidentreport.R;
import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.LargeTest;

@LargeTest
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
	
	public void test_WhenGPSIsReceived_ReportButtonShouldBeEnable() {
		// TODO
	}

	public void test_ClickFillAdditionalInfo_ShouldStartFillAdditionalInfoActivity() {
		onView(withId(R.id.btn_fill_additional_info))
			.perform(click());
		onView(withId(R.id.layout_fill_additional_info))
			.check(matches(isDisplayed()));
	}
	
	public void test_InsertDataIntoFillAdditionalInfoActivity_DataShouldNotLost() {
		onView(withId(R.id.btn_fill_additional_info))
			.perform(click());
		
		onView(withId(R.id.edittxt_input_accident_type))
			.perform(clearText(), typeText("TEST TYPE"));
		closeSoftKeyboard();
		
		onView(withId(R.id.edittxt_input_injured))
			.perform(clearText(), typeText("7"));
		closeSoftKeyboard();
		
		onView(withId(R.id.edittxt_input_dead))
			.perform(clearText(), typeText("5"));
		closeSoftKeyboard();
		
		onView(withId(R.id.chkbox_traffic_blocked_yes))
			.perform(click());
		
		onView(withId(R.id.edittxt_message))
			.perform(clearText(), typeText("TEST MESSAGE"));
		closeSoftKeyboard();
	
		onView(withId(R.id.btn_submit_additional_info))
			.perform(click());
		
		onView(withId(R.id.btn_fill_additional_info))
			.perform(click());
		
		onView(withId(R.id.edittxt_input_accident_type))
			.check(matches(withText("TEST TYPE")));
		
		onView(withId(R.id.edittxt_input_injured))
			.check(matches(withText("7")));
		
		onView(withId(R.id.edittxt_input_dead))
			.check(matches(withText("5")));
		
		onView(withId(R.id.chkbox_traffic_blocked_yes))
			.check(matches(isChecked()));
		
		onView(withId(R.id.edittxt_message))
			.check(matches(withText("TEST MESSAGE")));
		
	}
	
	public void test_PressBack_WhenInsertDataIntoFillAdditionalInfoActivity_DataShouldLost() {
		onView(withId(R.id.btn_fill_additional_info))
			.perform(click());
		
		onView(withId(R.id.edittxt_input_accident_type))
			.perform(clearText(), typeText("TEST TYPE"));
		closeSoftKeyboard();
	
		onView(withId(R.id.edittxt_input_injured))
			.perform(clearText(), typeText("7"));
		closeSoftKeyboard();
		
		onView(withId(R.id.edittxt_input_dead))
			.perform(clearText(), typeText("5"));
		closeSoftKeyboard();
		
		onView(withId(R.id.chkbox_traffic_blocked_yes))
			.perform(click());
		
		onView(withId(R.id.edittxt_message))
			.perform(clearText(), typeText("TEST MESSAGE"));
		closeSoftKeyboard();
		
		pressBack();
		
		onView(withId(R.id.btn_fill_additional_info))
			.perform(click());
	
		onView(withId(R.id.edittxt_input_accident_type))
			.check(matches(not(withText("TEST TYPE"))));
	
		onView(withId(R.id.edittxt_input_injured))
			.check(matches(not(withText("7"))));
		
		onView(withId(R.id.edittxt_input_dead))
			.check(matches(not(withText("5"))));
		
		onView(withId(R.id.chkbox_traffic_blocked_yes))
			.check(matches(not(isChecked())));
		
		onView(withId(R.id.edittxt_message))
			.check(matches(not(withText("TEST MESSAGE"))));
	}
}
