package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import screens.NewHabitScreen;
import screens.CreatedHabitScreen;
import screens.HabitsScreen;
import screens.WelcomeScreen;
import test_data.DefaultValue;
import utils.RandomUtils;

import java.util.List;

@Epic("Поток работы с привычками")
@Feature("Тесты создания привычек")
@Story("Сценарии создания новых привычек")
public class CreateHabitsTests extends TestBase {
    WelcomeScreen welcomeScreen = new WelcomeScreen();
    HabitsScreen habitsScreen = new HabitsScreen();
    NewHabitScreen newHabitScreen = new NewHabitScreen();
    CreatedHabitScreen createdHabitScreen = new CreatedHabitScreen();
    RandomUtils faker = new RandomUtils();
    String nameHabit, questionHabit, unitHabit, targetNumber, notesHabit, frequencyHabit,
    targetType;
    List<String> weekDays;

    @Tags({@Tag("createHabits"), @Tag("smoke")})
    @Test
    @DisplayName("Тест создания привычки Да/Нет")
    @Owner("oPalushina")
    @Severity(SeverityLevel.BLOCKER)
    void createYesOrNoHabitTest() {
        nameHabit = faker.getNameHabit();
        questionHabit = faker.getQuestionHabit();
        notesHabit = faker.getNotesHabit();
        unitHabit = faker.getNameHabit();


        welcomeScreen.skipScreen();
        habitsScreen
                .createHabit()
                .createYesOrNoHabit();

        newHabitScreen
                .enterNameHabbit(nameHabit)
                .enterQuestionHabbit(questionHabit)
                .pickColorHabit()
                .pickFrequencyHabbit()
                .enterNoteHabbit(notesHabit)
                .saveHabbit();

        habitsScreen
                .checkCreatedHabit(nameHabit)
                .openHabitByName(nameHabit);

        createdHabitScreen
                .checkNameHabit(nameHabit)
                .checkQuestionHabit(questionHabit)
                .checkNotesHabit(notesHabit)
                .checkFrequencyHabit(DefaultValue.defaultFrequency);
    }

    @Tags({@Tag("createHabits"), @Tag("smoke")})
    @Test
    @DisplayName("Тест создания измеримой привычки")
    @Owner("oPalushina")
    @Severity(SeverityLevel.CRITICAL)
    void createMeasurableHabitTest() {
        nameHabit = faker.getNameHabit();
        questionHabit = faker.getQuestionHabit();
        notesHabit = faker.getNotesHabit();
        unitHabit = faker.getRandomUnit();
        targetNumber = faker.getRandomNumberAsString();
        frequencyHabit = faker.getRandomFrequency();
        targetType = faker.getTargetType();
        weekDays = faker.getRandomWeekDays();

        welcomeScreen.skipScreen();
        habitsScreen
                .createHabit()
                .createMeasurableHabit();

        newHabitScreen
                .enterNameHabbit(nameHabit)
                .enterQuestionHabbit(questionHabit)
                .enterUnitHabit(unitHabit)
                .enterTargetHabit(targetNumber)
                .changeFrequencyHabbit(frequencyHabit)
                .pickTargetType(targetType)
                .addReminder(weekDays)
                .pickColorHabit()
                .enterNoteHabbit(notesHabit)
                .saveHabbit();

        habitsScreen.handleSystemAlerts();

        habitsScreen
                .checkCreatedHabit(nameHabit)
                .openHabitByName(nameHabit);

        createdHabitScreen
                .checkNameHabit(nameHabit)
                .checkQuestionHabit(questionHabit)
                .checkTargetHabit(targetNumber, unitHabit)
                .checkFrequencyHabit(frequencyHabit)
                .checkReminderHabit()
                .checkNotesHabit(notesHabit);
    }
}
