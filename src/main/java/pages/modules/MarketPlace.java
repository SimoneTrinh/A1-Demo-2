package pages.modules;

import io.qameta.allure.Step;
import pages.actions.MarketPlaceActions;

public class MarketPlace extends MarketPlaceActions {
    @Step("Click Login button")
    public void clickBtnLogin() {
        clickLoginBtn();
    }
}
