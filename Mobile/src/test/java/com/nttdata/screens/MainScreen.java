package com.nttdata.screens;

import io.appium.java_client.pagefactory.AndroidFindBy;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainScreen extends PageObject {

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.saucelabs.mydemoapp.android:id/productTV\"]")
    private WebElement lblProduct;

    @AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[@content-desc=\"Displays all products of catalog\"]")
    private WebElement displayProductos;


    public boolean isProductsTitleDisplayed(){
        waitFor(ExpectedConditions.visibilityOf(lblProduct));
        return lblProduct.isDisplayed();
    }
    public boolean isProductsDisplayed(){
        waitFor(ExpectedConditions.visibilityOf(lblProduct));
        return displayProductos.isDisplayed();
    }

    public WebElement getProductByName(String productName) {
        String xpathProducto = String.format("//android.widget.ImageView[@content-desc=\"%s\"]", productName);
        WebElement productElement = getDriver().findElement(By.xpath(xpathProducto));
        waitFor(ExpectedConditions.visibilityOf(productElement));
        return productElement;
    }

    public void clickProduct(String producto) {
        WebElement productElement = getProductByName(producto);
        productElement.click();
    }
}
