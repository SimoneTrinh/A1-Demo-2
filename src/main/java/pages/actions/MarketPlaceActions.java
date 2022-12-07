package pages.actions;

import Inject.Implementation.ILogin;
import org.openqa.selenium.By;
import ultils.WebUI;

public class MarketPlaceActions extends WebUI implements ILogin {
    By loginBtn = By.xpath("//div[@id='newnav-login']");
    By txbEmail = By.xpath("//input[@id='newpopup-login-email']");
    By txbPassword = By.xpath("//input[@id='newpopup-login-pass']");

    public void clickLoginBtn() {
        clickElement(loginBtn);
    }

    @Override
    public void inputEmail(String email) {
        inputText(txbEmail, email);
    }

    @Override
    public void inputPassword(String password) {
        inputText(txbPassword, password);
    }

    @Override
    public void clickOnBtnLogin() {
        clickElement(loginBtn);
    }
}
