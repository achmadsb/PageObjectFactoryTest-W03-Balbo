package com.juaracoding;

import com.juaracoding.pages.*;
import com.juaracoding.utils.TakeScreenShoot;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class CheckOutTest {
    private WebDriver driver;
    private ProductPage productPage;
    private CartPage cartPage;
    private BuyerDataPage buyerDataPage;
    private OverviewPage overviewPage;
    private FinishPage finishPage;

    public void scrollDown(int sampai) throws InterruptedException {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollTo({ top: " + sampai + ", behavior: 'smooth' });");
        Thread.sleep(5000);
    }


    @BeforeClass
    public void init() {
        driver = DriverSingleton.getDriver();

        productPage = new ProductPage(driver);
        cartPage = new CartPage(driver);
        buyerDataPage = new BuyerDataPage(driver);
        overviewPage = new OverviewPage(driver);
        finishPage = new FinishPage(driver);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test(priority = 1)
    public void cartTest() throws InterruptedException, IOException {
        Thread.sleep(2000);
        productPage.goCart();
        TakeScreenShoot.screenShootByDate(driver, "06");
    }

    @Test(priority = 2)
    public void checkOutTest() throws InterruptedException, IOException {
        Thread.sleep(2000);
        scrollDown(400);
        Thread.sleep(2000);
        TakeScreenShoot.screenShootByDate(driver, "07");
        scrollDown(800);
        Thread.sleep(1000);
        TakeScreenShoot.screenShootByDate(driver, "08");
        cartPage.clickCheckout();

    }

    @Test(priority = 3)
    @Parameters({"firstName", "lastName", "zip"})
    public void buyerDataTest(String firstName, String lastName, String zip) throws InterruptedException, IOException {
        TakeScreenShoot.screenShootByDate(driver, "09");
        Thread.sleep(1000);
        buyerDataPage.continueAction(firstName, lastName, zip);
        Thread.sleep(1000);
        TakeScreenShoot.screenShootByDate(driver, "10");
        Thread.sleep(1000);
        buyerDataPage.clickContinue();
        TakeScreenShoot.screenShootByDate(driver, "11");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test(priority = 4)
    public void checkOutFinish() throws InterruptedException, IOException {
        Thread.sleep(5000);
        scrollDown(400);
        Thread.sleep(1000);
        TakeScreenShoot.screenShootByDate(driver, "12");
        Thread.sleep(1000);
        scrollDown(900);
        Thread.sleep(1000);
        TakeScreenShoot.screenShootByDate(driver, "13");
        Thread.sleep(1000);
        overviewPage.getFinishButton();
        TakeScreenShoot.screenShootByDate(driver, "14");
        Thread.sleep(1000);
        String actual = finishPage.getFinishPage();
        String expected = "THANK YOU FOR YOUR ORDER";
        Assert.assertEquals(actual,expected);
    }
}