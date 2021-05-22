package Pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = "//a[text()='Add/Remove Elements']")
    private WebElement addAndRemoveElementsLink;
    @FindBy(xpath = "//a[text()='JavaScript Alerts']")
    private WebElement javaScriptAlertsLink;

    public AddAndRemoveElementsPage clickOnAddAndRemoveElementsLink(){
        addAndRemoveElementsLink.click();
        return new AddAndRemoveElementsPage(driver);
    }

    public JavaScriptAlertsPage clickOnJavaScriptAlertsLink() {
        javaScriptAlertsLink.click();
        return new JavaScriptAlertsPage(driver);
    }


}
