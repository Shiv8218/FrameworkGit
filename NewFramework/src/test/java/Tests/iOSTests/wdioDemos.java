package Tests.iOSTests;

import Tests.TestUtils.iosBaseTest;
import org.testng.annotations.Test;

public class wdioDemos extends iosBaseTest {

    @Test
    public void wdflow() throws InterruptedException {

        System.out.println("this is ios");
        homePage.print_statement();

    }
}