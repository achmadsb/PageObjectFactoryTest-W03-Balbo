package com.juaracoding.managers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeManager {
    public static WebDriver buildDriver() {
        WebDriverManager.chromedriver().driverVersion("130.0.6669.2").setup();

        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\chrome-win64\\chrome.exe");

        options.addArguments("--start-maximized");

        return new ChromeDriver(options);
    }
}
