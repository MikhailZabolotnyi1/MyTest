package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JavaScriptAlertsPage {
    private WebDriver driver;

    public JavaScriptAlertsPage(WebDriver driver) {
        this.driver = driver;
    }
    @FindBy (xpath = "//*[contains(@onclick,'jsAlert')]")
    private WebElement ForJSAlertButton;
    @FindBy (xpath ="//*[contains(@onclick,'jsConfirm')]")
    private WebElement ForJSConfirmButton;
    @FindBy (xpath = "//*[contains(@onclick,'jsPrompt')]")
    private WebElement ForJSPromptButton;
    @FindBy (xpath ="//*[@id='result']")
    private WebElement resultTextField;

    public JavaScriptAlertsPage clickForJSAlertButton() {
        ForJSAlertButton.click();
        return this;
    }

    public JavaScriptAlertsPage clickOkJSAlertButton() {
        driver.switchTo().alert().accept();
        return this;
    }

    public JavaScriptAlertsPage clickForJSConfirmButton() {
        ForJSConfirmButton.click();
        return this;
    }

    public JavaScriptAlertsPage clickCancelJSConfirmButton() {
        driver.switchTo().alert().dismiss();
        return this;
    }

    public JavaScriptAlertsPage clickForJSPromptButton() {
        ForJSPromptButton.click();
        return this;
    }

    public JavaScriptAlertsPage sendKeysInJSPromptButton(String text) {
        driver.switchTo().alert().sendKeys(text);
        return this;
    }

    public String getResultText() {
        return resultTextField.getText();
    }


}
