public class Violation {
    Rule ruleViolated;

    public Violation(Rule ruleViolated) {
        this.ruleViolated = ruleViolated;
    }

    public String getViolationDetails(ObservationDetails observationDetails){
        return "- " + ruleViolated.getViolationStatement(observationDetails) + " : " + ruleViolated.getViolationFee() + " EGP";
    }
}
