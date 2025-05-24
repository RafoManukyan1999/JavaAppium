package lib;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;

public class IOSTestCase {

    protected AppiumDriver driver;

    @BeforeEach
    protected void setUp() throws Exception
    {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "iOS");
        caps.setCapability("deviceName", "iPhone 16 Plus");
        caps.setCapability("platformVersion", "18.4");
        caps.setCapability("automationName", "XCUITest");
        caps.setCapability("app", "/Users/rafomanukyan/Desktop/JavaAppiumAutomation/apks/Wikipedia.app");

        driver = new IOSDriver(new URL("http://127.0.0.1:4723"), caps);
    }

    @AfterEach
    protected void tearDown() throws Exception {
        driver.quit();
    }
}