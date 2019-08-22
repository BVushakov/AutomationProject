package INFRASTRUCTURE.webdrivers;

import INFRASTRUCTURE.IWebDriver;

public class SafariWebDriver implements IWebDriver {
    @Override
    public void open(String url) {
        System.out.println("Safari open url " + url);
    }

    @Override
    public void click() {
        System.out.println("Safari click on element");
    }

    @Override
    public void sendKeys(String sendKeys) {
        System.out.println("Safari sendKeys " + sendKeys);
    }
}
