package lib.ui;

import io.appium.java_client.AppiumDriver;
import lib.Platform;
import org.openqa.selenium.WebElement;

abstract public class ArticlePageObject extends MainPageObject
{
    protected static String
            TITLE,
            FOOTER_ELEMENT,
            SAVED_BUTTON,
            OPTIONS_SNACKBAR_TEXT,
            OPTIONS_ADD_TO_MY_LIST_BUTTON,
//            OPTIONS_CREATE_NEW_BUTTON,
            CLOSE_ARTICLE_BUTTON,
            MY_LIST_NAME_INPUT,
            ADD_TO_MY_LIST_OK_BUTTON;


    public ArticlePageObject(AppiumDriver driver)
    {
        super(driver);
    }

    public WebElement waitForTitleElement(String s)
    {
        return waitForElementPresent(
                TITLE,
                "Cannot find article title on page!",
                10
        );
    }

    public String getArticleTitle() {
        WebElement titleElement = waitForTitleElement("Java (programming language)");
        if (Platform.getInstance().isAndroid()) {
            return titleElement.getText();
        } else {
            return titleElement.getAttribute("name");
        }
    }

    public void swipeToFooter()
    {
        swipeUpToFindElement(
                FOOTER_ELEMENT,
                "Cannot find the end of article",
                40
        );
    }

    public void addArticleToMyList(String name_of_folder)
    {
        waitForElementAndClick(
                SAVED_BUTTON,
                "Cannot find 'Save' Button",
                10
        );

        waitForElementPresent(
                OPTIONS_SNACKBAR_TEXT,
                "Cannot find text 'Saved Java (programming language). Do you want to add it to a list?' on Snackbar",
                15
        );

        waitForElementAndClick(
                OPTIONS_ADD_TO_MY_LIST_BUTTON,
                "Cannot find 'Add to list' Button",
                10
        );

//        waitForElementAndClick(
//                OPTIONS_CREATE_NEW_BUTTON,
//                "Cannot find 'Create new' Button",
//                10
//        );

        waitForElementAndSendKeys(
                MY_LIST_NAME_INPUT,
                name_of_folder,
                "Cannot find text input",
                15
        );

        waitForElementAndClick(
                ADD_TO_MY_LIST_OK_BUTTON,
                "Cannot find 'OK' Button",
                15
        );

        waitForElementPresent(
                OPTIONS_SNACKBAR_TEXT,
                "Cannot find text 'Moved Java (programming language) to '" + name_of_folder + " on the pop-up",
                15
        );
    }

    public void addArticlesToMySaved()
    {
        waitForElementAndClick(
                OPTIONS_ADD_TO_MY_LIST_BUTTON,
                "Cannot find 'Add to list' Button",
                10
        );
    }

    public void closeArticle()
    {
        waitForElementAndClick(
                CLOSE_ARTICLE_BUTTON,
                "Cannot find 'Close' Button",
                10
        );
    }
}