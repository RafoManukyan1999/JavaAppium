package lib.ui.Android;

import io.appium.java_client.AppiumDriver;
import lib.ui.NavigationUI;

public class AndroidNavigationUI extends NavigationUI
{
    static {
        OPTIONS_ViEW_LIST_BUTTON = "xpath://android.widget.Button[@resource-id='org.wikipedia:id/snackbar_action']";
    }

    public AndroidNavigationUI(AppiumDriver driver) {
        super(driver);
    }
}