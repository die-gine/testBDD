package steps.assetsOverview;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pageObjects.assetsOverview.AssetsOverviewEntryPO;
import pageObjects.general.GeneralEntryPO;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

public class AssetsOverviewSteps {
    private final GeneralEntryPO generalEntryPO;
    private final AssetsOverviewEntryPO assetsOverviewEntryPO;

    private final Logger logger = LoggerFactory.getLogger(AssetsOverviewSteps.class);

    public AssetsOverviewSteps(GeneralEntryPO commonEntryPO, AssetsOverviewEntryPO commonAssetsOverviewEntryPO){
        generalEntryPO = commonEntryPO;
        assetsOverviewEntryPO = commonAssetsOverviewEntryPO;
    }

    @Given("^is the \"([^\"]*)\" Banking App$")
    public void is_the_Banking_App(String arg1) throws Throwable {
        logger.info("Loading page");
        generalEntryPO.load();
        logger.debug("Loaded page");
    }

    @Given("^is the logged in user Markus Monitor$")
    public void is_the_logged_in_user_Markus_Monitor() throws Throwable {
        //#todo
        System.out.println("Markus Monitor hat sich eingelogged");
    }

    @Given("^is the startpage$")
    public void is_the_startpage() throws Throwable {
        logger.info("Loading assets overview");
        assetsOverviewEntryPO.load();
        logger.debug("Loaded assets overview");
    }

    @Given("^Deutsch is selected$")
    public void deutsch_is_selected() throws Throwable {
        //#todo
        System.out.println("Sprache: Deutsch");
    }

    @When("^I click on Kontoübersicht$")
    public void i_click_on_Kontoübersicht() throws Throwable {
        logger.info("Loading assets overview");
        assetsOverviewEntryPO.searchFor("hello");
        logger.debug("Loaded assets overview");
    }

    @Then("^I am on Kontoübersicht page$")
    public void i_am_on_Kontoübersicht_page() throws Throwable {
        logger.info("Loading assets overview");
        assertThat(assetsOverviewEntryPO.firstHitTitle().toLowerCase(), containsString("hello"));
        logger.debug("Loaded assets overview");
    }

    @Given("^English is selected$")
    public void english_is_selected() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^I click on Account Overview$")
    public void i_click_on_Account_Overview() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^I am on Account Overview page$")
    public void i_am_on_Account_Overview_page() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Given("^is the logged in user \"([^\"]*)\"$")
    public void is_the_logged_in_user(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Given("^\"([^\"]*)\" is selected$")
    public void is_selected(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^I see \"([^\"]*)\" bank account tiles$")
    public void i_see_bank_account_tiles(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^I see the \"([^\"]*)\" tile$")
    public void i_see_the_tile(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^the tiles are orderd by \"([^\"]*)\"$")
    public void the_tiles_are_orderd_by(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^I click on \"([^\"]*)\"$")
    public void i_click_on(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^I am on \"([^\"]*)\" page$")
    public void i_am_on_page(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

}
