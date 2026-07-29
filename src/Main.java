import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Radar myRadar = new Radar(List.of(
                new TruckSpeedRule(),
                new PrivateCarSpeedRule(),
                new SeatBeltRule()
        ));
        myRadar.displayAllFines();
        myRadar.processObservation(new Observation("ABC1234", LocalDate.now(), CarType.PrivateCar, 94, SeatbeltStatus.NotFastened));
        myRadar.processObservation(new Observation("BBC2233", LocalDate.now(), CarType.PrivateCar, 24, SeatbeltStatus.Fastened));
        myRadar.processObservation(new Observation("CCC3344", LocalDate.now(), CarType.Truck, 65, SeatbeltStatus.Fastened));
        myRadar.processObservation(new Observation("DEF4455", LocalDate.now(), CarType.Truck, 30, SeatbeltStatus.NotFastened));
        myRadar.displayAllFines();

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