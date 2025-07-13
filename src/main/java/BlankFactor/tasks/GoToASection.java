package BlankFactor.tasks;

import BlankFactor.userInterfaces.BlankFactorHomePage;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.MoveMouse;
import BlankFactor.utils.TargetMap;
import net.serenitybdd.screenplay.actions.Click;

public class GoToASection {

    public static Performable go(String section) {

        return Task.where("{0} hovers over the '" + section + "' section",
                Click.on(BlankFactorHomePage.ACCEPT_ALL),MoveMouse.to(TargetMap.from(section))
        );
    }
}