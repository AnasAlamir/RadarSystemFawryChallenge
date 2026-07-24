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
        for(Observation observation : observations)
        {
            observation.generateFine();
        }
    }
}
