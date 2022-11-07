package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.modules.HomePage;

public class ExtractDataHomePage extends BaseTest {
    @Test
    public void ExtractDataHomePage(){
        HomePage homePage = new HomePage();
        homePage.verifyRedirectToHomePage();
        homePage.getDataAndSort();
    }
}
