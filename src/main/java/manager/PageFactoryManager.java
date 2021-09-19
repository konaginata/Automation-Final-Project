package manager;

import org.openqa.selenium.WebDriver;
import pages.*;

public class PageFactoryManager {
    WebDriver driver;

    public PageFactoryManager(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage getHomePage() {
        return new HomePage(driver);
    }

    public SearchResultsPage getSearchResultsPage() {
        return new SearchResultsPage(driver);
    }

    public ItemPage getItemPage() {
        return new ItemPage(driver);
    }

    public DealsPage getDealsPage() {
        return new DealsPage(driver);
    }

    public LoginPage getLoginPage() {
        return new LoginPage(driver);
    }

    public CartPage getCartPage() {
        return new CartPage(driver);
    }
}
