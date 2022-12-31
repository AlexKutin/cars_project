package autoracing;

public class Bus<T extends DriverD> extends Transport<T> implements Competing<T> {

    enum BusCapacity {
        ESPECIALLY_SMALL(null, 10),
        SMALL(null, 25),
        AVERAGE(40, 50),
        LARGE(60, 80),
        ESPECIALLY_LARGE(100, 120);

        private final Integer from;
        private final Integer upTo;

        BusCapacity(Integer from, Integer upTo) {
            this.from = from;
            this.upTo = upTo;
        }

        @Override
        public String toString() {
            if (from == null && upTo == null) {
                return "Вместимость: не задана!";
            } else if (from != null && upTo == null) {
                return String.format("Вместимость: от %d мест", from);
            } else if (from == null) {
                return String.format("Вместимость: до %d мест", upTo);
            } else {
                return String.format("Вместимость: %d - %d мест", from, upTo);
            }
        }
    }

    private BusCapacity busCapacity;

    public BusCapacity getBusCapacity() {
        return busCapacity;
    }

    public void setBusCapacity(BusCapacity busCapacity) {
        this.busCapacity = busCapacity;
    }

    public Bus(String brand, String model, double engineVolume) {
        super(brand, model, engineVolume);
    }

    @Override
    public void printType() {
        if (busCapacity == null) {
            System.out.println("Данных по транспортному средству недостаточно");
        } else {
            System.out.println(busCapacity);
        }
    }

    @Override
    public void passDiagnostics() {
        throw new UnsupportedOperationException("Автобусы диагностику проходить не могут");
    }

    @Override
    public String toString() {
        return String.format("Автобус: " + super.toString());
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
