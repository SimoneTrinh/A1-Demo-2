package base;

import constants.Constants;
import driver.DriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class BaseTest {
    public static WebDriver driver;

    @Parameters("browser")
    @BeforeMethod(alwaysRun = true)
    public void setUp(@Optional("Chrome") String browser) {
        switch (browser) {
            case "Chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                driver.get(Constants.Env.LIVE_URL);
                DriverManager.setDriver(driver);
                driver.manage().window().maximize();
                driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                break;
            case "Firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                driver.get(Constants.Env.LIVE_URL);
                DriverManager.setDriver(driver);
                driver.manage().window().maximize();
                driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                break;
            case "Edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                driver.get(Constants.Env.LIVE_URL);
                DriverManager.setDriver(driver);
                driver.manage().window().maximize();
                driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                break;
        }
    }
    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}
