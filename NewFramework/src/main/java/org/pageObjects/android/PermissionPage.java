package org.pageObjects.android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.utils.AndroidActions;

public class PermissionPage extends AndroidActions {

    AndroidDriver driver;

    public PermissionPage(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);

    }

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_button")
    private WebElement SMS_Permission;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_button")
    private WebElement Call_Permission;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_all_button")
    private WebElement Media_Permission;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_foreground_only_button")
    private WebElement Location_Permission;


    public void click_on_SMS_Permission() {
        SMS_Permission.click();
    }


    public void click_on_Call_Permission() {
        Call_Permission.click();
    }


    public void click_on_Media_permission() {
        Media_Permission.click();
    }

    public TermAndConditionsPage click_on_Location_permission() {
        Location_Permission.click();

        return new TermAndConditionsPage(driver);

    }

}