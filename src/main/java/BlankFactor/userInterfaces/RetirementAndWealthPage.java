package BlankFactor.userInterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class RetirementAndWealthPage {
    public static Target AI = Target.the("AI section").locatedBy("//div[@class='card-text' and normalize-space()='AI & Machine learning']");
    public static Target AI_BACK = Target.the("AI Back").locatedBy("(//div[@class='card-text small'])[3]");
    public static Target BUTTON_START = Target.the("Button start").locatedBy("//div[@class='footer__header']//a[contains(@title, 'get started')]");

}
