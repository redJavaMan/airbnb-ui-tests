package com.airbnb.qe.uiautomationtests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    @FindBy(xpath = "//input[@data-testid='structured-search-input-field-query']")
    public WebElement location;

    @FindBy(xpath = "//button[@data-testid='structured-search-input-search-button']")
    public WebElement searchButton;

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void search(String location){
        this.location.sendKeys(location);
        this.searchButton.click();
    }
}
