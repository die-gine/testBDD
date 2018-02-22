package steps.mainMenu;

import cucumber.api.PendingException;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pageObjects.assetOverview.AssetOverviewPO;
import pageObjects.general.DashboardPO;
import pageObjects.general.PageObject;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class DashboardSteps {
    private static PageObject currentPage;
    private DashboardPO generalEntryPO;
    private AssetOverviewPO assetOverviewPO;

    private final Logger logger = LoggerFactory.getLogger(DashboardSteps.class);

    public DashboardSteps(DashboardPO ge, AssetOverviewPO as){
        generalEntryPO = ge;
        assetOverviewPO = as;
    }

   @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) currentPage.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
        }
    }

    @Given("^is the \"([^\"]*)\" Banking$")
    public void is_the_Banking_App(String arg1){
        if(arg1.equals("web")){

        }
        //#todo if web or mobile app access
        logger.debug("CIC Banking App loaded");
    }

    @Given("^is the \"([^\"]*)\"$")
    public void is_the(String arg1) {
       if (arg1.equals("Dashboard Web")){
           currentPage = generalEntryPO.load();
           logger.debug("CIC Banking Dashboard Web is loaded");
         //todo   Reporter.addScreenCaptureFromPath("C:\\Users\\test");
       }
    }

    @Given("^\"([^\"]*)\" is selected$")
    public void is_selected(String arg1) {
        if (arg1.equals("English")){
            currentPage.switchToEnglish();
        }
    }

    @When("^I click \"([^\"]*)\"$")
    public void i_click(String arg1) {
        switch (arg1) {
            case "Vermögen":
                currentPage = generalEntryPO.navigateToAssetsOverview();
                break;
            case "Dashboard":
                //todo
                break;
            case "Eva Moniter":
                assetOverviewPO.clickWidgetByAccountName(arg1);
                break;
            case "Markus Moniter":
                assetOverviewPO.clickWidgetByAccountName(arg1);
                break;
            default:
                throw new IllegalArgumentException("Do nothing. Invalid value: " + arg1);
        }
    }

    @Then("^the header \"([^\"]*)\" is shown$")
    public void the_is_shown(String arg1){
        assertThat(currentPage.getContentHeaderTitle(), containsString(arg1));
    }

    @Then("^the \"([^\"]*)\" icon is displayed as \"([^\"]*)\"$")
    public void the_icon_is_displayed_as(String arg1, String arg2){
        assertEquals(arg1, currentPage.getMainMenueIcon(arg2));
    }

    @Then("^the breadcrump contains: \"([^\"]*)\"$")
    public void the_breadcrump_contains(String arg1) {
        assertEquals(currentPage.getListOfBreadcrumpItems(), arg1);
    }


    @Then("^the \"([^\"]*)\" are shown$")
    public void the_are_shown(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^the <_elements_> are shown in Meta Navigation$")
    public void the_elements_AreShownInMetaNavigation() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
