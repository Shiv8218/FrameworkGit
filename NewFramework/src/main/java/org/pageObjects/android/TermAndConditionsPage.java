package org.pageObjects.android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.utils.AndroidActions;

public class TermAndConditionsPage extends AndroidActions{

    AndroidDriver driver;

    public TermAndConditionsPage(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);

    }

    @AndroidBy(xpath = "//android.widget.TextView[@text=\"Terms & Conditions\"]")
    public WebElement term_and_condition;

    @AndroidBy(xpath = "//android.widget.Button[@text=\"I Agree\"]")
    public WebElement agree_element;



    public void click_on_agree(){
        scrollToEnd();
        agree_element.click();

    }
}
