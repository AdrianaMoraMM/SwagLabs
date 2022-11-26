package Pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class MenuPage extends BasePage{



        @AndroidFindBy(xpath="//android.view.ViewGroup[@content-desc=\"test-Menu\"]/android.view.ViewGroup/android.widget.ImageView")
        //@iOSXCUITFindBy(xpath="//")
        private MobileElement settingsBtn;

        public SettingsPage pressSettingsBtn() {
            click(settingsBtn, "press Settings button");
            return new SettingsPage();
        }



}
