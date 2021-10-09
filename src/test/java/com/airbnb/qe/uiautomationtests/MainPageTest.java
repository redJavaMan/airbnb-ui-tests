package com.airbnb.qe.uiautomationtests;

import org.testng.annotations.*;

import static org.testng.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class MainPageTest {
    private WebDriver driver;
    private MainPage mainPage;
    private ResultsPage resultsPage;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.airbnb.co.in/");
        mainPage = new MainPage(driver);
        resultsPage = new ResultsPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void searchForPlaces() {
        mainPage.search("Kerala");
        String firstResult = resultsPage.getResults().get(0);
        assertEquals(firstResult, "Munnar");
    }

    @Test
    public void toolsMenu() {
        new Actions(driver)
                .moveToElement(mainPage.location)
                .perform();

        WebElement menuPopup = driver.findElement(By.cssSelector("div[data-test='menu-main-popup-content']"));
        assertTrue(menuPopup.isDisplayed());
    }

    @Test
    public void navigationToAllTools() {
        WebElement productsList = driver.findElement(By.id("products-page"));
        assertTrue(productsList.isDisplayed());
        assertEquals(driver.getTitle(), "All Developer Tools and Products by JetBrains");
    }
}
