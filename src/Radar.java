import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
                    totalViolationsAmount += violation.getViolationFee();
                }
                getFineDtos.add(new GetFineDto(observation.observationDetails.plateNumber, totalViolationsAmount));
            }
        }
        return getFineDtos;
    }

    Map<String, Integer> getAllViolationsCounts()
    {
        Map<String, Integer> counts = new HashMap<>();
        for (Observation observation : observations) {
            for(Violation violation : observation.violations)
                counts.put(violation.getRuleName(),counts.getOrDefault(violation.getRuleName(), 0) + 1);
        }
        return counts;
    }
}

