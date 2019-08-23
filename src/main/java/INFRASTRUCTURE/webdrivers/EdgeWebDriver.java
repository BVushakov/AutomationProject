package INFRASTRUCTURE.webdrivers;

import INFRASTRUCTURE.IWebDriver;

public class EdgeWebDriver implements IWebDriver {

    @Override
    public void open(String url) {
        System.out.println("Edge open url " + url);
    }

    @Override
    public void click() {
        System.out.println("Edge click on element");
    }

    @Override
    public void sendKeys(String sendKeys) {
        System.out.println("Edge sendKeys " + sendKeys);
    }
}
