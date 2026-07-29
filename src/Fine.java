import java.util.List;

public class Fine {
    List<Violation> violations;
    Observation observation;

    public Fine(List<Violation> violations, Observation observation) {
        this.violations = violations;
        this.observation = observation;
    }

    public void generateFine() {
        System.out.println("Traffic fine for car " + observation.plateNumber);
        System.out.println("Total amount: " + getTotalViolationsAmount(violations));
        System.out.println("Violations:");
        for (Violation violation : violations) {
            System.out.println(violation.getViolationDetails(observation));
        }

    }

    GetFineDto get(){
        return new GetFineDto(observation.plateNumber, getTotalViolationsAmount(violations));
    }

    public int getTotalViolationsAmount(List<Violation> violations) {
        int totalViolationsAmount = 0;
        for(Violation violation : violations) {
            totalViolationsAmount += violation.ruleViolated.getViolationFee();
        }
        return totalViolationsAmount;
    }
}
