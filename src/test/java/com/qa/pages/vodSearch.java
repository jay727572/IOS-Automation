package com.qa.pages;

import com.qa.CoreTest;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class vodSearch extends CoreTest {

        @iOSXCUITFindBy(id = "SearchButton")
        private WebElement searchButtonDisplayed;

    @iOSXCUITFindBy(id = "Search")
    private WebElement Search;

    @iOSXCUITFindBy(id = "backButton")
    private WebElement backButton;

    public vodSearch searchButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement SearchButtonElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("SearchButton")));
        SearchButtonElement.click();
        return this;
    }

    public vodSearch backButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement backButtonElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("backButton")));
        backButtonElement.click();
        return this;
    }

    public vodSearch search(String SearchText) {
        sendKeys(Search, SearchText);
        return this;
    }
}
