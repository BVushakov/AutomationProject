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

public class RegistrationTest {

    private WebDriver driver;
    private User existingUser;

    @BeforeClass
    public void setUpBeforeClass() {
        WebDriverManager.chromedriver().setup();
//        existingUser = new User();
//        existingUser.setUserName("007");
//        existingUser.setFirstName("James");
//        existingUser.setLastName("Bond");
//        existingUser.setEmail("bond_james@gmail.com");
//        existingUser.setPassword("bond007");
        existingUser = new User();
        existingUser.setUserName("dick");
        existingUser.setFirstName("dickname");
        existingUser.setLastName("dicklastname");
        existingUser.setEmail("dick@gmail.com");
        existingUser.setPassword("dick666");
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
    public void registerTestNewClient() throws InterruptedException {

        driver.get("http://localhost/index.html");
        WebElement registerLink = driver.findElement(By.cssSelector("#register>a"));
        registerLink.click();

        WebElement registerModalWindow = driver.findElement(By.id("register-modal"));
        Thread.sleep(2000);
        assertTrue(registerModalWindow.isDisplayed());

        WebElement userNameInput = registerModalWindow.findElement(By.id("register-username-modal"));
        userNameInput.clear();
        userNameInput.sendKeys(existingUser.getUserName());

        WebElement firstNameInput = registerModalWindow.findElement(By.id("register-first-modal"));
        firstNameInput.clear();
        firstNameInput.sendKeys(existingUser.getFirstName());

        WebElement lastNameInput = registerModalWindow.findElement(By.id("register-last-modal"));
        lastNameInput.clear();
        lastNameInput.sendKeys(existingUser.getLastName());

        WebElement emailInput = registerModalWindow.findElement(By.id("register-email-modal"));
        emailInput.clear();
        emailInput.sendKeys(existingUser.getEmail());

        WebElement passwordInput = registerModalWindow.findElement(By.id("register-password-modal"));
        passwordInput.clear();
        passwordInput.sendKeys(existingUser.getPassword());

        WebElement signUpBtn = registerModalWindow.findElement(By.cssSelector("#register-modal .fa-sign-in"));
        signUpBtn.click();

        WebElement logout = driver.findElement(By.id("logout"));
        Thread.sleep(3000);
        assertTrue(logout.isDisplayed());

        WebElement loggedInfo = driver.findElement(By.cssSelector("#howdy a"));
        String infoText = loggedInfo.getText();
        String expectedInfo = String.format("Logged in as %s %s", existingUser.getFirstName(), existingUser.getLastName());
        assertEquals(expectedInfo, infoText);
    }

    @Test
    public void registerTestSameClient() throws InterruptedException {// По таким данным уже есть разеганый пользователь

        driver.get("http://localhost/index.html");
        WebElement registerLink = driver.findElement(By.cssSelector("#register>a"));
        registerLink.click();

        WebElement registerModalWindow = driver.findElement(By.id("register-modal"));
        Thread.sleep(2000);
        assertTrue(registerModalWindow.isDisplayed());

        WebElement userNameInput = registerModalWindow.findElement(By.id("register-username-modal"));
        userNameInput.clear();
        userNameInput.sendKeys(existingUser.getUserName());

        WebElement firstNameInput = registerModalWindow.findElement(By.id("register-first-modal"));
        firstNameInput.clear();
        firstNameInput.sendKeys(existingUser.getFirstName());

        WebElement lastNameInput = registerModalWindow.findElement(By.id("register-last-modal"));
        lastNameInput.clear();
        lastNameInput.sendKeys(existingUser.getLastName());

        WebElement emailInput = registerModalWindow.findElement(By.id("register-email-modal"));
        emailInput.clear();
        emailInput.sendKeys(existingUser.getEmail());

        WebElement passwordInput = registerModalWindow.findElement(By.id("register-password-modal"));
        passwordInput.clear();
        passwordInput.sendKeys(existingUser.getPassword());

        WebElement signUpBtn = registerModalWindow.findElement(By.cssSelector("#register-modal .fa-sign-in"));
        signUpBtn.click();

        WebElement errorText = registerModalWindow.findElement(By.cssSelector(".alert-danger"));
        assertTrue(errorText.isDisplayed());
    }

    @Test
    public void registerTestWithoutUsernameField() throws InterruptedException {

        driver.get("http://localhost/index.html");
        WebElement registerLink = driver.findElement(By.cssSelector("#register>a"));
        registerLink.click();

        WebElement registerModalWindow = driver.findElement(By.id("register-modal"));
        Thread.sleep(2000);
        assertTrue(registerModalWindow.isDisplayed());

        WebElement firstNameInput = registerModalWindow.findElement(By.id("register-first-modal"));
        firstNameInput.clear();
        firstNameInput.sendKeys(existingUser.getFirstName());

        WebElement lastNameInput = registerModalWindow.findElement(By.id("register-last-modal"));
        lastNameInput.clear();
        lastNameInput.sendKeys(existingUser.getLastName());

        WebElement emailInput = registerModalWindow.findElement(By.id("register-email-modal"));
        emailInput.clear();
        emailInput.sendKeys(existingUser.getEmail());

        WebElement passwordInput = registerModalWindow.findElement(By.id("register-password-modal"));
        passwordInput.clear();
        passwordInput.sendKeys(existingUser.getPassword());

        WebElement signUpBtn = registerModalWindow.findElement(By.cssSelector("#register-modal .fa-sign-in"));
        signUpBtn.click();

        WebElement errorText = registerModalWindow.findElement(By.cssSelector(".alert-danger"));
        assertTrue(errorText.isDisplayed());
    }

    @Test
    public void registerTestWithoutFirstnameField() throws InterruptedException {

        driver.get("http://localhost/index.html");
        WebElement registerLink = driver.findElement(By.cssSelector("#register>a"));
        registerLink.click();

        WebElement registerModalWindow = driver.findElement(By.id("register-modal"));
        Thread.sleep(2000);
        assertTrue(registerModalWindow.isDisplayed());

        WebElement userNameInput = registerModalWindow.findElement(By.id("register-username-modal"));
        userNameInput.clear();
        userNameInput.sendKeys(existingUser.getUserName());

        WebElement lastNameInput = registerModalWindow.findElement(By.id("register-last-modal"));
        lastNameInput.clear();
        lastNameInput.sendKeys(existingUser.getLastName());

        WebElement emailInput = registerModalWindow.findElement(By.id("register-email-modal"));
        emailInput.clear();
        emailInput.sendKeys(existingUser.getEmail());

        WebElement passwordInput = registerModalWindow.findElement(By.id("register-password-modal"));
        passwordInput.clear();
        passwordInput.sendKeys(existingUser.getPassword());

        WebElement signUpBtn = registerModalWindow.findElement(By.cssSelector("#register-modal .fa-sign-in"));
        signUpBtn.click();

        WebElement errorText = registerModalWindow.findElement(By.cssSelector(".alert-danger"));
        assertTrue(errorText.isDisplayed());
    }

    @Test
    public void registerTestWithoutLastnameField() throws InterruptedException {

        driver.get("http://localhost/index.html");
        WebElement registerLink = driver.findElement(By.cssSelector("#register>a"));
        registerLink.click();

        WebElement registerModalWindow = driver.findElement(By.id("register-modal"));
        Thread.sleep(2000);
        assertTrue(registerModalWindow.isDisplayed());

        WebElement userNameInput = registerModalWindow.findElement(By.id("register-username-modal"));
        userNameInput.clear();
        userNameInput.sendKeys(existingUser.getUserName());

        WebElement firstNameInput = registerModalWindow.findElement(By.id("register-first-modal"));
        firstNameInput.clear();
        firstNameInput.sendKeys(existingUser.getFirstName());

        WebElement emailInput = registerModalWindow.findElement(By.id("register-email-modal"));
        emailInput.clear();
        emailInput.sendKeys(existingUser.getEmail());

        WebElement passwordInput = registerModalWindow.findElement(By.id("register-password-modal"));
        passwordInput.clear();
        passwordInput.sendKeys(existingUser.getPassword());

        WebElement signUpBtn = registerModalWindow.findElement(By.cssSelector("#register-modal .fa-sign-in"));
        signUpBtn.click();

        WebElement errorText = registerModalWindow.findElement(By.cssSelector(".alert-danger"));
        assertTrue(errorText.isDisplayed());
    }

    @Test
    public void registerTestWithoutEmailField() throws InterruptedException {

        driver.get("http://localhost/index.html");
        WebElement registerLink = driver.findElement(By.cssSelector("#register>a"));
        registerLink.click();

        WebElement registerModalWindow = driver.findElement(By.id("register-modal"));
        Thread.sleep(2000);
        assertTrue(registerModalWindow.isDisplayed());

        WebElement userNameInput = registerModalWindow.findElement(By.id("register-username-modal"));
        userNameInput.clear();
        userNameInput.sendKeys(existingUser.getUserName());

        WebElement firstNameInput = registerModalWindow.findElement(By.id("register-first-modal"));
        firstNameInput.clear();
        firstNameInput.sendKeys(existingUser.getFirstName());

        WebElement lastNameInput = registerModalWindow.findElement(By.id("register-last-modal"));
        lastNameInput.clear();
        lastNameInput.sendKeys(existingUser.getLastName());

        WebElement passwordInput = registerModalWindow.findElement(By.id("register-password-modal"));
        passwordInput.clear();
        passwordInput.sendKeys(existingUser.getPassword());

        WebElement signUpBtn = registerModalWindow.findElement(By.cssSelector("#register-modal .fa-sign-in"));
        signUpBtn.click();

        WebElement errorText = registerModalWindow.findElement(By.cssSelector(".alert-danger"));
        assertTrue(errorText.isDisplayed());
    }

    @Test
    public void registerTestWithoutPasswordField() throws InterruptedException {

        driver.get("http://localhost/index.html");
        WebElement registerLink = driver.findElement(By.cssSelector("#register>a"));
        registerLink.click();

        WebElement registerModalWindow = driver.findElement(By.id("register-modal"));
        Thread.sleep(2000);
        assertTrue(registerModalWindow.isDisplayed());

        WebElement userNameInput = registerModalWindow.findElement(By.id("register-username-modal"));
        userNameInput.clear();
        userNameInput.sendKeys(existingUser.getUserName());

        WebElement firstNameInput = registerModalWindow.findElement(By.id("register-first-modal"));
        firstNameInput.clear();
        firstNameInput.sendKeys(existingUser.getFirstName());

        WebElement lastNameInput = registerModalWindow.findElement(By.id("register-last-modal"));
        lastNameInput.clear();
        lastNameInput.sendKeys(existingUser.getLastName());

        WebElement emailInput = registerModalWindow.findElement(By.id("register-email-modal"));
        emailInput.clear();
        emailInput.sendKeys(existingUser.getEmail());

        WebElement signUpBtn = registerModalWindow.findElement(By.cssSelector("#register-modal .fa-sign-in"));
        signUpBtn.click();

        WebElement errorText = registerModalWindow.findElement(By.cssSelector(".alert-danger"));
        assertTrue(errorText.isDisplayed());
    }

    @Test
    public void registerTestWithEmptyFields() throws InterruptedException {
        driver.get("http://localhost/index.html");
        WebElement registerLink = driver.findElement(By.cssSelector("#register>a"));
        registerLink.click();

        WebElement registerModalWindow = driver.findElement(By.id("register-modal"));
        Thread.sleep(2000);
        assertTrue(registerModalWindow.isDisplayed());

        WebElement signUpBtn = registerModalWindow.findElement(By.cssSelector("#register-modal .fa-sign-in"));
        signUpBtn.click();

        WebElement errorText = registerModalWindow.findElement(By.cssSelector(".alert-danger"));
        assertTrue(errorText.isDisplayed());
    }

    @Test
    public void registerTestOpenRegisterFormAndClose() throws InterruptedException {
        driver.get("http://localhost/index.html");
        WebElement registerLink = driver.findElement(By.cssSelector("#register>a"));
        registerLink.click();

        WebElement registerModalWindow = driver.findElement(By.id("register-modal"));
        Thread.sleep(2000);
        assertTrue(registerModalWindow.isDisplayed());

        WebElement closeBtn = driver.findElement(By.cssSelector("#register-modal .close"));
        closeBtn.click();

        assertTrue(registerModalWindow.isEnabled());
    }

}
