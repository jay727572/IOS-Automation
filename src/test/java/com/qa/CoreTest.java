package com.qa;

import com.aventstack.extentreports.testng.listener.ExtentITestListenerAdapter;
import com.qa.utils.TestUtils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.InteractsWithApps;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.URL;
import java.util.HashMap;
import java.util.Properties;

@Listeners(ExtentITestListenerAdapter.class)


public class CoreTest {
    protected static AppiumDriver driver;
    protected static Properties props;
    protected static HashMap<String, String> strings = new HashMap<String, String>();
    InputStream inputStream = null;
    InputStream stringsis;
    TestUtils utils;
    private static AppiumDriverLocalService server;


    @BeforeSuite
    public void beforeSuite() throws Exception, Exception {
		server = getAppiumService(); // -> If using Mac, uncomment this statement and comment below statement
//        server = getAppiumServerDefault(); // -> If using Windows, uncomment this statement and comment above statement
        if(!checkIfAppiumServerIsRunnning(4723)) {
            server.start();
            server.clearOutPutStreams(); // -> Comment this if you want to see server logs in the console
        } else {
            System.out.println("Appium Server stopped");
        }
    }

    public boolean checkIfAppiumServerIsRunnning(int port) throws Exception {
        boolean isAppiumServerRunning = false;
        ServerSocket socket;
        try {
            socket = new ServerSocket(port);
            socket.close();
        } catch (IOException e) {
            System.out.println("1");
            isAppiumServerRunning = true;
        } finally {
            socket = null;
        }
        return isAppiumServerRunning;
    }

    @AfterSuite (alwaysRun = true)
    public void afterSuite() {
        if(server.isRunning()){
            server.stop();
            System.out.println("Appium server stopped");
        }
    }


    public AppiumDriverLocalService getAppiumServerDefault() {
        return AppiumDriverLocalService.buildDefaultService();
    }
    public AppiumDriverLocalService getAppiumService() {
        HashMap<String, String> environment = new HashMap<String, String>();
        environment.put("PATH", "enter_your_path_here" + System.getenv("PATH"));
        environment.put("ANDROID_HOME", "enter_android_home_path");
        return AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
                .usingDriverExecutable(new File("/usr/local/bin/node"))
                .withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
                .usingPort(4723)
                .withArgument(GeneralServerFlag.SESSION_OVERRIDE));
    }

    public CoreTest() {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    @Parameters({"platformName","udid","deviceName", "deviceVersion"})

    @BeforeTest
    public void beforeTest(String platformName,String udid,String deviceName, String deviceVersion) throws Exception {

        try {
            props = new Properties();
            String propFileName = "config.properties";
            String xmlFileName = "strings/strings.xml";
            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
            if (inputStream == null) {
                throw new IOException("Property file '" + propFileName + "' not found in the classpath.");
            }
            props.load(inputStream);

            stringsis = getClass().getClassLoader().getResourceAsStream(xmlFileName);
            utils = new TestUtils();
            strings = utils.parseStringXML(stringsis);



            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability("platformName", platformName);
            desiredCapabilities.setCapability("appium:platformVersion", deviceVersion);
            desiredCapabilities.setCapability("appium:deviceName", deviceName);
            desiredCapabilities.setCapability("appium:bundleId", props.getProperty("iOSBundleId"));
            desiredCapabilities.setCapability("appium:automationName", props.getProperty("iOSAutomationName"));
            desiredCapabilities.setCapability("appium:udid", udid);

            //desiredCapabilities.setCapability(MobileCapabilityType.SYSTEM_PORT, 8210);
            desiredCapabilities.setCapability("clearSystemFiles", true);

            URL url = new URL(props.getProperty("appiumURL"));

            driver = new AppiumDriver(url, desiredCapabilities);
            String sessionID = driver.getSessionId().toString();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            // Close the inputStream when done to prevent resource leaks.
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(stringsis != null) {
                stringsis.close();
            }
        }
    }

    public void waitForVisibility(WebElement e) {
        WebDriverWait wait = new WebDriverWait(driver, TestUtils.WAIT);
        wait.until(ExpectedConditions.visibilityOf(e));
    }

    public void click(WebElement e){
        waitForVisibility(e);
        e.click();
    }

    public void sendKeys(WebElement e, String txt){
        waitForVisibility(e);
        e.sendKeys(txt);
    }
    public String getAttribute(WebElement e, String attribute) {
        waitForVisibility(e);
        return e.getAttribute(attribute);
    }

    public boolean isElementDisplayed(WebElement e) {
            return e.isDisplayed();
    }

    public void closeApp() {
                ((InteractsWithApps) getDriver()).terminateApp(props.getProperty("iOSBundleId"));
    }

    public void launchApp() {
                ((InteractsWithApps) getDriver()).activateApp(props.getProperty("iOSBundleId"));
    }

    public AppiumDriver getDriver() {
        return driver;
    }


    @AfterTest
    public void afterTest() {
        driver.quit();
    }
}