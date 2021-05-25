import Pages.AddAndRemoveElementsPage;
import Pages.JavaScriptAlertsPage;
import Pages.MainPage;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import java.util.concurrent.TimeUnit;


public class MainTestClass {
    private WebDriver driver;

    @Before
    public void setUp() {

        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        System.out.println("Going to main page");
        driver.get("http://the-internet.herokuapp.com/");

    }

    @Test
    public void addAndDeleteElements() {
        MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
        AddAndRemoveElementsPage addAndRemoveElementsPage = PageFactory.initElements(driver, AddAndRemoveElementsPage.class);

        System.out.println("Going to Add and Remove Elements page");
        mainPage.clickOnAddAndRemoveElementsLink();

        System.out.println("Adding three elements");
        addAndRemoveElementsPage.clickAddElementButton().clickAddElementButton().clickAddElementButton();

        System.out.println("Checking for number of elements");
        Assert.assertEquals(3, addAndRemoveElementsPage.checkDeleteButtons());

        System.out.println("Removed one of them");
        addAndRemoveElementsPage.clickDeleteButton();

        System.out.println("Checking for number of elements");
        Assert.assertEquals(2, addAndRemoveElementsPage.checkDeleteButtons());

    }

    @Test
    public  void javaScriptAlerts() {
        MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
        JavaScriptAlertsPage javaScriptAlertsPage = PageFactory.initElements(driver, JavaScriptAlertsPage.class);

        System.out.println("Going to JS Alerts page");
        mainPage.clickOnJavaScriptAlertsLink();

        System.out.println("Click on \"Click for JS Alert\" and click \"OK\"");
        javaScriptAlertsPage.clickForJSAlertButton().clickOkJSAlertButton();

        System.out.println("Checking for a corresponding message");
        Assert.assertEquals("You successfully clicked an alert", javaScriptAlertsPage.getResultText());

        System.out.println("click on \"Click for JS Confirm\" and click \"Cancel\"");
        javaScriptAlertsPage.clickForJSConfirmButton().clickCancelJSConfirmButton();

        System.out.println("Checking for a corresponding message");
        Assert.assertEquals("You clicked: Cancel", javaScriptAlertsPage.getResultText());

        System.out.println("click on \"Click for JS Prompt\", sending some keys and click \"OK\"");
        javaScriptAlertsPage.clickForJSPromptButton().sendKeysInJSPromptButton("sheesh").clickOkJSAlertButton();

        System.out.println("Checking for a corresponding message");
        Assert.assertEquals("You entered: sheesh", javaScriptAlertsPage.getResultText());

    }

    @After
    public void tearDown() {
        driver.quit();
    }


}
