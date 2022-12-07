package tests;

import Inject.Bindings.Bindings;
import Inject.Controller.LoginController;
import base.BaseTest;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.modules.HomePage;
import pages.modules.MarketPlace;
import ultils.PropertiesFile;

public class InputLogin extends BaseTest {
    HomePage homePage = new HomePage();
    /* Không phải new MarketPlace */
//  MarketPlace marketPlace = new MarketPlace();
    Injector injector;
    LoginController loginController;

    @BeforeTest
    public void setUpTest() {
        injector = Guice.createInjector(new Bindings());
        loginController = injector.getInstance(LoginController.class);
        PropertiesFile.setPropertiesFile();
    }

    @Test
    public void doTest() {
        homePage.verifyRedirectToHomePage();
        homePage.goToMarketPlacePage();
        loginController.clickBtnLogin();
        loginController.setEmail(PropertiesFile.getPropValue("email"));
        loginController.setPassword(PropertiesFile.getPropValue("pass"));
    }
}
