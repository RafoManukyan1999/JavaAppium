package lib.ui;

import io.appium.java_client.AppiumDriver;

abstract public class NavigationUI extends MainPageObject{

    protected static String
            OPTIONS_ViEW_LIST_BUTTON;

    public NavigationUI(AppiumDriver driver)
    {
        super(driver);
    }

    public void clickViewArticle()
    {
        waitForElementAndClick(
                OPTIONS_ViEW_LIST_BUTTON,
                "Cannot find 'View list' button on the pop-up",
                15
        );
    }
}
