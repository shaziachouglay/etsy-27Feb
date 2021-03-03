package starter.search;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import org.openqa.selenium.Keys;

public class SearchForJobs  {
    public static Performable using(String jobType, String location) {
        return Task.where("search for "+jobType +"at" + location,
                Enter.theValue(jobType).into(SearchBar.JOB_TYPE_SEARCH_FIELD),
                Enter.theValue(location).into(SearchBar.LOCATION)
        .thenHit(Keys.ENTER));
    }

}
