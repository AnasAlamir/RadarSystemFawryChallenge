import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Observation{

    String PlateNumber;
    LocalDate date;
    CarType carType;
    int speed;
    SeatbeltStatus seatbeltStatus;
    List<Violation> violations;

    public Observation(String plateNumber, LocalDate date, CarType carType, int speed, SeatbeltStatus seatbeltStatus) {
        PlateNumber = plateNumber;
        this.date = date;
        this.carType = carType;
        this.speed = speed;
        this.seatbeltStatus = seatbeltStatus;
        this.violations = new ArrayList<>();
    }

    void observe(){
        if(this.seatbeltStatus == SeatbeltStatus.NotFastened)
            violations.add(new BeltViolation());

        if(this.carType == CarType.Truck){
            if(this.speed >= 60)
                violations.add(new TruckSpeedViolation(this.speed));
        }
        else if (this.carType == CarType.Private) {
            if(this.speed >= 80)
                violations.add(new PrivateSpeedViolation(this.speed));
        }
    }

    void generateFine() {
        System.out.println("Traffic fine for car " + this.PlateNumber);
        int totalViolationsAmount = 0;
        for(Violation violation : violations) {
            totalViolationsAmount += violation.GetViolationFee();
        }
        System.out.println("Total amount: " + totalViolationsAmount);

        System.out.println("Violations:");
        for(Violation violation : violations)
        {
            System.out.println("- " + violation.GetViolationStatement() + " : " + violation.GetViolationFee() + " EGP");
        }
    }
}