package tests;

import helpers.allure.annotations.Layer;
import helpers.allure.annotations.Microservice;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import screens.CreatedHabitScreen;
import screens.HabitsScreen;
import screens.NewHabitScreen;
import screens.WelcomeScreen;
import utils.RandomUtils;

@Owner("oPalushina")
@Layer("mobile")
@Microservice("Habits")
@Tag("mobile")
@Epic("Поток работы с привычками")
@Feature("Управление существующими привычками (Mobile UI)")
@Story("Сценарии работы с существующими привычками")
@DisplayName("Mobile UI: Тесты управления привычками")
public class WorkingWithHabitsTests extends TestBase {
    WelcomeScreen welcomeScreen = new WelcomeScreen();
    HabitsScreen habitsScreen = new HabitsScreen();
    NewHabitScreen newHabitScreen = new NewHabitScreen();
    CreatedHabitScreen createdHabitScreen = new CreatedHabitScreen();
    RandomUtils faker = new RandomUtils();
    String nameHabit;

    @Tags({@Tag("working"), @Tag("smoke")})
    @DisplayName("Mobile UI: Удаление существующей привычки")
    @Owner("oPalushina")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Создаёт новую привычку, открывает её карточку и удаляет. Проверяет, что привычка исчезла из общего списка")
    @Test
    void deleteHabitTest() {
        nameHabit = faker.getNameHabit();

        welcomeScreen.skipScreen();

        habitsScreen
                .createHabit()
                .createYesOrNoHabit();

        newHabitScreen
                .enterNameHabbit(nameHabit)
                .saveHabbit();

        habitsScreen
                .checkCreatedHabit(nameHabit)
                .openHabitByName(nameHabit);

        createdHabitScreen
                .deleteHabit();

        habitsScreen.checkDeleteHabit(nameHabit);
    }
}
