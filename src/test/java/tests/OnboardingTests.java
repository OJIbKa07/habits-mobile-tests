package tests;

import helpers.allure.annotations.Layer;
import helpers.allure.annotations.Microservice;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import screens.HabitsScreen;
import screens.SomeHabitScreen;
import screens.TrackScreen;
import screens.WelcomeScreen;

@Owner("oPalushina")
@Layer("mobile")
@Microservice("Onboarding")
@Tag("mobile")
@Epic("Поток работы с приложением")
@Feature("Онбординг (Mobile UI)")
@Story("Сценарии прохождения онбординга")
@DisplayName("Mobile UI: Тесты онбординга приложения")
public class OnboardingTests extends TestBase{

    WelcomeScreen welcomeScreen = new WelcomeScreen();
    SomeHabitScreen someHabitScreen = new SomeHabitScreen();
    TrackScreen trackScreen = new TrackScreen();
    HabitsScreen habitsScreen = new HabitsScreen();

    @Tags({@Tag("onboarding"), @Tag("smoke")})
    @DisplayName("Mobile UI: Листание экранов онбординга и переход к главному экрану")
    @Owner("oPalushina")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Проверяет поочерёдное отображение экранов онбординга: проверка заголовков, описаний, изображений и кнопок, завершение онбординга и переход на главный экран")
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
