package drivers;

import com.codeborne.selenide.WebDriverProvider;

public class DriverFactory {

    public static WebDriverProvider getDriver() {
        String deviceHost = System.getProperty("deviceHost", "local");

        return switch (deviceHost) {
            case "local" -> new LocalDriver();
            case "remote" -> new BrowserstackDriver();
            default -> throw new RuntimeException("Unknown deviceHost: " + deviceHost);
        };
    }
}
