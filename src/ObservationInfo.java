import java.time.LocalDate;

public class ObservationInfo {
    String PlateNumber;
    LocalDate date;
    CarType carType;
    int speed;
    SeatbeltStatus seatbeltStatus;

    public ObservationInfo(String plateNumber, LocalDate date, CarType carType, int speed, SeatbeltStatus seatbeltStatus) {
        PlateNumber = plateNumber;
        this.date = date;
        this.carType = carType;
        this.speed = speed;
        this.seatbeltStatus = seatbeltStatus;
    }
}