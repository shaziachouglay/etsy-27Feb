package starter.tasks;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import starter.search.ReedSearchResults;

import java.util.List;

public class ReedJobSearchResults {
    public static Question<List<String>> descriptions() {
        return Text.of(ReedSearchResults.TITLE).asAList();
    }

    public static Question<List<String>> filteredResult() {
        return Text.of(ReedSearchResults.FILTERED_RESULT).asAList();
    }
}
