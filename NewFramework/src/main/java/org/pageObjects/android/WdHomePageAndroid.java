package org.pageObjects.android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.utils.AndroidActions;

public class WdHomePageAndroid extends AndroidActions {

    AndroidDriver driver;

    public WdHomePageAndroid(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Login\"]")
    private WebElement loginElement;

    public WdLoginPage clickOnLogInPage() {
        loginElement.click();
        return new WdLoginPage(driver);
    }
}
