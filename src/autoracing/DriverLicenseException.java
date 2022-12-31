package autoracing;

public class DriverLicenseException extends Exception {
    private final Driver driver;

    public DriverLicenseException(String message, Driver driver) {
        super(message);
        this.driver = driver;
    }

    public Driver getDriver() {
        return driver;
    }
}
