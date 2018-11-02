import ru.model.AbstractLabelSection;
import ru.model.Resume;
import ru.model.SectionContacts;
import ru.model.SectionType;

import java.util.HashMap;
import java.util.Map;

public class ModelTest {

    public static void main(String[] args) {
        Map<SectionContacts, String> contacts = new HashMap<>();
        contacts.put(SectionContacts.PHONE_NUMBER, "+7(921) 855-0482");
        contacts.put(SectionContacts.SKYPE, "grigory.kislin");
        contacts.put(SectionContacts.EMAIL, "gkislin@yandex.ru");
        contacts.put(SectionContacts.LINKEDIN_PROFILE, "https://www.linkedin.com/in/gkislin");
        contacts.put(SectionContacts.GITHUB_PROFILE, "https://github.com/gkislin");
        contacts.put(SectionContacts.STACKOVERFLOW_PROFILE, "https://stackoverflow.com/users/548473");

        Map<SectionType, AbstractLabelSection> sectionTypes = new HashMap<>();
        //sectionTypes.put(SectionType.OBJECTIVE, );
        Resume r1 = new Resume("Григорий Кислин", contacts, sectionTypes);

    }

}
