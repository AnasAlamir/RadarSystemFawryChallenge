import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Radar {
    List<Rule> predefinedRules;
    List<Fine> fines;

    public Radar(List<Rule> predefinedRules) {
        this.predefinedRules = predefinedRules;
        fines = new ArrayList<>();
    }

    void processObservation(Observation observation)
    {
        List<Violation> violations = getPossibleViolations(observation);
        if(!violations.isEmpty())
            fines.add(new Fine(violations, observation));
    }

    private List<Violation> getPossibleViolations(Observation observation) {
        List<Violation> violations = new ArrayList<>();
        for (Rule rule : predefinedRules) {
            if (rule.checkRuleViolation(observation))
                violations.add(new Violation(rule));
        }
        return violations;
    }

    void displayAllFines()
    {
        if(!fines.isEmpty()) {
            for (Fine fine : fines) {
                fine.generateFine();
            }
        }
        else {
            System.out.println("No Fines yet");
        }
    }

    List<GetFineDto> getAllFines()
    {
        List<GetFineDto> finesDtos = new ArrayList<>();
        if(!fines.isEmpty()) {
            for (Fine fine : fines) {
                finesDtos.add(fine.get());
            }
        }
        return finesDtos;
    }

    Map<String, Integer> getAllViolationsCounts()
    {
        Map<String, Integer> counts = new HashMap<>();
        for (Fine fine : fines) {
            for(Violation violation : fine.violations)
                counts.put(violation.ruleViolated.getRuleName(),counts.getOrDefault(violation.ruleViolated.getRuleName(), 0) + 1);
        }
        return counts;
    }
}