package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static ru.iteco.fmhandroid.ui.data.DataHelper.elementWaiting;
import static ru.iteco.fmhandroid.ui.data.FieldIDs.*;
import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.data.DataHelper;
import ru.iteco.fmhandroid.ui.data.FieldIDs;
import ru.iteco.fmhandroid.ui.page.AuthorizationPage;

public class AuthorizationSteps {
    static DataHelper dataHelper = new DataHelper();
    public static AuthorizationPage authorizationPage = new AuthorizationPage();
    static MainSteps mainSteps = new MainSteps();
    static FieldIDs fieldIDs = new FieldIDs();

    public static void applicationHomeScreen() {
        Allure.step("Начальный экран приложения");
        elementWaiting(FieldIDs.homeScreen,5000);
    }



    public static void authorizWithValidData() {
        Allure.step("Авторизация с валидными данными");
        fieldIDs.authorizLog.perform(click());
        dataHelper.getValidLogin();
        //authorizationPage.loginField.perform(typeText(dataHelper.getValidUser().getLogin()), closeSoftKeyboard());
        fieldIDs.authorizPass.perform(click());
        dataHelper.getValidPassword();
        //authorizationPage.passwordField.perform(typeText(dataHelper.getValidUser().getPassword()), closeSoftKeyboard());
        fieldIDs.authorizationButtonEnter.matches(click());
    }

    public void authorizationInvalidLogin() {
        Allure.step("Авторизация с невалидным логином");
        authorizLog.perform(click());
        authorizationPage.loginField.perform(typeText(dataHelper.getInvalidUser().getInvalidLogin()));
        authorizPass.perform(click());
        authorizationPage.passwordField.perform(typeText(dataHelper.getValidPassword()), closeSoftKeyboard());
    }
    public void authorizationInvalidPassword() {
        Allure.step("Авторизация с невалидным паролем");
        authorizLog.perform(click());
        authorizationPage.loginField.perform(typeText(dataHelper.getValidUser().getLogin()));
        authorizPass.perform(click());
        authorizationPage.passwordField.perform(typeText(dataHelper.getInvalidPassword()), closeSoftKeyboard());
    }

    public void authorizationWithInvalidData() {
        Allure.step("Авторизация с невалидными и логином и паролем");
        authorizLog.perform(click());
        authorizationPage.loginField.perform(typeText(dataHelper.getInvalidUser().getInvalidLogin()));
        authorizPass.perform(click());
        authorizationPage.passwordField.perform(typeText(dataHelper.getInvalidPassword()), closeSoftKeyboard());
    }
    public void authorizationClickingLogInButtonSeveralTimesWithInvalidData() {
        Allure.step("Попытка авторизации, несколько раз нажав кнопку 'Войти'");
        authorizLog.perform(click());
        authorizationPage.loginField.perform(typeText(dataHelper.getInvalidUser().getInvalidLogin()));
        authorizPass.perform(click());
        authorizationPage.passwordField.perform(typeText(dataHelper.getInvalidPassword()), closeSoftKeyboard());
    }
    public void authorizationWithEmptyLoginAndPasswordFields() {
        Allure.step("Авторизация с незаполненными полями логина и пароля");
    }
}