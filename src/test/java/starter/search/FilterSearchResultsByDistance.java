package starter.search;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.selectactions.SelectByValueFromBy;
import org.openqa.selenium.By;

public class FilterSearchResultsByDistance implements Performable {
    String distance;
    public FilterSearchResultsByDistance(String distance) {
        this.distance = distance;
    }

    public static Performable bySelectingDistance(String distance) {
        return new FilterSearchResultsByDistance(distance);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                new SelectByValueFromBy(distance,ReedSearchResults.FILTER_BY_DISTANCE)
        );
    }
}
