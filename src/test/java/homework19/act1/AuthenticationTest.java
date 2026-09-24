package homework19.act1;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class AuthenticationTest {
    @Test
    public void testPositiveAuthentication() {
        open("https://the-internet.herokuapp.com/");

        $x("//a[contains(text(), 'Form Authentication')]").click();

        $x("//h2").shouldHave(text("Login Page"));

        $x("//input[@type='text']").setValue("tomsmith");

        $x("//input[@type='password']").setValue("SuperSecretPassword!");

        $x("//button[@type='submit']").click();

        $x("//h4[@class = 'subheader']").shouldHave(text("Welcome to the Secure Area. When you are done click logout below."));

        $x("//a[contains(@href, 'logout')]").shouldBe(visible);

        $x("//a[contains(@href, 'logout')]").click();

        $x("//h1").shouldHave(text("Login Page"));
    }

    @Test
    public void testNegativeAuthentication() {
        open("https://the-internet.herokuapp.com/");

        $x("//a[contains(text(), 'Form Authentication')]").click();

        $x("//h2").shouldHave(text("Login Page"));

        $x("//input[@type='text']").setValue("admin");

        $x("//input[@type='password']").setValue("1234");

        $x("//button[@type='submit']").click();

        $x("//div[@id = 'flash-messages']/div ").shouldHave(text("Your username is invalid!"));
    }
}
