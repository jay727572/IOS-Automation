package com.qa.pages;

import com.qa.CoreTest;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class launchScreen extends CoreTest {

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"NESN 360\"]/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther")
    private WebElement launchNesn;

    public boolean isLaunchNesnDisplayed() {
        return isElementDisplayed(launchNesn);
    }
}
