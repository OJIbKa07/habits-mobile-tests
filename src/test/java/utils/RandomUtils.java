package utils;

import com.github.javafaker.Faker;

import java.util.*;

public class RandomUtils {

    Faker faker = new Faker(new Locale("en"));

    private final List<String> weekDays = List.of(
            "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"
    );

    public String getNameHabit() {
        return faker.harryPotter().spell();
    }

    public String getQuestionHabit() {
        return faker.chuckNorris().fact();
    }

    public String getNotesHabit() {
        return faker.harryPotter().quote();
    }

    public String getRandomUnit() {
        List<String> units = Arrays.asList(
                "minutes", "hour", "steps", "km", "m",
                "grams", "ml", "pieces", "servings",
                "pages"
        );

        return faker.options().option(units.toArray(new String[0]));
    }

    public String getRandomFrequency() {
        String[] options = {"Every day", "Every week", "Every month"};
        return faker.options().option(options);
    }

    public String getTargetType() {
        String[] options = {"At least", "At most"};
        return faker.options().option(options);
    }

    public String getRandomNumberAsString() {
        int number = faker.number().numberBetween(1, 100);

        return String.valueOf(number);
    }

    public List<String> getRandomWeekDays() {
        int count = faker.number().numberBetween(1, 7);

        List<String> shuffledDays = new ArrayList<>(weekDays);
        Collections.shuffle(shuffledDays);

        return shuffledDays.subList(0, count);
    }
}

