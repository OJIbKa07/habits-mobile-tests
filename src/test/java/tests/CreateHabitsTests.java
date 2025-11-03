package tests;

import helpers.allure.annotations.Layer;
import helpers.allure.annotations.Microservice;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import screens.NewHabitScreen;
import screens.CreatedHabitScreen;
import screens.HabitsScreen;
import screens.WelcomeScreen;
import utils.RandomUtils;

import java.util.List;

@Owner("oPalushina")
@Layer("mobile")
@Microservice("Habits")
@Tag("mobile")
@Epic("Поток работы с привычками")
@Feature("Создание привычек (Mobile UI)")
@Story("Сценарии создания новых привычек")
@DisplayName("Mobile UI: Тесты создания привычек")
public class CreateHabitsTests extends TestBase {
    WelcomeScreen welcomeScreen = new WelcomeScreen();
    HabitsScreen habitsScreen = new HabitsScreen();
    NewHabitScreen newHabitScreen = new NewHabitScreen();
    CreatedHabitScreen createdHabitScreen = new CreatedHabitScreen();
    RandomUtils faker = new RandomUtils();
    String nameHabit, questionHabit, unitHabit, targetNumber, notesHabit, frequencyHabit,
    targetType;
    List<String> weekDays;
    String defaultFrequency;

    @Tags({@Tag("createHabits"), @Tag("smoke")})
    @Test
    @DisplayName("Mobile UI: Создание привычки типа Да/Нет")
    @Owner("oPalushina")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Проверяет создание бинарной привычки (Да/Нет): ввод имени, вопроса, заметки, выбор цвета и частоты, сохранение и проверка созданной карточки")
    void createYesOrNoHabitTest() {
        defaultFrequency = "Every 3 days";

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
                .checkFrequencyHabit(defaultFrequency);
    }

    @Tags({@Tag("createHabits"), @Tag("smoke")})
    @Test
    @DisplayName("Mobile UI: Создание измеримой привычки")
    @Owner("oPalushina")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Создание привычки с измеримым значением: ввод имени, вопроса, таргета, единицы измерения, напоминаний, сохранение и проверка всех данных на карточке привычки")
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
