package INFRASTRUCTURE.webdrivers;

import INFRASTRUCTURE.IWebDriver;

public class FireFoxWebDriver implements IWebDriver {
    @Override
    public void open(String url) {
        System.out.println("FireFox open url " + url);
    }

    @Override
    public void click() {
        System.out.println("FireFox click on element");
    }

    @Override
    public void sendKeys(String sendKeys) {
        System.out.println("FireFox sendKeys " + sendKeys);
    }
}
