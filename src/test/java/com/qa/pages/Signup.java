package com.qa.pages;

import com.qa.CoreTest;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.By.id;


public class Signup extends CoreTest {
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

    @iOSXCUITFindBy(id = "SCORES")
    private WebElement score;

    public loginPage emailTxtField(String email) {
        sendKeys(emailTxtField, email);
        return this.signOut();
    }

    public watchScreen score() {
        score.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Adjust the timeout as needed
        WebElement scoresElement = wait.until(ExpectedConditions.visibilityOfElementLocated(id("SCORES")));
        return new watchScreen();
    }

    public loginPage passwordText(String psw) {
        sendKeys(passwordText,psw);
        return this.signOut();
    }

    public loginPage signOut() {
        signOut.click();
        return this.signOut();
    }

    public watchScreen loginBtn() {
        loginBtn.click();
        return new watchScreen();
    }

}
