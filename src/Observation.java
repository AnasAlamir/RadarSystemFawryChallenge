import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Observation{
    ObservationDetails observationDetails;
    List<Violation> violations;

    public Observation(ObservationDetails observationDetails) {
        this.observationDetails = observationDetails;
        this.violations = new ArrayList<>();
    }
    public void CreateViolation(Rule rule)
    {
        violations.add(new Violation(rule));
    }
}