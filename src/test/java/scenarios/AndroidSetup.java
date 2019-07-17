package scenarios;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class AndroidSetup {

    protected AndroidDriver driver;

    protected void prepareAndroidForAppium() throws MalformedURLException {
        File appDir = new File("G:\\My Drive\\myColorado\\Apps");
        File app = new File(appDir, "myColorado_myColorado_v1.4b68.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("device","Android");

        //mandatory capabilities
        capabilities.setCapability("deviceName","Nexus5X_API28");
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("udid","emulator-5554");
        capabilities.setCapability("appPackage","com.soc.mycolorado");
        capabilities.setCapability("appActivity","com.soc.mycolorado.ui.splash.SplashActivity");

        //other caps
        capabilities.setCapability("app", app.getAbsolutePath());
        driver =  new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

}
