package BlankFactor.userInterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class BlankFactorHomePage {
    public static Target INDUSTRIES = Target.the("industries section").locatedBy("//ul[@id='menu-main-menu']//span[normalize-space()='Industries']");
    public static Target RETIREMENT = Target.the("wealth retirement").locatedBy("//img[@alt='Retirement and wealth']");
    public static Target ACCEPT_ALL = Target.the("acept all").locatedBy("//button[@data-cky-tag='accept-button']");

}
