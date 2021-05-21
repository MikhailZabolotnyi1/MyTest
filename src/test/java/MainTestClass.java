import Pages.AddAndRemoveElementsPage;
import Pages.JavaScriptAlertsPage;
import Pages.MainPage;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;


public class MainTestClass {
    private WebDriver driver;
    private MainPage mainPage;


    @Before
    public void setUp() {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Chris\\IdeaProjects\\PageObjectTZ\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();

        System.out.println("Going to main page");
        driver.get("http://the-internet.herokuapp.com/");

    }

    @Test
    public void addAndDeleteElements() {
        MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
        AddAndRemoveElementsPage addAndRemoveElementsPage = PageFactory.initElements(driver, AddAndRemoveElementsPage.class);

        System.out.println("Going to Add/Remove Elements page");
        mainPage.clickOnAddAndRemoveElementsLink();

        System.out.println("Adding three elements");
        for (int i=1; i<4;i++){
            addAndRemoveElementsPage.clickAddElementButton();
        }
        Assert.assertEquals(3, addAndRemoveElementsPage.checkDeleteButtons());

        System.out.println("Removed one of them");
        addAndRemoveElementsPage.clickDeleteButton();

        Assert.assertEquals(2, addAndRemoveElementsPage.checkDeleteButtons());

    }

    @Test
    public  void javaScriptAlerts() {
        MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
        JavaScriptAlertsPage javaScriptAlertsPage = PageFactory.initElements(driver, JavaScriptAlertsPage.class);

        System.out.println("Going to JS Alerts page");
        mainPage.clickOnJavaScriptAlertsLink();

        System.out.println("Click on \"Click for JS Alert\" button and click \"OK\" on Alert");
        javaScriptAlertsPage.clickForJSAlertButton().clickOkJSAlertButton();

        System.out.println("Checking for a corresponding message");
        Assert.assertEquals("You successfully clicked an alert", javaScriptAlertsPage.getResultText());

        System.out.println("click on \"Click for JS Confirm\" button and click \"Cancel\" on Alert");
        javaScriptAlertsPage.clickForJSConfirmButton().clickCancelJSConfirmButton();

        System.out.println("Checking for a corresponding message");
        Assert.assertEquals("You clicked: Cancel", javaScriptAlertsPage.getResultText());

        System.out.println("click on \"Click for JS Prompt\" button, some text input and click \"OK\" on Alert");
        javaScriptAlertsPage.clickForJSPromptButton().sendKeysInJSPromptButton("sheesh").clickOkJSAlertButton();

        System.out.println("Checking for a corresponding message");
        Assert.assertEquals("You entered: sheesh", javaScriptAlertsPage.getResultText());

    }

    @After
    public void tearDown() {
        driver.quit();
    }


}
