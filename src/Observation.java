import java.time.LocalDate;

public class Observation{
    String plateNumber;
    LocalDate date;
    CarType carType;
    int speed;
    SeatbeltStatus seatbeltStatus;

    public Observation(String plateNumber, LocalDate date, CarType carType, int speed, SeatbeltStatus seatbeltStatus) {
        this.plateNumber = plateNumber;
        this.date = date;
        this.carType = carType;
        this.speed = speed;
        this.seatbeltStatus = seatbeltStatus;
    }
}