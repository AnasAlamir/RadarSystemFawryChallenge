public interface Rule {
    String getViolationStatement(Observation observation);
    int getViolationFee();
    boolean checkRuleViolation(Observation observation);
    String getRuleName();
}