import java.time.LocalDate;

public class ObservationDetails {
    String plateNumber;
    LocalDate date;
    CarType carType;
    int speed;
    SeatbeltStatus seatbeltStatus;

    public ObservationDetails(String plateNumber, LocalDate date, CarType carType, int speed, SeatbeltStatus seatbeltStatus) {
        this.plateNumber = plateNumber;
        this.date = date;
        this.carType = carType;
        this.speed = speed;
        this.seatbeltStatus = seatbeltStatus;
    }
}
