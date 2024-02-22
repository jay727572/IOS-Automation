package com.qa.pages;

import com.qa.CoreTest;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static org.openqa.selenium.By.*;

public class loginPage extends CoreTest {
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"NESN 360\"]/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeTextField")
    private WebElement emailTxtField;

    @iOSXCUITFindBy(id = "Please enter a valid password")
    private WebElement passwordErrText;

    @iOSXCUITFindBy(id = "Please enter a valid email address")
    private WebElement emailErrText;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"NESN 360\"]/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeSecureTextField")
    private WebElement passwordText;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Let’s Go!\"]\n")
    private WebElement loginBtn;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Sign out\"]")
    private WebElement signOut;

    @iOSXCUITFindBy(id = "AccountIconWhiteLine")
    private WebElement accIcon;

    @iOSXCUITFindBy(id = "SCORES")
    private WebElement score;

    @iOSXCUITFindBy(xpath = "**/XCUIElementTypeButton[`label == \"Done\"`]")
    private WebElement done;

    public loginPage emailTxtField(String email) {
        sendKeys(emailTxtField, email);
        return this;
    }

    public loginPage passwordText(String psw) {
        sendKeys(passwordText,psw);
        return this;
    }

    public loginPage signOut() {
        signOut.click();
        return this;
    }

    public loginPage done() {
        done.click();
        return this;
    }

    public accountPage accIcon() {
        accIcon.click();
        return new accountPage();
    }

    public watchScreen loginBtn() {
        loginBtn.click();
        return new watchScreen();
    }

}
