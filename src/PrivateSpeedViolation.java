public class PrivateSpeedViolation implements Violation {
    int speed;

    public PrivateSpeedViolation(int speed) {
        this.speed = speed;
    }
    @Override
    public String GetViolationStatment() {
        return "speed of " + speed + " exceeded max allowed 80";
    }

    @Override
    public int GetViolationFee() {
        return 300;
    }
}