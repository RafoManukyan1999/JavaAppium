package lib.ui;

import io.appium.java_client.AppiumDriver;
import lib.Platform;

abstract public class MyListsPageObject extends MainPageObject {

    protected static String
            GOT_IT_BUTTON,
            ARTICLE_BY_TITLE_TPL,
            CLOSE_SYNC_AND_YOUR_SAVED_ARTICLE;

    private static String getSavedArticleXpathByTitle(String article_title)
    {
        return ARTICLE_BY_TITLE_TPL.replace("{TITLE}", article_title);
    }

    public MyListsPageObject(AppiumDriver driver)
    {
        super(driver);
    }

    public void vewArticlePage()
    {
        if (Platform.getInstance().isIOS()) {
            waitForElementAndClick(
                    CLOSE_SYNC_AND_YOUR_SAVED_ARTICLE,
                    "Cannot find 'X' Button",
                    15
            );
        } else {
            waitForElementAndClick(
                    GOT_IT_BUTTON,
                    "Cannot find 'Got it' Button",
                    15
            );
        }
    }

    public void waitForArticleToAppearByTitle(String article_title)
    {
        String article_xpath = getSavedArticleXpathByTitle(article_title);
        waitForElementPresent(
                article_xpath,
                "Cannot find saved article by title " + article_title + "'",
                15
        );
    }

    public void swipeArticleToDelete(String article_title)
    {
        waitForArticleToAppearByTitle(article_title);
        String article_xpath = getSavedArticleXpathByTitle(article_title);
        swipeElementToLeft(
                article_xpath,
                "Cannot find" + article_title + " in the Saved list"
        );
        waitForArticleToDisappearByTitle(article_title);
    }

    public void waitForArticleToDisappearByTitle(String article_title)
    {
        String article_xpath = getSavedArticleXpathByTitle(article_title);
        waitForElementNotPresent(
                article_xpath,
                "Article is still present with title '" + article_title + "'",
                15
        );
    }
}