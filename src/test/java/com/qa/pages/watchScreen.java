package com.qa.pages;

import com.qa.CoreTest;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class watchScreen extends CoreTest {

    @iOSXCUITFindBy(id = "scores")
    private WebElement score;

    @iOSXCUITFindBy(id = "BETS")
    private WebElement bets;

    @iOSXCUITFindBy(id = "NEWS")
    private WebElement news;

    @iOSXCUITFindBy(id = "SCHEDULE")
    private WebElement schedule;

    @iOSXCUITFindBy(id = "WATCH")
    private WebElement watch;

    @iOSXCUITFindBy(id = "AccountIcon")
    private WebElement AccountIcon;

    @iOSXCUITFindBy(id = "ManageNESNAccount")
    private WebElement ManageNESNAccount;

    public boolean score() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement scoreElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("scores")));
        return isElementDisplayed(scoreElement);
    }

    public boolean schedule() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement scheduleElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("schedule")));
        return isElementDisplayed(scheduleElement);
    }

    public boolean news() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement newsElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("news")));
        return isElementDisplayed(newsElement);
    }

    public boolean bets() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement betsElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("bets")));
        return isElementDisplayed(betsElement);
    }

    public accountPage watchClick() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement watchElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("watch")));
        watchElement.click();
        return new accountPage();
    }

    public accountPage scoreClick() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement scoreElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("scores")));
        scoreElement.click();
        return new accountPage();
   }

    public accountPage AccountIcon() {
        AccountIcon.click();
        return new accountPage();
    }

    public accountPage ManageNESNAccount(){
        ManageNESNAccount.click();
        return new accountPage();
    }

//    WebElement score = (WebElement) driver.findElement(AppiumBy.accessibilityId("scores"));
//        score.click();
}
