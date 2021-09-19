package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ItemPage extends BasePage {

    @FindBy(xpath = "//span[@id='productTitle']")
    private WebElement itemTitle;

    @FindBy(xpath = "//input[@value='Add to Cart']")
    private WebElement addToCartButton;

    @FindBy(xpath = "//li[@title='Click to select 256GB']")
    private WebElement gb256Switcher;

    @FindBy(xpath = "//label[contains(text(),'Size:')]/../span[@class='selection']")
    private WebElement capacityValue;

    public ItemPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getItemTitle() {
        return itemTitle;
    }

    public boolean isAddToCartButtonVisible() {
        return addToCartButton.isDisplayed();
    }

    public WebElement getAddToCartButton(){
        return addToCartButton;
    }

    public void clickAddToCartButton() {
        addToCartButton.click();
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }

    public boolean isGb256SwitcherVisible() {
        return gb256Switcher.isDisplayed();
    }

    public void clickGb256Switcher() {
        gb256Switcher.click();
    }

    public String getCapacityValue() {
        return capacityValue.getText();
    }
}
