import java.util.ArrayList;
import java.util.List;

public class Observation{
    ObservationDetails observationDetails;
    List<Violation> violations;

    public Observation(ObservationDetails observationDetails) {
        this.observationDetails = observationDetails;
        this.violations = new ArrayList<>();
    }

    void observe(List<Violation> rules){
        for (Violation violation : rules) {
            if (violation.checkViolation(observationDetails))
                violations.add(violation);
        }
    }

    void generateFine() {
        System.out.println("Traffic fine for car " + observationDetails.plateNumber);
        int totalViolationsAmount = 0;
        for(Violation violation : violations) {
            totalViolationsAmount += violation.getViolationFee();
        }
        System.out.println("Total amount: " + totalViolationsAmount);

        System.out.println("Violations:");
        if(!violations.isEmpty()) {
            for (Violation violation : violations) {
                System.out.println("- " + violation.getViolationStatement(observationDetails) + " : " + violation.getViolationFee() + " EGP");
            }
        }
        else {
            System.out.println("There are no violations");
        }
    }
}