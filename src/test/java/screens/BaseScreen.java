package screens;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;

public class BaseScreen {
    protected final SelenideElement
            skipButton = $(id("org.isoron.uhabits:id/skip")),
            nextButton = $(id("org.isoron.uhabits:id/next")),
            titleLanguageScreen = $(id("org.isoron.uhabits:id/title")),
            imageScreen = $(id("org.isoron.uhabits:id/image")),
            descriptionLanguageScreen = $(id("org.isoron.uhabits:id/description"));

    @Step("Пропустить Welcome экран")
    public BaseScreen skipScreen() {
        skipButton.click();

        return this;
    }

    @Step("Перейти к следующему экрану")
    public BaseScreen nextScreen() {
        nextButton.click();

        return this;
    }

    @Step("Проверяем текст заголовка: {expectedTitle}")
    public BaseScreen checkTitle(String expectedTitle) {
        titleLanguageScreen.shouldHave(text(expectedTitle));

        return this;
    }

    @Step("Проверяем, что на экране есть изображение")
    public BaseScreen checkImage() {
        imageScreen.shouldBe(visible);

        return this;
    }

    @Step("Проверяем, что на экране есть кнопка Skip")
    public BaseScreen checkSkipButton() {
        skipButton.shouldBe(visible);

        return this;
    }

    @Step("Проверяем, что на экране есть кнопка Next")
    public BaseScreen checkNextButton() {
        nextButton.shouldBe(visible);

        return this;
    }

    @Step("Проверяем текст описания экрана: {expectedDescription}")
    public BaseScreen checkDescription(String expectedDescription) {
        descriptionLanguageScreen.shouldHave(text(expectedDescription));

        return this;
    }

}
