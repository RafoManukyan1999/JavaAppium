package tests;

import io.qameta.allure.*;
import lib.CoreTestCase;
import lib.ui.ArticlePageObject;
import lib.ui.SearchPageObject;
import lib.ui.factories.ArticlePageObjectFactory;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Epic("Tests for articles")
public class ArticleTests extends CoreTestCase
{
    @Test
    @Features(value = {@Feature(value="Search"),@Feature(value="Article")})
    @DisplayName("Compare article title with expected title")
    @Description("This test searches for an article about Java, opens it, and compares the title with the expected title.")
    @Step("1. Start the test by searching for an article about Java")
    @Severity(value = SeverityLevel.BLOCKER)
    public void testCompareArticleTitle() {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.clickSkipButton();
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("Object-oriented programming language");

        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
        String article_Title = ArticlePageObject.getArticleTitle();

        //ArticlePageObject.takeScreenshot("article_title");

        assertEquals(
                "Java (programming language)",
                article_Title,
                "We see unexpected title"
        );
    }

    @Test
    @Features(value = {@Feature(value="Search"),@Feature(value="Article")})
    @DisplayName("Swipe article to footer")
    @Description("This test searches for an article about Java, opens it, and swipes it to the footer.")
    @Step("2. Start test by swiping the article to the footer")
    @Severity(value = SeverityLevel.MINOR)
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