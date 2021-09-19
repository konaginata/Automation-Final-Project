package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    @FindBy(xpath = "//input[@type='email']")
    private WebElement idField;

    @FindBy(xpath = "//input[@id='continue']")
    private WebElement continueButton;

    @FindBy(xpath = "//input[@type='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@id='signInSubmit']")
    private WebElement submitButton;

    @FindBy(xpath = "//a[@id='nav-item-signout']/span")
    private WebElement logoutLink;

    @FindBy(xpath = "//form[@name='signIn']//h1")
    private WebElement signInPageHeader;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public boolean isIdFieldVisible() {
        return idField.isDisplayed();
    }

    public void sendKeysToIdField(final String id) {
        idField.sendKeys(id);
    }

    public void clickContinueButton() {
        continueButton.click();
    }

    public boolean isPasswordIdFieldVisible() {
        return passwordField.isDisplayed();
    }

    public void sendKeysToPasswordField(final String password) {
        passwordField.sendKeys(password);
    }

    public void clickSubmitButton() {
        submitButton.click();
    }

    public void clickLogoutLink() {
        logoutLink.click();
    }

    public void moveToLogoutLink() {
        Actions actions = new Actions(driver);
        actions.moveToElement(logoutLink).build().perform();
    }

    public String getSignInPageHeaderText() {
        return signInPageHeader.getText();
    }
}
