public class PrivateCarSpeedViolation implements Violation {
    int speed;

    public PrivateCarSpeedViolation(int speed) {
        this.speed = speed;
    }
    @Override
    public String GetViolationStatement() {
        return "speed of " + speed + " exceeded max allowed 80";
    }

    @Override
    public int GetViolationFee() {
        return 300;
    }
}