package screens;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.MobileBy;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static io.appium.java_client.AppiumBy.id;

public class HabitsScreen {
    private SelenideElement
            createHabitButton = $(id("org.isoron.uhabits:id/actionCreateHabit")),
            yesOrNoHabitButton = $(id("org.isoron.uhabits:id/buttonYesNo")),
            measurableButtom  = $(id("org.isoron.uhabits:id/buttonMeasurable")),
            headerHabits = $("[text='Habits']");
    private SelenideElement allowButton;

    @Step("Проверяем, что открылся главный экран")
    public HabitsScreen checkMainScreen() {
        headerHabits.shouldBe(visible);

        return this;
    }

    @Step("Создать привычку")
    public HabitsScreen createHabit() {
        createHabitButton.click();

        return this;
    }

    @Step("Создать привычку Yes or No")
    public HabitsScreen createYesOrNoHabit() {
        yesOrNoHabitButton.click();

        return this;
    }

    @Step("Создать привычку Measurable")
    public HabitsScreen createMeasurableHabit() {
        measurableButtom.click();

        return this;
    }

    @Step("Проверить создание привычки на главном экране")
    public HabitsScreen checkCreatedHabit(String nameHabit) {
        $("[text='" + nameHabit + "']").shouldBe(visible);

        return this;
    }

    @Step("Открыть привычку по названию")
    public HabitsScreen openHabitByName(String nameHabit) {
        $("[text='" + nameHabit + "']").click();

        return this;
    }

    @Step("Проверить, что привычка удалена")
    public HabitsScreen checkDeleteHabit(String nameHabit) {
        $("[text='" + nameHabit + "']").shouldNotBe(visible);

        return this;
    }


    @Step("Обработать системные диалоги (разрешения / уведомления)")
    public void handleSystemAlerts() {
       allowButton = $(MobileBy.AndroidUIAutomator(
               "new UiSelector().textMatches(\"(?i)(разрешить|allow)\")"));

        if (allowButton.exists()) {
            allowButton.click();
        }
    }
}
