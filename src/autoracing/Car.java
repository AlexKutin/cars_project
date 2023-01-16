package autoracing;

public class Car extends Transport implements Competing {

    enum BodyType {
        SEDAN("Седан"),
        HATCHBACK("Хетчбек"),
        COUPE("Купе"),
        WAGON("Универсал"),
        SUV("Внедорожник"),
        CROSSOVER("Кроссовер"),
        PICKUP("Пикап"),
        VAN("Фургон"),
        MINIVAN("Минивэн");

        private final String name;

        BodyType(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Тип кузова: " + getName();
        }

        public String getName() {
            return name;
        }
    }

    private BodyType bodyType;

    public BodyType getBodyType() {
        return bodyType;
    }

    public void setBodyType(BodyType bodyType) {
        this.bodyType = bodyType;
    }

    public Car(String brand, String model, double engineVolume, int countMechanics) {
        super(brand, model, engineVolume, countMechanics);
    }

    public Car(String brand, String model, double engineVolume, int countMechanics, BodyType bodyType) {
        super(brand, model, engineVolume, countMechanics);
        this.bodyType = bodyType;
    }

    @Override
    public void printType() {
        if (bodyType == null) {
            System.out.println("Данных по транспортному средству недостаточно");
        } else {
            System.out.println(bodyType);
        }
    }

    @Override
    public void passDiagnostics() {
        System.out.printf("%s проходит диагностику\n", this);
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
    public int bestLapTime(Transport transport) {
        return 0;
    }

    @Override
    public int maximumSpeed(Transport transport) {
        return 0;
    }
}
