package pages.modules;

import org.openqa.selenium.By;
import pages.actions.HomePageActions;


public class HomePage extends HomePageActions {
    public HomePage() {
    }

    By StockTable = By.xpath("//div[@id='pills-active']//tbody");

    public void verifyRedirectToHomePage() {
        waitForElementIsPresence(StockTable, 20);
    }

    public void getDataAndSort() {
        getStockDataAndSort();
    }
}
