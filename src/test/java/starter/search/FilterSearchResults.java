package starter.search;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;

import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import org.openqa.selenium.By;

import java.util.HashMap;
import java.util.Map;

import static net.serenitybdd.screenplay.Task.*;
import static org.openqa.selenium.By.xpath;
import static starter.search.JobType.*;

public class FilterSearchResults implements Performable {

    public FilterSearchResults(JobType jobType) {
        this.jobType = jobType;
    }

    public FilterSearchResults() {
    }


    public static Performable bySelecting(JobType jobType) {
        return new FilterSearchResults(jobType);
    }

    static Map<JobType, By> JOB_TYPE_BUTTONS = new HashMap<>();

    static {
        JOB_TYPE_BUTTONS.put(Permanent, xpath("//li[@data-jobtype='Perm']"));
        JOB_TYPE_BUTTONS.put(Temporary, xpath("//li[@data-jobtype='Temp']"));
    }


    JobType jobType;

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(JOB_TYPE_BUTTONS.get(jobType)));
    }

}