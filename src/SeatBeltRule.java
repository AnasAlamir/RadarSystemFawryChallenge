public class SeatBeltRule implements Rule {
    private final int SeatBeltViolationFees = 100;

    @Override
    public String getViolationStatement(Observation observation) {
        return "Seatbelt not fastened";
    }

    @Override
    public int getViolationFee() {
        return SeatBeltViolationFees;
    }

    @Override
    public boolean checkRuleViolation(Observation observation) {
        return observation.seatbeltStatus == SeatbeltStatus.NotFastened;
    }

    @Override
    public String getRuleName() {
        return "Seat Belt";
    }
}