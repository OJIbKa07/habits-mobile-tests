package screens;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.MobileBy;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;

public class CreatedHabitScreen {
    private SelenideElement
            toolbar = $(id("org.isoron.uhabits:id/toolbar")),
            frequencyLabel = $(id("org.isoron.uhabits:id/frequencyLabel")),
            questionLabel = $(id("org.isoron.uhabits:id/questionLabel")),
            targetText = $(id("org.isoron.uhabits:id/targetText")),
            habitNotesLabel  = $(id("org.isoron.uhabits:id/habitNotes")),
            reminderLabel = $(id("org.isoron.uhabits:id/reminderLabel")),
            moreOptionsButton = $(MobileBy.AccessibilityId("More options")),
            deleteButton = $("[text='Delete']"),
            confirmDeleteButton = $("[text='YES']");

    @Step("Проверить название созданной привычки в карточке привычки")
    public CreatedHabitScreen checkNameHabit(String nameHabit) {
        toolbar.$("[text='" + nameHabit + "']").shouldBe(visible);

        return this;
    }

    @Step("Проверить вопрос созданной привычки")
    public CreatedHabitScreen checkQuestionHabit(String questionHabit) {
        questionLabel.shouldHave(text(questionHabit));

        return this;
    }

    @Step("Проверить частоту привычки")
    public CreatedHabitScreen checkTargetHabit(String targetNumber, String unitHabit) {
        targetText.shouldHave(text(targetNumber + " " + unitHabit));

        return this;
    }

    @Step("Проверить заметку созданной привычки")
    public CreatedHabitScreen checkNotesHabit(String notesHabit) {
        habitNotesLabel.shouldHave(text(notesHabit));

        return this;
    }

    @Step("Проверить периодичность созданной привычки")
    public CreatedHabitScreen checkFrequencyHabit(String frequencyHabit) {
        frequencyLabel.shouldHave(text(frequencyHabit));

        return this;
    }

    @Step("Проверить периодичность созданной привычки")
    public CreatedHabitScreen checkReminderHabit() {
        reminderLabel.shouldBe(visible);

        return this;
    }


    @Step("Удалить привычку")
    public CreatedHabitScreen deleteHabit() {
        moreOptionsButton.click();
        deleteButton.click();
        confirmDeleteButton.click();

        return this;
    }
}
