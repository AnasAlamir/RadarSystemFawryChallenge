public class BeltViolation implements Violation {

    @Override
    public String GetViolationStatment() {
        return "Seatbelt not fastned";
    }

    @Override
    public int GetViolationFee() {
        return 100;
    }
}