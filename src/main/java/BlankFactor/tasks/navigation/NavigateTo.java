package BlankFactor.tasks.navigation;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public class NavigateTo {
    public static Performable theBlankFactorPage() {
        return Task.where("{0} opens the Blank Factor home page",
                Open.browserOn().the(BlankFactorPage.class));
    }
}
