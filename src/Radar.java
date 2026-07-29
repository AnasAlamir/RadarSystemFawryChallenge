import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Radar {
    List<Observation> observations;
    List<Rule> predefinedRules;

    public Radar(List<Rule> predefinedRules) {
        observations = new ArrayList<>();
        this.predefinedRules = predefinedRules;

    }

    void addObservation(Observation observation)
    {
        observations.add(observation);

        checkObservationAgainstRules(observation);// and add??
    }

    private void checkObservationAgainstRules(Observation observation) {
        for (Rule rule : predefinedRules) {
            if (rule.checkRuleViolation(observation.observationDetails))
                observation.CreateViolation(rule);
        }
    }

    void showAllFines()
    {
        if(!observations.isEmpty()) {
            for (Observation observation : observations) {
                Fine.generateFine(observation);
            }
        }
        else {
            System.out.println("No Fines yet");
        }
    }

    List<GetFineDto> getAllFines()
    {
        List<GetFineDto> finesDtos = new ArrayList<>();
        if(!observations.isEmpty()) {
            for (Observation observation : observations) {
                finesDtos.add(Fine.get(observation));
            }
        }
        return finesDtos;
    }

    Map<String, Integer> getAllViolationsCounts()
    {
        Map<String, Integer> counts = new HashMap<>();
        for (Observation observation : observations) {
            for(Violation violation : observation.violations)
                counts.put(violation.ruleViolated.getRuleName(),counts.getOrDefault(violation.ruleViolated.getRuleName(), 0) + 1);
        }
        return counts;
    }
}

