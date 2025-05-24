package lib.ui.Android;

import io.appium.java_client.AppiumDriver;
import lib.ui.SearchPageObject;

public class AndroidSearchPageObject extends SearchPageObject
{
    static {
        SEARCH_SKIP_LINK = "xpath://android.widget.Button[@resource-id='org.wikipedia:id/fragment_onboarding_skip_button']";
        SEARCH_INIT_ELEMENT = "id:org.wikipedia:id/search_container";
        SEARCH_INPUT = "xpath://*[contains(@text,'Search Wikipedia')]";
        SEARCH_CANCEL_BUTTON = "id:org.wikipedia:id/search_close_btn";
        SEARCH_RESULT_BY_SUBSTRING_TPL = "xpath://android.widget.TextView[@resource-id='org.wikipedia:id/page_list_item_description' and @text='{SUBSTRING}']";
        SEARCH_RESULT_ELEMENT = "xpath://androidx.recyclerview.widget.RecyclerView[@resource-id='org.wikipedia:id/search_results_list']/android.view.ViewGroup";
        SEARCH_EMPTY_RESULT_ELEMENT = "id:org.wikipedia:id/results_text";
    }

    public AndroidSearchPageObject(AppiumDriver driver)
    {
        super(driver);
    }
}
