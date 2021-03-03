package starter.navigation;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actions.Switch;
import org.openqa.selenium.WebDriver;

public class NavigateTo {
    public static Performable theWikipediaHomePage() {
        return Task.where("{0} opens the Wikipedia home page",
                Open.browserOn().the(WikipediaHomePage.class));
    }

    public static Performable theEtsyHomePage() {
        return Task.where("{0} opens the etsy page",
                Open.browserOn().the(EtsyHomePage.class),
                Click.on(CookieDialog.ACCEPT_BUTTON));
    }

    public static Performable windowContainingTheCardDetail() {
        return Task.where("{0} switches tab to view the item detail",
               actor -> actor.attemptsTo(Switch.toWindow(otherWindowVisibleTo(actor))));
    }

    private static String otherWindowVisibleTo(Actor actor) {
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        String currentWindowHandle = driver.getWindowHandle();
        return driver.getWindowHandles().stream().filter(
                windowHandle -> !windowHandle.equals(currentWindowHandle))
                .findFirst().orElseThrow(NoBrowserTabWasOpenedException::new);

    }

    public static Performable theReedHomePage() {
        return Task.where("{0} opens the Reed Home Page",
                Open.browserOn().the(ReedHomePage.class),
                Click.on(CookieDialog.ACCEPT_BUTTON_REED));
    }
}
