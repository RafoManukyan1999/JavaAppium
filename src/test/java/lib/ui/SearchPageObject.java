package lib.ui;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;

abstract public class SearchPageObject extends MainPageObject {

     protected static String
            SEARCH_SKIP_LINK,
            SEARCH_INIT_ELEMENT,
            SEARCH_INPUT,
            SEARCH_CANCEL_BUTTON,
            SEARCH_RESULT_BY_SUBSTRING_TPL,
            SEARCH_RESULT_ELEMENT,
            SEARCH_EMPTY_RESULT_ELEMENT;

    public SearchPageObject(AppiumDriver driver) {
        super(driver);
    }

    private String getResultSearchElement(String substring) {
        return SEARCH_RESULT_BY_SUBSTRING_TPL.replace("{SUBSTRING}", substring);
    }

    @Step("Clicking skip button")
    public void clickSkipButton() {
        waitForElementAndClick(
                SEARCH_SKIP_LINK,
                "Cannot find and click skip button",
                10
        );
    }

    @Step("Initializing search input")
    public void initSearchInput() {
        waitForElementAndClick(
                SEARCH_INIT_ELEMENT,
                "Cannot find and click search init element",
                5
        );
        waitForElementPresent(
                SEARCH_INIT_ELEMENT,
                "Cannot find search init element after clicking",
                5
        );
    }

    @Step("Waiting for cancel button to appear")
    public void waitForCancelButtonToAppear() {
        waitForElementPresent(
                SEARCH_CANCEL_BUTTON,
                "Cannot find search cancel button",
                5
        );
    }

    @Step("Waiting for cancel button to disappear")
    public void waitForCancelButtonToDisappear() {
        waitForElementNotPresent(
                SEARCH_CANCEL_BUTTON,
                "Search cancel button is still present!",
                5
        );
    }

    @Step("Clicking cancel search button")
    public void clickCancelSearch() {
        waitForElementAndClick(
                SEARCH_CANCEL_BUTTON,
                "Cannot find and click search cancel button",
                5
        );
    }

    @Step("Typing '{search_line}' into search input")
    public void typeSearchLine(String search_line) {
        waitForElementAndSendKeys(
                SEARCH_INPUT,
                search_line, 
                "Cannot find and type into search input",
                5
        );
    }

    @Step("Waiting for search result with substring")
    public void waitForSearchResult(String substring) {
        String search_result_xpath = getResultSearchElement(substring);
        waitForElementPresent(
                search_result_xpath,
                "Cannot find search result with substring " + substring,
                15
        );
    }

    @Step("Clicking on article with substring")
    public void clickByArticleWithSubstring(String substring) {
        String search_result_xpath = getResultSearchElement(substring);
        waitForElementAndClick(
                search_result_xpath,
                "Cannot find and click search result with substring " + substring,
                15
        );
    }

    @Step("Getting amount of found articles")
    public int getAmountOfFoundArticles() {
        waitForElementPresent(
                SEARCH_RESULT_ELEMENT,
                "Cannot find results searching by",
                15
        );
        return getAmountOfElements(
                SEARCH_RESULT_ELEMENT
        );
    }

    @Step("Waiting for empty results label")
    public void waitForEmptyResultsLabel() {
        waitForElementPresent(
                SEARCH_EMPTY_RESULT_ELEMENT,
                "Cannot find empty result element",
                15
        );
    }

    @Step("Asserting there is no result of search")
    public void assertThereIsNoResultOfSearch() {
        assertElementNotPresent(
                SEARCH_RESULT_ELEMENT,
                "We supposed not to find any results"
        );
    }
}