package autoracing;

public class Car<T extends DriverB> extends Transport<T> implements Competing<T> {

    public Car(String brand, String model, double engineVolume) {
        super(brand, model, engineVolume);
    }

    @Override
    public String toString() {
        return String.format("Легковой автомобиль: " + super.toString());
    }

    @Override
    public void pitStop() {
        System.out.println("Остановка на пит-стоп");
    }

    @Override
    public int bestLapTime(Transport<T> transport) {
        return 0;
    }

    @Override
    public int maximumSpeed(Transport<T> transport) {
        return 0;
    }
}
