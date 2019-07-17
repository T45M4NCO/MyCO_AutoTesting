import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By;
import org.testng.annotations.*;
import java.net.URL;
import java.net.MalformedURLException;
import java.util.logging.Level;

public class appium {
    //private String reportDirectory = "reports";
    //private String reportFormat = "xml";
    //private String testName = "Untitled";
    protected AndroidDriver<AndroidElement> driver = null;

    DesiredCapabilities dc = new DesiredCapabilities();

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        //dc.setCapability("reportDirectory", reportDirectory);
        //dc.setCapability("reportFormat", reportFormat);
        //dc.setCapability("testName", testName);
        dc.setCapability(MobileCapabilityType.UDID, "emulator-5554");
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.soc.mycolorado");
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".ui.splash.SplashActivity");
        driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), dc);
        driver.setLogLevel(Level.INFO);
    }

    @Test
    public void testUntitled() {
        driver.findElement(By.xpath("//*[@text='or skip for now']")).click();
        new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='ALLOW']")));
        driver.findElement(By.xpath("//*[@text='ALLOW']")).click();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
