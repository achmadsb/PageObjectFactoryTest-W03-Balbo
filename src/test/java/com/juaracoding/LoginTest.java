package com.juaracoding;

import com.juaracoding.pages.LoginPage;
import com.juaracoding.pages.ProductPage;
import com.juaracoding.utils.TakeScreenShoot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;
import java.time.Duration;

public class LoginTest {
    private WebDriver driver;
    private LoginPage loginPage;
    private ProductPage productPage;

    @BeforeClass
    @Parameters("url")
    public void setUp(String url) throws IOException {
        driver = DriverSingleton.getDriver();

        loginPage = new LoginPage(driver);
        productPage = new ProductPage(driver);

        driver.get(url);
        TakeScreenShoot.screenShootByDate(driver, "01");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    @Parameters({ "username", "password" })
    public void loginTest(String username, String password) throws IOException, InterruptedException {
        loginPage.loginAction(username, password);
        Thread.sleep(1000);
        TakeScreenShoot.screenShootByDate(driver, "02");
        loginPage.clickLogin();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        String actual = productPage.getProductLabel();
        String expected = "Products";
        Assert.assertEquals(actual, expected);
    }
}
