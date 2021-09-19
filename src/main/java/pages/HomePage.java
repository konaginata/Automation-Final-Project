package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    @FindBy(xpath = "//div[@class='nav-line-1-container']")
    private WebElement loginButton;

    @FindBy(xpath = "//input[@id='twotabsearchtextbox']")
    private WebElement searchField;

    @FindBy(xpath = "//input[@id='nav-search-submit-button']")
    private WebElement searchButton;

    @FindBy(xpath = "//a[@data-csa-c-slot-id='nav_cs_0']")
    private WebElement dealsButton;

    @FindBy(xpath = "//a[@id='nav-global-location-popover-link']")
    private WebElement deliverySettingsButton;

    @FindBy(xpath = "//h4[@class='a-popover-header-content']")
    private WebElement locationSettingsPopupHeader;

    @FindBy(xpath = "//input[@aria-label='or enter a US zip code']")
    private WebElement zipCodeField;

    @FindBy(xpath = "//span[contains(text(),'Apply')]/../input")
    private WebElement applyZipCodeButton;

    @FindBy(xpath = "//div[contains(text(),'Please enter a valid US zip code')]")
    private WebElement zipCodeError;

    @FindBy(xpath = "//img[@alt='Oculus']")
    private WebElement oculusCatalog;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void openHomePage(String url) {
        driver.get(url);
    }

    public boolean isLoginButtonVisible() {
        return loginButton.isDisplayed();
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public void moveToLoginLink() {
        Actions actions = new Actions(driver);
        actions.moveToElement(loginButton).build().perform();
    }

    public boolean isSearchFieldVisible() {
        return searchField.isDisplayed();
    }

    public void sendKeysToSearchField(final String keyword) {
        searchField.sendKeys(keyword);
    }

    public void clickSearchButton() {
        searchButton.click();
    }

    public boolean isDealsButtonVisible() {
        return dealsButton.isDisplayed();
    }

    public void clickDealsButton() {
        dealsButton.click();
    }

    public boolean isDeliverySettingsButtonVisible() {
        return deliverySettingsButton.isDisplayed();
    }

    public void clickDeliverySettingsButton() {
        deliverySettingsButton.click();
    }

    public boolean isLocationSettingsPopupHeaderVisible() {
        return locationSettingsPopupHeader.isDisplayed();
    }

    public WebElement getLocationSettingsPopupHeader() {
        return locationSettingsPopupHeader;
    }

    public boolean isZipCodeFieldVisible() {
        return zipCodeField.isDisplayed();
    }

    public WebElement getZipCodeField() {
        return zipCodeField;
    }

    public void sendKeysToZipCodeField(final String code) {
        zipCodeField.sendKeys(code);
    }

    public boolean isApplyZipCodeButtonVisible() {
        return applyZipCodeButton.isDisplayed();
    }

    public WebElement getApplyZipCodeButton() {
        return applyZipCodeButton;
    }

    public void clickApplyZipCodeButton() {
        applyZipCodeButton.click();
    }

    public WebElement getZipCodeError() {
        return zipCodeError;
    }

    public String getZipCodeErrorText() {
        return zipCodeError.getText();
    }

    public boolean isOculusCatalogVisible() {
        return oculusCatalog.isDisplayed();
    }

    public WebElement getOculusCatalog() {
        return oculusCatalog;
    }

    public void clickOculusCatalog() {
        oculusCatalog.click();
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }
}
