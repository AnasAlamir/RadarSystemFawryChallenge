import java.time.LocalDate;
import java.util.Date;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Radar myRadar = new Radar();
        myRadar.addObservation(new Observation("ABC1234", LocalDate.now(), CarType.Private, 94, SeatbeltStatus.NotFastened));
        myRadar.showAllFines();
    }
}