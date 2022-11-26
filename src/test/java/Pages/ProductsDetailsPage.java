package Pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;



public class ProductsDetailsPage extends MenuPage {

    private AppiumDriver<?> driver;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Descripción\"]/android.widget.TextView[1]\n" +
            "")
    //@iOSXCUITFindBy(xpath = "")
    private MobileElement title;

    @AndroidFindBy (xpath = "//android.view.ViewGroup[@content-desc=\"test-Descripción\"]/android.widget.TextView[2]"
            + "")
    //@iOSXCUITFindBy (xpath = "")
    private MobileElement desc;

    @AndroidFindBy (accessibility = "test-REGRESO A PRODUCTOS")
    //@iOSXCUITFindBy (id = "")
    private MobileElement backToProductsBtn;

    @AndroidFindBy (accessibility = "test-AÑADIR A CARRITO")
    private MobileElement addToCartBtn;

    public By addToCartBtn() throws Exception {

        return By.xpath("//android.view.ViewGroup[@content-desc=\"test-AÑADIR A CARRITO\"]");

    }

    public ProductsPage pressBackToProductsBtn() {
        click(backToProductsBtn, "navigate regreso a productos page");
        return new ProductsPage();
    }
    public ProductsPage pressAddToCartBtn() {
        click(addToCartBtn, "press añadir al carrito button");
        return new ProductsPage();
    }

}


