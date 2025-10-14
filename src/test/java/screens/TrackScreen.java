package screens;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;

public class TrackScreen extends BaseScreen {
    private String
            trackLabel = "rack your progress",
            trackDescription = "Detailed graphs show you how your habits improved over time.";

    private SelenideElement doneButton = $(id("org.isoron.uhabits:id/done"));

    @Step("Проверяем заголовок экрана Welcome}")
    public TrackScreen checkTitleTrack() {
        checkTitle(trackLabel);

        return this;
    }

    @Step("Проверяем описание экрана Welcome")
    public TrackScreen checkDescriptionTrack() {
        checkDescription(trackDescription);

        return this;
    }

    @Step("Кликаем кнопку Done")
    public TrackScreen clickDone() {
        doneButton.click();

        return this;
    }
}
