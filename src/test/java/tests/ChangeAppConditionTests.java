package tests;

import lib.CoreTestCase;
import lib.ui.ArticlePageObject;
import lib.ui.SearchPageObject;
import lib.ui.factories.ArticlePageObjectFactory;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChangeAppConditionTests extends CoreTestCase
{
    @Test
    public void testChangeScreenOrientationOnSearchResults()
    {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.clickSkipButton();
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("Java (programming language)");

        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
        String title_before_rotation = ArticlePageObject.getArticleTitle();
        rotateScreenLandscape();
        String title_after_rotation = ArticlePageObject.getArticleTitle();

        assertEquals(
                title_before_rotation,
                title_after_rotation,
                "Article title has been changed after screen rotation"
        );

        rotateScreenPortrait();
        String titleAfterSecondRotation = ArticlePageObject.getArticleTitle();

        assertEquals(
                title_before_rotation,
                titleAfterSecondRotation,
                "Article title has been changed after screen rotation"
        );
    }

    @Test
    public void testCheckSearchArticleInBackground()
    {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);

        SearchPageObject.clickSkipButton();
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.waitForSearchResult("Java (programming language)");
        this.backgroundApp();
        SearchPageObject.waitForSearchResult("Java (programming language)");
    }
}