package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import screens.HabitsScreen;
import screens.SomeHabitScreen;
import screens.TrackScreen;
import screens.WelcomeScreen;

@Epic("Поток работы с приложением")
@Feature("Тесты онбординга")
@Story("Сценарии прохождения онбординга")
public class OnboardingTests extends TestBase{

    WelcomeScreen welcomeScreen = new WelcomeScreen();
    SomeHabitScreen someHabitScreen = new SomeHabitScreen();
    TrackScreen trackScreen = new TrackScreen();
    HabitsScreen habitsScreen = new HabitsScreen();

    @Tags({@Tag("onboarding"), @Tag("smoke")})
    @DisplayName("Тест листания экранов приветствия и настроек привычек")
    @Owner("oPalushina")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    void swapGettingStartedPreview() {
        welcomeScreen
                .checkTitleWelcome()
                .checkDescriptionWelcome()
                .checkImage()
                .checkSkipButton()
                .checkNextButton()
                .nextScreen();

        someHabitScreen
                .checkTitleHabit()
                .checkDescriptionHabit()
                .checkImage()
                .checkSkipButton()
                .checkNextButton()
                .nextScreen();

        trackScreen
                .checkTitleTrack()
                .checkDescriptionTrack()
                .checkImage();
        trackScreen
                .clickDone();

        habitsScreen.checkMainScreen();
    }
}
