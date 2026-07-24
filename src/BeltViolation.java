public class BeltViolation implements Violation {

    @Override
    public String GetViolationStatement() {
        return "Seatbelt not fastened";
    }

    @Override
    public int GetViolationFee() {
        return 100;
    }
}