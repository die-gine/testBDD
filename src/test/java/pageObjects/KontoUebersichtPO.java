package pageObjects;

import org.openqa.selenium.WebDriver;

public class KontoUebersichtPO extends PageObject {
    WebDriver driver;


    public KontoUebersichtPO(WebDriver driver) {
        this.driver= driver;
    }


    public String getTitle() {
        return "Konten";
    }

    public int getBankAccount() {
        return 2;
    }

    public Boolean isNewAccountAvailable() {
        return true;
    }

}
