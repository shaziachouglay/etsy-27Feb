package starter.search;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import org.openqa.selenium.Keys;

public class SearchesForItems {
    public static Performable with(String keyword) {
        return Task.where("search for "+keyword,
                Enter.theValue(keyword).into(SearchBar.SEARCH_FIELD)
                .thenHit(Keys.ENTER));
    }
}
