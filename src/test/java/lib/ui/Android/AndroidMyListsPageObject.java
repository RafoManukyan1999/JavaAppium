package lib.ui.Android;

import io.appium.java_client.AppiumDriver;
import lib.ui.MyListsPageObject;

public class AndroidMyListsPageObject extends MyListsPageObject
{
    static {
        ARTICLE_BY_TITLE_TPL = "xpath://*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='{TITLE}']";
        GOT_IT_BUTTON = "id:org.wikipedia:id/buttonView";
    }

    public AndroidMyListsPageObject(AppiumDriver driver) {
        super(driver);
    }
}
