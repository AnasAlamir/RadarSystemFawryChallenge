import java.util.ArrayList;
import java.util.List;

public class Radar {
    List<Observation> observations = new ArrayList<>();

    void addObservation(Observation observation)
    {
        observations.add(observation);
        observation.observe();
    }
    void showAllFines()
    {
        if(!observations.isEmpty()) {
            for (Observation observation : observations) {
                observation.generateFine();
            }
        }
        else {
            System.out.println("No Fines yet");
        }
    }

    List<GetFineDto> getAllFines()
    {
        List<GetFineDto> getFineDtos = new ArrayList<>();
        if(!observations.isEmpty()) {
            for (Observation observation : observations) {
                int totalViolationsAmount = 0;
                for(Violation violation : observation.violations) {
                    totalViolationsAmount += violation.GetViolationFee();
                }
                getFineDtos.add(new GetFineDto(observation.plateNumber, totalViolationsAmount));
            }
        }
        return getFineDtos;
    }

    ViolatedRulesCounts getAllViolationsCounts()
    {
        int privateCarSpeedViolationCount = 0;
        int truckSpeedViolationCount = 0;
        int seatBeltViolationCount = 0;
        for (Observation observation : observations) {
            for(Violation violation : observation.violations) {
                if(violation instanceof PrivateCarSpeedViolation)
                    privateCarSpeedViolationCount++;
                else if(violation instanceof TruckSpeedViolation)
                    truckSpeedViolationCount++;
                else if(violation instanceof SeatBeltViolation)
                    seatBeltViolationCount++;
            }
        }
        return new ViolatedRulesCounts(privateCarSpeedViolationCount, truckSpeedViolationCount, seatBeltViolationCount);
    }
}

