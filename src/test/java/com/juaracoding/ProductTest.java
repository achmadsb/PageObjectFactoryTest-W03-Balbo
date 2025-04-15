package com.juaracoding;

import com.juaracoding.pages.ProductPage;
import com.juaracoding.utils.TakeScreenShoot;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class ProductTest{
    private WebDriver driver;
    private ProductPage productPage;

    public void scrollDown(int sampai) throws InterruptedException {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollTo({ top: " + sampai + ", behavior: 'smooth' });");
        Thread.sleep(5000);
    }

    public void scrollUp() throws InterruptedException {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollTo({ top: 0, behavior: 'smooth' });");
        Thread.sleep(5000);
    }

    @BeforeClass
    public void init() {
        driver = DriverSingleton.getDriver();
        productPage = new ProductPage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test(priority = 1)
    public void addToCart() throws InterruptedException, IOException {
        scrollDown(100);
        TakeScreenShoot.screenShootByDate(driver, "03");
        Thread.sleep(1000);
        productPage.addToCart(0);
        Thread.sleep(1000);
        productPage.addToCart(1);
        Thread.sleep(1000);
        productPage.addToCart(2);
        Thread.sleep(1000);
        productPage.addToCart(3);
        Thread.sleep(1000);
        productPage.addToCart(4);
        Thread.sleep(1000);
        productPage.addToCart(5);
        Thread.sleep(1000);
        TakeScreenShoot.screenShootByDate(driver, "04");
        Thread.sleep(1000);
        scrollUp();
        Thread.sleep(1000);
        TakeScreenShoot.screenShootByDate(driver, "05");
    }

    @Test(priority = 2)
    public void verifyCartCount() {
        Assert.assertEquals(productPage.getShoppingCartBadge(), "6");
    }
}
