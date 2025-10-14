package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.ConnectionConfig;
import config.LocalConfig;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

import javax.annotation.Nonnull;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import static io.appium.java_client.remote.AutomationName.ANDROID_UIAUTOMATOR2;
import static io.appium.java_client.remote.MobilePlatform.ANDROID;
import static org.apache.commons.io.FileUtils.copyInputStreamToFile;

public class LocalDriver implements WebDriverProvider {
    private final LocalConfig localConfig = ConfigFactory.create(LocalConfig.class, System.getProperties());
    private final ConnectionConfig connectionConfig = ConfigFactory.create(ConnectionConfig.class, System.getProperties());

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {

        UiAutomator2Options options = new UiAutomator2Options();
        options.setAutomationName(ANDROID_UIAUTOMATOR2)
                .setPlatformName(ANDROID)
                .setPlatformVersion(localConfig.platformVersion())
                .setDeviceName(localConfig.deviceName())
                .setApp(getAppPath())
                .setAppPackage(connectionConfig.appPackage())
                .setAppActivity(connectionConfig.appActivity());

        return new AndroidDriver(getAppiumServerUrl(connectionConfig), options);
    }

    private URL getAppiumServerUrl(ConnectionConfig connectionConfig) {
        try {
            return new URL(connectionConfig.remoteUrl());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    private String getAppPath() {
        ConnectionConfig config = ConfigFactory.create(ConnectionConfig.class);
        File app = new File(config.appPath());
        if (!app.exists()) {
            try (InputStream in = new URL(config.appURL()).openStream()) {
                copyInputStreamToFile(in, app);
            } catch (IOException e) {
                throw new AssertionError("Failed to download application", e);
            }
        }
        return app.getAbsolutePath();
    }
}