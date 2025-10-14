package screens;

import io.qameta.allure.Step;

public class SomeHabitScreen extends BaseScreen {

    private String
            habitLabel = "Create some new habits",
            habitDescription = "Every day, after performing your habit, put a checkmark on the app.";

    @Step("Проверяем заголовок экрана Create some new habits}")
    public SomeHabitScreen checkTitleHabit() {
        checkTitle(habitLabel);

        return this;
    }

    @Step("Проверяем описание экрана Welcome")
    public SomeHabitScreen checkDescriptionHabit() {
        checkDescription(habitDescription);

        return this;
    }
}
