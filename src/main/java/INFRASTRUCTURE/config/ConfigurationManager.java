package INFRASTRUCTURE.config;

public class ConfigurationManager {

    private static ConfigurationManager instance;
    private String browser = "chrome";
    private String testEnv = "local";


    private ConfigurationManager() {
    }

    public static ConfigurationManager getInstance() {
        if (instance == null) {
            return instance = new ConfigurationManager();
        }
        return instance;
    }

    public String getBrowser() {
        return System.getProperty("browser".toLowerCase(), browser.toLowerCase());
    }

    public String getTestEnv() {
        return System.getProperty("env".toLowerCase(), testEnv.toLowerCase());
    }
}
