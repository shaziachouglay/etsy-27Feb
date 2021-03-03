package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import org.assertj.core.api.Assertions;
import starter.navigation.NavigateTo;
import starter.search.SearchesForItems;
import starter.tasks.DisplayedItems;
import starter.viewitem.ItemDetailsPage;
import starter.viewitem.ListingCard;
import starter.viewitem.ViewItemDetails;

import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class SearchForProductSteps {

    @Given("^(.*) is searching for product on Etsy$")
    public void sharonIsSearchingForProductOnEtsy(String actorName) {
        OnStage.theActor(actorName).attemptsTo(NavigateTo.theEtsyHomePage());
    }

    @When("^(.*) searches for '(.*)'$")
    public void sheSearchesForMasks(String actorName, String keyword) {
        OnStage.theActorInTheSpotlight().attemptsTo(SearchesForItems.with(keyword));
    }

    @Then("^she should only be shown product related to '(.*)'$")
    public void sheShouldOnlyBeShownProductRelatedToMask(String keyword) {
        List<String> listedItems =
        OnStage.theActorInTheSpotlight().asksFor(DisplayedItems.descriptions());
        Assertions.assertThat(listedItems).allMatch(description ->
                description.toLowerCase().contains(keyword.toLowerCase()));
    }

    @Given("^(.*) performed a search for '(.*)'$")
    public void sharonPerformedASearchForMask(String actorName, String keyword) {
        OnStage.theActor(actorName).attemptsTo(NavigateTo.theEtsyHomePage());
        OnStage.theActorInTheSpotlight().attemptsTo(SearchesForItems.with(keyword));
    }

    @When("she views the details for the first listed item")
    public void sheViewsTheDetailsForTheFirstListedItem() {
        OnStage.theActorInTheSpotlight().attemptsTo(ViewItemDetails.forOneOfTheItems());
    }

    @Then("the correct details for the listed item should be displayed")
    public void theCorrectDetailsForTheListedItemShouldBeDisplayed() {
        Actor actor = OnStage.theActorInTheSpotlight();
        ListingCard selectedItemDetails = actor
                .recall("SELECTED_TITLE");
        actor.should(seeThat(WebElementQuestion.the(ItemDetailsPage.ITEM_TITLE),
                WebElementStateMatchers.containsText(selectedItemDetails.getTitle())));
    }
}
