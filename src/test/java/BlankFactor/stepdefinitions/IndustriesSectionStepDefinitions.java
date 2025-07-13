package BlankFactor.stepdefinitions;

import BlankFactor.questions.CopyTextFromCard;
import BlankFactor.userInterfaces.RetirementAndWealthPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.page.TheWebPage;
import BlankFactor.tasks.navigation.NavigateTo;
import BlankFactor.tasks.GoToASection;
import BlankFactor.tasks.SelectSubSection;
import net.serenitybdd.screenplay.actions.Click;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

import java.util.List;
import java.util.Map;


public class IndustriesSectionStepDefinitions {
    @Given("{actor} choose a header section")
    public void chooseSection(Actor actor, List<Map<String, String>> section) {
        actor.wasAbleTo(NavigateTo.theBlankFactorPage());
        actor.attemptsTo(GoToASection.go(section.get(0).get("section")));

    }
    @And("{actor} selects a subsection")
    public void chooseSubSection(Actor actor, List<Map<String, String>> subSection) {
        actor.attemptsTo(SelectSubSection.go(subSection.get(0).get("subsection"))
        );

    }
    @When("{actor} wants to read the section {string}")
    public void copySection(Actor actor, String section) {
        String copiedText = actor.asksFor(CopyTextFromCard.fromSection(section));
        System.out.println("Copied Text : " + copiedText);


    }
    @And("{actor} wants to start the page")
    public void startPage(Actor actor) {
        actor.attemptsTo(Click.on(RetirementAndWealthPage.BUTTON_START));
    }
    @Then("{actor} should be see right URL and Title's page")
    public void validatePage(Actor actor, List<Map<String, String>> pageData) {
        actor.attemptsTo(
                Ensure.that(TheWebPage.currentUrl()).isEqualTo(pageData.get(0).get("url")),
                Ensure.that(TheWebPage.title()).isEqualToIgnoringCase(pageData.get(0).get("title"))
        );
        System.out.println("Actual title: " + TheWebPage.title().answeredBy(actor));

    }
}
