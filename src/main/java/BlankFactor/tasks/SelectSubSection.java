package BlankFactor.tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import BlankFactor.utils.TargetMap;


public class SelectSubSection {

    public static Performable go(String section) {

        return Task.where("{0} select the '" + section + "' subsection",
                Click.on(TargetMap.from(section))
        );
    }

}