package steps.mainMenu;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pageObjects.assetOverview.AccountDetailPO;
import pageObjects.assetOverview.AssetOverviewPO;
import pageObjects.general.DashboardPO;
import pageObjects.general.PageObject;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static junit.framework.Assert.assertFalse;
import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.CoreMatchers.*;


public class AssetOverviewSteps {
    private static PageObject currentPage;
    private DashboardPO generalEntryPO;
    private AssetOverviewPO assetOverview;
    private AccountDetailPO accountDetail;

    private final Logger logger = LoggerFactory.getLogger(DashboardSteps.class);

    public AssetOverviewSteps(DashboardPO ge, AssetOverviewPO bs, AccountDetailPO ad){
        generalEntryPO = ge;
        assetOverview = bs;
        accountDetail = ad;
    }

    @When("^I select \"([^\"]*)\"$")
    public void i_select(String arg1){
        assetOverview.clickElement(arg1);
    }

    @Then("^the content is shown as \"([^\"]*)\"$")
    public void the_content_is_shown_as(String arg1){
        isDisplayedOnAssetsOverview(arg1);
    }
    @Then("^the content is not shown as \"([^\"]*)\"$")
    public void the_content_is_not_shown_as(String arg1){
        assertFalse(assetOverview.isDisplayedOnAssetOverview(arg1));
    }

    @Then("^I see account widget with \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\" and \"([^\"]*)\"$")
    public void i_find_account_widget_with_and(String name, String title, String currency, String balance){
        ArrayList<String> x = new ArrayList<>(Arrays.asList(name,title,currency,balance));
        assertTrue(assetOverview.hasWidgetWithItems((ArrayList) x));
    }

    @Then("^the \"([^\"]*)\" is clickable$")
    public void the_icon_is_sclickable(String arg1){
        assertTrue(assetOverview.elementIsClickable(arg1));
    }

    @Then("^the widget \"([^\"]*)\" is diplayed$")
    public void the_widget_is_diplayed(String arg1) {
        isDisplayedOnAssetsOverview(arg1);
    }

    @Then("^the account detail page \"([^\"]*)\" is shown$")
    public void the_account_detail_page_is_shown(String arg1){
      Assert.assertThat(accountDetail.getContentHeaderTitle(), containsString(arg1));
    }

    @Then("^I see account detail with \"([^\"]*)\", \"([^\"]*)\" and \"([^\"]*)\"$")
    public void i_see_account_detail_with_and(String subtitle, String currency, String saldo){
        Assert.assertThat(accountDetail.getContentSubHeaderTitle(), containsString(subtitle));
        Assert.assertThat(accountDetail.getAccountCurrency(), containsString(currency));
        Assert.assertThat(accountDetail.getActualSaldo(), containsString(saldo));
    }

    private void isDisplayedOnAssetsOverview(String element){
        assertTrue(assetOverview.isDisplayedOnAssetOverview(element));
    }


}
