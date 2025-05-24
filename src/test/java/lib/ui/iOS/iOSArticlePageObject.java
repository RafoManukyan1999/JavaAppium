package lib.ui.iOS;

import io.appium.java_client.AppiumDriver;
import lib.ui.ArticlePageObject;

public class iOSArticlePageObject extends ArticlePageObject
{
    static {
        TITLE = "xpath://XCUIElementTypeStaticText[@name='Java (programming language)']";
        FOOTER_ELEMENT = "xpath://XCUIElementTypeStaticText[@name='View article in browser']";
        OPTIONS_ADD_TO_MY_LIST_BUTTON = "id:Save for later";
        CLOSE_ARTICLE_BUTTON = "id:Explore";
    }

    public iOSArticlePageObject(AppiumDriver driver)
    {
        super(driver);
    }
}