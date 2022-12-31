package autoracing;

import java.util.Objects;

public abstract class Transport<T extends Driver> {
    private final String brand; // Марка
    private final String model; // Модель
    private final double engineVolume; // Объем двигателя в литрах

    private T driver;

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public double getEngineVolume() {
        return engineVolume;
    }

    public T getDriver() {
        return driver;
    }

    public void setDriver(T driver) {
        this.driver = driver;
    }

    public Transport(String brand, String model, double engineVolume) {
        this.brand = checkIsNotEmptyAndFill(brand);
        this.model = checkIsNotEmptyAndFill(model);
        this.engineVolume = checkAndFillEngineVolume(engineVolume);
    }

    public abstract void printType();

    public abstract void passDiagnostics();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transport<T> transport = (Transport<T>) o;
        return Double.compare(transport.engineVolume, engineVolume) == 0 && Objects.equals(brand, transport.brand) &&
                Objects.equals(model, transport.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, engineVolume);
    }

    public void startMoving() {

    }

    public void finishMoving() {

    }

    public void manage(T driver) throws DriverLicenseException {
        if (driver.isDriverLicenceCorrect()) {
            System.out.printf("Водитель %s управляет автомобилем %s и будет участвовать в заезде\n",
                    driver.getFullName(), getShortTransportName());
        } else {
            if (driver.getTypeDriverLicense() == null) {
                throw new DriverLicenseException(String.format("У водителя %s не указан тип прав!", driver.getFullName()), driver);
            } else {
                throw new DriverLicenseException(
                        String.format("Категория прав водителя %s не позволяет управлять транспортным средством %s",
                                driver.getFullName(), this.getShortTransportName()), driver);
            }
        }
    }

    public String toString() {
        return getShortTransportName();
    }

    String checkIsNotEmptyAndFill(String str) {
        if (str == null || str.isBlank()) {
            return "Default";
        }
        return str;
    }

    private double checkAndFillEngineVolume(double engineVolume) {
        if (engineVolume > 0) {
            return engineVolume;
        }
        return 1.5;
    }

    private String getShortTransportName() {
        return String.format("%s %s, объем двигателя = %.1fл", getBrand(), getModel(), getEngineVolume());
    }

}
