package Pages;

import Utils.Driver;

import io.appium.java_client.*;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofMillis;


public class BasePage {

        private AppiumDriver<?> driver;


        public BasePage(){
            this.driver = new Driver().getDriver();
            PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
        }

        public void waitForVisibility(MobileElement e) {
            WebDriverWait wait = new WebDriverWait(driver,10);
            wait.until(ExpectedConditions.visibilityOf(e));
        }

        public void waitForVisibility(By e) {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOfElementLocated(e));
        }

        public void clear(MobileElement e) {
            waitForVisibility(e);
            e.clear();
        }


        public void click(MobileElement e, String msg) {
            waitForVisibility(e);
            e.click();
        }



        public void sendKeys(MobileElement e, String txt, String msg) {
            waitForVisibility(e);
            e.sendKeys(txt);
        }

        public String getAttribute(MobileElement e, String attribute) {
            waitForVisibility(e);
            return e.getAttribute(attribute);
        }

        public String getAttribute(By e, String attribute) {
            waitForVisibility(e);
            return driver.findElement(e).getAttribute(attribute);
        }

        public String getText(MobileElement e, String msg) {
            String txt;
            txt = getAttribute(e, "text");
            return txt;
        }

        public String getText(By e, String msg) {
            String txt;
            txt = getAttribute(e, "text");
            return txt;
        }


        public MobileElement andScrollToElementUsingUiScrollable(String childLocAttr, String childLocValue) {
            return (MobileElement) ((FindsByAndroidUIAutomator) driver).findElementByAndroidUIAutomator(
                    "new UiScrollable(new UiSelector()" + ".scrollable(true)).scrollIntoView("
                            + "new UiSelector()."+ childLocAttr +"(\"" + childLocValue + "\"));");
        }





        public By scrollToElement(By element, String direction) throws Exception {
            Dimension size = driver.manage().window().getSize();
            int startX = (int) (size.width * 0.5);
            int endX = (int) (size.width * 0.5);
            int startY = 0;
            int endY = 0;
            boolean isFound = false;

            switch (direction) {
                case "up":
                    endY = (int) (size.height * 0.4);
                    startY = (int) (size.height * 0.6);
                    break;

                case "down":
                    endY = (int) (size.height * 0.6);
                    startY = (int) (size.height * 0.4);
                    break;
            }

            for (int i = 0; i < 3; i++) {
                if (find(element, 1)) {
                    isFound = true;
                    break;
                } else {
                    swipe(startX, startY, endX, endY, 1000);
                }
            }
            if(!isFound){
                throw new Exception("Element not found");
            }
            return element;
        }


        public boolean find(final By element, int timeout) {
            try {
                WebDriverWait wait = new WebDriverWait(driver, timeout);
                return wait.until(new ExpectedCondition<Boolean>() {
                    @Override
                    public Boolean apply(WebDriver driver) {
                        if (driver.findElement(element).isDisplayed()) {
                            return true;
                        }
                        return false;
                    }
                });
            } catch (Exception e) {
                return false;
            }
        }

        public void swipe(int startX, int startY, int endX, int endY, int millis)
                throws InterruptedException {
            TouchAction t = new TouchAction(driver);
            t.press(point(startX, startY)).waitAction(waitOptions(ofMillis(millis))).moveTo(point(endX, endY)).release()
                    .perform();
        }
    }


