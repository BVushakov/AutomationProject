package INFRASTRUCTURE;

public class WebDriverMain {

    public static void main(String[] args) {

        WebDriverFactory webDriverFactory = new WebDriverFactory();
        IWebDriver driver = webDriverFactory.create();

        driver.open("https://www.google.ru/");
        driver.sendKeys("hillel");
        driver.click();
    }
}
