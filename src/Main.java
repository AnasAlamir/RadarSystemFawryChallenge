import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Radar myRadar = new Radar(List.of(
                new TruckSpeedViolation(),
                new PrivateCarSpeedViolation(),
                new SeatBeltViolation()
        ));
        myRadar.showAllFines();
        myRadar.addObservation(new Observation(new ObservationDetails("ABC1234", LocalDate.now(), CarType.PrivateCar, 94, SeatbeltStatus.NotFastened)));
        myRadar.addObservation(new Observation(new ObservationDetails("BBC2233", LocalDate.now(), CarType.PrivateCar, 24, SeatbeltStatus.Fastened)));
        myRadar.addObservation(new Observation(new ObservationDetails("CCC3344", LocalDate.now(), CarType.Truck, 65, SeatbeltStatus.Fastened)));
        myRadar.addObservation(new Observation(new ObservationDetails("DEF4455", LocalDate.now(), CarType.Truck, 30, SeatbeltStatus.NotFastened)));
        myRadar.showAllFines();

        System.out.println("==========================");
        System.out.println("getAllFines");
        List<GetFineDto> fineDtos = myRadar.getAllFines();
        for(var fineDto : fineDtos)
        {
            System.out.println(fineDto);
        }
        System.out.println("==========================");
        System.out.println("getAllViolationsCounts");
        System.out.println(myRadar.getAllViolationsCounts());
    }
}