package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {
    @FindBy(xpath = "//span[@id='nav-cart-count']")
    private WebElement cartWidget;

    @FindBy(xpath = "//span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap sc-product-price a-text-bold']")
    private WebElement oneItemPrice;

    @FindBy(xpath = "//span[@id='sc-subtotal-amount-activecart']/span")
    private WebElement totalItemsPrice;

    @FindBy(xpath = "//span[@id='sc-subtotal-label-buybox']")
    private WebElement cartItemCounter;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public boolean isCartWidgetVisible() {
        return cartWidget.isDisplayed();
    }

    public void clickCartWidget() {
        cartWidget.click();
    }

    public WebElement getCartWidget() {
        return cartWidget;
    }

    public double getOneItemPrice() {
        return Double.parseDouble(oneItemPrice.getText().substring(1));
    }

    public double getTotalItemsPrice() {
        return Double.parseDouble(totalItemsPrice.getText().substring(1));
    }

    public int getCountOfItemsInCart() {
        return Integer.parseInt(String.valueOf(cartItemCounter.getText().charAt(10)));
    }
}
