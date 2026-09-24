package homework19.act2.test;

import homework19.act2.pages.LoginPage;
import homework19.act2.pages.MainPage;
import org.junit.jupiter.api.Test;

public class TestAuthentication {
    private final MainPage mainPage = new MainPage();
    private final LoginPage loginPage = new LoginPage();

    @Test
    public void testFormAuthenticationScenario1() {
        mainPage.open();

        mainPage.goToFormAuthentication();

        loginPage.shouldHaveLoginPageTitle();

        loginPage.fillUsername("tomsmith");

        loginPage.fillPassword("SuperSecretPassword!");

        loginPage.login();

        loginPage.shouldHaveResultMessage("Welcome to the Secure Area. When you are done click logout below.");

        loginPage.shouldHaveLogoutButton();

        loginPage.clickLogout();

        loginPage.shouldHaveLoginPageTitle();
    }

    @Test
    public void testFormAuthenticationScenario2() {
        mainPage.open();

        mainPage.goToFormAuthentication();

        loginPage.shouldHaveLoginPageTitle();

        loginPage.fillUsername("admin");

        loginPage.fillPassword("1234");

        loginPage.login();

        loginPage.shouldHaveErrorResultMessage("Your username is invalid!");
    }
}
