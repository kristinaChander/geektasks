package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.List;
import java.util.concurrent.TimeUnit;

public abstract class TestBase {

    private static final int TIME_OUT_IN_SECONDS = 10;

    protected WebDriver driver;

    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setupTest() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    protected WebElement waitAndGetElement(By by) {
        return new WebDriverWait(driver, TIME_OUT_IN_SECONDS)
                .until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    protected List<WebElement> waitAndGetListOfElements(By by) {
        return new WebDriverWait(driver, TIME_OUT_IN_SECONDS)
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }

    //Close Browser
    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}
