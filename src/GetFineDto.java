public class GetFineDto{
    String plateNumber;
    int totalViolationsAmount;

    public GetFineDto(String plateNumber, int totalViolationsAmount) {
        this.plateNumber = plateNumber;
        this.totalViolationsAmount = totalViolationsAmount;
    }

    @Override
    public String toString() {
        return "GetFineDto{" +
                "plateNumber='" + plateNumber + '\'' +
                ", totalViolationsAmount=" + totalViolationsAmount +
                '}';
    }
}