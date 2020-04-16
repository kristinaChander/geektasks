package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ExOne extends TestBase {

    @Test
    public void loginTest(){
        driver.get("https://geekbrains.ru/");
        WebElement enterBtn = waitAndGetElement(By.cssSelector(".btn.sign-in"));
        enterBtn.click();

        WebElement userMailField = waitAndGetElement(By.id("user_email"));
        userMailField.sendKeys("accountfortests.test@mail.ru");

        WebElement userPasswordField = waitAndGetElement(By.id("user_password"));
        userPasswordField.sendKeys("test0987");

        WebElement submitBtn = waitAndGetElement(By.cssSelector("input[type='submit']"));
        submitBtn.click();

        String mainPage = "Главная";
        assertEquals(waitAndGetElement(By.className("gb-header__title")).getText(), mainPage);
    }
}
