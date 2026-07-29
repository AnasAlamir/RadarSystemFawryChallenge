public class PrivateCarSpeedRule implements Rule {
    private final int PrivateCarViolationSpeed = 80;
    private final int PrivateCarViolationFees = 300;

    @Override
    public String getViolationStatement(Observation observation) {
        return "speed of " + observation.speed + " exceeded max allowed " + PrivateCarViolationSpeed;
    }

    @Override
    public int getViolationFee() {
        return PrivateCarViolationFees;
    }

    @Override
    public boolean checkRuleViolation(Observation observation) {
        return observation.speed > PrivateCarViolationSpeed && observation.carType == CarType.PrivateCar;
    }

    @Override
    public String getRuleName() {
        return "Private Car Speed";
    }
}