package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import manager.PageFactoryManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DefinitionSteps {
    private static final long DEFAULT_TIMEOUT = 60;
    WebDriver driver;
    HomePage homePage;
    SearchResultsPage searchResultsPage;
    ItemPage itemPage;
    DealsPage dealsPage;
    LoginPage loginPage;
    CartPage cartPage;
    PageFactoryManager pageFactoryManager;

    @Before
    public void testsSetUp() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pageFactoryManager = new PageFactoryManager(driver);
    }

    @And("User opens {string} page")
    public void openPage(final String url) {
        homePage = pageFactoryManager.getHomePage();
        homePage.openHomePage(url);
    }

    @And("User checks login button visibility")
    public void userChecksLoginButtonVisibility() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        assertTrue(homePage.isLoginButtonVisible());
    }

    @And("User clicks login button")
    public void userClicksLoginButton() {
        homePage.clickLoginButton();
    }

    @And("User checks id field visibility")
    public void userChecksIdFieldVisibility() {
        loginPage = pageFactoryManager.getLoginPage();
        assertTrue(loginPage.isIdFieldVisible());
    }

    @And("User enters valid {string} to id field")
    public void userEntersValidId(final String id) {
        loginPage.sendKeysToIdField(id);
    }

    @And("User clicks continue button")
    public void userClicksContinueButton() {
        loginPage.clickContinueButton();
    }

    @And("User checks password field visibility")
    public void userChecksPasswordFieldVisibility() {
        assertTrue(loginPage.isPasswordIdFieldVisible());
    }

    @And("User enters valid {string} to password field")
    public void userEntersValidPasswordToPasswordField(final String password) {
        loginPage.sendKeysToPasswordField(password);
    }

    @When("User clicks submit button")
    public void userClicksSubmitButton() {
        loginPage.clickSubmitButton();
    }

    @And("User checks {string} is opened")
    public void userChecksHomePageIsOpened(final String url) {
        homePage = pageFactoryManager.getHomePage();
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        assertTrue(homePage.getUrl().contains(url));
    }

    @And("User clicks logout link")
    public void userClicksLogoutLink() {
        homePage.moveToLoginLink();
        loginPage.moveToLogoutLink();
        loginPage.clickLogoutLink();
    }

    @Then("User checks login page is opened after the logout")
    public void userChecksLoginPageIsOpenedAfterTheLogout() {
        assertEquals("Sign-In", loginPage.getSignInPageHeaderText());
    }

    @And("User checks search field visibility")
    public void userChecksSearchFieldVisibility() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        assertTrue(homePage.isSearchFieldVisible());
    }

    @When("User makes search by {string}")
    public void userMakesSearchByKeywordKeyword(final String keyword) {
        homePage.sendKeysToSearchField(keyword);
    }

    @And("User clicks search button")
    public void userClicksSearchButton() {
        homePage.clickSearchButton();
    }

    @Then("User checks that item name contains {string}")
    public void userChecksThatItemNameContainsKeyword(final String keyword) {
        itemPage = pageFactoryManager.getItemPage();
        itemPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        itemPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, itemPage.getItemTitle());
        assertTrue(itemPage.getItemTitle().getText().toLowerCase().contains(keyword));
    }

    @And("User checks Alienware checkbox visibility")
    public void userChecksAlienwareCheckboxVisibility() {
        searchResultsPage = pageFactoryManager.getSearchResultsPage();
        searchResultsPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        assertTrue(searchResultsPage.isAlienwareCheckBoxVisible());
    }

    @And("User clicks Alienware checkbox")
    public void userClicksAlienwareCheckbox() {
        searchResultsPage.clickAlienwareCheckBox();
    }

    @And("User checks search results visibility")
    public void userChecksSearchResultsVisibility() {
        searchResultsPage = pageFactoryManager.getSearchResultsPage();
        searchResultsPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        assertTrue(searchResultsPage.areSearchResultsVisible());
    }

    @Then("User checks each result contains {string}")
    public void userChecksEachResultContainsKeyword(final String keyword) {
        for (WebElement we : searchResultsPage.getSearchResults()) {
            assertTrue(we.getText().contains(keyword));
        }
    }

    @And("User checks for deals button visibility")
    public void userChecksForDealsButtonVisibility() {
        assertTrue(homePage.isDealsButtonVisible());
    }

    @And("User clicks deals button")
    public void userClicksDealsButton() {
        homePage.clickDealsButton();
    }

    @And("User checks books filter visibility")
    public void userChecksBooksFilterVisibility() {
        dealsPage = pageFactoryManager.getDealsPage();
        assertTrue(dealsPage.isBookSelectorVisible());
    }

    @And("User clicks on books filter")
    public void userClicksOnBooksFilter() {
        dealsPage.clickBookSelector();
    }

    @And("User clicks add to cart on the first result")
    public void userClicksAddToCartOnTheFirstResult() {
        dealsPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, dealsPage.getAddToCartButton());
        dealsPage.clickAddToCartButton();
    }

    @And("User checks add to cart button visibility")
    public void userChecksAddToCartButtonVisibility() {
        itemPage = pageFactoryManager.getItemPage();
        itemPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, itemPage.getAddToCartButton());
        assertTrue(itemPage.isAddToCartButtonVisible());
    }

    @And("User clicks add to cart button")
    public void userClicksAddToCartButton() {
        itemPage.clickAddToCartButton();
    }

    @And("User checks cart widget visibility")
    public void userChecksCartWidgetVisibility() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        cartPage = pageFactoryManager.getCartPage();
        cartPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, cartPage.getCartWidget());
        assertTrue(cartPage.isCartWidgetVisible());
    }

    @Then("User checks price calculation for two items")
    public void userChecksPriceCalculationForTwoItems() {
        assertEquals(cartPage.getOneItemPrice() * 2, cartPage.getTotalItemsPrice(), 0.0);
    }

    @And("User navigates to previous page")
    public void userNavigatesToPreviousPage() {
        driver.navigate().back();
    }

    @And("User checks price limiter visibility")
    public void userChecksPriceLimiterVisibility() {
        searchResultsPage = pageFactoryManager.getSearchResultsPage();
        searchResultsPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        assertTrue(searchResultsPage.isPriceLimiter25UsdVisible());
    }

    @And("User clicks on price limiter")
    public void userClicksOnPriceLimiter() {
        searchResultsPage.clickPriceLimiter25USD();
    }

    @Then("User checks prices of all search results do not exceed {string}")
    public void userChecksPricesOfAllSearchResultsDoNotExceedLimit(final String limit) {
        for (Double d : searchResultsPage.getAllPrices()) {
            assertTrue(d <= Double.parseDouble(limit));
        }
    }

    @And("User checks delivery settings button visibility")
    public void userChecksDeliverySettingsButtonVisibility() {
        assertTrue(homePage.isDeliverySettingsButtonVisible());
    }

    @And("User clicks delivery settings button")
    public void userClicksDeliverySettingsButton() {
        homePage.clickDeliverySettingsButton();
    }

    @And("User checks that location setting popup visibility")
    public void userChecksThatLocationSettingPopupVisibility() {
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, homePage.getLocationSettingsPopupHeader());
        assertTrue(homePage.isLocationSettingsPopupHeaderVisible());
    }

    @And("User checks the header to contain {string}")
    public void userChecksTheHeaderToContainText(final String text) {
        assertTrue(homePage.getLocationSettingsPopupHeader().getText().contains(text));
    }

    @And("User checks zipCode field visibility")
    public void userChecksZipCodeFieldVisibility() {
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, homePage.getZipCodeField());
        assertTrue(homePage.isZipCodeFieldVisible());
    }

    @When("User enters invalid {string}")
    public void userEntersInvalidText(final String code) {
        homePage.sendKeysToZipCodeField(code);
    }

    @And("User checks apply zipCode button visibility")
    public void userChecksApplyZipCodeButtonVisibility() {
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, homePage.getApplyZipCodeButton());
        assertTrue(homePage.isApplyZipCodeButtonVisible());
    }

    @And("User clicks apply button")
    public void userClicksApplyButton() {
        homePage.clickApplyZipCodeButton();
    }

    @Then("User checks {string} is shown")
    public void userChecksMessageIsShown(final String message) {
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, homePage.getZipCodeError());
        assertEquals(message, homePage.getZipCodeErrorText());
    }

    @And("User checks Oculus button visibility")
    public void userChecksOculusButtonVisibility() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, homePage.getOculusCatalog());
        assertTrue(homePage.isOculusCatalogVisible());
    }

    @When("User clicks Oculus button")
    public void userClicksOculusButton() {
        homePage.clickOculusCatalog();
    }

    @Then("User checks page url to contain{string}")
    public void userChecksPageUrlToContainUrlText(final String urlText) {
        itemPage = pageFactoryManager.getItemPage();
        itemPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        assertTrue(itemPage.getUrl().contains(urlText));
    }

    @And("User clicks on the first matching visible result")
    public void userClicksFirstMatchingSearchResult() {
        searchResultsPage = pageFactoryManager.getSearchResultsPage();
        searchResultsPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        searchResultsPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, searchResultsPage.getFirstSearchResultPicture());
        if (searchResultsPage.isFirstSearchResultVisible()) {
            searchResultsPage.clickFirstSearchResult();
        } else {
            searchResultsPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, searchResultsPage.getSecondSearchResultPicture());
            searchResultsPage.clickSecondSearchResult();
        }
    }

    @And("User checks parameter switcher visibility")
    public void userChecksParameterSwitcherVisibility() {
        assertTrue(itemPage.isGb256SwitcherVisible());
    }

    @When("User clicks parameter switcher")
    public void userClicksParameterSwitcher() {
        itemPage.clickGb256Switcher();
    }

    @Then("User checks the {string} is updated")
    public void userChecksTheParameterIsUpdated(final String parameter) {
        assertEquals(itemPage.getCapacityValue(), parameter);
    }

    @And("User clicks cart widget")
    public void userClicksCartWidget() {
        cartPage.clickCartWidget();
    }

    @Then("User checks items quantity in cart")
    public void userChecksItemsQuantityInCart() {
        assertEquals(1, cartPage.getCountOfItemsInCart());
    }

    @Then("User checks search {string} on result page")
    public void userChecksSearchHintOnResultPage(final String parameter) {
        searchResultsPage = pageFactoryManager.getSearchResultsPage();
        searchResultsPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, searchResultsPage.getHint());
        assertEquals(searchResultsPage.getHintText(), parameter);
    }

    @And("User checks hint visibility")
    public void userChecksHintVisibility() {
        searchResultsPage = pageFactoryManager.getSearchResultsPage();
        searchResultsPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, searchResultsPage.getHint());
        assertTrue(searchResultsPage.isHintVisible());
    }

    @After
    public void tearDown() {
        driver.close();
    }
}




