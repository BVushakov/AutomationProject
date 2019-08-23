package INFRASTRUCTURE.webdrivers;

import INFRASTRUCTURE.IWebDriver;

public class ChromeWebDriver implements IWebDriver {

    @Override
    public void open(String url) {
        System.out.println("Chrome open url " + url);
    }

    @Override
    public void click() {
        System.out.println("Chrome click on element");
    }

    @Override
    public void sendKeys(String sendKeys) {
        System.out.println("Chrome sendKeys " + sendKeys);
    }
}
