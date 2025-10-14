package tests;

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

@Epic("Поток работы с привычками")
@Feature("Тесты управления привычками")
@Story("Сценарии работы с существующими привычками")
public class WorkingWithHabitsTests extends TestBase {
    WelcomeScreen welcomeScreen = new WelcomeScreen();
    HabitsScreen habitsScreen = new HabitsScreen();
    NewHabitScreen newHabitScreen = new NewHabitScreen();
    CreatedHabitScreen createdHabitScreen = new CreatedHabitScreen();
    RandomUtils faker = new RandomUtils();
    String nameHabit;

    @Tags({@Tag("working"), @Tag("smoke")})
    @DisplayName("Тест удаления привычки")
    @Owner("oPalushina")
    @Severity(SeverityLevel.CRITICAL)
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
