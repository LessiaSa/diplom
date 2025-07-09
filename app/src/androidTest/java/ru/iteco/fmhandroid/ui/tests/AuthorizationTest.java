package ru.iteco.fmhandroid.ui.tests;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import android.view.View;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.data.DataHelper;
import ru.iteco.fmhandroid.ui.data.FieldIDs;
import ru.iteco.fmhandroid.ui.steps.AuthorizationSteps;
import ru.iteco.fmhandroid.ui.steps.MainSteps;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)

public class AuthorizationTest {
    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);
    MainSteps mainSteps = new MainSteps();
    FieldIDs fieldIDs = new FieldIDs();
    DataHelper dataHelper = new DataHelper();
    private View decorView;


    @Before
    public void setUp() {
        AuthorizationSteps.applicationHomeScreen();
    }

    @After
    public void tearDown() {
        try {
            mainSteps.logOutOfTheProfile();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void verifyingAuthorizWithValidData() {
        AuthorizationSteps.authorizWithValidData();
        mainSteps.loadingTheMainPage();
        onView(withId(R.id.all_news_text_view)) .check(matches(withText("Все новости")));
    }

    @Test
    public void valLog() {
        onView(withId(R.id.login_text_input_layout))
                .perform(typeText("login2"), closeSoftKeyboard());
        onView(withId(R.id.password_text_input_layout))
                .perform(typeText("password2"), closeSoftKeyboard());
        onView(withId(R.id.enter_button)).perform(click());
        onView(withId(R.id.trademark_image_view)).check(matches(withText("вхосписе")));
    }
}



