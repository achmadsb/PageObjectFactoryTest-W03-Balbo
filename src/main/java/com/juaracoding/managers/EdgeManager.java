package com.juaracoding.managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class EdgeManager {
    public static WebDriver buildDriver() {
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--start-maximized");

        return new EdgeDriver(options);
    }
}
