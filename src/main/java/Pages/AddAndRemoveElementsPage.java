package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AddAndRemoveElementsPage {
    private WebDriver driver;

    public AddAndRemoveElementsPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = "//*[contains(@onclick,'add')]")
    private WebElement addElementButton;
    @FindBy(xpath = "//*[contains(@onclick,'delete')]")
    private WebElement deleteButton;

    public AddAndRemoveElementsPage clickAddElementButton() {
        addElementButton.click();
        return this;
    }

    public AddAndRemoveElementsPage clickDeleteButton(){
        deleteButton.click();
        return  this;
    }

    public int checkDeleteButtons(){
        List<WebElement> webElementList = driver.findElements(By.xpath("//*[contains(@onclick,'delete')]"));
        return webElementList.size();
    }
}
