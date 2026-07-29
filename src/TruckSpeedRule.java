public class TruckSpeedRule implements Rule {
    private final int TruckViolationSpeed = 60;
    final int TruckViolationFees = 500;

    @Override
    public String getViolationStatement(ObservationDetails observationDetails) {
        return "speed of " + observationDetails.speed + " exceeded max allowed " + TruckViolationSpeed;
    }

    @Override
    public int getViolationFee() {
        return TruckViolationFees;
    }

    @Override
    public boolean checkRuleViolation(ObservationDetails observationDetails) {
        return observationDetails.speed >= TruckViolationSpeed && observationDetails.carType == CarType.Truck;
    }

    @Override
    public String getRuleName() {
        return "Truck Speed";
    }
}