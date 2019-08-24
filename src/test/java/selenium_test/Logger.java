package selenium_test;

import java.util.Calendar;
import java.util.Date;

public class Logger {

    public String log(String message) {
        System.out.println("LOG: " + getTime() + ": " + message);
        return message;
    }

    public static Date getTime() {
        return Calendar.getInstance().getTime();
    }
}
