package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DealsPage extends BasePage {

    @FindBy(xpath = "//div[@id='widgetFilters']//span[contains(text(),'Books')]")
    private WebElement booksSelector;

    @FindBy(xpath = "//div[@id='100_dealView_0']//button[contains(text(),'Add to Cart')]")
    private WebElement addToCartButton;

    public DealsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isBookSelectorVisible() {
        return booksSelector.isDisplayed();
    }

    public void clickBookSelector() {
        booksSelector.click();
    }

    public WebElement getAddToCartButton() {
        return addToCartButton;
    }

    public void clickAddToCartButton() {
        addToCartButton.click();
    }
}
