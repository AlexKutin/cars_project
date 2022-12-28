package autoracing;

public class Truck<T extends DriverC> extends Transport<T> implements Competing<T> {

    enum LoadCapacity {
        N1(null, 3.5f),
        N2(3.5f, 12f),
        N3(12f, null);

        private final Float from;
        private final Float upTo;

        LoadCapacity(Float from, Float upTo) {
            this.from = from;
            this.upTo = upTo;
        }

        @Override
        public String toString() {
            if (from == null && upTo == null) {
                return "Грузоподъемность: не задана!";
            } else if (from != null && upTo == null) {
                return String.format("Грузоподъемность: от %.1f тонн", from);
            } else if (from == null) {
                return String.format("Грузоподъемность: до %.1f тонн", upTo);
            } else {
                return String.format("Грузоподъемность: от %.1f тонн до %.1f тонн", from, upTo);
            }
        }
    }

    private LoadCapacity loadCapacity;

    public LoadCapacity getLoadCapacity() {
        return loadCapacity;
    }

    public void setLoadCapacity(LoadCapacity loadCapacity) {
        this.loadCapacity = loadCapacity;
    }

    public Truck(String brand, String model, double engineVolume) {
        super(brand, model, engineVolume);
    }

    @Override
    public void printType() {
        if (loadCapacity == null) {
            System.out.println("Данных по транспортному средству недостаточно");
        } else {
            System.out.println(loadCapacity);
        }
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
