package lib;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;

public class Platform {
    private static final String PLATFORM_ANDROID = "android";
    private static final String PLATFORM_IOS = "ios";
    private static final String APPIUM_URL = "http://127.0.0.1:4723";
    private static final String ANDROID_APP_PATH_WINDOWS = "C:\\Users\\User\\Desktop\\JavaAppiumAutomation\\apks\\org.wikipedia.apk";
    private static final String ANDROID_APP_PATH_MAC = "/Users/rafomanukyan/Desktop/org.wikipedia.apk";

    private static Platform instance;

    private Platform() {}

    public static Platform getInstance()
    {
        if (instance == null) {
            instance = new Platform();
        }
        return instance;
    }

    public AppiumDriver getDriver() throws Exception
    {
        URL URL = new URL(APPIUM_URL);
        if (isAndroid()) {
            return new AndroidDriver(URL, getCapabilitiesForAndroid());
        } else if (isIOS()) {
            return new IOSDriver(URL, getCapabilitiesForIOS());
        } else {
            throw new Exception("Cannot determine platform: " + getPlatformName());
        }
    }

    public boolean isAndroid()
    {
        return isPlatform(PLATFORM_ANDROID);
    }

    public boolean isIOS()
    {
        return isPlatform(PLATFORM_IOS);
    }


    private DesiredCapabilities getCapabilitiesForAndroid() {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("deviceName", "and12");
        caps.setCapability("udid", "emulator-5554");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("appPackage", "org.wikipedia");
        caps.setCapability("appActivity", "org.wikipedia.main.MainActivity");
        caps.setCapability("app", getAndroidAppPath());
        caps.setCapability("noReset", false);
//        caps.setCapability("avd", "and12");
        return caps;
    }

    private DesiredCapabilities getCapabilitiesForIOS() {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "iOS");
        caps.setCapability("deviceName", "iPhone 16 Plus");
        caps.setCapability("platformVersion", "18.4");
        caps.setCapability("automationName", "XCUITest");
        caps.setCapability("app", "/Users/rafomanukyan/Library/Developer/Xcode/DerivedData/Wikipedia-axsfdzypoxxmnjetjqmncfckgtay/Build/Products/Debug-iphonesimulator/Wikipedia.app");
        return caps;
    }

    private boolean isPlatform(String my_platform)
    {
        String platform = getPlatformName();
        return my_platform.equals(platform);

    }
    private String getPlatformName()
    {
        return System.getenv("PLATFORM");
    }

    private String getAndroidAppPath() {
        if (isWindows()) {
            return ANDROID_APP_PATH_WINDOWS;
        }
        return ANDROID_APP_PATH_MAC;
    }

    private boolean isWindows() {
        return System.getProperty("os.name").toLowerCase().contains("win");
    }
}