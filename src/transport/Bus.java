package transport;

public class Bus extends Transport {

    public Bus(String brand, String model, int productionYear, String productionCountry, String color, int maximumSpeed) {
        super(brand, model, productionYear, productionCountry, color, maximumSpeed);
    }

    @Override
    public String toString() {
        return String.format("Автобус: %s %s, %d год выпуска, страна сборки: %s, цвет кузова: %s, макс. скорость = %d км/ч",
                getBrand(), getModel(), getProductionYear(), getProductionCountry(), getColor(), getMaximumSpeed());
    }
}
