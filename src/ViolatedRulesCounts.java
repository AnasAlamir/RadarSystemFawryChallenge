public class ViolatedRulesCounts{
    int privateCarSpeedViolationCount;
    int truckSpeedViolationCount;
    int seatBeltViolationCount;

    public ViolatedRulesCounts(int privateCarSpeedViolationCount, int truckSpeedViolationCount, int seatBeltViolationCount) {
        this.privateCarSpeedViolationCount = privateCarSpeedViolationCount;
        this.truckSpeedViolationCount = truckSpeedViolationCount;
        this.seatBeltViolationCount = seatBeltViolationCount;
    }

    @Override
    public String toString() {
        return "ViolatedRulesCounts{" +
                "privateCarSpeedViolationCount=" + privateCarSpeedViolationCount +
                ", truckSpeedViolationCount=" + truckSpeedViolationCount +
                ", seatBeltViolationCount=" + seatBeltViolationCount +
                '}';
    }

}