package autoracing;

public interface Competing<T extends Driver> {

    void pitStop();

    int bestLapTime(Transport<T> party);

    int maximumSpeed(Transport<T> party);
}
