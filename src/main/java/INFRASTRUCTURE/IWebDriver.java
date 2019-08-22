package INFRASTRUCTURE;

public interface IWebDriver {
    void open (String url);

    void click();

    void sendKeys(String sendKeys);
}
