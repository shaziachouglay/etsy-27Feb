package starter.search;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ReedSearchResults {
    public static final Target TITLE = Target.the("Reed search Results page")
            .locatedBy("//article[@class='job-result   ']");

    public static final Target FILTERED_RESULT = Target.the("Filtered search results by Permanent filter")
            .locatedBy("//div[@class='metadata']//li[contains(.,'Permanent')]");
    public static final Target SELECT_DISTANCE = Target.the("Filtered search result by selecting distance")
            .located(By.id("refine-proximity"));

    public static final By FILTER_BY_DISTANCE = By.id("refine-proximity");
}
