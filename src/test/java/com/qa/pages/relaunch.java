package com.qa.pages;

        import io.appium.java_client.AppiumDriver;
        import io.appium.java_client.pagefactory.iOSXCUITFindBy;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.support.ui.ExpectedConditions;
        import org.openqa.selenium.support.ui.WebDriverWait;

        import java.time.Duration;

public class relaunch {
    protected static AppiumDriver driver;

    public relaunch(AppiumDriver driver) {
        this.driver = driver;
        // Initialize elements using PageFactory or other methods...
    }

    // Method to close and reopen the app
}
