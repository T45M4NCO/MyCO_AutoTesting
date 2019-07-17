package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class LogIn {

    public AndroidDriver<MobileElement> driver;
    public WebDriverWait wait;

    //Elements
    //String secondNewJob = "//android.widget.FrameLayout[2]/android.widget.LinearLayout/" +
    //        "android.widget.RelativeLayout/android.widget.ImageView";

    @BeforeMethod
    public void setup () throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Nexus5X_API28");
        caps.setCapability("udid", "emulator-5554"); //DeviceId from "adb devices" command
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "9.0");
        caps.setCapability("skipUnlock","true");
        caps.setCapability("appPackage", "com.soc.mycolorado");
        caps.setCapability("appActivity","com.soc.mycolorado.ui.splash.SplashActivity");
        caps.setCapability("noReset","false");
        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),caps);
        wait = new WebDriverWait(driver, 30);
    }

/*
    @Test
    public void basicTest () throws InterruptedException {
        //Click and pass Splash
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.id("com.soc.mycolorado:id/tv_login_skip_id"))).click();

        //Click I am searching a job
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//*[@text='ALLOW']"))).click();


        //Notification Allow
        //if (driver.findElements(By.id("com.android.packageinstaller:id/permission_allow_button")).size()>0) {
        //    driver.findElements(By.id("com.android.packageinstaller:id/permission_allow_button")).get(0).click();
        //}

        //wait.until(ExpectedConditions.visibilityOfElementLocated
        //        (By.xpath(secondNewJob)));
    }
*/
@Test
public void testUntitled() {
    driver.findElement(By.xpath("//*[@text='or skip for now']")).click();
    //new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='ALLOW']")));
    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='ALLOW']")));
    driver.findElement(By.xpath("//*[@text='ALLOW']")).click();
}

    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}