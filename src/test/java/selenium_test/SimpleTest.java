package selenium_test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

import static org.testng.Assert.*;

public class SimpleTest {

    Logger logger = new Logger();

    private WebDriver driver;

    @BeforeClass
    public void setUpDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void hillelSimpleTest() {
        String url = "https://dnipro.ithillel.ua/";
        driver.get(url);

        String currentUrl = driver.getCurrentUrl();
        logger.log("currentUrl: " + currentUrl);
        assertEquals(url, currentUrl, "Wrong opened URL!");

        String title = driver.getTitle();
        logger.log("title: " + title);
        assertFalse(title.isEmpty(), "Wrong title!");
        assertEquals("Компьютерная школа Hillel в Днепре: курсы IT технологий", title, "Wrong title!");
    }


    @Test
    public void windowHandlesTest() throws InterruptedException {
        String url = "https://auto.ria.com";
        driver.get(url);

        String mainWindow = driver.getWindowHandle();
        logger.log("mainWindow: " + mainWindow);
        String title = driver.getTitle();
        logger.log("main window title: " + title);

        WebElement element = driver.findElement(By.xpath("//*[@id='header']//*[contains(@href,'dom.ria.com')]"));
        element.click();
        Thread.sleep(2000);

        Set<String> windowHandles = driver.getWindowHandles();
        logger.log("windowHandles: " + windowHandles);

        String secondWindow = windowHandles.stream().filter(window -> !window.equalsIgnoreCase(mainWindow)).findFirst().get();
        logger.log("secondWindow: " + secondWindow);

        driver.switchTo().window(secondWindow);

        String secondTitle = driver.getTitle();
        logger.log("second window title: " + secondTitle);

        String currentUrl = driver.getCurrentUrl();
        logger.log("currentUrl: " + currentUrl);

        assertNotEquals(url, currentUrl, "Wrong opened URL!");

        driver.switchTo().window(mainWindow);

        String secondTitle1 = driver.getTitle();
        logger.log("second window title: " + secondTitle1);

        String currentUrl1 = driver.getCurrentUrl();
        logger.log("currentUrl: " + currentUrl1);
    }

}
