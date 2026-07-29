public class PrivateCarSpeedRule implements Rule {
    private final int PrivateCarViolationSpeed = 80;
    private final int PrivateCarViolationFees = 300;

    @Override
    public String getViolationStatement(ObservationDetails observationDetails) {
        return "speed of " + observationDetails.speed + " exceeded max allowed " + PrivateCarViolationSpeed;
    }

    @Override
    public int getViolationFee() {
        return PrivateCarViolationFees;
    }

    @Override
    public boolean checkRuleViolation(ObservationDetails observationDetails) {
        return observationDetails.speed >= PrivateCarViolationSpeed && observationDetails.carType == CarType.PrivateCar;
    }

    @Override
    public String getRuleName() {
        return "Private Car Speed";
    }
}