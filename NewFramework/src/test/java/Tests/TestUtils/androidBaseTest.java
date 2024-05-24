package Tests.TestUtils;

import io.appium.java_client.Setting;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.pageObjects.android.WdHomePageAndroid;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.utils.AppiumUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

public class androidBaseTest extends AppiumUtils {

    public static AndroidDriver driver;
    public static WdHomePageAndroid wdHomePageAndroid;

    @BeforeTest(alwaysRun = true)
    public void setup() throws IOException {

        Properties props = new Properties();

//        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+ "src//main//resources//data.properties");
        FileInputStream fis = new FileInputStream("src//main//resources//data.properties");
        props.load(fis);
        String ipAddress = props.getProperty("ipAddress");
        String port = props.getProperty("port");

        service = startAppiumServer(props.getProperty("ipAddress"),Integer.parseInt(port));

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("platformVersion","14");
        capabilities.setCapability("deviceName","emulator-5554");
        capabilities.setCapability("automationName","uiautomator2");
        capabilities.setCapability("app",System.getProperty("user.dir")+"//src//test//resources//app//wdiodemos.apk");

        capabilities.setCapability("appium:newCommandTimeout", 60);

//        URL url = new URL("http://127.0.0.1:4723");

        driver = new AndroidDriver(service.getUrl(), capabilities);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.setSetting(Setting.IGNORE_UNIMPORTANT_VIEWS, true);

        wdHomePageAndroid = new WdHomePageAndroid(driver);

    }

    @AfterTest(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
