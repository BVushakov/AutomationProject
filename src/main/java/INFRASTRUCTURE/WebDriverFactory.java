package INFRASTRUCTURE;

import INFRASTRUCTURE.config.ConfigurationManager;
import INFRASTRUCTURE.webdrivers.ChromeWebDriver;
import INFRASTRUCTURE.webdrivers.EdgeWebDriver;
import INFRASTRUCTURE.webdrivers.FireFoxWebDriver;
import INFRASTRUCTURE.webdrivers.SafariWebDriver;

public class WebDriverFactory implements IWebDriverFactory {

    @Override
    public IWebDriver create() {
        IWebDriver driver = null;

        String browserChromeConfig = ConfigurationManager.getInstance().getBrowser();
        Browsers browser = Browsers.valueOf(browserChromeConfig.toUpperCase());

        switch (browser) {
            case CHROME:
                driver = new ChromeWebDriver();
                break;
            case FIREFOX:
                driver = new FireFoxWebDriver();
                break;
            case EDGE:
                driver = new EdgeWebDriver();
                break;
            case SAFARI:
                driver = new SafariWebDriver();
                break;
            default:
                System.out.println(browser.name() + " is not supported!");
        }

        return driver;
    }
}
