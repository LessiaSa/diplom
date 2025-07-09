package ru.iteco.fmhandroid.ui.page;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import androidx.test.espresso.ViewInteraction;


public class AuthorizationPage {
    public ViewInteraction titleAuthoriz;
    public ViewInteraction loginField;
    public ViewInteraction passwordField;


    public AuthorizationPage() {
        titleAuthoriz = onView(withText("Авторизация"));
        loginField = onView(withHint("Логин"));
        passwordField = onView(withHint("Пароль"));
    }
}