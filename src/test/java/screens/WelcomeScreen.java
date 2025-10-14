package screens;

import io.qameta.allure.Step;

public class WelcomeScreen extends BaseScreen {
    private String
            welcomeLabel = "Welcome",
            welcomeDescription = "Loop Habit Tracker helps you create and maintain good habits.";

    @Step("Проверяем заголовок экрана Welcome}")
    public WelcomeScreen checkTitleWelcome() {
        checkTitle(welcomeLabel);

        return this;
    }

    @Step("Проверяем описание экрана Welcome")
    public WelcomeScreen checkDescriptionWelcome() {
        checkDescription(welcomeDescription);

        return this;
    }
}
