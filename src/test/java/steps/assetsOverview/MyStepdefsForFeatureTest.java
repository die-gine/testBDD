package steps.assetsOverview;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.balanceSheet.AssetsOverviewPO;
import pageObjects.general.GeneralEntryPO;
import pageObjects.general.PageObject;


//FOR LOCAL TESTRUNS ONLY
public class MyStepdefsForFeatureTest {
    private static PageObject currentPage;
    private GeneralEntryPO generalEntryPO;
    private AssetsOverviewPO balanceSheet;

    public MyStepdefsForFeatureTest(PageObject po, GeneralEntryPO ge, AssetsOverviewPO bs){
        currentPage = po;
        generalEntryPO = ge;
        balanceSheet = bs;
    }

    @Given("^is the \"([^\"]*)\" test$")
    public void is_the_test(String arg1) {
        if (arg1.equals("Dashboard Web")){
            currentPage = generalEntryPO.load();
        }
    }

    @When("^I click \"([^\"]*)\" test$")
    public void i_click_test(String arg1) {
       System.out.print("HEELLOO");
    }

    @Then("^the header \"([^\"]*)\" is shown test$")
    public void the_header_is_shown_test(String arg1) {
        System.out.print("HEELLOO AGAIN");
    }
}
