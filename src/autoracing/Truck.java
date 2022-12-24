package autoracing;

public class Truck<T extends DriverC> extends Transport<T> implements Competing<T> {

    public Truck(String brand, String model, double engineVolume) {
        super(brand, model, engineVolume);
    }

    @Override
    public String toString() {
        return String.format("Грузовик: " + super.toString());
    }

    @Override
    public void pitStop() {
        System.out.println("Остановка на пит-стоп");
    }

    @Override
    public int bestLapTime(Transport<T> party) {
        return 0;
    }

    @Override
    public int maximumSpeed(Transport<T> party) {
        return 0;
    }
}
