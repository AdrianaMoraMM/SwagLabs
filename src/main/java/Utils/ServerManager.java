package Utils;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServerHasNotBeenStartedLocallyException;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

import java.io.File;


public class ServerManager {
    private static ThreadLocal<AppiumDriverLocalService> server = new ThreadLocal<>();


    public AppiumDriverLocalService getServer(){
        return server.get();
    }

    public void startServer(){

        AppiumDriverLocalService server = WindowsGetAppiumService();
        server.start();
        if(server == null || !server.isRunning()){

            throw new AppiumServerHasNotBeenStartedLocallyException("Appium server not started. ABORT!!!");
        }
//
        this.server.set(server);

    }

    public AppiumDriverLocalService WindowsGetAppiumService() {
        GlobalParameters params = new GlobalParameters();
        return AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
                .usingAnyFreePort()
                .withArgument(GeneralServerFlag.SESSION_OVERRIDE)
                .withLogFile(new File(params.getPlatformName() + "_"
                        + params.getDeviceName() + File.separator + "Server.log")));
    }

}
