package LoginTests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import project.User;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest {

    private WebDriver driver;
    private User existingUser;

    @BeforeClass
    public void setUpBeforeClass() {
        WebDriverManager.chromedriver().setup();
        existingUser = new User();
        existingUser.setUserName("Bob");
        existingUser.setFirstName("Bogdan");
        existingUser.setLastName("Savchuk");
        existingUser.setEmail("bob-91@gmail.com");
        existingUser.setPassword("Bobpass");
    }

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(4, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        driver.manage().window().fullscreen();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void loginTestValidName() throws InterruptedException {

        driver.get("http://localhost/index.html");
        WebElement loginLink = driver.findElement(By.cssSelector("#login>a"));
        loginLink.click();

        WebElement loginModalWindow = driver.findElement(By.id("login-modal"));
        Thread.sleep(2000);
        assertTrue(loginModalWindow.isDisplayed());

        WebElement userNameInput = loginModalWindow.findElement(By.id("username-modal"));
        userNameInput.clear();
        userNameInput.sendKeys(existingUser.getUserName());

        WebElement passwordInput = loginModalWindow.findElement(By.id("password-modal"));
        passwordInput.clear();
        passwordInput.sendKeys(existingUser.getPassword());

        WebElement signInBtn = loginModalWindow.findElement(By.cssSelector("#login-modal .fa-sign-in"));
        signInBtn.click();

        WebElement logout = driver.findElement(By.id("logout"));
        Thread.sleep(2000);
        assertTrue(logout.isDisplayed());

        WebElement loggedInfo = driver.findElement(By.cssSelector("#howdy a"));
        String infoText = loggedInfo.getText();
        String expectedInfo = String.format("Logged in as %s %s", existingUser.getFirstName(), existingUser.getLastName());
        assertEquals(expectedInfo, infoText);
    }

    @Test
    public void loginTestInvalidName() throws InterruptedException {
        driver.get("http://localhost/index.html");
        WebElement loginLink = driver.findElement(By.cssSelector("#login>a"));
        loginLink.click();

        WebElement loginModalWindow = driver.findElement(By.id("login-modal"));
        Thread.sleep(2000);
        assertTrue(loginModalWindow.isDisplayed());

        WebElement userNameInput = loginModalWindow.findElement(By.id("username-modal"));
        userNameInput.clear();
        userNameInput.sendKeys(existingUser.getUserName() + "InvLog");

        WebElement passwordInput = loginModalWindow.findElement(By.id("password-modal"));
        passwordInput.clear();
        passwordInput.sendKeys(existingUser.getPassword());

        WebElement signInBtn = loginModalWindow.findElement(By.cssSelector("#login-modal .fa-sign-in"));
        signInBtn.click();

        WebElement errorText = loginModalWindow.findElement(By.cssSelector(".alert-danger"));
        assertTrue(errorText.isDisplayed());
    }

    @Test
    public void loginTestInvalidPass() throws InterruptedException {
        driver.get("http://localhost/index.html");
        WebElement loginLink = driver.findElement(By.cssSelector("#login>a"));
        loginLink.click();

        WebElement loginModalWindow = driver.findElement(By.id("login-modal"));
        Thread.sleep(2000);
        assertTrue(loginModalWindow.isDisplayed());

        WebElement userNameInput = loginModalWindow.findElement(By.id("username-modal"));
        userNameInput.clear();
        userNameInput.sendKeys(existingUser.getUserName());

        WebElement passwordInput = loginModalWindow.findElement(By.id("password-modal"));
        passwordInput.clear();
        passwordInput.sendKeys(existingUser.getPassword() + "InvPass");

        WebElement signInBtn = loginModalWindow.findElement(By.cssSelector("#login-modal .fa-sign-in"));
        signInBtn.click();

        WebElement errorText = loginModalWindow.findElement(By.cssSelector(".alert-danger"));
        assertTrue(errorText.isDisplayed());
    }

    @Test
    public void loginTestWithoutLogin() throws InterruptedException {
        driver.get("http://localhost/index.html");
        WebElement loginLink = driver.findElement(By.cssSelector("#login>a"));
        loginLink.click();

        WebElement loginModalWindow = driver.findElement(By.id("login-modal"));
        Thread.sleep(2000);
        assertTrue(loginModalWindow.isDisplayed());

        WebElement passwordInput = loginModalWindow.findElement(By.id("password-modal"));
        passwordInput.clear();
        passwordInput.sendKeys(existingUser.getPassword());

        WebElement signInBtn = loginModalWindow.findElement(By.cssSelector("#login-modal .fa-sign-in"));
        signInBtn.click();

        WebElement errorText = loginModalWindow.findElement(By.cssSelector(".alert-danger"));
        assertTrue(errorText.isDisplayed());
    }

    @Test
    public void loginTestWithoutPass() throws InterruptedException {
        driver.get("http://localhost/index.html");
        WebElement loginLink = driver.findElement(By.cssSelector("#login>a"));
        loginLink.click();

        WebElement loginModalWindow = driver.findElement(By.id("login-modal"));
        Thread.sleep(2000);
        assertTrue(loginModalWindow.isDisplayed());

        WebElement userNameInput = loginModalWindow.findElement(By.id("username-modal"));
        userNameInput.clear();
        userNameInput.sendKeys(existingUser.getUserName());

        WebElement signInBtn = loginModalWindow.findElement(By.cssSelector("#login-modal .fa-sign-in"));
        signInBtn.click();

        WebElement errorText = loginModalWindow.findElement(By.cssSelector(".alert-danger"));
        assertTrue(errorText.isDisplayed());
    }


}
