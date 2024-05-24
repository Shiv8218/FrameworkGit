package Tests.TestUtils;

import io.appium.java_client.Setting;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.pageObjects.iOS.WdHomePageIOS;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.utils.AppiumUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

public class iosBaseTest extends AppiumUtils {

    public static IOSDriver driver;
    public static WdHomePageIOS homePage;

    @BeforeTest
    public void setup() throws IOException {

        Properties props = new Properties();

        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+ "src//main//resources//data.properties");
        props.load(fis);
        String ipAddress = props.getProperty("ipAddress");
        String port = props.getProperty("port");

        service = startAppiumServer(props.getProperty("ipAddress"),Integer.parseInt(port));

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName", "iOS");
        capabilities.setCapability("platformVersion", "17.4");
        capabilities.setCapability("deviceName", "iPhone 15 Pro Max");
        capabilities.setCapability("automationName", "XCUITest");
        capabilities.setCapability("app", System.getProperty("user.dir")+ "src//test//resources//app//wdiodemos.zip");
        capabilities.setCapability("newCommandTimeout", 60);
        capabilities.setCapability("showXcodeLog", true);
        capabilities.setCapability("useNewWDA", true); // This capability ensures a new WDA session is used

//        URL url = new URL("http://localhost:4723"); // Ensure the Appium server URL is correct

        driver = new IOSDriver(service.getUrl(), capabilities);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.setSetting(Setting.IGNORE_UNIMPORTANT_VIEWS, true);
        homePage = new WdHomePageIOS(driver);
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
