package setup;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;

public class SetupMyAppiumDriver {

    private AppiumDriver appiumDriver;

    public SetupMyAppiumDriver() throws IOException {

        File classpathRoot = new File(System.getProperty("user.dir"));
        File appDir = new File(classpathRoot, "src/test/resources/apps");
        File app = new File(appDir.getCanonicalPath(), "ApiDemos-debug.apk");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
        capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());

        // Default value is a virtual device
        boolean isTestRealDevice = Boolean.getBoolean("test.real.device");
        if(!isTestRealDevice){
            capabilities.setCapability(AndroidMobileCapabilityType.AVD, "Pixel_4a_API_30");
        }else{
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "0041282805");
        }

        appiumDriver = new AppiumDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);

        appiumDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));

    }

    public AppiumDriver getAppiumDriver() {
        return appiumDriver;
    }

}