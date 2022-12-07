package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.modules.HomePage;
import pages.modules.MarketPlace;

public class ExtractDataHomePage extends BaseTest {
    HomePage homePage = new HomePage();
    MarketPlace marketPlace = new MarketPlace();
    @Test()
    public void ExtractData(){
        homePage.verifyRedirectToHomePage();
        homePage.getDataAndSort();
    }

    //For debug
//    @Test
//    public void avc()
//        homePage.title();
//    }
}
