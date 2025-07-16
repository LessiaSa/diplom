package ru.iteco.fmhandroid.ui.page;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import android.view.View;
import androidx.test.espresso.ViewInteraction;
import org.hamcrest.Matcher;


public class AuthorizationPage {
    public static Matcher<View> titleAuthoriz;
    public static ViewInteraction loginField;
    public static ViewInteraction passwordField;

    public AuthorizationPage() throws InterruptedException {
        titleAuthoriz = withText("Авторизация");
        loginField = onView(withHint("Логин"));
        passwordField = onView(withHint("Пароль"));
    }
}