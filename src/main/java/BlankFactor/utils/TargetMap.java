package BlankFactor.utils;
import BlankFactor.userInterfaces.BlankFactorHomePage;
import BlankFactor.userInterfaces.RetirementAndWealthPage;
import net.serenitybdd.screenplay.targets.Target;

import java.util.Map;
import java.util.HashMap;

import static java.util.Map.*;

public class TargetMap {

    private static final Map<String, Target> SECTIONS;

    static {
        SECTIONS = new HashMap<>();
        SECTIONS.put("INDUSTRIES", BlankFactorHomePage.INDUSTRIES);
        SECTIONS.put("RETIREMENT", BlankFactorHomePage.RETIREMENT);
        SECTIONS.put("AI", RetirementAndWealthPage.AI);
        SECTIONS.put("AI_BACK", RetirementAndWealthPage.AI_BACK);
        SECTIONS.put("BUTTON_START", RetirementAndWealthPage.BUTTON_START);

    }

    public static Target from(String sectionName) {
        Target target = SECTIONS.get(sectionName.toUpperCase());
        if (target == null) {
            throw new IllegalArgumentException("No Target defined for section: " + sectionName);
        }
        return target;
    }
}
