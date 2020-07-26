package com.weborders.pages;

import com.weborders.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
    //explicit wait
    //will be used inside every page class
    //since this variable is protected
    //it will not be visible in test classes
    protected WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 20);

    public BasePage() {
        //we put this line to be able to use @FindBy, @FindBys.. annotations
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (linkText = "View all orders")
    private WebElement viewAllOrders;

    @FindBy (linkText = "View all products")
    private WebElement viewAllProducts;

    @FindBy (linkText = "Order")
    private WebElement order;

    public void clickOnViewAllOrders(){
        System.out.println("Clicking on 'View All Oders' page");
        wait.until(ExpectedConditions.elementToBeClickable(viewAllOrders));
        viewAllOrders.click();
    }
    public void clickOnViewAllProducts(){
        System.out.println("Clicking on 'View All Products' page");
        wait.until(ExpectedConditions.elementToBeClickable(viewAllProducts));
        viewAllProducts.click();
    }
    public void clickOnOrder(){
        System.out.println("Clicking on 'Order'");
        wait.until(ExpectedConditions.elementToBeClickable(order)).click();
    }

}