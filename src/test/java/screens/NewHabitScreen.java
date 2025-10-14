package screens;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.MobileBy;
import io.qameta.allure.Step;

import java.util.List;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;

public class NewHabitScreen {

    private SelenideElement
            nameHabitInput = $(id("org.isoron.uhabits:id/nameInput")),
            questionHabitInput = $(id("org.isoron.uhabits:id/questionInput")),
            unitInput = $(id("org.isoron.uhabits:id/unitInput")),
            targetInput = $(id("org.isoron.uhabits:id/targetInput")),
            numericalFrequencyPicker = $(id("org.isoron.uhabits:id/numericalFrequencyPicker")),
            targetTypePicker = $(id("org.isoron.uhabits:id/targetTypePicker")),
            reminderTimePicker = $(id("org.isoron.uhabits:id/reminderTimePicker")),
            done_button = $(id("org.isoron.uhabits:id/done_button")),
            reminderDatePicker = $(id("org.isoron.uhabits:id/reminderDatePicker")),
            okButton = $("[text='OK']"),
            colorButton = $(id("org.isoron.uhabits:id/colorButton")),
            colorPickerRed = $(MobileBy.AccessibilityId("Color 1")),
            frequencyPicker = $(id("org.isoron.uhabits:id/boolean_frequency_picker")),
            everyXDayButton =  $(id("org.isoron.uhabits:id/everyXDaysRadioButton")),
            saveFrequencyButton = $("[text='SAVE']"),
            notesInput = $(id("org.isoron.uhabits:id/notesInput")),
            saveHabitButton = $(id("org.isoron.uhabits:id/buttonSave"));

    @Step("Ввести названия привычки")
    public NewHabitScreen enterNameHabbit(String nameHabit) {
        nameHabitInput.sendKeys(nameHabit);

        return this;
    }

    @Step("Ввести вопрос привычки")
    public NewHabitScreen enterQuestionHabbit(String questionHabit) {
        questionHabitInput.sendKeys(questionHabit);

        return this;
    }

    @Step("Ввести вопрос привычки")
    public NewHabitScreen enterUnitHabit(String unitHabit) {
        unitInput.sendKeys(unitHabit);

        return this;
    }

    @Step("Ввести цель по продолжительности привычки")
    public NewHabitScreen enterTargetHabit(String targetNumber) {
        targetInput.sendKeys(targetNumber);

        return this;
    }

    @Step("Выбрать цвет привычки")
    public NewHabitScreen pickColorHabit() {
        colorButton.click();
        colorPickerRed.click();

        return this;
    }

    @Step("Выбрать частоту привычки каждые Х дней")
    public NewHabitScreen pickFrequencyHabbit() {
        frequencyPicker.click();
        everyXDayButton.click();
        saveFrequencyButton.click();

        return this;
    }

    @Step("Изменить частоту привычки")
    public NewHabitScreen changeFrequencyHabbit(String frequencyHabit) {
        numericalFrequencyPicker.click();
        $("[text='" + frequencyHabit + "']").click();

        return this;
    }

    @Step("Выбрать тип привычки")
    public NewHabitScreen pickTargetType(String targetType) {
        targetTypePicker.click();
        $("[text='" + targetType + "']").click();

        return this;
    }

    @Step("Добавить напоминание")
    public NewHabitScreen addReminder(List<String> selectedDays) {
        reminderTimePicker.click();
        done_button.click();
        reminderDatePicker.click();
        for (String day : selectedDays) {
            $("[text='" + day + "']").click();
        }
        okButton.click();

        return this;
    }

    @Step("Ввести заметку для привычки")
    public NewHabitScreen enterNoteHabbit(String note) {
        notesInput.sendKeys(note);

        return this;
    }

    @Step("Сохранить привычку")
    public NewHabitScreen saveHabbit() {
        saveHabitButton.click();

        return this;
    }
}
