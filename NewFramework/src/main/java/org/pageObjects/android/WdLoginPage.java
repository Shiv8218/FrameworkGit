package org.pageObjects.android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.utils.AndroidActions;

public class WdLoginPage extends AndroidActions {

    AndroidDriver driver;

    public WdLoginPage(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);

    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Sign up\"]")
    private WebElement signUpElement;

    @AndroidFindBy(accessibility = "input-email")
    private WebElement emailElement;

    @AndroidFindBy(accessibility = "input-password")
    private WebElement passwordElement;

    public void enterCredential(String email,String password){
        emailElement.sendKeys(email);
        emailElement.sendKeys(password);

    }

    public WdSignUpPage signUpOption(){
        signUpElement.click();
        return new WdSignUpPage(driver);

    }



}
