public class Violation {
    Rule ruleViolated;

    public Violation(Rule ruleViolated) {
        this.ruleViolated = ruleViolated;
    }

    public String getViolationDetails(Observation observation){
        return "- " + ruleViolated.getViolationStatement(observation) + " : " + ruleViolated.getViolationFee() + " EGP";
    }
}
