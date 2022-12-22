package transport;

import java.util.Objects;

public class Transport {
    private final String brand; // Марка
    private final String model; // Модель
    private final int productionYear;   // Год производства
    private String color;   // Цвет кузова

    private final String productionCountry; // Страна производства

    private int maximumSpeed;   // Максимальная скорость передвижения

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public String getProductionCountry() {
        return productionCountry;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = checkColorAndFill(color);
    }

    public int getMaximumSpeed() {
        return maximumSpeed;
    }

    public void setMaximumSpeed(int maximumSpeed) {
        this.maximumSpeed = checkAndFillMaximumSpeed(maximumSpeed);
    }

    public Transport(String brand, String model, int productionYear, String productionCountry, String color, int maximumSpeed) {
        this.brand = checkIsNotEmptyAndFill(brand);
        this.model = checkIsNotEmptyAndFill(model);
        this.productionYear = checkAndFillProductionYear(productionYear);
        this.productionCountry = checkIsNotEmptyAndFill(productionCountry);
        this.color = checkColorAndFill(color);
        this.maximumSpeed = checkAndFillMaximumSpeed(maximumSpeed);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transport transport = (Transport) o;
        return productionYear == transport.productionYear && maximumSpeed == transport.maximumSpeed &&
                Objects.equals(brand, transport.brand) && Objects.equals(model, transport.model) &&
                Objects.equals(color, transport.color) && Objects.equals(productionCountry, transport.productionCountry);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, productionYear, color, productionCountry, maximumSpeed);
    }

    String checkIsNotEmptyAndFill(String str) {
        if (str == null || str.isBlank()) {
            return "Default";
        }
        return str;
    }

    private int checkAndFillProductionYear(int productionYear) {
        if (productionYear > 1900) {
            return productionYear;
        }
        return 2000;
    }

    private String checkColorAndFill(String str) {
        if (str == null || str.isBlank()) {
            return "Белый";
        }
        return str;
    }

    private int checkAndFillMaximumSpeed(int maximumSpeed) {
        if (maximumSpeed < 1) {
            return 100;  // скорость по умолчанию
        }
        return maximumSpeed;
    }
}
