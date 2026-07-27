public interface Violation {
    String getViolationStatement(ObservationDetails observationDetails);
    int getViolationFee();
    boolean checkViolation(ObservationDetails observationDetails);
    default String getRuleName(){
        return this.getClass().getSimpleName();
    }
}
