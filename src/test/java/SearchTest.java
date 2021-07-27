import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class SearchTest {
    /**
     * This class does not work, Classifier do not support WebBrowser?
     * @throws MalformedURLException
     */
    @Test(enabled = false)
    public void testSearch() throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
        HashMap<String, String> customFindModules = new HashMap<>();
        customFindModules.put("ai", "test-ai-classifier");
        capabilities.setCapability("customFindModules", customFindModules);
        capabilities.setCapability("shouldUseCompactResponses", false);
        WebDriver driver = new AndroidDriver<>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);

        driver.get("http://amazon.com");
        driver.findElement(MobileBy.custom("ai:menu")).click();
        driver.quit();
    }
}
