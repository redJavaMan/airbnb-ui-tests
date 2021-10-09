package com.airbnb.qe.uiautomationtests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

public class ResultsPage {

    @FindBy(xpath="//h2")
    List<WebElement> results;

    public ResultsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    public List<String> getResults(){
       return results.stream().map(WebElement::getText).collect(Collectors.toList());
    }
}
