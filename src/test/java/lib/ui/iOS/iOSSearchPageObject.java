package lib.ui.iOS;

import io.appium.java_client.AppiumDriver;
import lib.ui.SearchPageObject;

public class iOSSearchPageObject extends SearchPageObject
{
    static {
        SEARCH_SKIP_LINK = "xpath://XCUIElementTypeButton[@name='Skip']";
        SEARCH_INIT_ELEMENT = "id:Search Wikipedia";
        SEARCH_INPUT = "id:Search Wikipedia";
        SEARCH_CANCEL_BUTTON = "xpath://XCUIElementTypeStaticText[@name='Cancel']";
        SEARCH_RESULT_BY_SUBSTRING_TPL = "xpath://XCUIElementTypeStaticText[contains(@name,'{SUBSTRING}')]";
        SEARCH_RESULT_ELEMENT = "xpath:XCUIElementTypeStaticText";
        SEARCH_EMPTY_RESULT_ELEMENT = "id:No results found";
    }

    public iOSSearchPageObject(AppiumDriver driver)
    {
        super(driver);
    }
}
