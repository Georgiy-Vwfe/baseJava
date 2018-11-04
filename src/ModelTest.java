import ru.model.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ModelTest {

    private static AbstractSection objective = new TextSection("Ведущий стажировок и корпоративного обучения по Java Web и Enterprise технологиям");
    private static AbstractSection personal = new TextSection("Аналитический склад ума, сильная логика, креативность, инициативность. Пурист кода и архитектуры.");

    private static String[] achievementList =
            {
                    "С 2013 года: разработка проектов \"Разработка Web приложения\",\"Java Enterprise\", \"Многомодульный maven. Многопоточность. XML (JAXB/StAX). Веб сервисы (JAX-RS/SOAP). Удаленное взаимодействие (JMS/AKKA)\". Организация онлайн стажировок и ведение проектов. Более 1000 выпускников.",
                    "Реализация двухфакторной аутентификации для онлайн платформы управления проектами Wrike. Интеграция с Twilio, DuoSecurity, Google Authenticator, Jira, Zendesk.",
                    "Налаживание процесса разработки и непрерывной интеграции ERP системы River BPM. Интеграция с 1С, Bonita BPM, CMIS, LDAP. Разработка приложения управления окружением на стеке: Scala/Play/Anorm/JQuery. Разработка SSO аутентификации и авторизации различных ERP модулей, интеграция CIFS/SMB java сервера.",
                    "Реализация c нуля Rich Internet Application приложения на стеке технологий JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT), Commet, HTML5, Highstock для алгоритмического трейдинга.",
                    "Создание JavaEE фреймворка для отказоустойчивого взаимодействия слабо-связанных сервисов (SOA-base архитектура, JAX-WS, JMS, AS Glassfish). Сбор статистики сервисов и информации о состоянии через систему мониторинга Nagios. Реализация онлайн клиента для администрирования и мониторинга системы по JMX (Jython/ Django).",
                    "Реализация протоколов по приему платежей всех основных платежных системы России (Cyberplat, Eport, Chronopay, Сбербанк), Белоруcсии(Erip, Osmp) и Никарагуа."
            };
    private static AbstractSection achievement = new ListSection(new ArrayList(Arrays.asList(achievementList)));

    private static String[] qualificationList =
            {
                    "JEE AS: GlassFish (v2.1, v3), OC4J, JBoss, Tomcat, Jetty, WebLogic, WSO2",
                    "Version control: Subversion, Git, Mercury, ClearCase, Perforce",
                    "DB: PostgreSQL(наследование, pgplsql, PL/Python), Redis (Jedis), H2, Oracle,",
                    "MySQL, SQLite, MS SQL, HSQLDB",
                    "Languages: Java, Scala, Python/Jython/PL-Python, JavaScript, Groovy,",
                    "XML/XSD/XSLT, SQL, C/C++, Unix shell scripts,",
                    "Java Frameworks: Java 8 (Time API, Streams), Guava, Java Executor, MyBatis, Spring (MVC, Security, Data, Clouds, Boot), JPA (Hibernate, EclipseLink), Guice, GWT(SmartGWT, ExtGWT/GXT), Vaadin, Jasperreports, Apache Commons, Eclipse SWT, JUnit, Selenium (htmlelements).",
                    "Python: Django.",
                    "JavaScript: jQuery, ExtJS, Bootstrap.js, underscore.js",
                    "Scala: SBT, Play2, Specs2, Anorm, Spray, Akka",
                    "Технологии: Servlet, JSP/JSTL, JAX-WS, REST, EJB, RMI, JMS, JavaMail, JAXB, StAX, SAX, DOM, XSLT, MDB, JMX, JDBC, JPA, JNDI, JAAS, SOAP, AJAX, Commet, HTML5, ESB, CMIS, BPMN2, LDAP, OAuth1, OAuth2, JWT.",
                    "Инструменты: Maven + plugin development, Gradle, настройка Ngnix,",
                    "администрирование Hudson/Jenkins, Ant + custom task, SoapUI, JPublisher, Flyway, Nagios, iReport, OpenCmis, Bonita, pgBouncer.",
                    "Отличное знание и опыт применения концепций ООП, SOA, шаблонов",
                    "проектрирования, архитектурных шаблонов, UML, функционального",
                    "программирования" +
                            "Родной русский, английский \"upper intermediate\""
            };
    private static AbstractSection qualifications = new ListSection(new ArrayList(Arrays.asList(qualificationList)));

    private static ComplexTextSection experience = new ComplexTextSection("Java Online Projects", "10/2013 - Сейчас", "Автор проекта.", "Создание, организация и проведение Java онлайн проектов и стажировок.");

    private static AbstractSection education = new ComplexTextSection("Coursera", "03/2013 - 05/2013", null, "\"Functional Programming Principles in Scala\" by Martin Odersky");

    public static void main(String[] args) {
        Map<SectionContacts, String> contacts = new HashMap<>();
        contacts.put(SectionContacts.PHONE_NUMBER, "+7(921) 855-0482");
        contacts.put(SectionContacts.SKYPE, "grigory.kislin");
        contacts.put(SectionContacts.EMAIL, "gkislin@yandex.ru");
        contacts.put(SectionContacts.LINKEDIN_PROFILE, "https://www.linkedin.com/in/gkislin");
        contacts.put(SectionContacts.GITHUB_PROFILE, "https://github.com/gkislin");
        contacts.put(SectionContacts.STACKOVERFLOW_PROFILE, "https://stackoverflow.com/users/548473");


        Map<SectionType, AbstractSection> sectionTypes = new HashMap<>();
        sectionTypes.put(SectionType.OBJECTIVE, objective);
        sectionTypes.put(SectionType.PERSONAL, personal);
        sectionTypes.put(SectionType.ACHIEVEMENT, achievement);
        sectionTypes.put(SectionType.QUALIFICATIONS, qualifications);
        sectionTypes.put(SectionType.EXPERIENCE, experience);
        sectionTypes.put(SectionType.EDUCATION, education);
        Resume r1 = new Resume("Григорий Кислин", contacts, sectionTypes);

        System.out.println(r1.toString());
    }

}
