public class Car {
    private String brand;
    private String model;
    private double engineVolume;
    private String color;
    private int productionYear;
    private String productionCountry;

    public Car(String brand, String model, double engineVolume, String color, int productionYear, String productionCountry) {
        this.brand = brand;
        this.model = model;
        this.engineVolume = engineVolume;
        this.color = color;
        this.productionYear = productionYear;
        this.productionCountry = productionCountry;
    }

    @Override
    public String toString() {
        return String.format("%s %s, %d год выпуска, сборка в %s, цвет кузова %s, объем двигателя - %.1f литра",
                brand, model, productionYear, productionCountry, color, engineVolume);
    }
}
