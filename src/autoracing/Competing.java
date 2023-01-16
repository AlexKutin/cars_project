package autoracing;

public interface Competing {

    void pitStop();

    int bestLapTime(Transport party);

    int maximumSpeed(Transport party);
}
