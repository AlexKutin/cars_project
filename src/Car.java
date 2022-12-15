public class Car {
    private String brand;
    private String model;
    private double engineVolume;
    private String color;
    private int productionYear;
    private String productionCountry;

    public Car(String brand, String model, double engineVolume, String color, int productionYear, String productionCountry) {
        this.brand = checkIsNotEmptyAndFill(brand);
        this.model = checkIsNotEmptyAndFill(model);
        if (engineVolume > 0) {
            this.engineVolume = engineVolume;
        } else {
            this.engineVolume = 1.5;
        }

        this.color = checkColorAndFill(color);
        if (productionYear > 0) {
            this.productionYear = productionYear;
        } else {
            this.productionYear = 2000;
        }

        this.productionCountry = checkIsNotEmptyAndFill(productionCountry);
    }

    @Override
    public String toString() {
        return String.format("%s %s, %d год выпуска, сборка в %s, цвет кузова %s, объем двигателя - %.1f литра",
                brand, model, productionYear, productionCountry, color, engineVolume);
    }

    private String checkIsNotEmptyAndFill(String str) {
        if (str == null || str.isBlank()) {
            return "Default";
        } else {
            return str;
        }
    }

    private String checkColorAndFill(String str) {
        if (str == null || str.isBlank()) {
            return "Белый";
        } else {
            return str;
        }
    }
}
