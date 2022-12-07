package Inject.Controller;

import Inject.Implementation.ILogin;
import com.google.inject.Inject;

public class LoginController {
    @Inject
    ILogin iLogin;

    public void setEmail(String email){
        iLogin.inputEmail(email);
    }

    public void setPassword(String password){
        iLogin.inputPassword(password);
    }
    public void clickBtnLogin(){
        iLogin.clickOnBtnLogin();
    }
}
