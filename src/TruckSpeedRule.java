public class TruckSpeedRule implements Rule {
    private final int TruckViolationSpeed = 60;
    final int TruckViolationFees = 500;

    @Override
    public String getViolationStatement(Observation observation) {
        return "speed of " + observation.speed + " exceeded max allowed " + TruckViolationSpeed;
    }

    @Override
    public int getViolationFee() {
        return TruckViolationFees;
    }

    @Override
    public boolean checkRuleViolation(Observation observation) {
        return observation.speed > TruckViolationSpeed && observation.carType == CarType.Truck;
    }

    @Override
    public String getRuleName() {
        return "Truck Speed";
    }
}