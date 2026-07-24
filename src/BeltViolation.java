public class BeltViolation implements Violation {

    @Override
    public String GetViolationStatement() {
        return "Seatbelt not fastned";
    }

    @Override
    public int GetViolationFee() {
        return 100;
    }
}