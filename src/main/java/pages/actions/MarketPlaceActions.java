package pages.actions;

import Inject.Implementation.ILogin;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import ultils.WebUI;

public class MarketPlaceActions extends WebUI implements ILogin {
    By loginBtn = By.xpath("//div[@id='newnav-login']");
    By txbEmail = By.xpath("//input[@id='newpopup-login-email']");
    By txbPassword = By.xpath("//input[@id='newpopup-login-pass']");

    public void clickLoginBtn() {
        clickElement(loginBtn);
    }

    @Step("Input email")
    @Override
    public void inputEmail(String email) {
        inputText(txbEmail, email);
    }
    @Step("Input password")
    @Override
    public void inputPassword(String password) {
        inputText(txbPassword, password);
    }

    @Step("Click Login Button")
    @Override
    public void clickOnBtnLogin() {
        clickElement(loginBtn);
    }
}
