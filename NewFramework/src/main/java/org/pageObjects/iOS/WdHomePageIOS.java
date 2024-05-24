package org.pageObjects.iOS;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.utils.IOSActions;

public class WdHomePageIOS extends IOSActions {

    IOSDriver driver;

    public WdHomePageIOS(IOSDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);

    }

    @iOSXCUITFindBy(id = "com.android.permissioncontroller:id/permission_allow_button")
    private WebElement SMS_Permission;


    public void click_on_SMS_Permission() {
        SMS_Permission.click();
    }


    public void print_statement(){
        System.out.println("this is for ios from pom");
    }

}
