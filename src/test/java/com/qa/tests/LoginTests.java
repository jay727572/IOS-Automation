package com.qa.tests;
import com.qa.CoreTest;
import com.qa.pages.accountPage;
import com.qa.pages.launchScreen;
import com.qa.pages.loginPage;
import com.qa.pages.watchScreen;
import com.qa.pages.verifyLogin;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.*;

import java.io.InputStream;
import java.lang.reflect.Method;

public class LoginTests extends CoreTest {

    loginPage loginPage;
    launchScreen launchScreen;
    watchScreen watchScreen;
    JSONObject loginUser;
    accountPage accountPage;
    verifyLogin verifyLogin;


    @BeforeClass
    public void beforeClass() throws Exception {
        InputStream datais = null;
        try {
            String dataFileName = "data/loginUser.json";
            datais = getClass().getClassLoader().getResourceAsStream(dataFileName);
            JSONTokener tokener = new JSONTokener(datais);
            loginUser = new JSONObject(tokener);
        } catch(Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            if(datais != null) {
                datais.close();
            }
        }
    }

    @AfterClass
    public void afterClass() {

    }

    @BeforeMethod
    public void beforeMethod(Method m) {
        System.out.println("\n" + "-------- starting test:" + m.getName() + "-------" + "\n");
        loginPage = new loginPage();
        launchScreen = new launchScreen();
        watchScreen = new watchScreen();
        accountPage = new accountPage();
        verifyLogin = new verifyLogin();
    }

    @AfterMethod
    public void afterMethod() {

    }

    @Test
    public void launch(){
        launchScreen.isLaunchNesnDisplayed();
    }

    @Test
    public void loginValidation(){
        verifyLogin.isEmailFieldDisplayed();
        verifyLogin.isForgotPswTextDisplayed();
        verifyLogin.isLoginPageTextFieldDisplayed();
        verifyLogin.isLetsGoButtonDisplayed();
        verifyLogin.isPswFieldDisplayed();
        verifyLogin.isBottomTextFieldDisplayed();
    }
}
