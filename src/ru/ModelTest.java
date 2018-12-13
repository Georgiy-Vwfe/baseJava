package ru;

import ru.model.*;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.*;

import static ru.util.DateUtil.NOW;

public class ModelTest {
    public static Map<ContactType, String> contacts = new EnumMap<>(ContactType.class);
    public static Map<SectionType, AbstractSection> sections = new EnumMap<>(SectionType.class);

    public static void main(String[] args) {
        setup((EnumMap<ContactType, String>) contacts, (EnumMap<SectionType, AbstractSection>) sections);
        Resume r1 = new Resume("1", "Григорий Кислин");
        r1.setContacts(contacts);
        r1.setSections(sections);
        System.out.println(r1.toString());
    }

    public static void setup(EnumMap<ContactType, String> contacts, EnumMap<SectionType, AbstractSection> sections) {
        contacts.put(ContactType.PHONE_NUMBER, "+7(921) 855-0482");
        contacts.put(ContactType.SKYPE, "grigory.kislin");
        contacts.put(ContactType.EMAIL, "gkislin@yandex.ru");
        contacts.put(ContactType.LINKEDIN_PROFILE, "https://www.linkedin.com/in/gkislin");
        contacts.put(ContactType.GITHUB_PROFILE, "https://github.com/gkislin");
        contacts.put(ContactType.STACKOVERFLOW_PROFILE, "https://stackoverflow.com/users/548473");

        AbstractSection objective = new TextSection("Ведущий стажировок и корпоративного обучения по Java Web и Enterprise технологиям");
        AbstractSection personal = new TextSection("Аналитический склад ума, сильная логика, креативность, инициативность. Пурист кода и архитектуры.");

        String[] achievementList =
                {
                        "С 2013 года: разработка проектов \"Разработка Web приложения\",\"Java Enterprise\", \"Многомодульный maven. Многопоточность. XML (JAXB/StAX). Веб сервисы (JAX-RS/SOAP). Удаленное взаимодействие (JMS/AKKA)\". Организация онлайн стажировок и ведение проектов. Более 1000 выпускников.",
                        "Реализация двухфакторной аутентификации для онлайн платформы управления проектами Wrike. Интеграция с Twilio, DuoSecurity, Google Authenticator, Jira, Zendesk.",
                        "Налаживание процесса разработки и непрерывной интеграции ERP системы River BPM. Интеграция с 1С, Bonita BPM, CMIS, LDAP. Разработка приложения управления окружением на стеке: Scala/Play/Anorm/JQuery. Разработка SSO аутентификации и авторизации различных ERP модулей, интеграция CIFS/SMB java сервера.",
                        "Реализация c нуля Rich Internet Application приложения на стеке технологий JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT), Commet, HTML5, Highstock для алгоритмического трейдинга.",
                        "Создание JavaEE фреймворка для отказоустойчивого взаимодействия слабо-связанных сервисов (SOA-base архитектура, JAX-WS, JMS, AS Glassfish). Сбор статистики сервисов и информации о состоянии через систему мониторинга Nagios. Реализация онлайн клиента для администрирования и мониторинга системы по JMX (Jython/ Django).",
                        "Реализация протоколов по приему платежей всех основных платежных системы России (Cyberplat, Eport, Chronopay, Сбербанк), Белоруcсии(Erip, Osmp) и Никарагуа."
                };
        AbstractSection achievement = new ListSection(new ArrayList(Arrays.asList(achievementList)));
        String[] qualificationList =
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
                        "проектрирования, архитектурных шаблонов, UML, функционального программирования",
                        "Родной русский, английский \"upper intermediate\"",
                };
        AbstractSection qualifications = new ListSection(new ArrayList(Arrays.asList(qualificationList)));

        Organization[] experienceList = new Organization[]{
                new Organization(
                        new Link("Java Online Projects", "http://javaops.ru/"),
                        new ArrayList<>(Collections.singleton(
                                new Organization.Position(2013, Month.of(10), "Автор проекта.", "Создание, организация и проведение Java онлайн проектов и стажировок.")))
                ),
                new Organization(
                        new Link("Wrike", "https://www.wrike.com/"),
                        new ArrayList<>(Collections.singleton(
                                new Organization.Position(2014, Month.of(10), 2014, Month.of(10), "Старший разработчик (backend)", "Проектирование и разработка онлайн платформы управления проектами Wrike (Java 8 API, Maven, Spring, MyBatis, Guava, Vaadin, PostgreSQL, Redis). Двухфакторная аутентификация, авторизация по OAuth1, OAuth2, JWT SSO.")))
                ),
                new Organization(
                        new Link("RIT Center", null),
                        new ArrayList<>(Collections.singleton(
                                new Organization.Position(2012, Month.of(4), 2014, Month.of(10), "Автор проекта.", "Организация процесса разработки системы ERP для разных окружений: релизная политика, версионирование, ведение CI (Jenkins), миграция базы (кастомизация Flyway), конфигурирование системы (pgBoucer, Nginx), AAA via SSO. Архитектура БД и серверной части системы. Разработка интергационных сервисов: CMIS, BPMN2, 1C (WebServices), сервисов общего назначения (почта, экспорт в pdf, doc, html). Интеграция Alfresco JLAN для online редактирование из браузера документов MS Office. Maven + plugin development, Ant, Apache Commons, Spring security, Spring MVC, Tomcat,WSO2, xcmis, OpenCmis, Bonita, Python scripting, Unix shell remote scripting via ssh tunnels, PL/Python")))
                ),
                new Organization(
                        new Link("Luxoft (Deutsche Bank)", "http://www.luxoft.ru/"),
                        new ArrayList<>(Collections.singleton(
                                new Organization.Position(2010, Month.of(12), 2012, Month.of(4), "Ведущий программист", "Участие в проекте Deutsche Bank CRM (WebLogic, Hibernate, Spring, Spring MVC, SmartGWT, GWT, Jasper, Oracle). Реализация клиентской и серверной части CRM. Реализация RIA-приложения для администрирования, мониторинга и анализа результатов в области алгоритмического трейдинга. JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT), Highstock, Commet, HTML5.")))
                ),
                new Organization(
                        new Link("Yota", "https://www.yota.ru/"),
                        new ArrayList<>(Collections.singleton(
                                new Organization.Position(2008, Month.of(6), 2010, Month.of(12), "Ведущий специалист", "Дизайн и имплементация Java EE фреймворка для отдела \"Платежные Системы\" (GlassFish v2.1, v3, OC4J, EJB3, JAX-WS RI 2.1, Servlet 2.4, JSP, JMX, JMS, Maven2). Реализация администрирования, статистики и мониторинга фреймворка. Разработка online JMX клиента (Python/ Jython, Django, ExtJS)")))
                ),
                new Organization(
                        new Link("Enkata", "http://enkata.com/"),
                        new ArrayList<>(Collections.singleton(
                                new Organization.Position(2007, Month.of(3), 2008, Month.of(6), "Разработчик ПО", "Реализация клиентской (Eclipse RCP) и серверной (JBoss 4.2, Hibernate 3.0, Tomcat, JMS) частей кластерного J2EE приложения (OLAP, Data mining).")))
                ),
                new Organization(
                        new Link("Siemens AG", "https://www.siemens.com/ru/ru/home.html"),
                        new ArrayList<>(Collections.singleton(
                                new Organization.Position(2005, Month.of(1), 2007, Month.of(2), "Разработчик ПО", "Разработка информационной модели, проектирование интерфейсов, реализация и отладка ПО на мобильной IN платформе Siemens @vantage (Java, Unix).")))
                ),
                new Organization(
                        new Link("Alcatel", "http://www.alcatel.ru/"),
                        new ArrayList<>(Collections.singleton(
                                new Organization.Position(1997, Month.of(9), 2005, Month.of(1), "Инженер по аппаратному и программному тестированию", "Тестирование, отладка, внедрение ПО цифровой телефонной станции Alcatel 1000 S12 (CHILL, ASM).")))
                ),
        };
        AbstractSection experience = new OrganizationSection(new ArrayList(Arrays.asList(experienceList)));

        List<Organization.Position> list = new ArrayList<>();
        list.add(new Organization.Position(1993, Month.of(9), 1996, Month.of(7), "Аспирантура (программист С, С++)", null));
        list.add(new Organization.Position(1987, Month.of(9), 1993, Month.of(7), "Инженер (программист Fortran, C)", null));

        Organization[] educationList = new Organization[]{
                new Organization(
                        new Link("Coursera", "https://www.coursera.org/course/progfun"),
                        new ArrayList<>(Collections.singleton(
                                new Organization.Position(2013, Month.of(3), 2013, Month.of(5), "\"Functional Programming Principles in Scala\" by Martin Odersky", null)))
                ),
                new Organization(
                        new Link("Luxoft", "http://www.luxoft-training.ru/training/catalog/course.html?ID=22366"),
                        new ArrayList<>(Collections.singleton(
                                new Organization.Position(2011, Month.of(3), 2011, Month.of(4), "Курс \"Объектно-ориентированный анализ ИС. Концептуальное моделирование на UML.\"", null)))
                ),
                new Organization(
                        new Link("Siemens AG", "http://www.siemens.ru/"),
                        new ArrayList<>(Collections.singleton(
                                new Organization.Position(2005, Month.of(1), 2005, Month.of(4), "3 месяца обучения мобильным IN сетям (Берлин)", null)))
                ),
                new Organization(
                        new Link("Alcatel", "http://www.alcatel.ru/"),
                        new ArrayList<>(Collections.singleton(
                                new Organization.Position(1997, Month.of(9), 1998, Month.of(3), "6 месяцев обучения цифровым телефонным сетям (Москва)", null)))
                ),
                new Organization(
                        new Link("Санкт-Петербургский национальный исследовательский университет информационных технологий, механики и оптики", "http://www.ifmo.ru/"),
                        list
                ),
                new Organization(
                        new Link("Alcatel", "http://www.alcatel.ru/"),
                        new ArrayList<>(Collections.singleton(
                                new Organization.Position(1997, Month.of(9), 1998, Month.of(3), "6 месяцев обучения цифровым телефонным сетям (Москва)", null)))
                ),
                new Organization(
                        new Link("Заочная физико-техническая школа при МФТИ", "http://www.school.mipt.ru/"),
                        new ArrayList<>(Collections.singleton(
                                new Organization.Position(1984, Month.of(9), 1987, Month.of(6), "Закончил с отличием", null)))
                )
        };
        AbstractSection education = new OrganizationSection(new ArrayList(Arrays.asList(educationList)));

        sections.put(SectionType.OBJECTIVE, objective);
        sections.put(SectionType.PERSONAL, personal);
        sections.put(SectionType.ACHIEVEMENT, achievement);
        sections.put(SectionType.QUALIFICATIONS, qualifications);
        sections.put(SectionType.EXPERIENCE, experience);
        sections.put(SectionType.EDUCATION, education);
    }
}