package com.juaracoding.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FinishPage {
    @FindBy(xpath = "//*[@id=\"checkout_complete_container\"]/h2")
    private WebElement finishText;

    public FinishPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public String getFinishPage() {
        return finishText.getText();
    }
}