package lib;

import io.appium.java_client.AppiumDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import java.util.Map;

public class CoreTestCase {

    protected AppiumDriver driver;

    @BeforeEach
    public void setUp() throws Exception
    {
        driver = Platform.getInstance().getDriver();
        rotateScreenPortrait();
    }

    @AfterEach
    public void tearDown() throws Exception {
        driver.quit();
    }

    protected void rotateScreenPortrait() {
        if (isLandscapeOrientation()) {
            System.out.println("Please rotate device to portrait orientation");
            sleep(3);
        }
    }

    protected void rotateScreenLandscape() {
        if (!isLandscapeOrientation()) {
            System.out.println("Please rotate device to landscape orientation");
            sleep(3);
        }
    }

    protected boolean isLandscapeOrientation() {
        return driver.manage().window().getSize().getWidth() >
               driver.manage().window().getSize().getHeight();
    }

    protected void backgroundApp(int seconds) {
        driver.executeScript("mobile: backgroundApp", Map.of("seconds", seconds));
    }

    protected void backgroundApp() {
        backgroundApp(2);
    }

    private void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

//    private void skipWelcomePageForIOSApp()
//    {
//        if(Platform.getInstance().isIOS()) {
//            WelcomePageObject WelcomePageObject = new WelcomePageObject(driver);
//            WelcomePageObject.clickSkip();
//        }
//    }
}