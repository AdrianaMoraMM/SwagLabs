package Utils;

public class GlobalParameters {
    private static ThreadLocal<String> platformName = new ThreadLocal<String>();
    private static ThreadLocal<String> udid = new ThreadLocal<String>();
    private static ThreadLocal<String> deviceName = new ThreadLocal<String>();
    private static ThreadLocal<String> systemPort = new ThreadLocal<String>();
    private static ThreadLocal<String> chromeDriverPort = new ThreadLocal<String>();


    public void setPlatformName(String platformName1){
        platformName.set(platformName1);
    }

    public String getPlatformName(){
        return platformName.get();
    }

    public String getUDID() {
        return udid.get();
    }

    public void setUDID(String udid2) {
        udid.set(udid2);
    }

    public String getDeviceName() {
        return deviceName.get();
    }

    public void setDeviceName(String deviceName2) {
        deviceName.set(deviceName2);
    }

    public String getSystemPort() {
        return systemPort.get();
    }

    public void setSystemPort(String systemPort2) {
        systemPort.set(systemPort2);
    }

    public String getChromeDriverPort() {
        return chromeDriverPort.get();
    }

    public void setChromeDriverPort(String chromeDriverPort2) {
        chromeDriverPort.set(chromeDriverPort2);
    }


    public void initializeGlobalParams(){
        GlobalParameters params = new GlobalParameters();
        params.setPlatformName(System.getProperty("platformName", "Android"));
        params.setUDID(System.getProperty("udid", "a8c6503f"));
        params.setDeviceName(System.getProperty("deviceName", "lavender"));
        params.setSystemPort(System.getProperty("systemPort", "10000"));
        params.setChromeDriverPort(System.getProperty("chromeDriverPort", "11000"));

        // For IOS and AND try, switch,case and exception, example below
        //switch(params.getPlatformName()){
          //  case "Android":
            //params.set.....
            //break;
            //case "iOS":
              //  params.setWdaLocalPort(System.getProperty("wdaLocalPort", "10001"));
               // params.setWebkitDebugProxyPort(System.getProperty("webkitDebugProxyPort", "11001"));
               // break;
            //default:
              //  throw new IllegalStateException("Invalid Platform Name!");
        }
}
