package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class SearchResultsPage extends BasePage {

    @FindBy(xpath = "//div[@data-cel-widget='search_result_1']//img")
    private WebElement firstSearchResultPicture;

    @FindBy(xpath = "//div[@data-cel-widget='search_result_2']//img")
    private WebElement secondSearchResultPicture;

    @FindBy(xpath = "//ul/li[@aria-label='Alienware']//i")
    private WebElement alienwareCheckBox;

    @FindBy(xpath = "//div[@data-component-type='s-search-result']//a[@class='a-link-normal a-text-normal']/span")
    private List<WebElement> searchResults;

    @FindBy(xpath = "//div[@id='priceRefinements']//span[contains(text(),'Under $25')]")
    private WebElement priceLimiter25USD;

    @FindBy(xpath = "//span[@class='a-price']/span[@class='a-offscreen']")
    private List<WebElement> allPrices;

    @FindBy(xpath = "//span[contains(text(),'Did you mean')]/../a")
    private WebElement hint;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isFirstSearchResultVisible() {
        return firstSearchResultPicture.isDisplayed();
    }

    public WebElement getFirstSearchResultPicture() {
        return firstSearchResultPicture;
    }

    public void clickFirstSearchResult() {
        firstSearchResultPicture.click();
    }

    public WebElement getSecondSearchResultPicture() {
        return secondSearchResultPicture;
    }

    public void clickSecondSearchResult() {
        secondSearchResultPicture.click();
    }

    public boolean isAlienwareCheckBoxVisible() {
        return alienwareCheckBox.isDisplayed();
    }

    public void clickAlienwareCheckBox() {
        alienwareCheckBox.click();
    }

    public boolean areSearchResultsVisible() {
        boolean temp = true;
        for (WebElement we : searchResults) {
            if (!we.isDisplayed()) {
                temp = false;
            }
        }
        return temp;
    }

    public List<WebElement> getSearchResults() {
        return searchResults;
    }

    public boolean isPriceLimiter25UsdVisible() {
        return priceLimiter25USD.isDisplayed();
    }

    public void clickPriceLimiter25USD() {
        priceLimiter25USD.click();
    }

    public List<Double> getAllPrices() {
        return allPrices.stream()
                .filter(f -> !f.getText().isEmpty() && !f.getText().isBlank())
                .map(e -> Double.parseDouble(e.getText().replace('$', ' ').strip()))
                .collect(Collectors.toList());
    }

    public boolean isHintVisible() {
        return hint.isDisplayed();
    }

    public WebElement getHint() {
        return hint;
    }

    public String getHintText() {
        return hint.getText();
    }
}
