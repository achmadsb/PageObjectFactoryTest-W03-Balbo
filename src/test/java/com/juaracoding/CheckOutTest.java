package com.juaracoding;

import com.juaracoding.pages.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

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
    public void cartTest() throws InterruptedException {
        Thread.sleep(2000);
        productPage.goCart();
    }

    @Test(priority = 2)
    public void checkOutTest() throws InterruptedException {
        Thread.sleep(2000);
        scrollDown(400);
        scrollDown(800);
        cartPage.clickCheckout();
    }

    @Test(priority = 3)
    @Parameters({"firstName", "lastName", "zip"})
    public void buyerDataTest(String firstName, String lastName, String zip) throws InterruptedException {
        Thread.sleep(2000);
        buyerDataPage.continueAction(firstName, lastName, zip);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test(priority = 4)
    public void checkOutFinish() throws InterruptedException{
        Thread.sleep(5000);
        scrollDown(400);
        scrollDown(900);
        overviewPage.getFinishButton();
        String actual = finishPage.getFinishPage();
        String expected = "THANK YOU FOR YOUR ORDER";
        Assert.assertEquals(actual,expected);
    }
}