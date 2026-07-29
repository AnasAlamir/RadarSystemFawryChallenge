public class SeatBeltRule implements Rule {
    private final int SeatBeltViolationFees = 100;

    @Override
    public String getViolationStatement(ObservationDetails observationDetails) {
        return "Seatbelt not fastened";
    }

    @Override
    public int getViolationFee() {
        return SeatBeltViolationFees;
    }

    @Override
    public boolean checkRuleViolation(ObservationDetails observationDetails) {
        return observationDetails.seatbeltStatus == SeatbeltStatus.NotFastened;
    }

    @Override
    public String getRuleName() {
        return "Seat Belt";
    }
}