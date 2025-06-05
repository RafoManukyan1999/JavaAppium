package lib;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

public class CoreTestCase {

    protected AppiumDriver driver;

    @BeforeEach
    @Step("Run driver and session")
    public void setUp() throws Exception
    {
        driver = Platform.getInstance().getDriver();
        createAllurePropertyFile();
        rotateScreenPortrait();
    }

    @AfterEach
    @Step("Close driver and session")
    public void tearDown()
    {
        driver.quit();
    }

    @Step("Rotate screen to portrait orientation")
    protected void rotateScreenPortrait() {
        if (isLandscapeOrientation()) {
            System.out.println("Please rotate device to portrait orientation");
            sleep(3);
        }
    }

    @Step("Rotate screen to landscape orientation")
    protected void rotateScreenLandscape() {
        if (!isLandscapeOrientation()) {
            System.out.println("Please rotate device to landscape orientation");
            sleep(3);
        }
    }

    @Step("Check if the device is in landscape orientation")
    protected boolean isLandscapeOrientation() {
        return driver.manage().window().getSize().getWidth() >
               driver.manage().window().getSize().getHeight();
    }

    @Step("Check if the device is in portrait orientation")
    protected void backgroundApp(int seconds) {
        driver.executeScript("mobile: backgroundApp", Map.of("seconds", seconds));
    }

    @Step("Background the app for 2 seconds")
    protected void backgroundApp() {
        backgroundApp(2);
    }

    @Step("Sleep for a specified number of seconds")
    private void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static boolean environmentFileCreated = false;

    @Step("Create Allure environment properties file")
    private void createAllurePropertyFile() {
        if (environmentFileCreated) {
            return;
        }
        
        String path = System.getProperty("allure.results.directory");
        if (path == null || path.isEmpty()) {
            path = "target/allure-results";
        }
        
        try {
            File directory = new File(path);
            directory.mkdirs();
        
            File envFile = new File(directory, "environment.properties");
        
            Properties props = new Properties();
            props.setProperty("Platform", Platform.getInstance().getPlatformName());

            try (FileOutputStream fos = new FileOutputStream(envFile)) {
                props.store(fos, "Allure environment properties");
            }
        
            environmentFileCreated = true;
            System.out.println("Environment properties created");
        
        } catch (IOException e) {
            System.out.println("Error creating environment.properties file: " + e.getMessage());
        }
    }
}