package tests;

import helpers.allure.annotations.Manual;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static io.qameta.allure.Allure.step;

public class ManualTests {

    @Test
    @Manual
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Отметка выполнения привычки")
    public void markAsComplete() {
        step("Открыть приложение Habits");
        step("Нажать кнопку Skip");
        step("Создать привычку кликнув по +");
        step("Ввести название привычки");
        step("Сохранить новую привычку");
        step("В строке созданной привычки кликнуть по Х");
    }

    @Test
    @Manual
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Проверка сортировки привычек по имени")
    public void sortHabitsByName() {
        step("Открыть приложение Habits");
        step("Нажать кнопку Skip");
        step("Создать 3 любых привычки и сохранить");
        step("На главном экране в строке Habits кликнуть на значок перевернутой пирамиды");
        step("Раскрыть раздел Sort и выбрать опцию By name");
    }

    @Test
    @Manual
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Проверка включения темной темы")
    public void darkThemeOn() {
        step("Открыть приложение Habits");
        step("Нажать кнопку Skip");
        step("На главном экране в строке Habits кликнуть на троеточие");
        step("Активировать чекбокс Dark Theme");
    }

    @Test
    @Manual
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Проверка открытия настроек приложения")
    public void openSettings() {
        step("Открыть приложение Habits");
        step("Нажать кнопку Skip");
        step("На главном экране в строке Habits кликнуть на троеточие");
        step("Кликнуть по Settings");
    }

}

