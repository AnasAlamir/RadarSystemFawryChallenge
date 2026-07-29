public interface Rule {
    String getViolationStatement(ObservationDetails observationDetails);
    int getViolationFee();
    boolean checkRuleViolation(ObservationDetails observationDetails);
    String getRuleName();
}