package pages.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ultils.StockData;
import ultils.WebUI;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class HomePageActions extends WebUI {
    public HomePageActions() {
    }
    By tableRows = By.xpath("//div[@id='pills-active']//tbody/tr");
    By codeElms = By.cssSelector("td:nth-child(1)");
    By nameElms = By.tagName("th");
    By lastDoneElms = By.cssSelector("td:nth-child(3)");
    By changeElms = By.cssSelector("td:nth-child(4)");
    By volElms = By.cssSelector("td:nth-child(5)");
    public void getStockDataAndSort() {
        List<WebElement> rows = get_List_Element(tableRows);
        List<StockData> stockData = new ArrayList<>();
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
