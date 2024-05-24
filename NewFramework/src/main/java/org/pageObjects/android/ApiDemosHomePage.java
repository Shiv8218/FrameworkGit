package org.pageObjects.android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.utils.AndroidActions;

public class ApiDemosHomePage extends AndroidActions {

    AndroidDriver driver;

    public ApiDemosHomePage(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(accessibility = "Accessibility")
    private WebElement accessibilityEle;

    public AccessibilityPage clickOnAccessibility() {
        accessibilityEle.click();
        return new AccessibilityPage(driver);
    }
}
