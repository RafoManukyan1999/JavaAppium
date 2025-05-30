package lib.ui.factories;

import io.appium.java_client.AppiumDriver;
import lib.Platform;
import lib.ui.Android.AndroidArticlePageObject;
import lib.ui.Android.AndroidMyListsPageObject;
import lib.ui.ArticlePageObject;
import lib.ui.MyListsPageObject;
import lib.ui.iOS.iOSArticlePageObject;
import lib.ui.iOS.iOSMyListsPageObject;

public class MyListsPageObjectFactory
{
    public static MyListsPageObject get(AppiumDriver driver)
    {
        if(Platform.getInstance().isAndroid()) {
            return new AndroidMyListsPageObject(driver);
        } else {
            return new iOSMyListsPageObject(driver);
        }
    }
}
