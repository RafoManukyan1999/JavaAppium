package lib.ui.iOS;

import io.appium.java_client.AppiumDriver;
import lib.ui.MyListsPageObject;

public class iOSMyListsPageObject extends MyListsPageObject
{
    static {
        ARTICLE_BY_TITLE_TPL = "xpath://XCUIElementTypeStaticText[@name='{TITLE}']";
        CLOSE_SYNC_AND_YOUR_SAVED_ARTICLE = "id:Close";
    }

    public iOSMyListsPageObject(AppiumDriver driver) {
        super(driver);
    }
}