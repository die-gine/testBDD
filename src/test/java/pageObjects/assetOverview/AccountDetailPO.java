package pageObjects.assetOverview;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.general.PageObject;

public class AccountDetailPO extends PageObject {
    public WebDriver driver = getDriver();

    @FindBy(className ="formatted-number__currency")
    WebElement accountCurrency;

    @FindBy(className ="formatted-number__value")
    WebElement actualSaldo;

    public AccountDetailPO(WebDriver commonDriver) {
        super(commonDriver);
        PageFactory.initElements(driver, this);
    }

    public String getAccountCurrency() {
        return accountCurrency.getText();
    }

    public String getActualSaldo() {
        return actualSaldo.getText().replaceAll("[^0-9.]", "").replace(".",",");
    }
}
