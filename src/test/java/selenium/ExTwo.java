package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class ExTwo extends TestBase {

    @Test
    public void loginAndGoToDifferentPagesTest() {
        driver.get("https://geekbrains.ru/");
        WebElement enterBtn = waitAndGetElement(By.cssSelector(".btn.sign-in"));
        enterBtn.click();

        WebElement userMailField = waitAndGetElement(By.id("user_email"));
        userMailField.sendKeys("accountfortests.test@mail.ru");

        WebElement userPasswordFied = waitAndGetElement(By.id("user_password"));
        userPasswordFied.sendKeys("test0987");

        WebElement submitBtn = waitAndGetElement(By.cssSelector("input[type='submit']"));
        submitBtn.click();

        assertEquals(waitAndGetElement(By.className("gb-header__title")).getText(), "Главная");


        WebElement careerBtn = waitAndGetElement(By.xpath("//a[normalize-space()='Карьера']"));
        careerBtn.click();

        WebElement geekBrains = waitAndGetElement(By.cssSelector("div.projects.row>div:nth-child(1) div.small"));
        geekBrains.click();

        String title = driver.getTitle();
        assertEquals(title, "Вакансии Образовательный портал GeekBrains | GeekBrains - образовательный портал");

        WebElement vacancy = waitAndGetElement(By.xpath("//span[text()='Вакансии']"));
        vacancy.click();

        assertNotNull(waitAndGetElement(By.xpath("//*[text()='Преподаватель вебинаров по курсу \"Основы Go\"']")));
    }
}
