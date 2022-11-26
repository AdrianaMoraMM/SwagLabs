package Pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;


public class ProductsPage extends MenuPage {


        @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Zona de caída del carrito de compras\"]/android.view.ViewGroup/android.widget.TextView")
        @iOSXCUITFindBy(xpath ="//XCUIElementTypeOther[@name=\"test-Toggle\"]/parent::*[1]/preceding-sibling::*[1]")
        private MobileElement titleTxt;

        @iOSXCUITFindBy (xpath = "//XCUIElementTypeOther[@name=\"test-PRODUCTS\"]/XCUIElementTypeScrollView")
        private MobileElement iOSSCrollView;

        public String getTitle() {
            return getText(titleTxt, "product page title is - ");
        }


        public String getProductTitle(String title) throws Exception {
               return getText(andScrollToElementUsingUiScrollable("text", title), "product title is: " + title);

        }

        public By defProductPrice(String title) throws Exception {

        return By.xpath("//*[@text=\"" + title + "\"]/following-sibling::*[@content-desc=\"test-Precio\"]");

        }

        public String getProductPrice(String title, String price) throws Exception {
            return getText(scrollToElement(defProductPrice(title), "up"), "product price is: " + price);
        }

        public ProductsDetailsPage pressProductTitle(String title) throws Exception {

                    click(andScrollToElementUsingUiScrollable("text", title), "press " + title + " link");
                    return new ProductsDetailsPage();

    }
    public ProductsDetailsPage pressProductTitle2(String title) throws Exception {

        click(andScrollToElementUsingUiScrollable("description", title), "press " + title + " link");
        return new ProductsDetailsPage();


    }
    }
