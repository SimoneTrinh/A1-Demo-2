package pages.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.modules.MarketPlace;
import ultils.StockData;
import ultils.WebUI;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class HomePageActions extends WebUI {
    By tableRows = By.xpath("//div[@id='pills-active']//tbody/tr");
    By codeElms = By.cssSelector("td:nth-child(1)");
    By nameElms = By.tagName("th");
    By lastDoneElms = By.cssSelector("td:nth-child(3)");
    By changeElms = By.cssSelector("td:nth-child(4)");
    By volElms = By.cssSelector("td:nth-child(5)");
    By market = By.xpath("//div[@id='newnav-bmp']");

    public void goToMarketPlacePage(){
        clickElement(market);
    }
    private final List<StockData> stockData = new ArrayList<>();
    public void getStockDataAndSort() {
        List<WebElement> rows = getListElements(tableRows);
        for (WebElement cell : rows) {
            String code = cell.findElement(codeElms).getText();
            String name = cell.findElement(nameElms).getText();
            String lastDone = cell.findElement(lastDoneElms).getText();
            //Resolve for case change = "-" return 0.0
            WebElement changeElm = cell.findElement(changeElms);
            double change;
            if (changeElm.getText().trim().equals("-")) {
                change = 0.0;
            } else {
                change = Double.parseDouble(changeElm.getText());
            }
            String vol = cell.findElement(volElms).getText();
            //TODO: add keyword getText, chia nhỏ hàm
            stockData.add(new StockData(code, name, lastDone, change, vol));
        }
        stockData.sort(Comparator.comparingDouble(StockData::getChange));
        Collections.reverse(stockData);
        //Print
        for (StockData data : stockData) {
            System.out.println(data.toString());
        }
    }
}
