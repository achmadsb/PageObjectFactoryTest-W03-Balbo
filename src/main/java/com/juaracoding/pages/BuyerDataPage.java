package com.juaracoding.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class BuyerDataPage {
    private Actions actions;

    @FindBy(id = "first-name")
    private WebElement firstNameField;

    @FindBy(id = "last-name")
    private WebElement lastNameField;

    @FindBy(id = "postal-code")
    private WebElement postalCode;

    @FindBy(xpath = "//*[@id=\"checkout_info_container\"]/div/form/div[2]/input")
    private WebElement continueButton;

    public BuyerDataPage(WebDriver driver) {
        actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    public void continueAction(String firstName, String lastName, String zip) {
        actions.click(firstNameField).sendKeys(firstName)
                .pause(Duration.ofSeconds(1))
                .click(lastNameField).sendKeys(lastName)
                .pause(Duration.ofSeconds(1))
                .click(postalCode).sendKeys(zip)
                .pause(Duration.ofSeconds(1))
                .moveToElement(continueButton).click().build().perform();
    }
}
