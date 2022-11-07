package pages.modules;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import pages.actions.HomePageActions;


public class HomePage extends HomePageActions {
    public HomePage() {
    }

    By StockTable = By.xpath("//div[@id='pills-active']//tbody");

    @Step("verify redirect to homepage")
    public void verifyRedirectToHomePage() {
        waitForElementIsPresence(StockTable, 20);
    }
    @Step("Get Data and Sort")
    public void getDataAndSort() {
        getStockDataAndSort();
    }
    //For debug
//    @Step("get title")
//    public String title() {
//        return getTitle();
//    }
}
