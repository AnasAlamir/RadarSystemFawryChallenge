import java.util.List;

public class Fine {

    static void generateFine(Observation observation) {
        System.out.println("Traffic fine for car " + observation.observationDetails.plateNumber);
        System.out.println("Total amount: " + getTotalViolationsAmount(observation.violations));
        System.out.println("Violations:");
        if(!observation.violations.isEmpty()) {
            for (Violation violation : observation.violations) {
                System.out.println(violation.getViolationDetails(observation.observationDetails));
            }
        }
        else {
            System.out.println("There are no violations");
        }
    }

    static GetFineDto get(Observation observation){
        return new GetFineDto(observation.observationDetails.plateNumber, Fine.getTotalViolationsAmount(observation.violations));
    }

    static public int getTotalViolationsAmount(List<Violation> violations) {
        int totalViolationsAmount = 0;
        for(Violation violation : violations) {
            totalViolationsAmount += violation.ruleViolated.getViolationFee();
        }
        return totalViolationsAmount;
    }
}
