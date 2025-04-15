package com.juaracoding.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TakeScreenShoot {
//    public static void screenShoot(WebDriver driver, String filename) throws IOException {
//        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//        Files.copy(srcFile.toPath(), Paths.get("stepfile_" + filename + ".png"));
//        System.out.println("Berhasil menyimpan image screenshot..");
//    }
//
//    public static void screenShootByDate(WebDriver driver, String step) throws IOException {
//        String stamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
//        String folderPath = "ScreenShootsSaucedemo/";
//        Files.createDirectories(Paths.get(folderPath));
//        // nentuin nama file (kombinasi)
//        String filePath = folderPath + step + "_screenshot_" + stamp + ".png";
//        TakeScreenShoot.screenShoot(driver, filePath);
//    }

    public static void screenShootByDate(WebDriver driver, String step) throws IOException {
        String stamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String folderPath = "ScreenShootsSaucedemo/";
        Files.createDirectories(Paths.get(folderPath));
        // nentuin nama file (kombinasi)
        String filePath = folderPath + step + "_screenshot_" + stamp + ".png";
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        Files.copy(srcFile.toPath(), Paths.get(filePath)); // Langsung copy dengan filePath yang sudah dibuat
        System.out.println("Berhasil menyimpan image screenshot dengan nama: " + filePath);
    }
}
