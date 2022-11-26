package Utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class Driver {
    private static ThreadLocal<AppiumDriver> driver = new ThreadLocal<>();
    public AppiumDriver getDriver(){
        return driver.get();
    }
    public void setDriver(AppiumDriver driver2){
        driver.set(driver2);
    }
    public void startDriver() throws Exception {
        AppiumDriver driver = null;

        if(driver == null){
            driver = new AndroidDriver(new ServerManager().getServer().getUrl(), new Capabilities().getCaps());

            // For IOS and AND try, switch,case and exception, example below
            //try{
              //  switch(params.getPlatformName()){
                //    case "Android":
                  //      driver= newAndroidDriver()....
                   // case "iOS":
                     //   driver = new IOSDriver())....;
                       // break;
            //} catch (IOException e) {
            //  e.printStackTrace();

            //throw e;
        }

        this.driver.set(driver);

        }
    }





