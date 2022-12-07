package ultils;

import driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class WebUI {
    static WebDriverWait wait;

    public void getToUrl(String url) {
        DriverManager.getDriver().get(url);
    }

    public WebElement getElement(By by) {
        return DriverManager.getDriver().findElement(by);
    }

    public void clickElement(By by) {
        getElement(by).click();
    }
    public void inputText(By by, String text){
        getElement(by).click();
        getElement(by).sendKeys(text);
    }

    public String getTitle() {
        return DriverManager.getDriver().getTitle();
    }

    public String getTextByElement(By by) {
        return DriverManager.getDriver().findElement(by).getText();
    }

    public List<WebElement> getListElements(By by) {
        return DriverManager.getDriver().findElements(by);
    }

    public void waitForElementIsPresence(By by, int time) {
        try {
            wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(time));
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        } catch (Throwable error) {
            Assert.fail("Timeout for wait element: " + by.toString() + " on " + time);
            System.out.println(error.getMessage());
        }
    }
}
