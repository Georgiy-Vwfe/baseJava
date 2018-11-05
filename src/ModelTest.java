import ru.model.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ModelTest {

    private static AbstractSection objective = new TextSection("Text 1");
    private static AbstractSection personal = new TextSection("Text 2");

    private static String[] achievementList =
            {
                    "Line 1",
                    "Line 2",
                    "Line 3"
            };
    private static AbstractSection achievement = new ListSection(new ArrayList(Arrays.asList(achievementList)));

    private static String[] qualificationList =
            {
                    "Line 1",
                    "Line 2",
                    "Line 3",
                    "Line 4",
                    "Line 5"
            };
    private static AbstractSection qualifications = new ListSection(new ArrayList(Arrays.asList(qualificationList)));

    private static ComplexTextSection experience = new ComplexTextSection("Java Online Projects", LocalDate.of(2013, 10, 1), LocalDate.now(), "Автор проекта.", "Создание, организация и проведение Java онлайн проектов и стажировок.");

    private static AbstractSection education = new ComplexTextSection("Coursera", LocalDate.of(2013, 3, 1), LocalDate.of(2013, 5, 1), "\"Functional Programming Principles in Scala\" by Martin Odersky", null);

    public static void main(String[] args) {

        Map<ContactType, String> contacts = new HashMap<>();
        contacts.put(ContactType.PHONE_NUMBER, "+7(921) 855-0482");
        contacts.put(ContactType.SKYPE, "grigory.kislin");
        contacts.put(ContactType.EMAIL, "gkislin@yandex.ru");
        contacts.put(ContactType.LINKEDIN_PROFILE, "https://www.linkedin.com/in/gkislin");
        contacts.put(ContactType.GITHUB_PROFILE, "https://github.com/gkislin");
        contacts.put(ContactType.STACKOVERFLOW_PROFILE, "https://stackoverflow.com/users/548473");


        Map<SectionType, AbstractSection> sectionTypes = new HashMap<>();
        sectionTypes.put(SectionType.OBJECTIVE, objective);
        sectionTypes.put(SectionType.PERSONAL, personal);
        sectionTypes.put(SectionType.ACHIEVEMENT, achievement);
        sectionTypes.put(SectionType.QUALIFICATIONS, qualifications);
        sectionTypes.put(SectionType.EXPERIENCE, experience);
        sectionTypes.put(SectionType.EDUCATION, education);
        Resume r1 = new Resume("0", "Григорий Кислин", contacts, sectionTypes);

        System.out.println(r1.toString());
    }
}
