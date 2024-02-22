package com.qa.tests;

import com.qa.CoreTest;
import com.qa.pages.*;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.*;

import java.io.InputStream;
import java.lang.reflect.Method;

public class watchScreen extends CoreTest {
    com.qa.pages.loginPage loginPage;
    com.qa.pages.launchScreen launchScreen;
    com.qa.pages.watchScreen watchScreen;
    JSONObject loginUser;
    com.qa.pages.accountPage accountPage;
    com.qa.pages.verifyLogin verifyLogin;
    com.qa.pages.vodSearch vodSearch;


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
        watchScreen = new com.qa.pages.watchScreen();
        accountPage = new accountPage();
        verifyLogin = new verifyLogin();
        vodSearch = new vodSearch();
    }

    @AfterMethod
    public void afterMethod() {
        watchScreen.scoreClick();
        accountPage.AccountIcon();
        accountPage.manageAcc();
        loginPage.signOut();

    }

    @Test
    public void login() {
        loginPage.emailTxtField(loginUser.getJSONObject("validUser").getString("username"));
        loginPage.passwordText(loginUser.getJSONObject("validUser").getString("password"));
        loginPage.loginBtn();
        watchScreen.scoreClick();
        accountPage.AccountIcon();
        accountPage.userEmailFieldDisplayed();
        accountPage.manageAcc();
        loginPage.signOut();
        loginPage.emailTxtField(loginUser.getJSONObject("validUser").getString("username"));
        loginPage.passwordText(loginUser.getJSONObject("validUser").getString("password"));
        loginPage.loginBtn();
    }

    @Test
    public void watchScreenSignOut(){
        loginPage.emailTxtField(loginUser.getJSONObject("validUser").getString("username"));
        loginPage.passwordText(loginUser.getJSONObject("validUser").getString("password"));
        loginPage.loginBtn();
        watchScreen.scoreClick();
        accountPage.AccountIcon();
        accountPage.manageAcc();
        loginPage.signOut();
        loginPage.emailTxtField(loginUser.getJSONObject("validUser").getString("username"));
        loginPage.passwordText(loginUser.getJSONObject("validUser").getString("password"));
        loginPage.loginBtn();
    }

    @Test
    public void watchScreenValidation() {
        loginPage.emailTxtField(loginUser.getJSONObject("validUser").getString("username"));
        loginPage.passwordText(loginUser.getJSONObject("validUser").getString("password"));
        loginPage.loginBtn();
        watchScreen.score();
        watchScreen.bets();
        watchScreen.schedule();
        watchScreen.news();
    }

    @Test
    public void Search() {
        loginPage.emailTxtField(loginUser.getJSONObject("validUser").getString("username"));
        loginPage.passwordText(loginUser.getJSONObject("validUser").getString("password"));
        loginPage.loginBtn();
        vodSearch.search(loginUser.getJSONObject("search").getString("search"));
        vodSearch.backButton();
    }
}
