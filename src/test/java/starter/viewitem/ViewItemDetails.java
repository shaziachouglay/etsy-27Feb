package starter.viewitem;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.grid.web.servlet.LifecycleServlet;
import starter.navigation.NavigateTo;

import java.util.List;

public class ViewItemDetails implements Performable {
    private final Target LISTING_CARD = Target.the("listing card with id {0}")
            .locatedBy("//a[@data-listing-id='{0}']");

    public static Performable forOneOfTheItems() {
        return new ViewItemDetails();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        List<ListingCard> listingCards = actor.asksFor(DisplayedListingCard.details());
        ListingCard selectedItem = randomItemFrom(listingCards);
        System.out.println("SELECTED ITEM = " +selectedItem);
        actor.remember("SELECTED_TITLE",selectedItem);
        actor.attemptsTo(Click.on(LISTING_CARD.of(selectedItem.getDataListingId())),
                NavigateTo.windowContainingTheCardDetail());
    }

    private ListingCard randomItemFrom(List<ListingCard> itemTitles) {
        int max = Math.min(10,itemTitles.size());
        int chosenTitle = (int) (Math.random() * max);
        return itemTitles.get(chosenTitle);
    }
}
