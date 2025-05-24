package lib.ui.iOS;

import io.appium.java_client.AppiumDriver;
import lib.ui.NavigationUI;

public class iOSNavigationUI extends NavigationUI
{
    static {
        OPTIONS_ViEW_LIST_BUTTON = "id:tabbar-save";
    }

    public iOSNavigationUI(AppiumDriver driver) {
        super(driver);
    }
}
