package com.juaracoding.strategy;

import com.juaracoding.managers.ChromeManager;
import com.juaracoding.managers.EdgeManager;
import com.juaracoding.managers.FirefoxManager;
import com.juaracoding.utils.Browser;
import org.openqa.selenium.WebDriver;

public class DriverStrategy {
    public static WebDriver setStrategy(String browser) {
        if (browser.equals(Browser.CHROME)) {
            return ChromeManager.buildDriver();
        } else if (browser.equals(Browser.FIREFOX)) {
            return FirefoxManager.buildDriver();
        } else if (browser.equals(Browser.EDGE)) {
            return EdgeManager.buildDriver();
        }
        else {
            return ChromeManager.buildDriver();
        }
    }
}
