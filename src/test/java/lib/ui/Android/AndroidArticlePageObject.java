package lib.ui.Android;

import io.appium.java_client.AppiumDriver;
import lib.ui.ArticlePageObject;

public class AndroidArticlePageObject extends ArticlePageObject
{
    static {
        TITLE = "xpath://android.widget.TextView[@text=\"Java (programming language)\"]";
        FOOTER_ELEMENT = "xpath://android.widget.TextView[@text=\"View article in browser\"]";
        SAVED_BUTTON = "id:org.wikipedia:id/page_save";
        OPTIONS_SNACKBAR_TEXT = "xpath://android.widget.TextView[@resource-id=\"org.wikipedia:id/snackbar_text\"]";
        OPTIONS_ADD_TO_MY_LIST_BUTTON = "xpath://android.widget.Button[@resource-id=\"org.wikipedia:id/snackbar_action\"]";
//        OPTIONS_CREATE_NEW_BUTTON = "id:org.wikipedia:id/create_button";
        MY_LIST_NAME_INPUT = "xpath://android.widget.EditText[@resource-id=\"org.wikipedia:id/text_input\"]";
        ADD_TO_MY_LIST_OK_BUTTON = "xpath://android.widget.Button[@resource-id=\"android:id/button1\"]";
    }

    public AndroidArticlePageObject(AppiumDriver driver)
    {
        super(driver);
    }
}