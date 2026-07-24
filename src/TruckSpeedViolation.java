public class TruckSpeedViolation implements Violation {

    int speed;

    public TruckSpeedViolation(int speed) {
        this.speed = speed;
    }

    @Override
    public String GetViolationStatement() {
        return "speed of " + speed + " exceeded max allowed 60";
    }

    @Override
    public int GetViolationFee() {
        return 500;
    }
}