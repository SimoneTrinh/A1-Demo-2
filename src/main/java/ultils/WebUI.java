package ultils;

import driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import javax.swing.*;
import java.awt.*;
import java.time.Duration;
import java.util.List;

public class WebUI {
    static WebDriverWait wait;
    public void getToUrl(String url) {
        DriverManager.getDriver().get(url);
    }
    public String getTitle() {
        return DriverManager.getDriver().getTitle();
    }
    public List<WebElement> get_List_Element(By by) {
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
