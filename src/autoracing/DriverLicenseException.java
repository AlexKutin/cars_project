package autoracing;

public class DriverLicenseException extends Exception {
    private final Driver<? extends Transport> driver;

    public DriverLicenseException(String message, Driver<? extends Transport> driver) {
        super(message);
        this.driver = driver;
    }

    public Driver<? extends Transport> getDriver() {
        return driver;
    }
}
