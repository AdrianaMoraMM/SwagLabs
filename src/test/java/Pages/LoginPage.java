package Pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class LoginPage extends BasePage {
    @AndroidFindBy(accessibility = "test-Usuario")
    //@iOSXCUITFindBy(id = "")
    private MobileElement usernameTxtFld;

    @AndroidFindBy (accessibility = "test-Contraseña")
    //@iOSXCUITFindBy (id = "")
    private MobileElement passwordTxtFld;

    @AndroidFindBy (accessibility = "test-LOGIN")
    //@iOSXCUITFindBy (id = "")
    private MobileElement loginBtn;

    @AndroidFindBy (xpath = "//android.view.ViewGroup[@content-desc=\"test-Error\"]/android.widget.TextView")
    //@iOSXCUITFindBy (xpath = "")
    private MobileElement errTxt;

    public LoginPage(){
    }

    public LoginPage enterUserName(String username) throws InterruptedException {
        clear(usernameTxtFld);
        sendKeys(usernameTxtFld, username, "login with " + username);
        return this;
    }

    public LoginPage enterPassword(String password) {
        clear(passwordTxtFld);
        sendKeys(passwordTxtFld, password, "password is " + password);
        return this;
    }

    public ProductsPage pressLoginBtn() {
        click(loginBtn, "press login button");
        return new ProductsPage();
    }

    public ProductsPage login(String username, String password) throws InterruptedException {
        enterUserName(username);
        enterPassword(password);
        return pressLoginBtn();
    }

    public String getErrTxt() {
        String err = getText(errTxt, "error text is - ");
        return err;
    }

}

