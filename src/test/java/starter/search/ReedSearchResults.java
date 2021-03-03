package starter.search;

import net.serenitybdd.screenplay.targets.Target;

public class ReedSearchResults {
    public static final Target TITLE = Target.the("Reed search Results page")
            .locatedBy("//article[@class='job-result   ']");
}
