package com.qa.pages;

import com.qa.CoreTest;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class accountPage extends CoreTest {

    @iOSXCUITFindBy(id = "AccountIconWhiteLine")
    private WebElement AccountIcon;

    @iOSXCUITFindBy(id = "Manage NESN Account")
    private WebElement manageAcc;

    @iOSXCUITFindBy(xpath = "**/XCUIElementTypeStaticText[`label == \"Sign out\"`]")
    private WebElement signOut;

    @iOSXCUITFindBy(id = "djay@nesntest.com")
    private WebElement userValidation;

    public boolean userEmailFieldDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOf(userValidation)).isDisplayed();
    }
    public accountPage AccountIcon() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement accountIconElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("AccountIconWhiteLine")));
        accountIconElement.click();
        return new accountPage();
    }

    public accountPage manageAcc() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement accountManage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Manage NESN Account")));
        accountManage.click();
        return new accountPage();
    }

    public accountPage signOut() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement signOut = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("**/XCUIElementTypeStaticText[`label == \"Sign out\"`]")));
        signOut.click();
        return new accountPage();
    }
}
