package starter.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.assertj.core.api.Assertions;
import starter.navigation.NavigateTo;
import starter.search.FilterSearchResults;
import starter.search.JobType;
import starter.search.SearchForJobs;
import starter.tasks.ReedJobSearchResults;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class ReedJobSearch {

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }


    @Given("^(.*) a non registered user has opened the reed application$")
    public void arielANonRegisteredUserHasOpenedTheReedApplication(String actorName) {
        OnStage.theActor(actorName).attemptsTo(
                NavigateTo.theReedHomePage()
        );
    }

    @When("she searches for job by type of job {string} and location {string}")
    public void sheSearchesForJobByTypeOfJobAndLocation(String jobType, String location) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                SearchForJobs.using(jobType,location)
        );
    }

    @Then("she should be able to see jobs related to the type of job searched for {string}")
    public void sheShouldBeAbleToSeeJobsRelatedToTheTypeOfJobSearchedFor(String expectedResult) {
        List<String> displayedReedResults =
                OnStage.theActorInTheSpotlight().asksFor(ReedJobSearchResults.descriptions());

        assertThat(displayedReedResults).allMatch(
                result -> result.toLowerCase().contains(expectedResult.toLowerCase())
        );
    }


    @Given("^(.*) has already performed search for a job by type of job (.*) and location (.*)$")
    public void dannyHasAlreadyPerformedSearchForAJobByTypeOfJobAndLocation(String actor,String jobType, String location) {
        OnStage.theActor(actor).attemptsTo(
                NavigateTo.theReedHomePage(),
                SearchForJobs.using(jobType,location));
    }


    @When("^he filters the search result using filter of (.*)$")
    public void heFiltersTheSearchResultUsingFilterOfJobType(JobType jobType) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                FilterSearchResults.bySelecting(jobType)
        );
    }
    @Then("^he should be able to see jobs search results containing (.*)$")
    public void heShouldBeAbleToSeeJobsSearchResultsContainingJobType(String expectedResult) {
        List<String> displayedFilteredResult = OnStage.theActorInTheSpotlight()
                .asksFor(ReedJobSearchResults.filteredResult());
        assertThat(displayedFilteredResult).allMatch(
                result-> result.toLowerCase().contains(expectedResult.toLowerCase())
        );

    }
}
