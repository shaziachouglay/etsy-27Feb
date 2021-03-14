package starter.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import starter.search.FilterSearchResultsByDistance;
import starter.tasks.ReedJobSearchResults;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FilterSearchResultsSteps {
    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @When("^he filters search results using filter distance (.*)$")
    public void heFiltersSearchResultsUsingFilterDistanceDistance(String distance) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                FilterSearchResultsByDistance.bySelectingDistance(distance)
        );
    }

    @Then("^the distance filter should contain (.*)$")
    public void theDistanceFilterShouldContainDistance(String expectedDistance) {
        List<String> selectedDistance = OnStage.theActorInTheSpotlight().asksFor(ReedJobSearchResults.chosenDistance());
        System.out.println(selectedDistance);
        assertThat(selectedDistance).allMatch(
                distance -> distance.toLowerCase().contains(expectedDistance.toLowerCase())
        );
    }



}
