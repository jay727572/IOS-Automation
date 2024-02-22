package com.qa.pages;

import com.qa.CoreTest;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class verifyLogin extends CoreTest {

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Forgot Password?\"]")
    private WebElement forgotPswText;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Let’s Go!\"]")
    private WebElement letsGoButton;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"NESN 360\"]/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeTextView[1]")
    private WebElement loginPageText;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextView[@name=\"Please refer to the FAQ for more information.\"]")
    private WebElement bottomText;

    @iOSXCUITFindBy(id = "Email Address")
    private WebElement emailFieldText;

    @iOSXCUITFindBy(id = "Password")
    private WebElement pswFieldText;

    public boolean isEmailFieldDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOf(emailFieldText)).isDisplayed();
    }

    public boolean isPswFieldDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOf(pswFieldText)).isDisplayed();
    }

    public boolean isBottomTextFieldDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOf(bottomText)).isDisplayed();
    }

    public boolean isLoginPageTextFieldDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOf(loginPageText)).isDisplayed();
    }

    public boolean isLetsGoButtonDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOf(letsGoButton)).isDisplayed();
    }

    public boolean isForgotPswTextDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOf(forgotPswText)).isDisplayed();
    }
}
