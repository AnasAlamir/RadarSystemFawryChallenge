public class PrivateCarSpeedViolation implements Violation {
    final int PrivateCarViolationSpeed = 80;
    final int PrivateCarViolationFees = 300;

    @Override
    public String getViolationStatement(ObservationDetails observationDetails) {
        return "speed of " + observationDetails.speed + " exceeded max allowed " + PrivateCarViolationSpeed;
    }

    @Override
    public int getViolationFee() {
        return PrivateCarViolationFees;
    }

    @Override
    public boolean checkViolation(ObservationDetails observationDetails) {
        return observationDetails.speed >= PrivateCarViolationSpeed && observationDetails.carType == CarType.PrivateCar;
    }
}