import java.util.ArrayList;
import java.util.List;

public class Radar {
    List<Observation> observations = new ArrayList<>();

    void addObservation(Observation observation)
    {
        observations.add(observation);
    }
}
