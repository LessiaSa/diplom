package ru.iteco.fmhandroid.ui.tests;

import static androidx.test.espresso.Espresso.onView;
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
        try {
            AuthorizationSteps.applicationHomeScreen();
            //onView(withId(R.id.enter_button)).perform(typeText("Войти"));
            //dataHelper.elementWaiting(authorizationPage.titleAuthoriz, 10000);
        } catch (Exception e) {
            mainSteps.buttonLogOutProfile();
            mainSteps.logOutPopUpOfTheProfile();
            //dataHelper.elementWaiting(withId(R.id.enter_button), 5000);
        }
        mActivityScenarioRule.getScenario().onActivity(activity -> decorView = activity.getWindow().getDecorView());

    }

    @After
    public void tearDown() {
        try {
            mainSteps.buttonLogOutProfile();
            mainSteps.logOutPopUpOfTheProfile();
        } catch (Exception ignored) {
            //onView(allOf(withId(R.id.authorization_logout_menu_item), isDisplayingAtLeast(40))).perform(click());
            //buttonExitPopUpWindow.inRoot(withDecorView(Matchers.not(decorView))).check(matches(isDisplayed())).perform(click());
//        onView(withText(R.id.authorization_logout_menu_item)).inRoot(RootMatchers.
//                withDecorView(not(decorView))).check(matches(isDisplayed())).perform(click());
            //onView(withText(endsWith("Выйти"))).check(matches(isDisplayed()));
        }
    }
    @Test
    public void verifyingAuthorizWithValidData() {
        AuthorizationSteps.authorizWithValidData();
        mainSteps.loadingTheMainPage();
        onView(withId(R.id.all_news_text_view)).check(matches(withText("Все новости")));
//        mainSteps.buttonLogOutProfile();
//        mainSteps.logOutPopUpOfTheProfile();
    }

}



