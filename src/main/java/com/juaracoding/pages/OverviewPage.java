package com.juaracoding.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OverviewPage {
    @FindBy(xpath = "//*[@id=\"checkout_summary_container\"]/div/div[2]/div[8]/a[2]\n")
    private WebElement finishButton;

    public OverviewPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void getFinishButton() {
        finishButton.click();
    }
}
