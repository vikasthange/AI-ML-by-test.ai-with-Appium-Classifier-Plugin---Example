import ai.test.classifier_client.ClassifierClient;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class SearchSettingsTest {

    /**
     * @Author - Vikas Thange
     * @email vikasthange@gmail.com
     * @date July 26, 2021
     */
    AppiumDriver<WebElement> driver=null;
    @BeforeMethod
    public void setup() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.android.settings.Settings");
        capabilities.setCapability("fastReset", "true");
        HashMap<String, String> customFindModules = new HashMap<>();
        customFindModules.put("ai", "test-ai-classifier");
        capabilities.setCapability("customFindModules", customFindModules);
        capabilities.setCapability("shouldUseCompactResponses", false);
//        capabilities.setCapability("testaiFindMode","object_detection");
        capabilities.setCapability("testaiObjDetectionDebug","true");
        System.out.print("Launching app");
        driver = new AndroidDriver<>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
        ((AndroidDriver)driver).startActivity(new Activity("com.android.settings","com.android.settings.Settings"));
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }
    @Test
    public void testSearch() {

        System.out.println("Clicking on search");
        driver.findElement(MobileBy.custom("ai:search")).click();
        System.out.println("typing bluetooth");
        new Actions(driver).sendKeys("bluetooth").build().perform();;
        System.out.println("clicking on bluetooth icon from search result");
        driver.findElement(MobileBy.custom("ai:bluetooth")).click();
        System.out.println("Reading screen title");
        boolean connectionPrefIsDisplayed = driver.findElement(By.xpath("//*[contains(@text,'Connection preferences')]")).isDisplayed();
        Assert.assertTrue(connectionPrefIsDisplayed,"Connection preferences - Screen not shown");
    }
    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        if(driver!=null){
            driver.quit();
        }
    }
}
