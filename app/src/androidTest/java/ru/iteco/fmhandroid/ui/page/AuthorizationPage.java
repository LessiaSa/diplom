package ru.iteco.fmhandroid.ui.page;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import android.view.View;

import androidx.test.espresso.ViewInteraction;

import org.hamcrest.Matcher;

import ru.iteco.fmhandroid.ui.data.DataHelper;
import ru.iteco.fmhandroid.ui.data.FieldIDs;


public class AuthorizationPage {
    public static ViewInteraction titleAuthoriz;
    public static Matcher<View> loginField;
    public static ViewInteraction passwordField;
    static DataHelper dataHelper = new DataHelper();

    public AuthorizationPage() {
        titleAuthoriz = onView(withText("Авторизация"));
        loginField = dataHelper.elementWaiting(FieldIDs.authorizLog, 5000);
        passwordField = onView(withHint("Пароль"));
    }
}