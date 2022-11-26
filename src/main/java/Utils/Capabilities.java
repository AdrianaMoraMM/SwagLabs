package Utils;

import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

public class Capabilities {
    public DesiredCapabilities getCaps() throws IOException {
        GlobalParameters params = new GlobalParameters();
        Properties props = new PropertyManager().getProps();
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, params.getPlatformName());
        caps.setCapability(MobileCapabilityType.UDID, params.getUDID());
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, params.getDeviceName());
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, props.getProperty("androidAutomationName"));
        caps.setCapability("appPackage", props.getProperty("androidAppPackage"));
        caps.setCapability("appActivity", props.getProperty("androidAppActivity"));
        caps.setCapability("systemPort", params.getSystemPort());
        caps.setCapability("chromeDriverPort", params.getChromeDriverPort());
        String androidAppUrl = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
                + File.separator + "resources" + File.separator + "Android.SauceLabs.Mobile.Sample.app.2.7.1.apk";

        caps.setCapability("app", androidAppUrl);

        return caps;

      // For IOS and AND try, switch,case and exception, example below
        //  try{
        //switch(params.getPlatformName()){
        // case "Android":
            //caps.setCapability (MobileCapa.....
        // case "iOS":
            //caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, props.getProperty("iOSAutomationName"));
            //String iOSAppUrl = getClass().getResource(props.getProperty("iOSAppLocation")).getFile();
            //String iOSAppUrl = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
            //      + File.separator + "resources"  + File.separator + "SwagLabsMobileApp.app";
            // caps.setCapability("bundleId", props.getProperty("iOSBundleId"));
            // caps.setCapability("wdaLocalPort", params.getWdaLocalPort());
            // caps.setCapability("webkitDebugProxyPort", params.getWebkitDebugProxyPort());
            // caps.setCapability("app", iOSAppUrl);
            // break;
            //}
        //} catch(Exception e){
          //  e.printStackTrace();
            //throw e;
       // }
    }

    }

