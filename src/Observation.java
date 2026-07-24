import java.util.ArrayList;
import java.util.List;

public class Observation{
    ObservationInfo observationInfo;
    List<Violation> violations;

    public Observation(ObservationInfo observationInfo) {
        this.observationInfo = observationInfo;
        this.violations = new ArrayList<>();
    }

    List<Violation> observe(){

        if(this.observationInfo.seatbeltStatus == SeatbeltStatus.NotFastened)
            violations.add(new BeltViolation());

        if(this.observationInfo.carType == CarType.Truck){
            if(this.observationInfo.speed >= 60)
                violations.add(new TruckSpeedViolation(this.observationInfo.speed));
        }
        else if (this.observationInfo.carType == CarType.Private) {
            if(this.observationInfo.speed >= 80)
                violations.add(new PrivateSpeedViolation(this.observationInfo.speed));
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