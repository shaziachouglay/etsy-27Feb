package starter.navigation;

import net.serenitybdd.screenplay.targets.Target;

public class CookieDialog {
    public static final Target ACCEPT_BUTTON = Target.the("accept the cookies")
            .locatedBy("//button[contains(.,'Accept')]");
    public static final Target ACCEPT_BUTTON_REED = Target.the("accept the cookies")
            .locatedBy("//button[@id='onetrust-accept-btn-handler']");
}
