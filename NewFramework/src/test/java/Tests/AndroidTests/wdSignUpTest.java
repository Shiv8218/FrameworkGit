package Tests.AndroidTests;


import Tests.TestUtils.androidBaseTest;
import org.pageObjects.android.WdLoginPage;
import org.pageObjects.android.WdSignUpPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class wdSignUpTest extends androidBaseTest {

    @Test(dataProvider = "getData", groups = {"Smoke"})
    public void signFlow(HashMap <String ,String> input) throws InterruptedException {

        WdLoginPage wdLoginPage = wdHomePageAndroid.clickOnLogInPage();
        WdSignUpPage wdSignUpPage = wdLoginPage.signUpOption();
        wdSignUpPage.enterCredentialSignUp(input.get("Email"),input.get("Password"));
        wdSignUpPage.clickOnSubmitButton();

        String text = wdSignUpPage.getSignUpText();
        wdSignUpPage.clickOnSignUpOk();

        Assert.assertEquals(text,"Signed Up!");
        Thread.sleep(4000);

    }

    @DataProvider
    public Object[][] getData() throws IOException {
        List<HashMap<String, String>> data = getJsonData(System.getProperty("user.dir")+"//src//test//java//TestData//credentials.json");
        return new Object[][] {  {data.get(0)},{data.get(1)}  };

    }

}