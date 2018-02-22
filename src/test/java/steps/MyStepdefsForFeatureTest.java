package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.assetOverview.AssetOverviewPO;
import pageObjects.general.DashboardPO;
import pageObjects.general.PageObject;


//FOR LOCAL TESTRUNS ONLY
public class MyStepdefsForFeatureTest {
    private static PageObject currentPage;
    private DashboardPO generalEntryPO;
    private AssetOverviewPO balanceSheet;

    public MyStepdefsForFeatureTest(PageObject po, DashboardPO ge, AssetOverviewPO bs){
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
