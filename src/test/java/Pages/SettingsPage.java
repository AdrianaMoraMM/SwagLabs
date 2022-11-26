package Pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class SettingsPage extends BasePage{


    @AndroidFindBy(accessibility="test-LOGOUT")
    @iOSXCUITFindBy(id = "test-LOGOUT")
    private MobileElement logoutBtn;

    public LoginPage pressLogoutBtn() {
        click(logoutBtn, "press Logout button");
        return new LoginPage();
    }

}
