import java.util.ArrayList;
import java.util.List;

public class Observation{
    ObservationInfo observationInfo;
    List<Violation> violations;

    public Observation(ObservationInfo observationInfo) {
        this.observationInfo = observationInfo;
        this.violations = new ArrayList<>();
    }

    List<Violation> observe(ObservationInfo observationInfo){

        if(observationInfo.seatbeltStatus == SeatbeltStatus.NotFastened)
            violations.add(new BeltViolation());

        if(observationInfo.carType == CarType.Truck){
            if(observationInfo.speed >= 60)
                violations.add(new TruckSpeedViolation(observationInfo.speed));
        } else if (observationInfo.carType == CarType.Private) {
            if(observationInfo.speed >= 80)
                violations.add(new PrivateSpeedViolation(observationInfo.speed));
        }

        return violations;
    }
    void generateFine() {
        System.out.println("Traffic fine for car " + observationInfo.PlateNumber);
        int totalViolationsAmount = 0;
        for(Violation violation : violations) {
            totalViolationsAmount += violation.GetViolationFee();
        }
        System.out.println("Total amount: " + totalViolationsAmount);

        System.out.println("Violations:");
        for(Violation violation : violations)
        {
            System.out.println("- " + violation.GetViolationStatment() + " : " + violation.GetViolationFee() + " EGP");
        }
    }


}