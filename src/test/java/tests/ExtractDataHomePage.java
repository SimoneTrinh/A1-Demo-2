package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.modules.HomePage;

public class ExtractDataHomePage extends BaseTest {
    HomePage homePage = new HomePage();
    @Test()
    public void ExtractDataHomePage(){
        homePage.verifyRedirectToHomePage();
        homePage.getDataAndSort();
    }

    //For debug
//    @Test
//    public void avc()
//        homePage.title();
//    }
}
