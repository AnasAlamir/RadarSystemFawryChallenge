public class SeatBeltViolation implements Violation {
    final int SeatBeltViolationFees = 100;

    @Override
    public String getViolationStatement(ObservationDetails observationDetails) {
        return "Seatbelt not fastened";
    }

    @Override
    public int getViolationFee() {
        return SeatBeltViolationFees;
    }

    @Override
    public boolean checkViolation(ObservationDetails observationDetails) {
        return observationDetails.seatbeltStatus == SeatbeltStatus.NotFastened;
    }
}