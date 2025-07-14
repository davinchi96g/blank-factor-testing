# BlankFactor Testing Project

This project is based on the [Serenity Cucumber Starter](https://github.com/serenity-bdd/serenity-cucumber-starter) template and uses the **Screenplay Pattern** for better maintainability and scalability. It is configured to run with **Maven** and implements **BDD** scenarios using **Gherkin** syntax.

---

## 📁 Project Structure

The project follows a Screenplay architecture and has been tested using **Maven**.

```
src
├── main
│   └── java
│       └── BlankFactor
│           ├── questions
│           ├── tasks
│           ├── userInterfaces
│           └── utils
└── test
    ├── java
    │   └── BlankFactor
    │       ├── runners
    │       │   └── CheckIndustriesIT.java     # Test runner
    │       └── stepdefinitions
    └── resources
        └── features.blankfactor
            └── check_industries_information.feature
```

---

## 🎯 Scenario Overview

This project automates a scenario where the actor (`David`) navigates through the **Industries** section of the BlankFactor website, selects a subsection, reads a paragraph triggered by hovering, and finally verifies the contact page URL and title.

> The test case is tagged with `@DesktopTest` to support potential viewport-based behavior.

```gherkin
@DesktopTest
Scenario: Validating Industries sections
Given David choose a header section
  | section    |
  | INDUSTRIES |
And he selects a subsection
  | subsection |
  | RETIREMENT |
When he wants to read the section "AI"
And he wants to start the page
Then he should be see right URL and Title's page
  | url                                  | title                 |
  | https://blankfactor.com/contact/     | Contact | Blankfactor |
```

---

## 🎭 Screenplay Implementation

This project follows the **Screenplay Pattern**, which organizes the automation code around *actors*, *tasks*, *interactions*, and *questions* for high readability and reusability.

### 💪 Step Definitions

```java
@Given("{actor} choose a header section")
public void chooseSection(Actor actor, List<Map<String, String>> section) {
    actor.wasAbleTo(NavigateTo.theBlankFactorPage());
    actor.attemptsTo(GoToASection.go(section.get(0).get("section")));
}

@When("{actor} wants to read the section {string}")
public void copySection(Actor actor, String section) {
    String copiedText = actor.asksFor(CopyTextFromCard.fromSection(section));
    System.out.println("Copied Text : " + copiedText);
}

@Then("{actor} should be see right URL and Title's page")
public void validatePage(Actor actor, List<Map<String, String>> pageData) {
    actor.attemptsTo(
        Ensure.that(TheWebPage.currentUrl()).isEqualTo(pageData.get(0).get("url")),
        Ensure.that(TheWebPage.title()).isEqualToIgnoringCase(pageData.get(0).get("title"))
    );
    System.out.println("Actual title: " + TheWebPage.title().answeredBy(actor));
}
```

---

## 🔧 Reusable Tasks and Components

### Navigation Task

```java
public class NavigateTo {
    public static Performable theBlankFactorPage() {
        return Task.where("{0} opens the Blank Factor home page",
            Open.browserOn().the(BlankFactorPage.class));
    }
}
```

### Select a Section Task

```java
public class GoToASection {
    public static Performable go(String section) {
        return Task.where("{0} hovers over the '" + section + "' section",
            Click.on(BlankFactorHomePage.ACCEPT_ALL),
            MoveMouse.to(TargetMap.from(section))
        );
    }
}
```

---

## 🌟 Locators and Target Mapping

Locators are managed using the `Target` class:

```java
public class RetirementAndWealthPage {
    public static Target AI = Target.the("AI section")
        .locatedBy("//div[@class='card-text' and normalize-space()='AI & Machine learning']");
}
```

Reusable targets are organized using a `Map` for dynamic access:

```java
private static final Map<String, Target> SECTIONS;

static {
    SECTIONS = new HashMap<>();
    SECTIONS.put("INDUSTRIES", BlankFactorHomePage.INDUSTRIES);
    SECTIONS.put("RETIREMENT", BlankFactorHomePage.RETIREMENT);
}
```

---

## ▶️ Running Tests

You can run the tests using Maven:

```bash
mvn clean verify
```

To run in **Firefox**, override the driver:

```bash
mvn clean verify -Ddriver=firefox
```

Test results and reports are generated under:

```
target/site/serenity
```

---

## 📍 Reports

The Serenity report will be automatically generated at the end of the test run using:

```bash
mvn serenity:aggregate
```

Or it is automatically included after `mvn verify` due to the `serenity-maven-plugin` configuration in `pom.xml`.

---

## ⚙️ Configuration

All WebDriver and Serenity configurations are defined in:

```
src/test/resources/serenity.conf
```

### WebDriver Example:

```hocon
webdriver {
  driver = chrome
}
headless.mode = true

chrome.switches = """
  --start-maximized;
  --test-type;
  --no-sandbox;
  --ignore-certificate-errors;
  --disable-popup-blocking;
  --disable-default-apps;
  --disable-extensions-file-access-check;
  --incognito;
  --disable-infobars;
  --disable-gpu
"""
```
### Test Cases Document (Excel)

As part of the program, an Excel document is included at the root of the repository. The second sheet of this document contains the Test Case Design.
```
Test_Cases_Desing_Login_Blank_Factor.xlsx
```

---
