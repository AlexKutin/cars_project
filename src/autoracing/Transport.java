package autoracing;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Transport {
    private final String brand; // Марка
    private final String model; // Модель
    private final double engineVolume; // Объем двигателя в литрах

    private Driver<? extends Transport> driver;

    private final List<Mechanic> mechanics;

    private final int countMechanics;

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public double getEngineVolume() {
        return engineVolume;
    }

    public Driver<? extends Transport> getDriver() {
        return driver;
    }

    public void setDriver(Driver<? extends Transport> driver) {
        this.driver = driver;
    }

    public int getCountMechanics() {
        return countMechanics;
    }

    public Transport(String brand, String model, double engineVolume, int countMechanics) {
        this.brand = checkIsNotEmptyAndFill(brand);
        this.model = checkIsNotEmptyAndFill(model);
        this.engineVolume = checkAndFillEngineVolume(engineVolume);
        this.countMechanics = countMechanics;
        mechanics = new ArrayList<>(countMechanics);
    }

    public abstract void printType();

    public abstract void passDiagnostics();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transport transport = (Transport) o;
        return Double.compare(transport.engineVolume, engineVolume) == 0 && Objects.equals(brand, transport.brand) &&
                Objects.equals(model, transport.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, engineVolume);
    }

    public void addMechanic(Mechanic mechanic) {
        if (mechanics.size() == countMechanics) {
            throw new MechanicsCountOverflowException("Количество механиков не может превышать: " + countMechanics);
        }
        mechanics.add(mechanic);
    }

    public void dismissMechanic(Mechanic mechanic) {
        mechanics.remove(mechanic);
    }

    public void startMoving() {

    }

    public void finishMoving() {

    }

    public void manage(Driver<? extends Transport> driver) throws DriverLicenseException {
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

    public void printFullInfo() {
        if (driver == null) {
            System.out.printf("Авто: {%s}, Водитель - не назначен!, Механики: %s\n", getShortTransportName(), mechanics);
        } else {
            System.out.printf("Авто: {%s}, %s, Механики: %s\n", getShortTransportName(), driver, mechanics);
        }
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
