package com.juaracoding.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductPage {
    @FindBy(className = "product_label")
    private WebElement productLabel;

    @FindBy(className = "shopping_cart_container")
    private WebElement shoppingCartBadge;

    @FindBy(className = "btn_inventory")
    private List<WebElement> productButton;

    @FindBy(className = "shopping_cart_container")
    private WebElement cartButton;

    public ProductPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public String getProductLabel() {
        return productLabel.getText();
    }

    public String getShoppingCartBadge() {
        return shoppingCartBadge.getText();
    }

    public void addToCart(int index) {
        productButton.get(index).click();
    }

    public void goCart() {
        cartButton.click();
    }
}
