package autoracing;

public class Truck extends Transport implements Competing {

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

    public Truck(String brand, String model, double engineVolume, int countMechanics) {
        super(brand, model, engineVolume, countMechanics);
    }

    public Truck(String brand, String model, double engineVolume, int countMechanics, LoadCapacity loadCapacity) {
        super(brand, model, engineVolume, countMechanics);
        this.loadCapacity = loadCapacity;
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
    public void passDiagnostics() {
        System.out.printf("%s проходит диагностику\n", this);
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
    public int bestLapTime(Transport party) {
        return 0;
    }

    @Override
    public int maximumSpeed(Transport party) {
        return 0;
    }
}
