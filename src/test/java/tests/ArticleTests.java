package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import lib.CoreTestCase;
import lib.ui.ArticlePageObject;
import lib.ui.SearchPageObject;
import lib.ui.factories.ArticlePageObjectFactory;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArticleTests extends CoreTestCase
{

    @Test
    @DisplayName("Compare article title with expected title")
    @Description("This test searches for an article about Java, opens it, and compares the title with the expected title.")
    @Step("1. Start the test by searching for an article about Java")
    public void testCompareArticleTitle() {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.clickSkipButton();
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("Object-oriented programming language");

        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
        String article_Title = ArticlePageObject.getArticleTitle();

        assertEquals(
                "Java (programming language)",
                article_Title,
                "We see unexpected title"
        );
    }

    @Test
    @DisplayName("Swipe article to footer")
    @Description("This test searches for an article about Java, opens it, and swipes it to the footer.")
    @Step("2. Start test by swiping the article to the footer")
    public void testSwipeArticle() {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.clickSkipButton();
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("Object-oriented programming language");

        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
        ArticlePageObject.waitForTitleElement("Java (programming language)");
        ArticlePageObject.swipeToFooter();
    }
}