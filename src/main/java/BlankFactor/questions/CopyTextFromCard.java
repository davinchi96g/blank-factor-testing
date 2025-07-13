package BlankFactor.questions;

import BlankFactor.utils.TargetMap;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.MoveMouse;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class CopyTextFromCard implements Question<String> {

    private final String sectionName;

    public CopyTextFromCard(String sectionName) {
        this.sectionName = sectionName.toUpperCase();
    }

    public static CopyTextFromCard fromSection(String sectionName) {
        return new CopyTextFromCard(sectionName);
    }

    @Override
    public String answeredBy(Actor actor) {
        Target hoverTarget = TargetMap.from(sectionName);
        Target backTarget = TargetMap.from(sectionName + "_BACK");

        actor.attemptsTo(
                Scroll.to(hoverTarget),
                MoveMouse.to(hoverTarget),
                WaitUntil.the(backTarget, isVisible()).forNoMoreThan(5).seconds()
        );

        return Text.of(backTarget).answeredBy(actor);
    }
}