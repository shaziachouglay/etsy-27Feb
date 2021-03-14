package starter.search;

import net.serenitybdd.screenplay.targets.Target;

public class ReedSearchResults {
    public static final Target TITLE = Target.the("Reed search Results page")
            .locatedBy("//article[@class='job-result   ']");

    public static final Target FILTERED_RESULT = Target.the("Filtered search results by Permanent filter")
            .locatedBy("//div[@class='metadata']//li[contains(.,'Permanent')]");
}
