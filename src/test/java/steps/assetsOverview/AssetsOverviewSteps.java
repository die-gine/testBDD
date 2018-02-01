package steps.assetsOverview;

import com.cucumber.listener.Reporter;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pageObjects.balanceSheet.AssetsOverviewPO;
import pageObjects.general.GeneralEntryPO;
import pageObjects.general.PageObject;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class AssetsOverviewSteps {
    private static PageObject currentPage;
    private GeneralEntryPO generalEntryPO;
    private AssetsOverviewPO balanceSheet;

    private final Logger logger = LoggerFactory.getLogger(AssetsOverviewSteps.class);

    public AssetsOverviewSteps(PageObject po, GeneralEntryPO ge, AssetsOverviewPO bs){
        currentPage = po;
        generalEntryPO = ge;
        balanceSheet = bs;
    }

    @Given("^is the \"([^\"]*)\" Banking$")
    public void is_the_Banking_App(String arg1) throws Throwable {
        //#todo if web or mobile app access
        logger.debug("CIC Banking App loaded");
        Reporter.addStepLog("hello wooooorld");
    }

    @Given("^is the \"([^\"]*)\"$")
    public void is_the(String arg1) throws Throwable {
       if (arg1.equals("Dashboard Web")){
           currentPage = generalEntryPO.load();
           logger.debug("CIC Banking Dashboard Web is loaded");
           Reporter.addScreenCaptureFromPath("C:\\Users\\test");
       }
    }

    @Given("^\"([^\"]*)\" is selected$")
    public void is_selected(String arg1) throws Throwable {
        if (arg1.equals("English")){
            currentPage.switchToEnglish();
        }
    }

    @When("^I click \"([^\"]*)\"$")
    public void i_click(String arg1) throws Throwable {
        switch (arg1) {
            case "Vermögen":
                currentPage = generalEntryPO.navigateToAssetsOverview();
                break;
            case "Dashboard":
                //todo
                System.out.println("Error - do nothing");
                break;
            default:
                throw new IllegalArgumentException("Do nothing. Invalid value: " + arg1);
        }
        currentPage.takeScreenshotCurrentPage("currentPageAfterClickOn"+arg1);
    }

    @Then("^the header \"([^\"]*)\" is shown$")
    public void the_is_shown(String arg1) throws Throwable {
        assertThat(currentPage.getContentHeaderTitle(), containsString(arg1));

    }


    @Then("^the \"([^\"]*)\" icon is displayed as \"([^\"]*)\"$")
    public void the_icon_is_displayed_as(String arg1, String arg2) throws Throwable {
            assertEquals(arg1, currentPage.getElementTextbyXpath(arg2));
    }

    @Then("^the breadcrump contains: \"([^\"]*)\"$")
    public void the_breadcrump_contains(String arg1) throws Throwable {
        assertEquals(currentPage.getListOfBreadcrumpItems(), arg1);
    }


    @Then("^the \"([^\"]*)\" are shown$")
    public void the_are_shown(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^the \"([^\"]*)\" are clickable$")
    public void the_are_clickable(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
