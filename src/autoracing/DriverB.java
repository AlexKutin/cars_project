package autoracing;

public class DriverB extends Driver {

    public DriverB(String fullName, boolean driverLicense, int experience) {
        super(fullName, driverLicense, experience);
    }

    @Override
    public String toString() {
        return super.toString() + ", категория: B";
    }
}
