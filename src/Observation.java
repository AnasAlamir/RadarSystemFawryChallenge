import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Observation{
    final int TruckViolationSpeed = 60;
    final int PrivateCarViolationSpeed = 80;

    String plateNumber;
    LocalDate date;
    CarType carType;
    int speed;
    SeatbeltStatus seatbeltStatus;
    List<Violation> violations;


    public Observation(String plateNumber, LocalDate date, CarType carType, int speed, SeatbeltStatus seatbeltStatus) {
        this.plateNumber = plateNumber;
        this.date = date;
        this.carType = carType;
        this.speed = speed;
        this.seatbeltStatus = seatbeltStatus;
        this.violations = new ArrayList<>();
    }

    void observe(){
        if(this.seatbeltStatus == SeatbeltStatus.NotFastened)
            violations.add(new SeatBeltViolation());

        if(this.carType == CarType.Truck){
            if(this.speed >= TruckViolationSpeed)
                violations.add(new TruckSpeedViolation(this.speed));
        }
        else if (this.carType == CarType.PrivateCar) {
            if(this.speed >= PrivateCarViolationSpeed)
                violations.add(new PrivateCarSpeedViolation(this.speed));
        }
    }

    void generateFine() {
        System.out.println("Traffic fine for car " + this.plateNumber);
        int totalViolationsAmount = 0;
        for(Violation violation : violations) {
            totalViolationsAmount += violation.GetViolationFee();
        }
        System.out.println("Total amount: " + totalViolationsAmount);

        System.out.println("Violations:");
        if(!violations.isEmpty()) {
            for (Violation violation : violations) {
                System.out.println("- " + violation.GetViolationStatement() + " : " + violation.GetViolationFee() + " EGP");
            }
        }
        else {
            System.out.println("There are no violations");
        }
    }
}